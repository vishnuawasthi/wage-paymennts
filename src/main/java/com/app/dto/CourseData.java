package com.app.dto;

import java.util.ArrayList;
import java.util.List;

public class CourseData {

	private Long courseId;

	private String courseName;

	private List<Employee> oneMonthEmployee;

	private List<Employee> moreThanOneMonthEmployee;
	private List<Employee> allEmployeeList;

	public CourseData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Employee> getOneMonthEmployee() {

		if (oneMonthEmployee == null) {
			return new ArrayList<Employee>();
		}
		return oneMonthEmployee;
	}

	public void setOneMonthEmployee(List<Employee> oneMonthEmployee) {
		this.oneMonthEmployee = oneMonthEmployee;
	}

	public List<Employee> getMoreThanOneMonthEmployee() {

		if (moreThanOneMonthEmployee == null) {
			return new ArrayList<Employee>();
		}
		return moreThanOneMonthEmployee;
	}

	public void setMoreThanOneMonthEmployee(List<Employee> moreThanOneMonthEmployee) {
		this.moreThanOneMonthEmployee = moreThanOneMonthEmployee;
	}

	public List<Employee> getAllEmployeeList() {
		return allEmployeeList;
	}

	public void setAllEmployeeList(List<Employee> allEmployeeList) {
		this.allEmployeeList = allEmployeeList;
	}

	@Override
	public String toString() {
		return "CourseData [courseId=" + courseId + ", courseName=" + courseName + ", oneMonthEmployee="
				+ oneMonthEmployee + ", moreThanOneMonthEmployee=" + moreThanOneMonthEmployee + ", allEmployeeList="
				+ allEmployeeList + "]";
	}

}
