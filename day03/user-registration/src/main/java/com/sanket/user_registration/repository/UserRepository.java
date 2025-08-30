package com.sanket.user_registration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanket.user_registration.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	 boolean existsByEmail(String email);
	 Users findByEmail(String email);
	 
}
