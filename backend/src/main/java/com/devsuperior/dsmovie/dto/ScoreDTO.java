package com.devsuperior.dsmovie.dto;

public class ScoreDTO {

	private Long movieId;
	private String email;
	private Double score;
	
	private ScoreDTO() {
		
	}

	/**
	 * @return the movieID
	 */
	public Long getMovieId() {
		return movieId;
	}

	/**
	 * @param movieID the movieID to set
	 */
	public void setMovieId(Long movieID) {
		this.movieId = movieID;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}
	
}
