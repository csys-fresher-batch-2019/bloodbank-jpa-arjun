package com.chainsys.bloodbankapp.dao;

import java.util.List;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public interface BloodGroupDAO {

	BloodGroup findByBloodGroupName(String bloodGroup) throws DbException;	//i/p = bloodGroup(B+ve) , o/p = bloodGroupId(3)

	List<BloodGroup> findAll() throws DbException;

	BloodGroup findOne(int bloodGroupId) throws DbException;	//i/p = bloodGroupId(3) , o/p = bloodGroup(B+ve)

	void delete(int bloodGroupId);

	void save(BloodGroup bloodGroup);

	void update(BloodGroup bloodGroup);

}
