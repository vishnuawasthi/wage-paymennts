package com.app.dto;

import java.util.List;

public class DiscriminatorExampleDTO {

	private List<Long> deptSalesEmployees;

	private List<Long> deptMrktEmployees;

	public List<Long> getDeptSalesEmployees() {
		return deptSalesEmployees;
	}

	public void setDeptSalesEmployees(List<Long> deptSalesEmployees) {
		this.deptSalesEmployees = deptSalesEmployees;
	}

	public List<Long> getDeptMrktEmployees() {
		return deptMrktEmployees;
	}

	public void setDeptMrktEmployees(List<Long> deptMrktEmployees) {
		this.deptMrktEmployees = deptMrktEmployees;
	}

	@Override
	public String toString() {
		return "DiscriminatorExampleDTO [deptSalesEmployees=" + deptSalesEmployees + ", deptMrktEmployees="
				+ deptMrktEmployees + "]";
	}

	public DiscriminatorExampleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
