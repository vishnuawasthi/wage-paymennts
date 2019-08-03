package com.app.service;

import com.app.dto.CaseDetails;

public interface ExampleService {

	boolean isMedicalCase(CaseDetails caseDetails);
	
	boolean isBHCase(CaseDetails caseDetails);

}
