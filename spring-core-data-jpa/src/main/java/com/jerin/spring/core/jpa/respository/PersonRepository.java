package com.jerin.spring.core.jpa.respository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jerin.spring.core.jpa.entity.Person;

@Repository
@Transactional
public class PersonRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Person findById(int i) {
		return entityManager.find(Person.class, i);
	}

	public Person updateName(Person p2) {
		return entityManager.merge(p2);
	}

	public Person insert(Person pNew) {
		return entityManager.merge(pNew);
	}

	public List<Person> findAll() {
		TypedQuery<Person> jpql =  entityManager.createNamedQuery("find_all_person", Person.class);
		return jpql.getResultList();
	}

	public void deletById(int i) {
		Person p = findById(i);
		entityManager.remove(p);
	}

}
