package com.chainsys.bloodbankapp.service;

import java.util.List;

import com.chainsys.bloodbankapp.dao.UserDAO;
import com.chainsys.bloodbankapp.dao.impl.UserDAOImpl;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.User;

public class UserService {

	private UserDAO userDAO = new UserDAOImpl();

	public List<User> findByBloodGroup(String bloodGroup) throws ServiceException {

		List<User> list = null;
		try {
			list = userDAO.findByBloodGroup(bloodGroup);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch User Details");
		}
		return list;
	}

	public List<User> findByBloodGroupWithCity(String bloodGroup, String city) throws ServiceException {

		List<User> list = null;
		try {
			list = userDAO.findByBloodGroupWithCity(bloodGroup, city);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch User Details");
		}
		return list;
	}

	public User findByEmail(String email) throws ServiceException {
		User user = null;
		try {
			user = userDAO.findByEmail(email);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch Email");
		}
		return user;

	}

	public User findByUserId(int userId) throws ServiceException {
		User user = null;
		try {
			user = userDAO.findByUserId(userId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch UserId");
		}
		return user;
	}

	public Long countInCity(String bloodGroup, String city) throws ServiceException {
		Long count;
		try {
			count = userDAO.countInCity(bloodGroup, city);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch User Details Count");
		}
		return count;
	}

	public void save(User a) throws ServiceException {
		try {
			userDAO.save(a);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to save User");
		}
	}

	public void update(User user) throws ServiceException {
		try {
			userDAO.update(user);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to update User Details");
		}
	}

	public void delete(int userId) throws ServiceException {
		try {
			userDAO.delete(userId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to delete User Details");
		}
	}

}
