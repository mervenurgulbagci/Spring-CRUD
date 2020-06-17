package com.merve.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.merve.domain.Departments;
import com.merve.domain.Employees;
import com.merve.domain.Jobs;
import com.merve.service.EmployeeServisi;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
	@Autowired
	EmployeeServisi employeeServisi;
	
	@GetMapping("/list")
	public String listEmployees(Model model,HttpSession oturum, ModelMap modelMap)
	{
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			return "redirect:/index";
		} else {
		List<Employees> employeeList=employeeServisi.listEmployees();
		model.addAttribute("employees",employeeList);
		Employees employee1 = new Employees();
		model.addAttribute("employeeara", employee1);
		return "employee-list";
		}
	}
	
	@PostMapping("/search")
	public String EmployeeAra(@ModelAttribute("employeeara") Employees employee, Model model) {

		List<Employees> employeeList = employeeServisi.getAraEmployee(employee);
		model.addAttribute("employees", employeeList);
		return "employee-list";

	}
	
	@GetMapping("/employee-ekle")
	public String employeeEkle(Model model,HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			return "redirect:/index";
		} else {
		Employees employee=new Employees();
		model.addAttribute("employees", employee);
		return "employee-form";}
	}
	
	@PostMapping("/employee-kaydet")
	public String employeeKaydet(@Valid @ModelAttribute("employees") Employees employees, BindingResult bindingResult, Model model)
	{
		Jobs job=employeeServisi.getJob(employees.getJobs().getId());
		if(employees.getSalary()<job.getMin_salary()) {
			bindingResult.rejectValue("salary", "error.emplooye", "Minimum maaþtan("+job.getMin_salary()+") düþük olamaz!");
		}
		if(employees.getSalary()>job.getMax_salary()) {
			bindingResult.rejectValue("salary", "error.emplooye", "Maximum maaþtan("+job.getMax_salary()+") yüksek olamaz!");
			}
		System.out.println(bindingResult);
		if(bindingResult.hasErrors())
			return "employee-form";
		employeeServisi.saveEmployee(employees);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/employee-guncelle")
	public String employeeGuncelle(@RequestParam("employeeId") int employeeId, Model model )  {
		Employees employee=employeeServisi.getEmployee(employeeId);
		model.addAttribute("employees", employee);
		return "employee-form";
	}
	
	@GetMapping("/employee-sil")
	public String employeeSil(@RequestParam("employeeId") int employeeId) {
		employeeServisi.deleteEmployee(employeeId);
		return  "redirect:/employees/list";
	}

	/*
	@ModelAttribute("employeeList")
	public List<Employees> getEmployees() {
		List<Employees> employee = employeeServisi.getEmployees();
		return employee;
	}*/
	
	@ModelAttribute("department")
	public Map<Integer, String> getDepartments(){
		List<Departments> depts=employeeServisi.listDepartments();
		 Map<Integer, String> getDepartments = new HashMap<Integer, String>();
		 for (Departments departments : depts) {
			 getDepartments.put(departments.getDepartment_id(), departments.getDepartment_name());
		}
		return getDepartments;
	}
	
	@ModelAttribute("job")
	public List<String> getJobs(){
		List<Jobs> jobs=employeeServisi.listJobs();
		List<String> jobId=new ArrayList<String>();
//		 Map<String, String> getJobs = new HashMap<String, String>();
		 for (Jobs job : jobs) {
			 jobId.add(job.getId());
		}
		return jobId;
	}
	
	@ModelAttribute("manager")
	public Map<Integer,Employees> listManager() {
		Map<Integer, Employees> manager= new HashMap<Integer, Employees>();
		List<Employees> managerList = employeeServisi.listEmployees();
		for (Employees employee : managerList) {
			manager.put(employee.getEmployeeId(), employee);
		}
		return manager;
	}
	
}
