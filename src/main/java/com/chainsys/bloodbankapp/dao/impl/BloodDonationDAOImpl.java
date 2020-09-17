package com.chainsys.bloodbankapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.chainsys.bloodbankapp.dao.BloodDonationDAO;
import com.chainsys.bloodbankapp.model.BloodDonation;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.util.JPAUtil;

public class BloodDonationDAOImpl implements BloodDonationDAO {

	private static final EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();

	public void save(BloodDonation bloodDonation) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(bloodDonation);
		em.getTransaction().commit();
		em.close();

	}

	public List<BloodDonation> findAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<BloodDonation> query = em.createQuery("from BloodDonation b", BloodDonation.class);
		List<BloodDonation> list = query.getResultList();
		em.close();
		return list;
	}

	public List<BloodDonation> findByUserId(int userId) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<BloodDonation> query = em.createQuery("from BloodDonation b where b.user.userId = ?1",
				BloodDonation.class);
		query.setParameter(1, userId);
		List<BloodDonation> list = query.getResultList();
		em.close();
		return list;
	}

	public Long count() {
		Long count = null;
		EntityManager em = emf.createEntityManager();
		TypedQuery<Long> query = em.createQuery("select count(*) from BloodDonation b", Long.class);
		count = query.getSingleResult();
		em.close();
		return count;
	}

}
