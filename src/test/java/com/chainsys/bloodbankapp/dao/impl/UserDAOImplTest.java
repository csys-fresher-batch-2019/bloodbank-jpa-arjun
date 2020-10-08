package com.chainsys.bloodbankapp.dao.impl;

import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.dao.UserDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.model.User;

public class UserDAOImplTest {

	public static void main(String[] args) throws DbException {

		////////////// find///////////////

		// findByBloodGroupValid();
		// findByBloodGroupInValid();

		// findByBloodGroupWithCityValid();
		// findByBloodGroupWithCityInValidBloodGroup();
		// findByBloodGroupWithCityInValidCity();
		// findByBloodGroupWithCityInValidBloodGroupAndCity();

		// findByMailValid();
		// findByMailInValid();

		// findByUserIdValid();
		// findByUserIdInValid();

		// countInCity();

		////////////// save///////////////

		// saveUserValid();

		////////////// update///////////////

		// updateDonateStatus();

		// updateEmail();

		// updateBloodGroup();

		// updateCity();

		// Extra//

		// updateName();

		// updateMobileNumber();

		// updatePassword();

		////////////// delete///////////////

		// deleteByUserId();
	}

	// findByBloodGroup

	private static void findByBloodGroupValid() throws DbException {
		System.out.println("#### findByBloodGroupValid ####");
		UserDAO userDAO = new UserDAOImpl();
		List<User> bloodGroup = userDAO.findByBloodGroup("A+ve");
		System.out.println(bloodGroup);

	}

	private static void findByBloodGroupInValid() throws DbException {
		System.out.println("#### findByBloodGroupInValid ####");
		UserDAO userDAO = new UserDAOImpl();
		List<User> bloodGroup = userDAO.findByBloodGroup("AB1+ve");
		System.out.println(bloodGroup);

	}

	// findByBloodGroupWithCity

	private static void findByBloodGroupWithCityValid() throws DbException {
		System.out.println("#### findByBloodGroupWithCityValid ####");
		UserDAO userDAO = new UserDAOImpl();
		List<User> bloodGroupWithCity = userDAO.findByBloodGroupWithCity("A+ve", "Madurai");
		System.out.println(bloodGroupWithCity);

	}

	private static void findByBloodGroupWithCityInValidBloodGroup() throws DbException {
		System.out.println("#### findByBloodGroupWithCityInValidBloodGroup ####");
		UserDAO userDAO = new UserDAOImpl();
		List<User> bloodGroupWithCity = userDAO.findByBloodGroupWithCity("B+ve", "Madurai");
		System.out.println(bloodGroupWithCity);

	}

	private static void findByBloodGroupWithCityInValidCity() throws DbException {
		System.out.println("#### findByBloodGroupWithCityInValidCity ####");
		UserDAO userDAO = new UserDAOImpl();
		List<User> bloodGroupWithCity = userDAO.findByBloodGroupWithCity("A+ve", "Chennai");
		System.out.println(bloodGroupWithCity);

	}

	private static void findByBloodGroupWithCityInValidBloodGroupAndCity() throws DbException {
		System.out.println("#### findByBloodGroupWithCityInValidBloodGroupAndCity ####");
		UserDAO userDAO = new UserDAOImpl();
		List<User> bloodGroupWithCity = userDAO.findByBloodGroupWithCity("B+ve", "Chennai");
		System.out.println(bloodGroupWithCity);

	}

	// findByMail

	private static void findByMailValid() throws DbException {

		System.out.println("#### findByMailValid ####");
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByEmail("arjunae798@gmail.com");
		boolean existEmail = false;
		if (user != null) {
			existEmail = true;
		} else {
			existEmail = false;
		}
		System.out.println(user);
		System.out.println(existEmail);
	}

	private static void findByMailInValid() throws DbException {

		System.out.println("#### findByMailInValid ####");
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByEmail("akash@gmail.com");
		boolean existEmail = false;
		if (user != null) {
			existEmail = true;
		} else {
			existEmail = false;
		}
		System.out.println(user);
		System.out.println(existEmail);
	}

	// findByUserId

	private static void findByUserIdValid() throws DbException {

		System.out.println("#### findByUserIdValid ####");
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByUserId(1);
		boolean existUserId = false;
		if (user != null) {
			existUserId = true;
		} else {
			existUserId = false;
		}
		System.out.println(user);
		System.out.println(existUserId);

	}

	private static void findByUserIdInValid() throws DbException {

		System.out.println("#### findByUserIdInValid ####");
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByUserId(106);
		boolean existUserId = false;
		if (user != null) {
			existUserId = true;
		} else {
			existUserId = false;
		}
		System.out.println(user);
		System.out.println(existUserId);

	}

	// count

	private static void countInCity() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		Long count = userDAO.countInCity("A+ve", "Madurai");
		System.out.println(count);

	}

	// save

	private static void saveUserValid() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		User user = new User();
		user.setUserName("Kumar");
		user.setGender("M");
		user.setAge(23);
		user.setEmail("kumar@gmail.com");
		user.setActive(true);
		user.setCity("Madurai");
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroupId(7);
		user.setBloodGroup(bg);
		user.setMobileNumber(8979696321l);
		user.setPassword("kumar");
		user.setUserType("E");
		userDAO.save(user);

	}

	// update

	private static void updateDonateStatus() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByEmail("kumar@gmail.com"); // getting that row
		user.setActive(false); // change that column
		userDAO.update(user);
	}

	private static void updateEmail() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByUserId(152);
		user.setEmail("kumarrrrr@gmail.com");
		userDAO.update(user);

	}

	private static void updateBloodGroup() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		BloodGroupDAO bloodGroupDAO = new BloodGroupDAOImpl();
		BloodGroup bloodGroup = bloodGroupDAO.findByBloodGroupName("A+ve");
		User user = userDAO.findByUserId(152);
		user.setBloodGroup(bloodGroup);
		userDAO.update(user);

	}

	private static void updateCity() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByUserId(152);
		user.setCity("Chennai");
		userDAO.update(user);

	}

	private static void updateName() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByUserId(152);
		user.setUserName("Kumarrr Kumar");
		userDAO.update(user);

	}

	private static void updateMobileNumber() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByUserId(152);
		user.setMobileNumber(9812736450l);
		userDAO.update(user);

	}

	private static void updatePassword() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findByUserId(152);
		user.setPassword("kumar98");
		userDAO.update(user);

	}

	// delete

	private static void deleteByUserId() throws DbException {

		UserDAO userDAO = new UserDAOImpl();
		userDAO.delete(152);
	}

}
