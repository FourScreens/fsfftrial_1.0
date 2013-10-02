package com.fsff.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ADMIN")
public class Admin {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "approvedBy")
	private Set<Film> approvedFilms;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Film> getApprovedFilms() {
		return approvedFilms;
	}

	public void setApprovedFilms(Set<Film> approvedFilms) {
		this.approvedFilms = approvedFilms;
	}

}
