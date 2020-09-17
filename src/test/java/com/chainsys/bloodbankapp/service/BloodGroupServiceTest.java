package com.chainsys.bloodbankapp.service;

import java.util.List;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodGroupServiceTest {

	private static BloodGroupService bloodGroupService = new BloodGroupService();

	public static void main(String[] args) throws ServiceException {

		// findByBloodGroup();
		// findByBloodGroupInvalid();
		// findAll();
		// findByBloodGroupId();
		// findByBloodGroupIdInvalid();
		// saveBloodGroup();
		// saveBloodGroupInvalid();
		// updateBloodGroup();
		// updateBloodGroupInvalid();
		// updateBloodGroupInvalidAlreadyExist();
		// deleteBloodGroup();
		// deleteBloodGroupInvalid();

	}

	private static void updateBloodGroupInvalid() throws ServiceException {

		BloodGroup bloodGroup = new BloodGroup();
		bloodGroup.setBloodGroupId(1);
		bloodGroup.setBloodGroup("");
		bloodGroupService.update(bloodGroup);

	}

	private static void updateBloodGroupInvalidAlreadyExist() throws ServiceException {

		BloodGroup bloodGroup = new BloodGroup();
		bloodGroup.setBloodGroupId(1);
		bloodGroup.setBloodGroup("AB+ve");
		bloodGroupService.update(bloodGroup);

	}

	private static void saveBloodGroupInvalid() throws ServiceException {

		BloodGroup bloodGroup = new BloodGroup();
		bloodGroup.setBloodGroupId(1000);
		bloodGroup.setBloodGroup("");
		bloodGroupService.save(bloodGroup);

	}

	private static void deleteBloodGroupInvalid() throws ServiceException {

		bloodGroupService.delete(100);

	}

	private static void findByBloodGroupIdInvalid() throws ServiceException {

		BloodGroup bloodGroupId = bloodGroupService.findOne(0);
		System.out.println(bloodGroupId);

	}

	private static void findByBloodGroupInvalid() throws ServiceException {

		BloodGroup bloodGroup = bloodGroupService.findByBloodGroupName("  ");
		System.out.println(bloodGroup);

	}

	private static void findByBloodGroup() throws ServiceException {

		BloodGroup bloodGroup = bloodGroupService.findByBloodGroupName("B+ve");
		System.out.println(bloodGroup);

	}

	private static void findAll() throws ServiceException {

		List<BloodGroup> list = bloodGroupService.findAll();
		System.out.println(list);
	}

	private static void findByBloodGroupId() throws ServiceException {

		BloodGroup bloodGroup = bloodGroupService.findOne(7);
		System.out.println(bloodGroup);

	}

	private static void saveBloodGroup() throws ServiceException {

		BloodGroup bloodGroup = new BloodGroup();
		bloodGroup.setBloodGroupId(10);
		bloodGroup.setBloodGroup("A1B+ve");
		bloodGroupService.save(bloodGroup);

	}

	private static void updateBloodGroup() throws ServiceException {

		BloodGroup bloodGroup = new BloodGroup();
		bloodGroup.setBloodGroupId(1);
		bloodGroup.setBloodGroup("A+ve");
		bloodGroupService.update(bloodGroup);

	}

	private static void deleteBloodGroup() throws ServiceException {

		bloodGroupService.delete(10);

	}

}
