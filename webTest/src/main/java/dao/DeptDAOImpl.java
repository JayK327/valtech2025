//package dao;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import servlets.Dept;
//
//import java.util.List;
//
//public class DeptDAOImpl implements DeptDAO {
//	@Override
//	public Dept first() {
//		return depts.get(depts.keySet().stream().min((a,b) -> (a - b)).get());
//	}
//	@Override
//	public Dept last() {
//		return depts.get(depts.keySet().stream().max((a,b) -> (a - b)).get());
//	}
//	@Override
//	public Dept next(int id) {
//		if(id == depts.size()) return depts.get(depts.size());
//		return depts.get(id+1);
//	}
//	@Override
//	public Dept previous(int id) {
//		if(id==1) return getDept(1);
//		return depts.get(id-1);
//	}
//
//	private Map<Integer, Dept> depts;
//	public  DeptDAOImpl() {
//		depts= new HashMap<Integer,Dept>() ;
//	}
//	
//	@Override
//	public void save(Dept dept){
//		depts.put(dept.getId(), dept);
//	}
//	@Override
//	public void update(Dept dept) {
//		depts.put(dept.getId(), dept);
//	}
//	
//	@Override
//	public Dept getDept(int id) {
//		return depts.get(id);
//		
//	}
//	
//	@Override
//	public void delete(int id) {
//		depts.remove(id);
//	}
//	
//	@Override
//	public List<Dept> getAll() {
//	    List<Dept> all = new ArrayList<>();
//	    for (int id : depts.keySet()) {
//	        all.add(depts.get(id));
//	    }
//	    return all;
//	}
//
//}

package servlets;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import servlets.Dept;

public class DeptDAOImpl implements DeptDAO {
	
	private ServletContext sce;
	
	
	public DeptDAOImpl(ServletContext sce) {
		super();
		this.sce = sce;
	}
	private Connection getConnection()  throws SQLException{
		return DriverManager.getConnection((String)sce.getAttribute("jdbc_url"),(String)sce.getAttribute("jdbc_username"),(String)sce.getAttribute("jdbc_password"));
		
	}
	@Override
	public void save(Dept d) {
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("INSERT INTO DEPARTMENT (NAME,LOCATION,DEPTID) VALUES(?,?,?) ");
			setValuestoPrepareStatement(d, ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println(rowsAffected);
	
		}
		catch(Exception ex) {
			throw new RuntimeException (ex);
		}
		// TODO Auto-generated method stub
		
		
	}
	private void setValuestoPrepareStatement(Dept e, PreparedStatement ps) throws SQLException {
		
		ps.setInt(3,e.getId());
		ps.setString(1,e.getName());
		ps.setString(2, e.getLocation());
	}

	@Override
	public void update(Dept e) {
		// TODO Auto-generated method stub
		try(Connection conn= getConnection()){
			PreparedStatement ps=conn.prepareStatement("UPDATE DEPARTMENT SET NAME= ?,LOCATION= ? WHERE DEPTID=?");
			setValuestoPrepareStatement(e,ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows Updated"+rowsAffected);
		}
		catch(Exception es) {
			throw new RuntimeException(es);
		}
		
	}

	public Dept first() {
			try(Connection conn=getConnection()){
				PreparedStatement ps=conn.prepareStatement("SELECT DEPTID,NAME,LOCATION from Department where DEPTID=(SELECT MIN(DEPTID) FROM DEPARTMENT )");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Dept d=populateEmployee(rs);
					return d;
				}
			}
			
			
			catch(Exception e) {
				e.printStackTrace();
			};
			return null;
		
	}


	public Dept last() {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("SELECT DEPTID,NAME,LOCATION from Department where DEPTID=(SELECT MAX(DEPTID) FROM DEPARTMENT )");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Dept d=populateEmployee(rs);
				return d;
			}
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		};
		return null;
		
	}


	public Dept next(int id) {
		// TODO Auto-generated method stu
		try(Connection conn=getConnection()){
			System.out.println("In the Next Method");
			PreparedStatement ps=conn.prepareStatement("SELECT DEPTID,NAME,LOCATION from Department where (DEPTID=?)");
			ps.setInt(1, id+1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Dept d=populateEmployee(rs);
				System.out.println(d);
				return d;
			}
			else {
				PreparedStatement pd=conn.prepareStatement("SELECT DEPTID,NAME,LOCATION FROM DEPARTMENT WHERE DEPTID=(SELECT MAX(DEPTID) FROM DEPARTMENT)");
				ResultSet rd=pd.executeQuery();
				if(rd.next()) {
					Dept d=populateEmployee(rd);
					System.out.println("MAX"+d);
					return d;
				}
			}
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		};
		return null;
		
	}

	public Dept previous(int id) {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("SELECT DEPTID,NAME,LOCATION from Department where DEPTID=?");
			ps.setInt(1, id-1);
			ResultSet rs=ps.executeQuery();
			System.out.println("INSIDE RS METHOD");
			if(rs.next()) {
				System.out.println("INSIDE RS");
				Dept d=populateEmployee(rs);
				return d;
			}
			else {
				PreparedStatement pd=conn.prepareStatement("SELECT DEPTID,NAME,LOCATION from Department where DEPTID=(SELECT MIN(DEPTID) FROM Department)");
				ResultSet rd=pd.executeQuery();
				if(rd.next()) {
					Dept d=populateEmployee(rd);
					return d;
				}

			}
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		};
		return null;
		
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("DELETE FROM DEPARTMENT WHERE ID=?");
			ps.setInt(1, id);
			ps.executeQuery();
			
		}catch(Exception ex) {
			System.out.println("New RunTime Exception"+ex);
		}
		
	}
	private Dept populateEmployee(ResultSet rs) throws SQLException {
		return new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
		
	}

	@Override
	public Dept get(int id) {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("Select DEPTID,NAME,LOCATION from Department where DEPTID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Dept e=populateEmployee(rs);
				return e;
			}
			else {
				System.out.println("No Element of the provided ID exists");
			}
		}
		catch(Exception e) {
			System.out.println("New Runtime Exception "+e);
		}
		return null;
	}

	@Override
	public List<Dept> getAll() {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			List<Dept> ls=new ArrayList<>();
			PreparedStatement ps=conn.prepareStatement("Select DEPTID,NAME,LOCATION FROM Department");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ls.add(populateEmployee(rs));
			}
			return ls;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
