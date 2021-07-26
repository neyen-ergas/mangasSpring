package com.restfull.core.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restfull.core.entities.Mangas;

public interface MangasRepository extends JpaRepository<Mangas, Long> {
	Void save(Optional<Mangas> customerToUpdate);
}