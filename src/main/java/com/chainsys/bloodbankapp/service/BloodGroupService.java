package com.chainsys.bloodbankapp.service;

import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.dao.impl.BloodGroupDAOImpl;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.exception.ValidatorException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.validator.BloodGroupValidator;

public class BloodGroupService {

	private BloodGroupDAO bloodGroupDAO = new BloodGroupDAOImpl();

	private BloodGroupValidator bloodGroupValidator = new BloodGroupValidator();

	public BloodGroup findByBloodGroupName(String bloodGroup) throws ServiceException {

		BloodGroup bloodGroupObj;
		try {
			bloodGroupValidator.validateBloodGroup(bloodGroup);
			bloodGroupObj = bloodGroupDAO.findByBloodGroupName(bloodGroup);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch BloodGroup Details");
		}
		return bloodGroupObj;

	}

	public List<BloodGroup> findAll() throws ServiceException {

		List<BloodGroup> list;
		try {
			list = bloodGroupDAO.findAll();
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch BloodGroup Details");
		}
		return list;
	}

	public BloodGroup findOne(int bloodGroupId) throws ServiceException {

		BloodGroup bloodGroup;
		try {
			bloodGroupValidator.validateBloodGroupId(bloodGroupId);
			bloodGroup = bloodGroupDAO.findOne(bloodGroupId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch BloodGroup Details");
		}
		return bloodGroup;

	}

	public void delete(int bloodGroupId) throws ServiceException {

		try {
			bloodGroupValidator.validateBloodGroupId(bloodGroupId);			// case 1 : id <= 0 , then it throws exception
			BloodGroup bloodGroup = bloodGroupDAO.findOne(bloodGroupId);	// case 2 : id = 1 to infinity	
			if (bloodGroup == null) {										// case 3 : id = invalid , then it throws exception
				throw new ValidatorException("Invalid BloodGroupId");
			}
			bloodGroupDAO.delete(bloodGroupId);								// case 4 : id = valid						
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to delete Blood Group");
		}

	}

	public void save(BloodGroup bloodGroup) throws ServiceException {
		
		try {
			bloodGroupValidator.validateBloodGroup(bloodGroup);
			BloodGroup bloodGroupObj = bloodGroupDAO.findByBloodGroupName(bloodGroup.getBloodGroup());
			if (bloodGroupObj != null) {
				throw new ValidatorException("BloodGroup name already exists");
			}
			bloodGroupDAO.save(bloodGroup);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to save Blood Group");
		}

	}

	public void update(BloodGroup bloodGroup) throws ServiceException {

		try {
			bloodGroupValidator.validateBloodGroup(bloodGroup);												// bg validatation
			bloodGroupValidator.validateBloodGroupId(bloodGroup.getBloodGroupId());							// bg_id validatation
			BloodGroup bloodGroupObj = bloodGroupDAO.findOne(bloodGroup.getBloodGroupId());					// getting row w.r.to bg_id
			if (bloodGroupObj == null) {																	// if( bg_id is not in db),then it throws exception
				throw new ValidatorException("Invalid BloodGroupId");
			}
			BloodGroup bloodGroupObj2 = bloodGroupDAO.findByBloodGroupName(bloodGroup.getBloodGroup());		// getting row w.r.to bg
			if (bloodGroupObj2 != null) {																	// if( bg is already there), then it throws exception 	
				throw new ValidatorException("BloodGroup Name already exists");
			}
			bloodGroupDAO.update(bloodGroup);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to update BloodGroup");
		}

	}

}
