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
    
    public Employee() {
    	
    }

    // Private constructor to enforce builder pattern
    public Employee(int id, String name, int age, float salary, Gender gender, int level,
			int experience) {
    	super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.level = level;
		this.experience = experience;
	}
    
    @Override
	public int compareTo(Employee other) {
    	if (this.level != other.level) {
            return Integer.compare(this.level, other.level);
        }   	

        // If level is the same, compare by age
        if (this.experience != other.experience) {
            return Integer.compare(this.experience, other.experience);
        }
        // If age is the same, compare by salary
        if ((this.salary!= other.salary)) {
            return Float.compare(this.salary, other.salary);
        }
        // If salary is the same, compare by experience
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
    			.toString();
    			}

	@Override
	public int hashCode() {
		return Objects.hash(age, experience, gender, id, level, name, salary);
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
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
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