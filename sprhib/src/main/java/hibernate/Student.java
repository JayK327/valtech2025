package hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import  javax.persistence.Column;

@Entity
public class Student {
	private String name;
	private String fatherName;
	private String stream;
	private long mobile;
	@EmbeddedId
	private StudentId id;
	@Embedded()
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="home_street")),
		@AttributeOverride(name="city",column=@Column(name="home_city")),
		@AttributeOverride(name="pincode",column=@Column(name="home_pincode")),

	})
	private StudentAddress homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="current_street")),
		@AttributeOverride(name="city",column=@Column(name="current_city")),
		@AttributeOverride(name="pincode",column=@Column(name="current_pincode")),

	})
	private StudentAddress currrentAddress;

	public StudentAddress getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(StudentAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	public StudentAddress getCurrrentAddress() {
		return currrentAddress;
	}
	public void setCurrrentAddress(StudentAddress currrentAddress) {
		this.currrentAddress = currrentAddress;
	}
	
	public Student() {}
	public Student(StudentId id,String name, String fatherName, String stream, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.stream = stream;
		this.mobile = mobile;
		
	}
	
	public Student(StudentId id, String name, String fatherName, String stream, long mobile, StudentAddress homeAddress,
			StudentAddress currrentAddress) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.stream = stream;
		this.mobile = mobile;
		this.homeAddress = homeAddress;
		this.currrentAddress = currrentAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public StudentId getId() {
		return id;
	}
	public void setId(StudentId id) {
		this.id = id;
	}

}
