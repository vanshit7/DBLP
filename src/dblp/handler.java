package dblp;

import java.util.jar.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class handler extends DefaultHandler{
	   boolean bAuther = false;
	   boolean bTitle = false;
	   boolean bPages = false;
	   boolean bYear = false;
	   boolean bVolume = false;

	   public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
	      if (qName.equalsIgnoreCase("article")) {
	         String mDate = attributes.getValue("mdate");
	         System.out.println("mdate : " + mDate);
	      } else if (qName.equalsIgnoreCase("title")) {
	    	  bTitle = true;
	      } else if (qName.equalsIgnoreCase("pages")) {
	         bPages = true;
	      } else if (qName.equalsIgnoreCase("volume")) {
	         bVolume = true;
	      } else if (qName.equalsIgnoreCase("auther")) {
		         bAuther = true;
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
	      if (bAuther) {
	         System.out.println("Author: " 
	         + new String(ch, start, length));
	         bAuther = false;
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
