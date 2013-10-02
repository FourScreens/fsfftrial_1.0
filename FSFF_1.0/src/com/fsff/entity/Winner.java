package com.fsff.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WINNER")
public class Winner {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	//TO-DO:Check
//	@OneToOne(mappedBy="address")
//	@PrimaryKeyJoinColumn
//	private Film film;

	private String position;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FESTIVAL", referencedColumnName = "id")
	private Festival festivalId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Film getFilm() {
//		return film;
//	}
//
//	public void setFilm(Film film) {
//		this.film = film;
//	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
