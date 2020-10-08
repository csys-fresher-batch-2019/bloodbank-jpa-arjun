package com.chainsys.bloodbankapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ServiceException;
import com.chainsys.bloodbankapp.model.BloodDonation;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.model.User;

public class UserServiceTest {

	private static UserService userService = new UserService();

	public static void main(String[] args) throws ServiceException, DbException {

		 findByBloodGroupValid();
		 findByBloodGroupInValid();

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

		// saveUser();

		// saveUserWithDonation();

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

	private static void findByBloodGroupValid() throws ServiceException {

		System.out.println("#### findByBloodGroupValid ####");
		List<User> list = userService.findByBloodGroup("A+ve");
		System.out.println(list);

	}

	private static void findByBloodGroupInValid() throws ServiceException {

		System.out.println("#### findByBloodGroupInValid ####");
		List<User> list = userService.findByBloodGroup("AB+ve");
		System.out.println(list);
	}

	// findByBloodGroupWithCity

	private static void findByBloodGroupWithCityValid() throws ServiceException {

		System.out.println("#### findByBloodGroupWithCityValid ####");
		List<User> list = userService.findByBloodGroupWithCity("A+ve", "Madurai");
		System.out.println(list);

	}

	private static void findByBloodGroupWithCityInValidBloodGroup() throws ServiceException {

		System.out.println("#### findByBloodGroupWithCityInValidBloodGroup ####");
		List<User> list = userService.findByBloodGroupWithCity("AB+ve", "Madurai");
		System.out.println(list);

	}

	private static void findByBloodGroupWithCityInValidCity() throws ServiceException {

		System.out.println("#### findByBloodGroupWithCityInValidCity ####");
		List<User> list = userService.findByBloodGroupWithCity("A+ve", "Chennai");
		System.out.println(list);

	}

	private static void findByBloodGroupWithCityInValidBloodGroupAndCity() throws ServiceException {

		System.out.println("#### findByBloodGroupWithCityInValidBloodGroupAndCity ####");
		List<User> list = userService.findByBloodGroupWithCity("AB+ve", "Chennai");
		System.out.println(list);

	}

	// findByMail

	private static void findByMailValid() throws ServiceException {

		System.out.println("#### findByMailValid ####");
		User user = userService.findByEmail("arjunae798@gmail.com");
		System.out.println(user);

	}

	private static void findByMailInValid() throws ServiceException {

		System.out.println("#### findByMailInValid ####");
		User user = userService.findByEmail("kumarrathnaaa@gmail.com");
		System.out.println(user);

	}

	// findByUserId

	private static void findByUserIdValid() throws ServiceException {

		System.out.println("#### findByUserIdValid ####");
		User user = userService.findByUserId(101);
		System.out.println(user);

	}

	private static void findByUserIdInValid() throws ServiceException {

		System.out.println("#### findByUserIdInValid ####");
		User user = userService.findByUserId(11);
		System.out.println(user);

	}

	// count

	private static void countInCity() throws ServiceException {

		Long count = userService.countInCity("A+ve", "Madurai");
		System.out.println(count);
	}

	// save

	private static void saveUser() throws ServiceException {

		User user = new User();
		user.setUserName("Rathna");
		user.setGender("M");
		user.setAge(24);
		user.setEmail("rathnakumar@gmail.com");
		user.setActive(true);
		user.setCity("Madurai");
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroupId(3);
		user.setBloodGroup(bg);
		user.setMobileNumber(8979695789l);
		user.setPassword("rathna");
		user.setUserType("D");
		userService.save(user);

	}

	private static void saveUserWithDonation() throws ServiceException {

		User user = new User();
		user.setUserName("Rathnakumar");
		user.setGender("M");
		user.setAge(24);
		user.setEmail("rathnakumar2@gmail.com");
		user.setActive(true);
		user.setCity("Madurai");
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroupId(10);
		bg.setBloodGroup("AB1+ve");
		user.setBloodGroup(bg);
		user.setMobileNumber(8979695689l);
		user.setPassword("rathna");
		/*List<BloodDonation> bloodDonationList = new ArrayList<BloodDonation>();
		BloodDonation bloodDonation = new BloodDonation();
		bloodDonation.setUser(user);
		bloodDonation.setDonatedOn(LocalDate.now());
		bloodDonation.setCreatedOn(LocalDateTime.now());
		bloodDonation.setModifiedOn(LocalDateTime.now());
		bloodDonationList.add(bloodDonation);
		user.setBloodDonations(bloodDonationList);*/
		userService.save(user);

	}

	// update

	private static void updateDonateStatus() throws ServiceException {

		User user = userService.findByEmail("rathnakumar2@gmail.com"); // getting that row
		user.setActive(false);
		userService.update(user);

	}

	private static void updateEmail() throws ServiceException {

		User user = userService.findByUserId(252);
		user.setEmail("rathnakumarrrrr@gmail.com");
		userService.update(user);
	}

	private static void updateBloodGroup() throws DbException, ServiceException {

		BloodGroupService bloodGroupService = new BloodGroupService();
		BloodGroup bloodGroup = bloodGroupService.findByBloodGroupName("O+ve");
		User user = userService.findByUserId(252);
		user.setBloodGroup(bloodGroup);
		userService.update(user);

	}

	private static void updateCity() throws ServiceException {

		User user = userService.findByUserId(252);
		user.setCity("Chennai");
		userService.update(user);

	}

	private static void updateName() throws ServiceException {

		User user = userService.findByUserId(252);
		user.setUserName("Rathna Kumar");
		userService.update(user);

	}

	private static void updateMobileNumber() throws ServiceException {

		User user = userService.findByUserId(252);
		user.setMobileNumber(9876543210l);
		userService.update(user);

	}

	private static void updatePassword() throws ServiceException {

		User user = userService.findByUserId(252);
		user.setPassword("rathnaKumar");
		userService.update(user);

	}

	// delete

	private static void deleteByUserId() throws ServiceException {

		userService.delete(352);

	}

}
