package com.fsff.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FILM")
public class Film {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private String filmName;

	@ManyToOne(optional = false)
	@JoinColumn(name = "GENRE", referencedColumnName = "id")
	private Genre genre;

	private String filmDescription;

	private String cast;

	private String director;

	private String producer;

	private String writer;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Clip1 roundOneClip;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Clip2 roundTwoClip;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Clip3 roundThreeClip;

	private Date submissionDate;

	private boolean fullMovieReceived;

	private Date fullMovieReceivedDate;

	private Date lastStatusUpdateDate;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Votes votes;

	private long numberOfVotes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private Set<Comment> comments;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FESTIVAL", referencedColumnName = "id")
	private Festival festivalId;

	private String status;

	private String roundOneStatus;

	private String roundTwoStatus;

	private String roundThreeStatus;

	@ManyToOne
	@JoinColumn(name = "ADMIN", referencedColumnName = "id")
	private Admin approvedBy;

	@ManyToOne
	@JoinColumn(name = "USER", referencedColumnName = "id")
	private User filmMaker;

	private String filmUID;

	private boolean editorPicks;

	private boolean paid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getFilmDescription() {
		return filmDescription;
	}

	public void setFilmDescription(String filmDescription) {
		this.filmDescription = filmDescription;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Clip1 getRoundOneClip() {
		return roundOneClip;
	}

	public void setRoundOneClip(Clip1 roundOneClip) {
		this.roundOneClip = roundOneClip;
	}

	public Clip2 getRoundTwoClip() {
		return roundTwoClip;
	}

	public void setRoundTwoClip(Clip2 roundTwoClip) {
		this.roundTwoClip = roundTwoClip;
	}

	public Clip3 getRoundThreeClip() {
		return roundThreeClip;
	}

	public void setRoundThreeClip(Clip3 roundThreeClip) {
		this.roundThreeClip = roundThreeClip;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public boolean isFullMovieReceived() {
		return fullMovieReceived;
	}

	public void setFullMovieReceived(boolean fullMovieReceived) {
		this.fullMovieReceived = fullMovieReceived;
	}

	public Date getFullMovieReceivedDate() {
		return fullMovieReceivedDate;
	}

	public void setFullMovieReceivedDate(Date fullMovieReceivedDate) {
		this.fullMovieReceivedDate = fullMovieReceivedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoundOneStatus() {
		return roundOneStatus;
	}

	public void setRoundOneStatus(String roundOneStatus) {
		this.roundOneStatus = roundOneStatus;
	}

	public String getRoundTwoStatus() {
		return roundTwoStatus;
	}

	public void setRoundTwoStatus(String roundTwoStatus) {
		this.roundTwoStatus = roundTwoStatus;
	}

	public String getRoundThreeStatus() {
		return roundThreeStatus;
	}

	public void setRoundThreeStatus(String roundThreeStatus) {
		this.roundThreeStatus = roundThreeStatus;
	}

	public Date getLastStatusUpdateDate() {
		return lastStatusUpdateDate;
	}

	public void setLastStatusUpdateDate(Date lastStatusUpdateDate) {
		this.lastStatusUpdateDate = lastStatusUpdateDate;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Festival getFestivalId() {
		return festivalId;
	}

	public void setFestivalId(Festival festivalId) {
		this.festivalId = festivalId;
	}

	public Admin getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Admin approvedBy) {
		this.approvedBy = approvedBy;
	}

	public User getFilmMaker() {
		return filmMaker;
	}

	public void setFilmMaker(User filmMaker) {
		this.filmMaker = filmMaker;
	}

	public Votes getVotes() {
		return votes;
	}

	public void setVotes(Votes votes) {
		this.votes = votes;
	}

	public long getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(long numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	public String getFilmUID() {
		return filmUID;
	}

	public void setFilmUID(String filmUID) {
		this.filmUID = filmUID;
	}

	public boolean isEditorPicks() {
		return editorPicks;
	}

	public void setEditorPicks(boolean editorPicks) {
		this.editorPicks = editorPicks;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

}
