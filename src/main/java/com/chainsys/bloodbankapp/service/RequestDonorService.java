package com.chainsys.bloodbankapp.service;

import com.chainsys.bloodbankapp.dao.RequestDonorDAO;
import com.chainsys.bloodbankapp.dao.impl.RequestDonorDAOImpl;
import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.RequestDonor;
import com.chainsys.bloodbankapp.validator.RequestDonorValidator;

public class RequestDonorService {

	private RequestDonorDAO requestDonorDAO = new RequestDonorDAOImpl();

	private RequestDonorValidator requestDonorValidator = new RequestDonorValidator();

	public void save(RequestDonor requestDonor) throws ServiceException {
		try {
			requestDonorValidator.validateStatus(requestDonor);
			requestDonorDAO.save(requestDonor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to save RequestDonor");
		}
	}

	public RequestDonor findOne(int id) throws ServiceException {
		RequestDonor requestDonor = null;
		try {
			requestDonor = requestDonorDAO.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch RequestDonor Details");
		}
		return requestDonor;
	}

	public void update(RequestDonor requestDonor) throws ServiceException {
		try {
			requestDonorValidator.validateStatus(requestDonor);
			requestDonorDAO.update(requestDonor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to update RequestDonor Details");
		}
	}

	public void delete(int id) throws ServiceException {
		try {
			requestDonorDAO.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to update RequestDonor Details");
		}
	}
}
