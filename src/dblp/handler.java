package dblp;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class handler extends DefaultHandler{
	   boolean bAuthor = false;
	   boolean bTitle = false;
	   boolean bPages = false;
	   boolean bYear = false;
	   boolean bVolume = false;
	   boolean bJournal= false;
	   boolean bNumber = false;
	   boolean bEe = false;
	   boolean bUrl = false;
	   //boolean bArticle  = false;
	   books name;
	   ArrayList<books> book =  new ArrayList<books>(); 
	   
	  @Override
	   public void startElement(String uri,
               String localName,
               String qName,
               Attributes attributes)
                 throws SAXException {
		  
	      if (qName.equalsIgnoreCase("article")) {
	         name = new books();
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
		  } else if(qName.equalsIgnoreCase("journal")){
			  bJournal = true;
		  } else if(qName.equalsIgnoreCase("number")){
			  bNumber = true;
		  } else if(qName.equalsIgnoreCase("ee")){
			  bEe = true;
		  } else if(qName.equalsIgnoreCase("url")){
			  bUrl = true;
		  }
	      	
	   }

	   @Override
	   public void endElement(String uri, 
	      String localName, String qName) throws SAXException {
	      if (qName.equalsIgnoreCase("article")) {
	         book.add(name);
	      }
	      else if(qName.equalsIgnoreCase("dblp")){
	    	  print();
	      }
	   }

	   @Override
	   public void characters(char ch[], 
	      int start, int length) throws SAXException {
		   if (bAuthor) {
	         name.setAuthor(new String(ch, start, length));
	         bAuthor = false;
	      } else if (bTitle) {
	         name.setTitle(new String(ch, start, length));
	         bTitle = false;
	      } else if (bPages) {
	         name.setPages(new String(ch, start, length));
	         bPages = false;
	      } else if (bVolume) {
	    	  name.setVolume(new String(ch, start, length));
	         bVolume = false;
	      }  else if (bYear) {
		         name.setYear(new String(ch, start, length));
		    	  bYear = false;
		   } else if(bJournal){
			   name.setJournal(new String(ch, start, length));
			   bJournal = false;
		   } else if(bNumber){
			   name.setNumber(new String(ch, start, length));
			   bNumber = false;
		   } else if(bEe){
			   name.setEe(new String(ch, start, length));
			   bEe = false;
		   } else if(bUrl){
			   name.setUrl(new String(ch, start, length));
			   bUrl = false;
		   }
	   }
	   
	   public void print(){
		  for(books b: book){
			  System.out.println(b);
		  }
	   }
	   
}
