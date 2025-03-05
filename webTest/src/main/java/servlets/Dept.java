package servlets;

import java.util.ArrayList;
import java.util.List;

public class Dept {
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	private int id;
	private String name;
	private String location;
	public static List<Dept> depts=new ArrayList<Dept>();
	
	public Dept() {}
	public Dept(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public static List<Dept> getDepts() {
		return depts;
	}
	public static void setDepts(List<Dept> depts) {
		Dept.depts = depts;
	}
	 public static deptBuilder builder() {
		 return new deptBuilder(new Dept());
	 }
	 public static class deptBuilder{
		private Dept dept;

		public deptBuilder(Dept dept) {
			this.dept = dept;
		}
		public Dept build() {
			depts.add(dept);
			return dept;
		}
		public deptBuilder id(int id) {
			dept.setId(id);
			return this;
		}
		public deptBuilder name(String name) {
			dept.setName(name);
			return this;
		}
		public deptBuilder location(String location) {
			dept.setLocation(location);
			return this;
		}
		 
	 }

}
