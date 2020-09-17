package com.chainsys.bloodbankapp.dao;

import java.util.List;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public interface BloodGroupDAO {

	BloodGroup findByBloodGroupName(String bloodGroup) throws DbException;

	List<BloodGroup> findAll();

	BloodGroup findOne(int bloodGroupId);

	void delete(int bloodGroupId);

	void save(BloodGroup bloodGroup);

	void update(BloodGroup bloodGroup);

}
