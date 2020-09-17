package com.chainsys.bloodbankapp.service;

import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodDonationDAO;
import com.chainsys.bloodbankapp.dao.impl.BloodDonationDAOImpl;
import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.BloodDonation;

public class BloodDonationService {

	private BloodDonationDAO bloodDonationDAO = new BloodDonationDAOImpl();

	public void save(BloodDonation bloodDonation) throws ServiceException {
		try {
			bloodDonationDAO.save(bloodDonation);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to save Blood Donation");
		}
	}

	public List<BloodDonation> findAll() throws ServiceException {

		List<BloodDonation> list = null;
		try {
			list = bloodDonationDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch Blood Donation Details");
		}
		return list;
	}

	public List<BloodDonation> findByUserId(int userId) throws ServiceException {

		List<BloodDonation> list = null;
		try {
			list = bloodDonationDAO.findByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch Blood Donation Details");
		}
		return list;

	}

	public Long count() throws ServiceException {

		Long count = null;
		try {
			count = bloodDonationDAO.count();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch Blood Donation Count");
		}
		return count;

	}

}
