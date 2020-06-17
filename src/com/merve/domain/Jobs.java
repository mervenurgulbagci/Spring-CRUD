package com.merve.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOBS")
public class Jobs {
	
	@Id
	@Column(name="JOB_ID")
	private String id;
	
	@Column(name="JOB_TITLE")
	private String job_title;
	
	@Column(name="MIN_SALARY")
	private int min_salary;
	
	@Column(name="MAX_SALARY")
	private int max_salary;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public int getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}

	public int getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}

	public Jobs() {
		super();
	}

	public Jobs(String job_title, int min_salary, int max_salary) {
		super();
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + "]";
	}
	
	
	
	

}
