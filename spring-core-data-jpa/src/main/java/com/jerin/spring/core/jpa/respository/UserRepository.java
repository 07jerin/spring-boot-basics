package com.jerin.spring.core.jpa.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jerin.spring.core.jpa.entity.User;

@Repository
@Transactional
public class UserRepository {

	@PersistenceContext
	private EntityManager entiryManager;

	public long insert(User user) {
		entiryManager.persist(user);
		return user.getId();
	}

}
