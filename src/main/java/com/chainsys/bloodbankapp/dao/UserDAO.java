package com.chainsys.bloodbankapp.dao;

import java.util.List;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.User;

public interface UserDAO {

	List<User> findByBloodGroup(String bloodGroup) throws DbException;

	int addEmployeeDetails(User a) throws DbException;

	boolean updateDonateStatus(boolean active, String email) throws DbException;

	boolean updateEmail(int userId, String email) throws DbException;

	boolean updateBloodGroup(int userId, String bloodGroup) throws DbException;

	boolean deleteEmployeeRecord(int userId) throws DbException;

	int countInCity(String bloodGroup, String city) throws DbException;

	List<User> findByUserDetails(String bloodGroup, String city) throws DbException;

	boolean updateCity(int userId, String city) throws DbException;

	boolean findByEmail(String email) throws DbException;

	boolean findByUserId(int userId) throws DbException;
}
