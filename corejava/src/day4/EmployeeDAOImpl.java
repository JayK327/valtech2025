package day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment1.Employee;
import assignment1.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO {

	static {
		// this code is executed only once when the class is loaded
		try{ Class.forName("org.postgresql.Driver");
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
	}
	
	
	@Override
	public void save(Employee e) {
		// TODO Auto-generated method stub
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows inserted = "+rowsAffected);
			
		}catch(Exception ex) {
			throw new RuntimeException(ex);
			
		}
		

	}


	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, e.getId());
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("UPDATE EMPLOYEE SET NAME = ? ,AGE = ?,GENDER = ?,SALARY = ?,EXPERIENCE = ?,LEVEL = ? WHERE ID = ?");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = "+rowsAffected);
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID =?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Deleted = "+rowsAffected);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public Employee get(int id) {
				try(Connection conn = getConnection()){
					PreparedStatement ps = conn.prepareStatement
							("SELECT ID ,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID = ?");
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					if(rs.next()) { 
						// if this next returns true then we have another row ,next return false we are  at the end of resultset
						Employee e = populateEmployee(rs);
						return e;
					}else {
						new RuntimeException("No Employee with id "+id+" Found.");
					}
				}catch(Exception ex) {
					throw new RuntimeException(ex);
				}
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException{
		
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
				.gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6))
				.level(rs.getInt(7)).build();
	}


	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		List<Employee> emps = new ArrayList<Employee>();
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID ,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return emps;
	}

}
