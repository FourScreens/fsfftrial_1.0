package com.fsff.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "VOTES")
public class Votes {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "votesId")
	private Map<Integer, Vote> weightVoteMap;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "votesId")
	private Set<Vote> votes;

	private double final_rating;

	@OneToOne(mappedBy = "votes", optional = false)
	@PrimaryKeyJoinColumn
	private Film film;

	public Votes() {
		this.weightVoteMap = new HashMap<Integer, Vote>();
		this.votes = new HashSet<Vote>();
		// Vote vote_user;
		// vote_user = new Vote(starWeight1);
		// votes.add(vote_user);
		// this.weightVoteMap.put(starWeight1, vote_user);
		// Vote vote_registered_user;
		// vote_registered_user = new Vote(starWeight1);
		// votes.add(vote_registered_user);
		// this.weightVoteMap.put(starWeight2, vote_registered_user);
		// Vote vote_admins;
		// vote_admins = new Vote(starWeight1);
		// votes.add(vote_admins);
		// this.weightVoteMap.put(starWeight3, vote_admins);
	}

	public int getId() {
		return id;
	}

	public double getFinal_Rating() {
		return final_rating;
	}

	public void setFinal_Rating(double final_rating) {
		this.final_rating = final_rating;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void addVotes(int starWeight, Vote vote) {
		if (vote != null && starWeight > 0) {
			this.votes.add(vote);
			this.weightVoteMap.put(starWeight, vote);
		}
	}

	public Set<Vote> getVotes() {
		return this.votes;
	}

	public Vote getKeyValue(int key) {
		return this.weightVoteMap.get(key);
	}

	public Set<Integer> getKeySet() {
		return this.weightVoteMap.keySet();
	}

}
