package com.merve.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.merve.domain.Departments;
import com.merve.domain.Employees;
import com.merve.domain.Jobs;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public List<Employees> listEmployees() {
		Session session = sessionFactory.getCurrentSession();
		Query<Employees> query = session.createQuery("from Employees", Employees.class);
		List<Employees> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void saveEmployee(Employees employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
		
	}


	@Override
	public Employees getEmployee(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Employees employee=session.get(Employees.class, employeeId);
		return employee;
	}


	@Override
	public void deleteEmployee(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Employees employee=session.get(Employees.class, employeeId);
		session.delete(employee);
		
	}


	@Override
	public List<Departments> listDepartmens() {
		Session session = sessionFactory.getCurrentSession();
		List <Departments> listDepartments=session.createQuery("from Departments",Departments.class).getResultList();
		return listDepartments;
	}


	@Override
	public List<Jobs> listJobs() {
		Session session=sessionFactory.getCurrentSession();
		List<Jobs> listJobs=session.createQuery("from Jobs", Jobs.class).getResultList();
		return listJobs;
	}

	@Override
	public Jobs getJob(String jobId) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Jobs.class, jobId);
	}

	@Override
	public List<Employees> getAraEmployee(Employees employee) {
		Session session = sessionFactory.getCurrentSession();

		Query<Employees> query = session.createQuery(
				"from Employees e where 1=1 and e.first_name like :araEmpFirstName and e.manager.first_name like  :araManagerFirstName and e.job.job_title like :job and e.last_name like :lastName and e.phone_number like :phone",
				Employees.class).setParameter("araEmpFirstName", '%' + employee.getFirst_name() + '%')
				.setParameter("araManagerFirstName", '%' + employee.getManager().getFirst_name() + '%')
				.setParameter("job", '%' + employee.getJob().getJob_title()+ '%')
				.setParameter("lastName", '%' + employee.getLast_name() + '%')
				.setParameter("phone", '%' + employee.getPhone_number()+'%');
				//.setParameter("dept", employee.getDepartment().getDepartmentName())

		List<Employees> resultList = query.getResultList();
		System.out.println(resultList + "arama");
		return resultList;
	}

}
