<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Öğrenci Formu</title>
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
			<h2>Öğretmen Formu</h2>
			<frm:form action="ogretmen-kaydet" modelAttribute="ogretmen" method="POST">
			<frm:hidden path="id"/>
			<frm:errors path="id"/>
		
				<table>
					<tr>
						<td><label>İsim</label></td>
						<td><frm:input path="ogrtmn_adi" required="true" /></td>
					</tr>
					<tr>
						<td><label>Soyisim</label></td>
						<td><frm:input path="ogrtmn_soyadi" required="true"/></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><frm:input path="email" required="true" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><frm:button value="save" name="save" class="kaydet">Kaydet</frm:button>
					</td>
					</tr>
				</table>
			</frm:form>
		</div>
	</div>
	<br>
</body>
</html>