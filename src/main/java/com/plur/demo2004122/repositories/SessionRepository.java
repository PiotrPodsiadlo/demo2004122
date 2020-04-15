package com.plur.demo2004122.repositories;

import com.plur.demo2004122.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
