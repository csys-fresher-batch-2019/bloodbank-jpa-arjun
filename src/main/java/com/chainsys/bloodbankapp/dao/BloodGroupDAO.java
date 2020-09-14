package com.chainsys.bloodbankapp.dao;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public interface BloodGroupDAO {

	BloodGroup findByBloodGroupName(String bloodGroup) throws DbException;

}
