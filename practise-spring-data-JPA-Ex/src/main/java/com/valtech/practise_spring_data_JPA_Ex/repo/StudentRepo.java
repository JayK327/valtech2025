package com.valtech.practise_spring_data_JPA_Ex.repo;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valtech.practise_spring_data_JPA_Ex.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	//The difference is in SQL we use table names column names.
    //In Jpql we use the class name and the property names.
	@Query("select s from Student s where s.name=?1")
	List<Student> findByName(String string);

	List<Student> findByMarksGreaterThan(int i);

	
	//So what JPA does is JPA uses something called a domain specific language, which is DSL.
    //Uh, so using this DSL, it creates certain methods for you behind the scene.No need to give Query.
	//But name should be correct.
}
