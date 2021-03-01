package com.bekirarslan.entitylifecycle.repository;

import com.bekirarslan.entitylifecycle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
