package com.example.github_gcp_mysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.github_gcp_mysql.entity.User;
import com.example.github_gcp_mysql.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return repo.save(user);
    }

    public User get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> list() {
        return repo.findAll();
    }

    public User update(Long id, User data) {
        User existing = get(id);
        existing.setName(data.getName());
        existing.setEmail(data.getEmail());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
