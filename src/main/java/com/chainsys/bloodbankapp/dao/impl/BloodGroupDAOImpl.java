package com.chainsys.bloodbankapp.dao.impl;

import java.util.List;

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

	/**
	 * This method will search by bloodGroup
	 */
	
	public BloodGroup findByBloodGroupName(String bloodGroup) throws DbException {
		BloodGroup bg = null;
		try {
			EntityManager em = emf.createEntityManager();
			TypedQuery<BloodGroup> query = em.createQuery("from BloodGroup b where b.bloodGroup = ?1",
					BloodGroup.class);
			query.setParameter(1, bloodGroup);
			bg = query.getSingleResult();
			em.close();
		} catch (NoResultException e) {

		}
		return bg;
	}

	public List<BloodGroup> findAll() throws DbException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<BloodGroup> query = em.createQuery("from BloodGroup b ", BloodGroup.class);
		List<BloodGroup> list = query.getResultList();
		em.close();
		return list;
	}

	public BloodGroup findOne(int bloodGroupId) throws DbException {
		BloodGroup bg = null;
		try {
			EntityManager em = emf.createEntityManager();
			TypedQuery<BloodGroup> query = em.createQuery("from BloodGroup b where b.bloodGroupId = ?1",
					BloodGroup.class);
			query.setParameter(1, bloodGroupId);
			bg = query.getSingleResult();
			em.close();
		} catch (NoResultException e) {

		}
		return bg;
	}

	public void delete(int bloodGroupId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		BloodGroup findOne = em.find(BloodGroup.class, bloodGroupId);
		em.remove(findOne);
		em.getTransaction().commit();
		em.close();
	}

	public void save(BloodGroup bloodGroup) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(bloodGroup);
		em.getTransaction().commit();
		em.close();
	}

	public void update(BloodGroup bloodGroup) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(bloodGroup);
		em.getTransaction().commit();
		em.close();
	}

}
