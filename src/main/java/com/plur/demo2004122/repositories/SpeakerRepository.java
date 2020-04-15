package com.plur.demo2004122.repositories;

import com.plur.demo2004122.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
