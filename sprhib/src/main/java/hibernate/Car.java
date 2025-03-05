package hibernate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
public class Car {
	
//There are four method to generate primary key: IDENTITY,AUTO,SEQUENCE,TABLE
	
//	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)	//mandatory @Id    
	// in case of identity database is responsible for generating primary key
	
//	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="carseq")
//	@SequenceGenerator(name="carseq",sequenceName="car_seq",allocationSize = 1)   //Name and generator should match
	
	@Id @GeneratedValue(strategy= GenerationType.TABLE,generator="cartab")
	@TableGenerator(name="cartab",table="car_pk")   //(unique_name for generator,table_name contains pk)
	private long id;	//mandatory
	private String manufacturer;
	private String name;
	private int year;
	@Version         //Enable optimistic locking:Manage if two person make changes in database at same time.(Data consistency)
	private int version;
	
	public Car() {}   //Default const. is mandatory
	
	
	public Car(long id, String manufacturer, String name, int year) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.name = name;
		this.year = year;
	}

	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", manufacturer=" + manufacturer + ", name=" + name + ", year=" + year + ", version="
				+ version + "]";
	}
}
//How it works:
//-Tracks changes to the entity with the version field.
//-When updating, JPA compares the version number to avoid concurrent modification issues.
//-If the version doesn’t match, an OptimisticLockException is thrown.

