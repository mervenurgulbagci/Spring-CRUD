package com.merve.dao;

import java.util.List;
import com.merve.domain.Departments;
import com.merve.domain.Employees;
import com.merve.domain.Jobs;

public interface EmployeeDAO {
	public List<Employees> listEmployees();

	public void saveEmployee(Employees employee);

	public Employees getEmployee(int employeeId);

	public void deleteEmployee(int employeeId);

	public List<Departments> listDepartmens();

	public List<Jobs> listJobs();

	public Jobs getJob(String jobId);

	public List<Employees> getAraEmployee(Employees employee);

}
