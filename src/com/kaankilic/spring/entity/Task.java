package com.kaankilic.spring.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


import com.kaankilic.spring.enums.Status;


@Entity
@Table(name="tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate = Calendar.getInstance().getTime();
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.todo;
	
	@Transient
	private String tempDate;
	
//	@ManyToOne
//	@JoinColumn(name="user_id", insertable=false, updatable=false)
//	private User user;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTempDate() {
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dFormat.format(endDate);
	}

	public void setTempDate(String tempDate) {
		this.tempDate = tempDate;
		 
		try {
			System.out.println("Date: " + tempDate);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);
			System.out.println(endDate);
		} catch (Exception e) {
			System.out.println("Date Parse Exception: " + e.getMessage());
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	
	

}
