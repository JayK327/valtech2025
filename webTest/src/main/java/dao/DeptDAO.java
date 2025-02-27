package servlets;

import java.util.List;



public interface DeptDAO {
	Dept first();
	Dept last();
	Dept next(int id);
	Dept previous(int id);
	

	void save(Dept dept);

	void update(Dept dept);

	//Dept getDept(int id);
	Dept get(int id);
	void delete(int id);

	List<Dept> getAll();

}

