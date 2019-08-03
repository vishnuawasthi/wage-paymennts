package com.app.dto;

import java.util.List;

public class CaseDetails {

	private String caseName;

	private List<String> assignedCases;

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public List<String> getAssignedCases() {
		return assignedCases;
	}

	public void setAssignedCases(List<String> assignedCases) {
		this.assignedCases = assignedCases;
	}

	public CaseDetails(String caseName, List<String> assignedCases) {
		super();
		this.caseName = caseName;
		this.assignedCases = assignedCases;
	}

}
