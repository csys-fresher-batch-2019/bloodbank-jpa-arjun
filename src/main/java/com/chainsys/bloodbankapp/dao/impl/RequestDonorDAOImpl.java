package com.chainsys.bloodbankapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.chainsys.bloodbankapp.dao.RequestDonorDAO;
import com.chainsys.bloodbankapp.model.RequestDonor;
import com.chainsys.bloodbankapp.util.JPAUtil;

public class RequestDonorDAOImpl implements RequestDonorDAO {

	private static final EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();

	public void save(RequestDonor requestDonor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(requestDonor);
		em.getTransaction().commit();
		em.close();

	}

	public RequestDonor findOne(int id) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<RequestDonor> query = em.createQuery("from RequestDonor r where r.id = ?1", RequestDonor.class);
		query.setParameter(1, id);
		RequestDonor list = query.getSingleResult();
		em.close();
		return list;
	}

	public void update(RequestDonor requestDonor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(requestDonor);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		RequestDonor findOne = em.find(RequestDonor.class, id);
		em.remove(findOne);
		em.getTransaction().commit();
		em.close();
	}

}
