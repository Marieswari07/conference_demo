package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<session,Long> {
}
