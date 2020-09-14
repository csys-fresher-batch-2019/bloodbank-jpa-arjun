package com.chainsys.bloodbankapp.dao.impl;

import java.util.List;

import com.chainsys.bloodbankapp.dao.UserDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.User;

public class UserDAOImpl implements UserDAO {

	public List<User> findByBloodGroup(String bloodGroup) throws DbException {
		
		return null;
	}

	public int addEmployeeDetails(User a) throws DbException {
		
		return 0;
	}

	public boolean updateDonateStatus(boolean active, String email) throws DbException {
		
		return false;
	}

	public boolean updateEmail(int userId, String email) throws DbException {
		
		return false;
	}

	public boolean updateBloodGroup(int userId, String bloodGroup) throws DbException {
		
		return false;
	}

	public boolean deleteEmployeeRecord(int userId) throws DbException {
		
		return false;
	}

	public int countInCity(String bloodGroup, String city) throws DbException {
		
		return 0;
	}

	public List<User> findByUserDetails(String bloodGroup, String city) throws DbException {
		
		return null;
	}

	public boolean updateCity(int userId, String city) throws DbException {
		
		return false;
	}

	public boolean findByEmail(String email) throws DbException {
		
		return false;
	}

	public boolean findByUserId(int userId) throws DbException {
		
		return false;
	}

}
