package com.fsff.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FESTIVAL")
public class Festival {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private String year;

	private String quarter;

	private Date submissionStartDate;

	private Date submissionEndDate;

	private Date roundOneStartDate;

	private Date roundOneEndDate;

	private Date roundTwoStartDate;

	private Date roundTwoEndDate;

	private Date roundThreeStartDate;

	private Date roundThreeEndDate;

	private boolean active;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "festivalId")
	private Set<Film> films;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "festivalId")
	private Set<Winner> winners;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public Date getSubmissionStartDate() {
		return submissionStartDate;
	}

	public void setSubmissionStartDate(Date submissionStartDate) {
		this.submissionStartDate = submissionStartDate;
	}

	public Date getSubmissionEndDate() {
		return submissionEndDate;
	}

	public void setSubmissionEndDate(Date submissionEndDate) {
		this.submissionEndDate = submissionEndDate;
	}

	public Date getRoundOneStartDate() {
		return roundOneStartDate;
	}

	public void setRoundOneStartDate(Date roundOneStartDate) {
		this.roundOneStartDate = roundOneStartDate;
	}

	public Date getRoundOneEndDate() {
		return roundOneEndDate;
	}

	public void setRoundOneEndDate(Date roundOneEndDate) {
		this.roundOneEndDate = roundOneEndDate;
	}

	public Date getRoundTwoStartDate() {
		return roundTwoStartDate;
	}

	public void setRoundTwoStartDate(Date roundTwoStartDate) {
		this.roundTwoStartDate = roundTwoStartDate;
	}

	public Date getRoundTwoEndDate() {
		return roundTwoEndDate;
	}

	public void setRoundTwoEndDate(Date roundTwoEndDate) {
		this.roundTwoEndDate = roundTwoEndDate;
	}

	public Date getRoundThreeStartDate() {
		return roundThreeStartDate;
	}

	public void setRoundThreeStartDate(Date roundThreeStartDate) {
		this.roundThreeStartDate = roundThreeStartDate;
	}

	public Date getRoundThreeEndDate() {
		return roundThreeEndDate;
	}

	public void setRoundThreeEndDate(Date roundThreeEndDate) {
		this.roundThreeEndDate = roundThreeEndDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	public Set<Winner> getWinners() {
		return winners;
	}

	public void setWinners(Set<Winner> winners) {
		this.winners = winners;
	}

}
