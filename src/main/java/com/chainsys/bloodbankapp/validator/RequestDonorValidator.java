package com.chainsys.bloodbankapp.validator;

import com.chainsys.bloodbankapp.exception.ValidatorException;
import com.chainsys.bloodbankapp.model.RequestDonor;

public class RequestDonorValidator {

	public void validateBloodGroupId(int bloodGroupId) {
		if (bloodGroupId <= 0) {
			throw new ValidatorException("BloodGroupId must be positive number");
		}
	}
	
	public void validateStatus(RequestDonor requestDonor) {
		String status = requestDonor.getStatus();
		if(!(status.equals("OPENED") || status.equals("PENDING") || status.equals("CLOSED"))) {
			throw new ValidatorException("Invalid Status");
		}
	}
}
