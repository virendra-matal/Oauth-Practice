package com.veer.oauth.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veer.oauth.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
