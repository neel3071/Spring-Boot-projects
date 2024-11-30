package com.jbk.entities;

import javax.annotation.processing.SupportedAnnotationTypes;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {

	@Id
	@NotEmpty(message = "invalid username")
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password", nullable = false)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,20}$", message = "Password must be 8-20 characters long, include at least one uppercase letter, one lowercase letter, one number, and one special character.")
	private String password;
	@Column(name = "question", nullable = false)
	@NotNull
	@NotEmpty

	private String question;
	@Column(name = "answer", nullable = false)
	@NotNull
	@NotEmpty
	private String answer;
	@Column(name = "role", nullable = false)
	@NotNull
	@NotEmpty
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", question=" + question + ", answer=" + answer
				+ ", role=" + role + "]";
	}

	public User(String username, String password, String question, String answer, String role) {
		super();
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
