package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<speaker,Long> {
}
