package com.chainsys.bloodbankapp.dao;

import com.chainsys.bloodbankapp.model.RequestDonor;

public interface RequestDonorDAO {

	void save(RequestDonor requestDonor);

	RequestDonor findOne(int id);

	void update(RequestDonor requestDonor);
	
	void delete(int id);
}
