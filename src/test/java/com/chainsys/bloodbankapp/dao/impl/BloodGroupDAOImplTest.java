package com.chainsys.bloodbankapp.dao.impl;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodGroupDAOImplTest {

	public static void main(String[] args) throws DbException {

		findByBloodGroupIdValid();
		findByBloodGroupIdInValid();
	}

	public static void findByBloodGroupIdValid() throws DbException {

		System.out.println("#### findByBloodGroupIdValid ####");
		BloodGroupDAO bloodGroupDAO = new BloodGroupDAOImpl();
		BloodGroup bloodGroup = bloodGroupDAO.findByBloodGroupName("B+ve");

		System.out.println(bloodGroup);

	}

	public static void findByBloodGroupIdInValid() throws DbException {
		
		System.out.println("#### findByBloodGroupIdInValid ####");
		BloodGroupDAO bloodGroupDAO = new BloodGroupDAOImpl();
		BloodGroup bloodGroup = bloodGroupDAO.findByBloodGroupName("AB1+ve");

		System.out.println(bloodGroup);

	}
}
