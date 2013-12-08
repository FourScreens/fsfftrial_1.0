package com.fsff.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int starWeight;
	private long numberOfVotes;
	private long weightedSum;

	@ManyToOne
	@JoinColumn(name = "VOTES", referencedColumnName = "id")
	private Votes votesId;

	public Vote() {
		this.starValue1 = 0;
		this.starValue2 = 0;
		this.starValue3 = 0;
		this.starValue4 = 0;
		this.starValue5 = 0;
		this.starWeight = 1;
	}

	public Vote(int starWeight) {
		this.starValue1 = 0;
		this.starValue2 = 0;
		this.starValue3 = 0;
		this.starValue4 = 0;
		this.starValue5 = 0;
		this.starWeight = starWeight;
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

	public void setStarValue1() {
		this.starValue1++;
		numberOfVotes++;
	}

	public long getStarValue2() {
		return starValue2;
	}

	public void setStarValue2() {
		this.starValue2++;
		numberOfVotes++;
	}

	public long getStarValue3() {
		return starValue3;
	}

	public void setStarValue3() {
		this.starValue3++;
		numberOfVotes++;
	}

	public long getStarValue4() {
		return starValue4;
	}

	public void setStarValue4() {
		this.starValue4++;
		numberOfVotes++;
	}

	public long getStarValue5() {
		return starValue5;
	}

	public void setStarValue5() {
		this.starValue5++;
		numberOfVotes++;
	}

	public int getStarWeight() {
		return starWeight;
	}

	public void setStarWeight(int starWeight) {
		this.starWeight = starWeight;
	}

	public long getNumberOfVotes() {
		return numberOfVotes;
	}

	public Votes getVotes() {
		return votesId;
	}

	public void setVotes(Votes votes) {
		this.votesId = votes;
	}

	public long getWeightedSum() {
		this.weightedSum = 0;
		this.weightedSum = this.starValue1 * 1 + this.starValue2 * 2
				+ this.starValue3 * 3 + this.starValue4 * 4 + this.starValue5
				* 5;
		return weightedSum;
	}
}
