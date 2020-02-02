package com.app.mappers;

import java.util.HashMap;
import java.util.List;

import com.app.dto.DepartmentResultDTO;
import com.app.dto.DiscriminatorExampleDTO;
import com.app.dto.Employee;

public interface SelectExampleMapper {

	// Select Query example with all the options

	HashMap<String, Object> selectExampleWithMap(Long id);
	
	List<HashMap<String, Object>>  selectExampleWithMapMultipleRow();
	
	List<Employee>    selectWithAutoColumnMapping ();
	
	
	List<HashMap<String, Object>>	selectWithSqlTagExample();
	
	
	// Save Employee Example
	
	void saveEmployeeExample1(Employee employee);
	
	void insertMultipleRowExample(List<Employee> employeeList);
	
	Long selectEmployeeIdFieldValue();
	
	
	// Complex select example 
	
	List<DepartmentResultDTO>  selectDepartmentWithEmployeesEx1();
	
	DiscriminatorExampleDTO	selectEmployeeWithDiscriminatorExample();
 	
	
	
}
