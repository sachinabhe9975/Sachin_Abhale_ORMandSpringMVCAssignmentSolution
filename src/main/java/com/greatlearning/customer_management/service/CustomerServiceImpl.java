package com.greatlearning.customer_management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.customer_management.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionfactory;

	private Session session;

	public CustomerServiceImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		try {
			session = this.sessionfactory.getCurrentSession();

		} catch (HibernateException e) {
			session = this.sessionfactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {
		List<Customer> customerList = session.createQuery(" from Customer").list();
		/*
		 * for(Student b:studentList) { System.out.println(b); }
		 */
		return customerList;
	}

	@Transactional
	public Customer findById(Integer id) {
		Customer student = session.get(Customer.class, id);
		return student;
	}

	@Transactional
	public void save(Customer student) {
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(student);
		tr.commit();
	}

	@Transactional
	public void delete(Customer b) {
		Transaction tr = session.beginTransaction();
		session.delete(b);
		tr.commit();
	}

}
