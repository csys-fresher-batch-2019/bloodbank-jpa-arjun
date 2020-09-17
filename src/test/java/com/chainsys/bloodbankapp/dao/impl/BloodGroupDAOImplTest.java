package com.chainsys.bloodbankapp.dao.impl;

import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodGroupDAOImplTest {

	private static BloodGroupDAO bloodGroupDAO = new BloodGroupDAOImpl();

	public static void main(String[] args) throws DbException {

		// findByBloodGroupIdValid();
		// findByBloodGroupIdInValid();
		// findAll();
		// findByBloodGroup();
		// saveBloodGroup();
		// updateBloodGroup();
		// deleteBloodGroup();
	}

	public static void findByBloodGroupIdValid() throws DbException {

		System.out.println("#### findByBloodGroupIdValid ####");
		BloodGroup bloodGroup = bloodGroupDAO.findByBloodGroupName("B+ve");
		System.out.println(bloodGroup);

	}

	public static void findByBloodGroupIdInValid() throws DbException {

		System.out.println("#### findByBloodGroupIdInValid ####");
		BloodGroup bloodGroup = bloodGroupDAO.findByBloodGroupName("AB1+ve");
		System.out.println(bloodGroup);

	}

	private static void findAll() throws DbException {

		List<BloodGroup> list = bloodGroupDAO.findAll();
		System.out.println(list);

	}

	private static void findByBloodGroup() throws DbException {

		BloodGroup bloodGroupId = bloodGroupDAO.findOne(6);
		System.out.println(bloodGroupId);

	}

	private static void saveBloodGroup() {

		BloodGroup bloodGroup = new BloodGroup();
		bloodGroup.setBloodGroupId(10);
		bloodGroup.setBloodGroup("A1B+ve");
		bloodGroupDAO.save(bloodGroup);

	}

	private static void updateBloodGroup() throws DbException {

		BloodGroup bloodGroup = bloodGroupDAO.findByBloodGroupName("A1B+ve"); // selecting the bloodGroup
		bloodGroup.setBloodGroup("A1B-ve"); // changing/updating that bloodGroup
		bloodGroupDAO.update(bloodGroup);

	}

	private static void deleteBloodGroup() {

		bloodGroupDAO.delete(10);

	}

}
