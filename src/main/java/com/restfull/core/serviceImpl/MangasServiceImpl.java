package com.restfull.core.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restfull.core.entities.Mangas;
import com.restfull.core.repository.MangasRepository;
import com.restfull.core.service.MangasService;

@Service
public class MangasServiceImpl implements MangasService {
	@Autowired
	MangasRepository mangaRepository;

	@Override
	public List<Mangas> findAllMangas() {
		return mangaRepository.findAll();
	}

	@Override
	public Optional<Mangas> findMangasById(Long id) {
		Optional<Mangas> customer = mangaRepository.findById(id);
		return customer;
	}

	@Override
	public Mangas saveMangas(Mangas mangaNew) {
		if (mangaNew != null) {
			return mangaRepository.save(mangaNew);
		}
		return new Mangas();
	}

	@Override
	public String deleteMangas (Long id) {
		if (mangaRepository.findById(id).isPresent()) {
			mangaRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}

	@Override
	public String updateManga(Mangas mangaUpdated) {
		Long num = mangaUpdated.getId();
		if (mangaRepository.findById(num).isPresent()) {
			Mangas mangaToUpdate = new Mangas();
			mangaToUpdate.setId(mangaUpdated.getId());
			mangaToUpdate.setNombre(mangaUpdated.getNombre());
			mangaToUpdate.setEditorial(mangaUpdated.getEditorial());
			mangaToUpdate.setAutor(mangaUpdated.getAutor());
			mangaToUpdate.setCantidad(mangaUpdated.getCantidad());
			mangaToUpdate.setGenero(mangaUpdated.getGenero());
			mangaRepository.save(mangaToUpdate);
			return "Manga modificado";
		}
		return "Error al modificar el Manga";
	}


	
}