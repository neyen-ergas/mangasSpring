package com.restfull.core.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restfull.core.controllers.MangasController;
import com.restfull.core.entities.Mangas;
import com.restfull.core.service.MangasService;

@RestController
public class MangasControllerImpl implements MangasController {
	@Autowired
	MangasService mangasService;

	// http://localhost:8888/mangas (GET)
	@RequestMapping(value = "/mangas", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Mangas> getMangas() {
		return mangasService.findAllMangas();
	}

	// http://localhost:8888/mangas/1 (GET)
	@Override
	@RequestMapping(value = "/mangas/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Mangas> getMangasById(@PathVariable Long id) {
		return mangasService.findMangasById(id);
	}

	// http://localhost:8888/mangas/add (ADD)
	@Override
	@RequestMapping(value = "/mangas/add", method = RequestMethod.POST, produces = "application/json")
	public Mangas addManga(Mangas manga) {
		return mangasService.saveMangas(manga);
	}

	// http://localhost:8888/mangas/delete/1 (GET)
	@Override
	@RequestMapping(value = "/mangas/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteManga(@PathVariable Long id) {
		return mangasService.deleteMangas(id);
	}

	// http://localhost:8888/mangas/update (PATCH)
	@Override
	@RequestMapping(value = "/mangas/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateManga(Mangas mangaNew) {
		return mangasService.updateManga(mangaNew);
	}

	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}


	
}