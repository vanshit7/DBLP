package dblp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class handler extends DefaultHandler{
	   boolean bAuthor = false;
	   boolean bTitle = false;
	   boolean bPages = false;
	   boolean bYear = false;
	   boolean bVolume = false;
	   boolean bArticle  = false;

	  @Override
	   public void startElement(String uri,
               String localName,
               String qName,
               Attributes attributes)
                 throws SAXException {
	
	      if (qName.equalsIgnoreCase("article")) {
	         String mDate = attributes.getValue("mdate");
	         bArticle = true;
	         System.out.println("mdate : " + mDate);
	      } else if (qName.equalsIgnoreCase("title")) {
	    	  bTitle = true;
	      } else if (qName.equalsIgnoreCase("pages")) {
	         bPages = true;
	      } else if (qName.equalsIgnoreCase("volume")) {
	         bVolume = true;
	      } else if (qName.equalsIgnoreCase("author")) {
		         bAuthor = true;
		  } else if (qName.equalsIgnoreCase("year")) {
		         bYear = true;
		  }
	   }

	   @Override
	   public void endElement(String uri, 
	      String localName, String qName) throws SAXException {
	      if (qName.equalsIgnoreCase("article")) {
	         System.out.println("End Element :" + qName);
	         System.out.println();
	      }
	   }

	   @Override
	   public void characters(char ch[], 
	      int start, int length) throws SAXException {
		   if(bArticle){
			   System.out.println("Article: " 
				         + new String(ch, start, length));
				         bArticle = false;
		   }
		   else if (bAuthor) {
	         System.out.println("Author: " 
	         + new String(ch, start, length));
	         bAuthor = false;
	      } else if (bTitle) {
	         System.out.println("Title: " 
	         + new String(ch, start, length));
	         bTitle = false;
	      } else if (bPages) {
	         System.out.println("Pages: " 
	         + new String(ch, start, length));
	         bPages = false;
	      } else if (bVolume) {
	         System.out.println("Volume: " 
	         + new String(ch, start, length));
	         bVolume = false;
	      }  else if (bYear) {
		         System.out.println("Year: " 
		    	 + new String(ch, start, length));
		    	  bYear = false;
		   }
	   }
}
