package intuit.craftexcercise;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shelves implements Record{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="shelfid")
	private long shelfid;	
	private String name;
	private int capacity;
	private int available;
	public long getShelfid() {
		return shelfid;
	}
	public void setShelfid(long shelfid) {
		this.shelfid = shelfid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	
}
