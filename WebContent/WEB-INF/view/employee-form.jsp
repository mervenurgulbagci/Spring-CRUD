<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Employee Formu</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<style>
.hata {
	color: red;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id=header>
			<h2>Çalışan Formu</h2>
			<frm:form action="employee-kaydet" modelAttribute="employees"
				method="POST">
				<frm:hidden path="employeeId" />
				
				<table>
					<tr>
						<td><label>İsim</label></td>
						<td><frm:input path="first_name" required="true" /> <frm:errors
								path="first_name" cssClass="hata" /></td>
					</tr>
					<tr>
						<td><label>Soyisim</label></td>
						<td><frm:input path="last_name" required="true" /> <frm:errors
								path="last_name" cssClass="hata" /></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><frm:input path="email" required="true" /> <frm:errors
								path="email" cssClass="hata" /></td>
					</tr>
					<tr>
						<td><label>Telefon</label></td>
						<td><frm:input path="phone_number" placeholder="5XX.XXX.XX.XX"
								required="true"
								pattern="^[0-9+-]+(\\.[0-9+-]+)*[0-9-]+(.[0-9]+)$"
								title="Rakam veya nokta içerebilir" /> <frm:errors
								path="phone_number" cssClass="hata" /></td>
					</tr>
					<tr>
						<td><label>Hire Date</label></td>
						<td><frm:input type="date" path="hire_date"   required="true" placeholder="1900-01-01"/>
						<frm:errors path="hire_date" cssClass="hata" /></td>
					</tr>
					<tr>
						<td><label>Job</label></td>
						<td>
						<frm:select path="job.id">
							<frm:options items="${job}" />
						</frm:select>
						</td>
					</tr>
					<tr>
						<td><label>Salary</label></td>
						<td><frm:input path="salary" type="number"  required="true"/></td>
					</tr>
					<tr>
						<td><label>Commission</label></td>
						<td><frm:input path="commission_pct" type="number" /></td>
					</tr>
					<tr>
						<td><label>Manager</label></td>
						<td>
						<frm:select path="manager.employeeId">
						</frm:select>
						</td>
					</tr>
					<tr>
						<td><label>Departman</label></td>
						<td>
						<frm:select path="department.department_id">
							<frm:options items="${department}" />
						</frm:select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><frm:button value="save" name="save">Kaydet</frm:button></td>
					</tr>
				</table>
			</frm:form>
			<button onclick="window.location.href='employee-list'" class="vazgec">Vazgec</button>
		</div>
	</div>
	<br>
</body>
</html>