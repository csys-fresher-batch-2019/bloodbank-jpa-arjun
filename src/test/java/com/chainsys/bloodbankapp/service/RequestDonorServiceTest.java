package com.chainsys.bloodbankapp.service;

import java.time.LocalDateTime;

import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.model.RequestDonor;
import com.chainsys.bloodbankapp.model.User;

public class RequestDonorServiceTest {

	private static RequestDonorService requestDonorService = new RequestDonorService();

	public static void main(String[] args) throws ServiceException {

		// save();
		// findById();
		// update();
		// delete();
	}

	private static void delete() throws ServiceException {
		requestDonorService.delete(202);
	}

	private static void update() throws ServiceException {
		RequestDonor requestDonor = requestDonorService.findOne(202);
		requestDonor.setStatus("OPENED");
		requestDonorService.update(requestDonor);
	}

	private static void findById() throws ServiceException {
		RequestDonor requestDonor = requestDonorService.findOne(952);
		System.out.println(requestDonor);
	}

	private static void save() throws ServiceException {
		RequestDonor requestDonor = new RequestDonor();
		requestDonor.setTitle("Request for B+ve Blood Group");
		requestDonor.setDescription("contact Chellam : 9876543210 who is the son of patient Charen");
		// requestDonor.setPostedBy("Arjun kumar");
		User postedBy = new User();
		postedBy.setUserId(1);
		requestDonor.setPostedBy(postedBy);
		requestDonor.setPostedDate(LocalDateTime.now());
		requestDonor.setStatus("PENDING");
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroupId(8);
		requestDonor.setBloodGroup(bg);
		requestDonorService.save(requestDonor);
	}
}
