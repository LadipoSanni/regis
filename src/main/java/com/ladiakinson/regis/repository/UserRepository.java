package com.ladiakinson.regis.repository;


import com.ladiakinson.regis.model.UserRegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRegisterRequest, Long> {
    Optional<UserRegisterRequest> findByUsername(String username);
}

