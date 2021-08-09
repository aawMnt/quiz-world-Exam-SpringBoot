package com.examweb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AdminResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long rid;
	private String totalMarks;
	private String marksGot;
	private String correctAns;
	private String attempt;
	private String percentage;
	private String grade;
	private String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date examDate = new Date();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User users;

	public AdminResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminResult(Long rid, String totalMarks, String marksGot, String correctAns, String attempt,
			String percentage, String grade, String title, Date examDate, User users) {
		super();
		this.rid = rid;
		this.totalMarks = totalMarks;
		this.marksGot = marksGot;
		this.correctAns = correctAns;
		this.attempt = attempt;
		this.percentage = percentage;
		this.grade = grade;
		this.title = title;
		this.examDate = examDate;
		this.users = users;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getMarksGot() {
		return marksGot;
	}

	public void setMarksGot(String marksGot) {
		this.marksGot = marksGot;
	}

	public String getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}

	public String getAttempt() {
		return attempt;
	}

	public void setAttempt(String attempt) {
		this.attempt = attempt;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	

}
