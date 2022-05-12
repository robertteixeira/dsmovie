package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {

	@EmbeddedId
	private ScorePK idScorePK;
	private Double value;

	public Score() {
		this.idScorePK = new ScorePK();
	}
	
	/**
	 * @return the id
	 */
	public ScorePK getId() {
		return idScorePK;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ScorePK id) {
		this.idScorePK = id;
	}

	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}
	
	public void setMovie(Movie movie) {
		this.idScorePK.setMovie(movie);
	}

	public void setUser(User user) {
		this.idScorePK.setUser(user);
	}
	
}
