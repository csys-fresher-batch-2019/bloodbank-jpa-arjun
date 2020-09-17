package com.chainsys.bloodbankapp.service;

import java.util.List;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodGroupServiceTest {

	private static BloodGroupService bloodGroupService = new BloodGroupService();

	public static void main(String[] args) throws DbException, ServiceException {

		// findByBloodGroup();
		// findAll();
		// findByBloodGroupId();
		// saveBloodGroup();
		// updateBloodGroup();
		// deleteBloodGroup();

	}

	private static void findByBloodGroup() throws DbException, ServiceException {

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

	private static void updateBloodGroup() throws ServiceException, DbException {

		BloodGroup bloodGroup = bloodGroupService.findByBloodGroupName("A1B+ve");
		bloodGroup.setBloodGroup("A1B-ve");
		bloodGroupService.update(bloodGroup);

	}

	private static void deleteBloodGroup() throws ServiceException {

		bloodGroupService.delete(10);

	}

}
