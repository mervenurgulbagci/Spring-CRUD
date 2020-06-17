package com.merve.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.merve.dao.EmployeeDAO;
import com.merve.domain.Departments;
import com.merve.domain.Employees;
import com.merve.domain.Jobs;
@Component
@Service
public class EmployeeServisiImpl implements EmployeeServisi {
	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	@Override
	public List<Employees> listEmployees() {
		return employeeDAO.listEmployees();
	}

	@Transactional
	@Override
	public void saveEmployee(Employees employee) {
		employeeDAO.saveEmployee(employee);
		
	}


	@Transactional
	@Override
	public Employees getEmployee(int employeeId) {
		
		return employeeDAO.getEmployee(employeeId);
	}

	
	

	@Transactional
	@Override
	public void deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
		
	}


	@Transactional
	@Override
	public List<Departments> listDepartments() {
		
		return employeeDAO.listDepartmens();
	}


	@Transactional
	@Override
	public List<Jobs> listJobs() {
		return employeeDAO.listJobs();
	}


	@Transactional
	@Override
	public Jobs getJob(String jobId) {
		
		return employeeDAO.getJob(jobId);
	}

	@Transactional
	@Override
	public List<Employees> getAraEmployee(Employees employee) {
		
		return employeeDAO.getAraEmployee(employee);
	}


}
