package com.edgarjba.airline.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgarjba.airline.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{}
