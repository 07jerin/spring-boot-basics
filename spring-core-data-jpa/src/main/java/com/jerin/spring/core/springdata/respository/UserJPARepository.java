package com.jerin.spring.core.springdata.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jerin.spring.core.jpa.entity.User;

public interface UserJPARepository extends JpaRepository<User, Long> {

}
