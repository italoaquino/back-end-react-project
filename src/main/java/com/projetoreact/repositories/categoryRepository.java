package com.projetoreact.repositories;

import com.projetoreact.entities.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<category, Long> {
}
