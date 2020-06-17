package com.merve.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Departments {

	@Id
	@Column(name = "DEPARTMENT_ID")
	@SequenceGenerator(name="depart_seq",sequenceName="departments_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="depart_seq")
	private Integer department_id;

	@Column(name = "DEPARTMENT_NAME")
	private String department_name;

	//@OneToMany(cascade= {CascadeType.ALL})
	//@JoinColumn(name = "MANAGER_ID")
//	private Employees employees;

	//@OneToMany(cascade= {CascadeType.ALL})
	//@JoinColumn(name="LOCATION_ID")
	//private Location location;

	@Override
	public String toString() {
		return department_name ;
	}
	

	public Integer getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}


	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	
	
}
