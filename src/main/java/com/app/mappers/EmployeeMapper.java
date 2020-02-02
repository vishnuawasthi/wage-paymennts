package com.app.mappers;

import java.util.List;

import com.app.dto.CourseData;
import com.app.dto.CourseDto;
import com.app.dto.DepartmentResultDTO;
import com.app.dto.Employee;

public interface EmployeeMapper {

	// List<Employee> getAllEmployee();

	List<DepartmentResultDTO> fetchDepartmentsWithEmployeesId();

	// EmployeesData fetchEmployeesDetails();

	List<Employee> fetchEmployeesDetailsList();

	List<CourseData> fetchCourseDetails();

	CourseDto saveCourseDetails(CourseDto courseDto);

	List<CourseData> selectCourseWithDiscriminatorExample();
	
	
	

}
