package com.devsuperior.dsmovie.services;

import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository reporsitory;
	
	@Transactional(readOnly = true)
	public List<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> moviesPageable = reporsitory.findAll(pageable);
		Page<MovieDTO> moviesDTOPageable = moviesPageable.map(MovieDTO::new);
		return moviesDTOPageable.getContent();
	}

	public MovieDTO findById(Long id) {
		Optional<Movie> movieOptional = reporsitory.findById(id);
		return movieOptional.isPresent() ? new MovieDTO(movieOptional.get()) : new MovieDTO();
	}

}
