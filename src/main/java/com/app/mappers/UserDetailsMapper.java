package com.app.mappers;

import java.util.List;

import com.app.dto.BillDetails;

public interface UserDetailsMapper {

	List<BillDetails> findTotalBillDetails ();
	
	void saveBillDetails(BillDetails billDetails);
}
