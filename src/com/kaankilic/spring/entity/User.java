package com.kaankilic.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.kaankilic.spring.validation.FieldMatch;


@Entity
@Table(name = "users")
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match.")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message = "Should be not null")
	@Size(min = 3, max = 20, message = "First name must be between 2 and 20 characters")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "Should be not null")
	@Size(min = 3, max = 20, message = "Last name must be between 2 and 20 characters")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "Should be not null")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "This does not appear to be a valid email adress")
	@Column(name = "email")
	private String email;

	/*
	 * Password must be 6-40 characters - {6,40} Must have no spaces, at least 1
	 * digit (?=.*[\d]), at least 1 uppercase letter (?=.*[A-Z]) and at least one
	 * lowercase letter (?=.*[a-z]). Allows specifying special characters - !@#$%_
	 */
	// Valid : Pa5$Word | HORS3y | Th1$IsMyR3allYl0ngPa$$
	// No-Matches: PASSWORD | password | Password | 1234567
	@NotNull(message = "Should be not null")
	@Pattern(regexp = "^(?=.*[\\d])(?=.*[A-Z])(?=.*[a-z])[\\w\\d!@#$%_]{6,40}$", message = "This does not appear to be a password")
	@Column(name = "password")
	private String password;

	@Transient
	private String confirmPassword;

	// @Transient
	// private boolean conditionTrue = false;
	//
	// @AssertTrue(message="Password should be equal with Confirm Password")
	// public boolean isConditionTrue() {
	//
	// conditionTrue = password.equals(confirmPassword);
	// return conditionTrue;
	// }

	// @AssertTrue(message="password field should be equal than confirm password
	// field" )
	// private boolean isConfirmPassword() {
	// return this.password.equals(this.confirmPassword);
	// }

	// @AssertTrue(message="Password should be equal with Confirm Password")
	// public boolean isConfirmPassword() {
	// return this.password.equals(this.confirmPassword);
	// }

	// public void setConditionTrue(boolean conditionTrue) {
	// this.conditionTrue = conditionTrue;
	// }

	@Column(name = "rank")
	private int rank;
	
//	@OneToMany(mappedBy="user", cascade= CascadeType.ALL)
//	private Set<Task> tasks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

//	public Set<Task> getTasks() {
//		return tasks;
//	}
//
//	public void setTasks(Set<Task> tasks) {
//		this.tasks = tasks;
//	}

}
