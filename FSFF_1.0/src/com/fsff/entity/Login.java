package com.fsff.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "LOGIN")
public class Login {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private String login;

	private String password;

	@OneToOne(mappedBy = "loginDetails", optional = false)
	@PrimaryKeyJoinColumn
	private UserType userType;
	// private String userType;

	private String forgotPasswordQuestion;

	private String forgotPasswordAnswer;

	@OneToOne(mappedBy = "loginDetails", optional = false)
	@PrimaryKeyJoinColumn
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getForgotPasswordQuestion() {
		return forgotPasswordQuestion;
	}

	public void setForgotPasswordQuestion(String forgotPasswordQuestion) {
		this.forgotPasswordQuestion = forgotPasswordQuestion;
	}

	public String getForgotPasswordAnswer() {
		return forgotPasswordAnswer;
	}

	public void setForgotPasswordAnswer(String forgotPasswordAnswer) {
		this.forgotPasswordAnswer = forgotPasswordAnswer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
