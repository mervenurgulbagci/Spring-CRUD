<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee LİSTE</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<script>
	//Get the button
	var mybutton = document.getElementById("myBtn");
	// When the user scrolls down 20px from the top of the document, show the button
	window.onscroll = function() {
		scrollFunction()
	};
	function scrollFunction() {
		if (document.body.scrollTop > 20
				|| document.documentElement.scrollTop > 20) {
			mybutton.style.display = "block";
		} else {
			mybutton.style.display = "none";
		}
	}
	// When the user clicks on the button, scroll to the top of the document
	function topFunction() {
		document.body.scrollTop = 10000;
		document.documentElement.scrollTop = 10000;
	}
</script>

</head>
<body>
	<div id="wrapper">
		<div id=header>
			<h2>Employee Listeleme</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<br>

			<table>
				<thead>
					<tr>
						<th>ID:</th>
						<th>Adı:</th>
						<th>Soyadı:</th>
						<th>Email:</th>
						<th>Telefon:</th>
						<th>Hire Date:</th>
						<th>Job:</th>
						<th>Salary:</th>
						<th>Commıssıon:</th>
						<th>Manager:</th>
						<th>Department:</th>

						<th>İşlem:</th>
					</tr>
					<tr>
						<frm:form action="search" modelAttribute="employeeara"
							method="POST">
							<td></td>
							<td><frm:input path="first_name" placeholder="Ara" /></td>
							<td><frm:input path="last_name" placeholder="Ara"/></td>
							<td></td>
							<td><frm:input path="phone_number" placeholder="Ara"/></td>
							<td></td>
							<td><frm:input path="job.job_title" placeholder="Ara"/></td>
							<td></td>
							<td></td>
							<td><frm:input path="manager.first_name" placeholder="Ara"/></td>
							<td></td>
							<td><frm:button type="submit" class="button">Ara</frm:button></td>
						</frm:form>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employees}" var="employees">
						<c:url var="updateLink" value="/employees/employee-guncelle">
							<c:param name="employeeId" value="${employees.employeeId}" />
						</c:url>
						<c:url var="deleteLink" value="/employees/employee-sil">
							<c:param name="employeeId" value="${employees.employeeId}" />
						</c:url>
						<tr>
							<td>${employees.employeeId}</td>
							<td>${employees.first_name}</td>
							<td>${employees.last_name}</td>
							<td>${employees.email}</td>
							<td>${employees.phone_number}</td>
							<td>${employees.hire_date}</td>
							<td>${employees.job.job_title}</td>
							<td>${employees.salary}</td>
							<td>${employees.commission_pct}</td>
							<td>${employees.manager.first_name}</td>
							<td>${employees.department.department_name}</td>
							<td>
								<button onclick="window.location.href='${updateLink}'"
									class="update-button">Güncelle</button>
								<button
									onclick="if(confirm('Siliyoruz, Emin misin?'))window.location.href='${deleteLink}'"
									class="delete-button">Sil</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<hr>
	<button onclick="window.location.href='employee-ekle'">Employee
		Ekle</button>
</body>
</html>