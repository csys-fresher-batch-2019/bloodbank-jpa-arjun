package com.chainsys.bloodbankapp.service;

import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.dao.impl.BloodGroupDAOImpl;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodGroupService {

	private BloodGroupDAO bloodGroupDAO = new BloodGroupDAOImpl();

	public BloodGroup findByBloodGroupName(String bloodGroup) throws DbException, ServiceException {

		BloodGroup bloodGroupId;
		try {
			bloodGroupId = bloodGroupDAO.findByBloodGroupName(bloodGroup);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch BloodGroup Details");
		}
		return bloodGroupId;

	}

	List<BloodGroup> findAll() throws ServiceException {

		List<BloodGroup> list;
		try {
			list = bloodGroupDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch BloodGroup Details");
		}
		return list;
	}

	BloodGroup findOne(int bloodGroupId) throws ServiceException {

		BloodGroup bloodGroup;
		try {
			bloodGroup = bloodGroupDAO.findOne(bloodGroupId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch BloodGroup Details");
		}
		return bloodGroup;

	}

	void delete(int bloodGroupId) throws ServiceException {

		try {
			bloodGroupDAO.delete(bloodGroupId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to delete Blood Group");
		}

	}

	void save(BloodGroup bloodGroup) throws ServiceException {

		try {
			bloodGroupDAO.save(bloodGroup);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to save Blood Group");
		}

	}

	void update(BloodGroup bloodGroup) throws ServiceException {

		try {
			bloodGroupDAO.update(bloodGroup);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to update BloodGroup");
		}

	}

}
