package com.test.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, String>{
}
