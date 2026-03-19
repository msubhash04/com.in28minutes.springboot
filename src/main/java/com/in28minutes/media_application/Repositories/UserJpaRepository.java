package com.in28minutes.media_application.Repositories;

import com.in28minutes.media_application.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
}
