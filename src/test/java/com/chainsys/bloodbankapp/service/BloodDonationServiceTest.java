package com.chainsys.bloodbankapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.BloodDonation;
import com.chainsys.bloodbankapp.model.User;

public class BloodDonationServiceTest {

	private static BloodDonationService bloodDonationService = new BloodDonationService();

	public static void main(String[] args) throws ServiceException {

		// saveBloodDonation();
		// findAll();
		// findByUserId();
		// count();

	}

	private static void saveBloodDonation() throws ServiceException {

		BloodDonation bloodDonation = new BloodDonation();
		User user = new User();
		user.setUserId(202);
		bloodDonation.setUser(user);
		bloodDonation.setDonatedOn(LocalDate.parse("2020-09-15"));
		bloodDonation.setCreatedOn(LocalDateTime.now());
		bloodDonation.setModifiedOn(LocalDateTime.now());
		bloodDonationService.save(bloodDonation);

	}

	private static void findAll() throws ServiceException {

		List<BloodDonation> bloodDonation = bloodDonationService.findAll();
		System.out.println(bloodDonation);

	}

	private static void findByUserId() throws ServiceException {

		int userId = 202;
		List<BloodDonation> bloodDonation = bloodDonationService.findByUserId(userId);
		System.out.println(bloodDonation);

	}

	private static void count() throws ServiceException {

		Long count = bloodDonationService.count();
		System.out.println(count);

	}

}
