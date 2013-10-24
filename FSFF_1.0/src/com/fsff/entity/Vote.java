package com.fsff.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "VOTE")
public class Vote {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private long starValue1;
	private long starValue2;
	private long starValue3;
	private long starValue4;
	private long starValue5;

	private long score;

	@OneToOne(mappedBy = "roundOneClip", optional = false)
	@PrimaryKeyJoinColumn
	private Film film;

	public Vote() {
		this.starValue1 = 0;
		this.starValue2 = 0;
		this.starValue3 = 0;
		this.starValue4 = 0;
		this.starValue5 = 0;
		this.score = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getStarValue1() {
		return starValue1;
	}

	public void setStarValue1(long starValue1) {
		this.starValue1 = starValue1;
	}

	public long getStarValue2() {
		return starValue2;
	}

	public void setStarValue2(long starValue2) {
		this.starValue2 = starValue2;
	}

	public long getStarValue3() {
		return starValue3;
	}

	public void setStarValue3(long starValue3) {
		this.starValue3 = starValue3;
	}

	public long getStarValue4() {
		return starValue4;
	}

	public void setStarValue4(long starValue4) {
		this.starValue4 = starValue4;
	}

	public long getStarValue5() {
		return starValue5;
	}

	public void setStarValue5(long starValue5) {
		this.starValue5 = starValue5;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}
