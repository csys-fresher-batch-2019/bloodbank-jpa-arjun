package com.chainsys.bloodbankapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.JPAUtil;

public class BloodGroupDAOImpl implements BloodGroupDAO {

	private static final EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
	
	public BloodGroup findByBloodGroupName(String bloodGroup) throws DbException {
		BloodGroup bg =null;
		try {
			EntityManager em = emf.createEntityManager();
			TypedQuery<BloodGroup> query = em.createQuery("from BloodGroup b where b.bloodGroup = ?1",BloodGroup.class);
			query.setParameter(1, bloodGroup);
			bg = query.getSingleResult();
			em.close();
		} catch (NoResultException e) {
			
		}
		return bg;
	}

	
}
