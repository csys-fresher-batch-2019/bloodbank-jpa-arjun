package com.chainsys.bloodbankapp.validator;

import com.chainsys.bloodbankapp.exception.ValidatorException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodGroupValidator {

	public void validateBloodGroup(String bloodGroup) throws ValidatorException {
		if (bloodGroup == null || "".equals(bloodGroup.trim())) {
			throw new ValidatorException("Blood Group name cannot be blank/empty");
		}
	}

	public void validateBloodGroupId(int bloodGroupId) {
		if (bloodGroupId <= 0) {
			throw new ValidatorException("BloodGroupId must be positive number");
		}
	}

	public void validateBloodGroup(BloodGroup bloodGroup) {
		if (bloodGroup == null) {
			throw new ValidatorException("BloodGroup cannot be null");
		} else if (bloodGroup.getBloodGroup() == null || "".equals(bloodGroup.getBloodGroup().trim())) {
			throw new ValidatorException("Blood Group name cannot be blank/empty");
		}
	}

}
