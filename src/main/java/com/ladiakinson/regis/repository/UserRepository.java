package com.ladiakinson.regis.repository;


import com.ladiakinson.regis.model.RegisUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<RegisUser, Long> {
    Optional<RegisUser> findByUsername(String username);
}

