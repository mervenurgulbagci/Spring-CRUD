package com.merve.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="EMPLOYEES")
public class Employees {
	@Id
	@Column(name="EMPLOYEE_ID")
	@SequenceGenerator(name="employees_seq",sequenceName="EMPLOYEES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employees_seq")
	private Integer employeeId; 
	
	@Column(name="FIRST_NAME")
	private String first_name;
	
	@Column(name="LAST_NAME")
	private String last_name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private String phone_number;
	
	@Column(name="HIRE_DATE")
	private Date hire_date;
	
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Jobs job;
	
	@Max(value=9999999,message="Fazla yüksek")
	@Min(value=0, message="negatif olamaz")
	@Column(name="SALARY")
	private Integer salary;
	
	@Column(name="COMMISSION_PCT")
	private Integer commission_pct;
	
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Employees manager;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Departments department;

	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	

	public Jobs getJobs() {
		return job;
	}

	public void setJobs(Jobs job) {
		this.job = job;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getCommission_pct() {
		return commission_pct;
	}

	public void setCommission_pct(Integer commission_pct) {
		this.commission_pct = commission_pct;
	}

	
	public Departments getDepartments() {
		return department;
	}

	public void setDepartments(Departments department) {
		this.department = department;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}


	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	public Employees() {
		super();
	}

	@Override
	public String toString() {
		return "manager=" + manager.getSalary() + ", employees=" + getSalary() + "]";
	}


}
