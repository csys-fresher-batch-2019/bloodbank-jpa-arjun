package com.chainsys.bloodbankapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.chainsys.bloodbankapp.dao.UserDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.util.JPAUtil;

public class UserDAOImpl implements UserDAO {

	private static final EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();

	public List<User> findByBloodGroup(String bloodGroup) throws DbException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createQuery("from User u where u.bloodGroup.bloodGroup = ?1", User.class);
		query.setParameter(1, bloodGroup);
		List<User> list = query.getResultList();
		em.close();
		return list;
	}

	public List<User> findByBloodGroupWithCity(String bloodGroup, String city) throws DbException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createQuery("from User u where u.bloodGroup.bloodGroup = ?1 and u.city = ?2",
				User.class);
		query.setParameter(1, bloodGroup);
		query.setParameter(2, city);
		List<User> list = query.getResultList();
		em.close();
		return list;
	}

	public User findByEmail(String email) throws DbException {
		User user = null;
		try {
			EntityManager em = emf.createEntityManager();
			TypedQuery<User> query = em.createQuery("from User u where u.email = ?1", User.class);
			query.setParameter(1, email);
			user = query.getSingleResult();
			em.close();

		} catch (NoResultException e) {

		}
		return user;
	}

	public User findByUserId(int userId) throws DbException {
		User user = null;
		try {
			EntityManager em = emf.createEntityManager();
			TypedQuery<User> query = em.createQuery("from User u where u.userId = ?1", User.class);
			query.setParameter(1, userId);
			user = query.getSingleResult();
			em.close();

		} catch (NoResultException e) {

		}
		return user;
	}

	public Long countInCity(String bloodGroup, String city) throws DbException {
		Long count = null;
		EntityManager em = emf.createEntityManager();
		TypedQuery<Long> query = em.createQuery(
				"select count(*) from User u where u.bloodGroup.bloodGroup = ?1 and u.city = ?2", Long.class);
		query.setParameter(1, bloodGroup);
		query.setParameter(2, city);
		count = query.getSingleResult();
		em.close();
		return count;
	}

	public void save(User user) throws DbException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public void update(User user) throws DbException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(int userId) throws DbException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User findOne = em.find(User.class, userId);
		em.remove(findOne);
		em.getTransaction().commit();
		em.close();
	}

	/*
	 * public boolean updateEmail(int userId, String email) throws DbException {
	 * 
	 * return false; }
	 * 
	 * public boolean updateBloodGroup(int userId, String bloodGroup) throws
	 * DbException {
	 * 
	 * return false; }
	 * 
	 * public boolean updateCity(int userId, String city) throws DbException {
	 * 
	 * return false; }
	 */

}
