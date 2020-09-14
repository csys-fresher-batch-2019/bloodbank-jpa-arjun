package com.chainsys.bloodbankapp.dao;

import com.chainsys.bloodbankapp.exception.DbException;

public interface BloodGroupDAO {

	int findByBloodGroupId(String bloodGroup) throws DbException;

}
