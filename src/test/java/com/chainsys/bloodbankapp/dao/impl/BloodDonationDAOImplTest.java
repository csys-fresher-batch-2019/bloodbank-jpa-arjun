package com.chainsys.bloodbankapp.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodDonationDAO;
import com.chainsys.bloodbankapp.model.BloodDonation;
import com.chainsys.bloodbankapp.model.User;

public class BloodDonationDAOImplTest {

	private static BloodDonationDAO bloodDonationDAO = new BloodDonationDAOImpl();

	public static void main(String[] args) {

		// saveBloodDonation();
		// findAllValid();
		// findByUserId();
		// count();
	}

	private static void count() {

		Long count = bloodDonationDAO.count();
		System.out.println(count);

	}

	private static void findByUserId() {

		int userId = 102;
		List<BloodDonation> bloodDonation = bloodDonationDAO.findByUserId(userId);
		System.out.println(bloodDonation);

	}

	private static void findAllValid() {

		List<BloodDonation> bloodDonation = bloodDonationDAO.findAll();
		System.out.println(bloodDonation);

	}

	private static void saveBloodDonation() {

		BloodDonation bloodDonation = new BloodDonation();
		User user = new User();
		user.setUserId(102);
		bloodDonation.setUser(user);
		bloodDonation.setDonatedOn(LocalDate.parse("2020-09-14"));
		bloodDonation.setCreatedOn(LocalDateTime.now());
		bloodDonation.setModifiedOn(LocalDateTime.now());
		bloodDonationDAO.save(bloodDonation);

	}

}
