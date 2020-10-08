package com.chainsys.bloodbankapp.dao;

import java.util.List;

import com.chainsys.bloodbankapp.model.BloodDonation;

public interface BloodDonationDAO {

	void save(BloodDonation bloodDonation);

	List<BloodDonation> findAll();

	List<BloodDonation> findByUserId(int userId);	

	Long count();
}
