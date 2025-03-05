package dao;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

	public enum Gender {
		MALE, FEMALE, OTHER;
	}
    private int id;
    private String name;
    private int age;
	private float salary;
    private Gender gender;
    private int level;
    private int experience;
    private int deptid;
    public Employee() {
    	
    }
       
    
    public Employee(int id, String name, int age, float salary, Gender gender, int level, int experience, int deptid) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.level = level;
		this.experience = experience;
		this.deptid = deptid;
	}

	@Override
	public int compareTo(Employee other) {
		//Firstly compare on the basis of level
    	if (this.level != other.level) {
            return Integer.compare(this.level, other.level);
        }   	

        // If level is the same then compare by age
        if (this.experience != other.experience) {
            return Integer.compare(this.experience, other.experience);
        }
        // then compare by salary
        if ((this.salary!= other.salary)) {
            return Float.compare(this.salary, other.salary);
        }
        //then finally compare by experience
        return this.gender.compareTo(other.gender);
	}


	// Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public float getSalary() { return salary; }
    public Gender getGender() { return gender; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public int getDeptid() {
		return deptid;
	}
    public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

    public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	// Builder function
    public static EmployeeBuilder builder() {
    	return new EmployeeBuilder(new Employee());
    }

    // Override hashCode and equals
    
    @Override
	public String toString() {
		// return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", gender=" + gender
		//		+ ", level=" + level + ", position=" + position + ", experience=" + experience + "]";
    	return new StringBuilder()
    			.append(id)
    			.append(" ")
    			.append(name)
    			.append(" ")
    			.append(age)
    			.append(" ")
    			.append(salary)
    			.append(" ")
    			.append(gender)
    			.append(" ")
    			.append(level)
    			.append(" ")
    			.append(experience)
    			.append(" ")
    			.append(deptid)
    			.toString();
    			}

	@Override
	public int hashCode() {
		return Objects.hash(age, experience, gender, id, level, name, salary,deptid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && deptid == other.deptid&& gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}
    
    public static class EmployeeBuilder{
    	private Employee emp;
    	public EmployeeBuilder(Employee emp) {
    		this.emp = emp;
    	}
		
    	public Employee build() {
    		return emp;
    	}
    	public EmployeeBuilder id(int id) {
    		emp.setId(id);
    		return this;
    	}
    	public EmployeeBuilder name(String name) {
    		emp.setName(name);
    		return this;
    	}
    	public EmployeeBuilder age(int age) {
    		emp.setAge(age);
    		return this;
    	}
    	public EmployeeBuilder salary(float i) {
    		emp.setSalary(i);
    		return this;
    	}
    	public EmployeeBuilder gender(Gender gender) {
    		emp.setGender(gender);
    		return this;
    	}
    	public EmployeeBuilder level(int level) {
    		emp.setLevel(level);
    		return this;
    	}
    	public EmployeeBuilder experience(int experience) {
    		emp.setExperience(experience);
    		return this;
    	}
    	public EmployeeBuilder deptid(int deptid) {
    		emp.setDeptid(deptid);
    		return this;
    	}

//		public EmployeeBuilder gender(String string) {
//			// TODO Auto-generated method stub
//			return null;
//		}

//		public EmployeeBuilder gender(String string) {
//			// TODO Auto-generated method stub
//			emp.setGender(Gender.valueOf(gender));
//			return this;
//		}    	
    } 
}