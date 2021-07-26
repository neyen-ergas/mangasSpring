package com.restfull.core.controllers;

import java.util.List;
import java.util.Optional;
import com.restfull.core.entities.Mangas;

public interface MangasController {
	public List<Mangas> getMangas();

	public Optional<Mangas> getMangasById(Long id);

	public Mangas addManga(Mangas manga);

	public String deleteManga(Long id);

	public String updateManga(Mangas customerNew);

	public String test();

}