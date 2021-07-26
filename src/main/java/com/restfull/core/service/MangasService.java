package com.restfull.core.service;

import java.util.List;
import java.util.Optional;
import com.restfull.core.entities.Mangas;

public interface MangasService {
	public List<Mangas> findAllMangas();

	public Optional<Mangas> findMangasById(Long id);

	public Mangas saveMangas(Mangas mangaNew);

	public String deleteMangas(Long id);

	public String updateManga(Mangas mangaNew);
}