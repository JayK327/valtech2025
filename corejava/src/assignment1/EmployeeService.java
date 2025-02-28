package assignment1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import assignment1.Employee.Gender;

public class EmployeeService {

	public static Map<Gender,List<Employee>> getEmpByLevel(List<Employee> emps,int level){
		return emps.stream().filter(e->e.getLevel()==level).sorted((emp1,emp2)->emp1.compareTo(emp2)).collect(Collectors.groupingBy(e->e.getGender()));
	// return emps.stream().filter(e->e.getLevel()==level).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	
	public static Map<Gender,List<Employee>> getEmpByGender(List<Employee> emps,Gender gender){
		return emps.stream().filter(e->e.getGender()==gender).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	
	public static Map<Gender,List<Employee>> getEmpByExactName(List<Employee> emps,String name){
		return emps.stream().filter(e->e.getName()==name).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	public static Map<Gender,List<Employee>> getEmpBySubstringName(List<Employee> emps,String substringName){
		return emps.stream().filter(e->e.getName().contains(substringName)).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	public static Map<Gender,List<Employee>> getEmpBySubstringNameIgnoreCase(List<Employee> emps,String substringName){
		return emps.stream().filter(e->e.getName().toUpperCase().contains(substringName.toUpperCase())).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	public static Map<Gender,List<Employee>> getEmpByGenderAndLevel(List<Employee> emps,Gender gender,int level){
		return emps.stream().filter(e->e.getGender()==gender && e.getLevel()==level).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}

	public static double getTotalSumOfSalary(List<Employee> emps) {
		return emps.stream().mapToDouble(Employee::getSalary).sum();
	}
	public static Map<Gender,List<Employee>> getAllEmp(List<Employee>emps){
		 return emps.stream().collect(Collectors.groupingBy(e -> e.getGender()));
	    }
}
