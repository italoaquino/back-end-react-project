package com.projetoreact.repositories;

import com.projetoreact.entities.project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projectRepository extends JpaRepository<project, Long> {
}
