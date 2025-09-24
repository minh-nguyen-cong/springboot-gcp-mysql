package com.example.github_gcp_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.github_gcp_mysql.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
