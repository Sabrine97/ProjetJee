package com.fr.projetjee.persistence.repository;
import java.util.Optional;

import com.fr.projetjee.persistence.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}