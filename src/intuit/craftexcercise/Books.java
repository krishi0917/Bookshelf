package intuit.craftexcercise;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Books implements Record{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bookid")
	private long bookid;	
	private String isbn;
	private String title;
	private String author;
	private String reservedby;
	private Date issuedate;
	private Date returndate;
	private boolean available;

	//constructors-------------------
	public Books(){}
	public Books(String isbn, String title, String author, String reservedby){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.reservedby = reservedby;
		this.setAvailable(true);
	}
	
	public long getBookId() {
		return bookid;
	}

	public void setBookId(long bookId) {
		this.bookid = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public String getReservedby() {
		return reservedby;
	}
	
	public void setReservedby(String reservedby) {
		this.reservedby = reservedby;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	
	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public Date getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(Date issuedate2) {
		this.issuedate = issuedate2;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	
}
