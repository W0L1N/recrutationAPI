package com.kacwol.recrutationAPI.user.service;

import com.kacwol.recrutationAPI.user.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}
