package com.app.dto;

import java.util.List;

public class DepartmentResultDTO {

	private Long deptId;

	private String deptName;

	private String deptType;

	private String code;

	List<Long> employeeIdList;

	List<Employee> employeesList;

	private List<Employee> salesEmployees;

	private List<Employee> mrktEmployees;
	
	private List<Employee> otherEmployees;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DepartmentResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Long> getEmployeeIdList() {
		return employeeIdList;
	}

	public void setEmployeeIdList(List<Long> employeeIdList) {
		this.employeeIdList = employeeIdList;
	}

	public DepartmentResultDTO(Long deptId, String deptName, String deptType, String code) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptType = deptType;
		this.code = code;
	}

	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}

	public List<Employee> getSalesEmployees() {
		return salesEmployees;
	}

	public void setSalesEmployees(List<Employee> salesEmployees) {
		this.salesEmployees = salesEmployees;
	}

	public List<Employee> getMrktEmployees() {
		return mrktEmployees;
	}

	public void setMrktEmployees(List<Employee> mrktEmployees) {
		this.mrktEmployees = mrktEmployees;
	}

	
	
	public List<Employee> getOtherEmployees() {
		return otherEmployees;
	}

	public void setOtherEmployees(List<Employee> otherEmployees) {
		this.otherEmployees = otherEmployees;
	}

	@Override
	public String toString() {
		return "DepartmentResultDTO [deptId=" + deptId + ", deptName=" + deptName + ", deptType=" + deptType + ", code="
				+ code + ", salesEmployees=" + salesEmployees + ", mrktEmployees=" + mrktEmployees + ", otherEmployees="
				+ otherEmployees + "]";
	}

	

}
