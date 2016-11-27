package dblp;

public class books implements Comparable{
	private String Author;
	private String title;
	private String pages;
	private String year;
	private String volume;
	private String journal;
	private String number;
	private String ee;
	private String url;

	public String getAuthor() {
		return Author;
	}
	
	public void setAuthor(String author) {
		Author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPages() {
		return pages;
	}
	
	public void setPages(String pages) {
		this.pages = pages;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String getJournal() {
		return journal;
	}
	
	public void setJournal(String journal) {
		this.journal = journal;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getEe() {
		return ee;
	}
	
	public void setEe(String ee) {
		this.ee = ee;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString(){
		String re = this.getAuthor();
		re += "\n";
		re += this.getTitle();
		re += "\n";
		re += this.getJournal();
		re += "\n";
		re += this.getNumber();
		re += "\n";
		re += this.getVolume();
		re += "\n";
		re += this.getPages();
		re += "\n";
		re += this.getYear();
		re += "\n";
		re += this.getEe();
		re += "\n";
		re += this.getUrl();
		re += "\n";
		return re;
	}

	@Override
	public int compareTo(Object arg0) {
		
		return 0;
	}
}
