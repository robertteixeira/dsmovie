package com.devsuperior.dsmovie.services;

import java.util.Optional;
import java.util.Set;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		// Save user if it is null
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		// Get the movie
		Optional<Movie> movieOptional = movieRepository.findById(dto.getMovieId());
		Movie movie = movieOptional.isPresent() ? movieOptional.get() : new Movie();

		// Save the score
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		scoreRepository.saveAndFlush(score);

		// Recalculate the scores
		Set<Score> scores = movie.getScores();

		double sum = 0;
		for (Score s : scores) {
			sum += s.getValue();
		}

		int size = movie.getScores().size();
		double avg = sum / size;

		movie.setScore(avg);
		movie.setCount(size);

		movie = movieRepository.saveAndFlush(movie);

		return new MovieDTO(movie);
	}

}
