package com.chainsys.bloodbankapp.dao.impl;

import java.time.LocalDateTime;

import com.chainsys.bloodbankapp.dao.RequestDonorDAO;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.model.RequestDonor;
import com.chainsys.bloodbankapp.model.User;

public class RequestDonorDAOImplTest {

	private static RequestDonorDAO requestDonorDAO = new RequestDonorDAOImpl();

	public static void main(String[] args) {

		// save();
		// findById();
		// update();
		// delete();
	}

	private static void delete() {
		requestDonorDAO.delete(152);
	}

	private static void update() {
		RequestDonor requestDonor = requestDonorDAO.findOne(152);
		requestDonor.setStatus("OPENED");
		requestDonorDAO.update(requestDonor);
	}

	private static void findById() {
		RequestDonor requestDonor = requestDonorDAO.findOne(152);
		System.out.println(requestDonor);

	}

	private static void save() {
		RequestDonor requestDonor = new RequestDonor();
		requestDonor.setTitle("Request for B+ve Blood Group");
		requestDonor.setDescription("contact Chellam : 9876543210 who is the son of patient Charen");
		// requestDonor.setPostedBy("Arjun");
		User postedBy = new User();
		postedBy.setUserId(1);
		requestDonor.setPostedBy(postedBy);
		requestDonor.setPostedDate(LocalDateTime.now());
		requestDonor.setStatus("PENDING");
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroupId(3);
		requestDonor.setBloodGroup(bg);
		requestDonorDAO.save(requestDonor);
	}

}
