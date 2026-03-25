package com.in28minutes.media_application.Repositories;

import com.in28minutes.media_application.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Integer> {
}
