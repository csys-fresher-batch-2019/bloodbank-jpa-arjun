package com.chainsys.bloodbankapp.dao;

import java.util.List;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.User;

public interface UserDAO {

	List<User> findByBloodGroup(String bloodGroup) throws DbException;

	List<User> findByBloodGroupWithCity(String bloodGroup, String city) throws DbException;

	User findByEmail(String email) throws DbException;

	User findByUserId(int userId) throws DbException;

	Long countInCity(String bloodGroup, String city) throws DbException;

	void save(User a) throws DbException;

	void update(User user) throws DbException;

	void delete(int userId) throws DbException;

	// boolean updateEmail(int userId, String email) throws DbException;

	// boolean updateBloodGroup(int userId, String bloodGroup) throws DbException;
	// //problem

	// boolean updateCity(int userId, String city) throws DbException;

}
