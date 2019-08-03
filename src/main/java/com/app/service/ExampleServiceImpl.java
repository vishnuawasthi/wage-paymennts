/**
 * 
 */
package com.app.service;

import org.springframework.stereotype.Service;

import com.app.dto.CaseDetails;

/**
 * @author Dell
 *
 */

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	/* (non-Javadoc)
	 * @see com.app.service.ExampleService#isMedicalCase(com.app.dto.CaseDetails)
	 */
	
	@Override
	public boolean isMedicalCase(CaseDetails caseDetails) {
		return caseDetails.getAssignedCases().contains("MED");
	}

	@Override
	public boolean isBHCase(CaseDetails caseDetails) {
		return caseDetails.getAssignedCases().contains("BH");
	}
	
	

}
