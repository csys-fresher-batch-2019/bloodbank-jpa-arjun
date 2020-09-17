package com.chainsys.bloodbankapp.validator;

import com.chainsys.bloodbankapp.exception.ValidatorException;

public class BloodGroupValidatorTest {

	private static BloodGroupValidator bloodGroupValidator = new BloodGroupValidator();
	
	public static void main(String[] args) throws ValidatorException {
		
		String bloodGroup = " ";
		
		bloodGroupValidator.validateBloodGroup(bloodGroup);

	}

}
