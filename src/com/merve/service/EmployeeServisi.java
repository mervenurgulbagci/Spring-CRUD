package com.merve.service;

import java.util.List;

import com.merve.domain.Departments;
import com.merve.domain.Employees;
import com.merve.domain.Jobs;

public interface EmployeeServisi {
	public List<Employees> listEmployees();

	public void saveEmployee(Employees employee);

	public Employees getEmployee(int employeeId);

	public void deleteEmployee(int employeeId);

	public List<Departments> listDepartments();

	public List<Jobs> listJobs();

	public List<Employees> getAraEmployee(Employees employee);

	public Jobs getJob(String id);

}
