package com.devsuperior.dsmovie.controllers;

import java.util.List;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	MovieService service;

	@GetMapping
	public List<MovieDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}

	@GetMapping(value = "/{id}")
	public MovieDTO findBiId(@PathVariable Long id){
		return service.findById(id);
	}
}