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
			<h2>Kurs Formu</h2>
			<frm:form action="kurs-kaydet" modelAttribute="kurslar" method="POST">
			<frm:hidden path="id"/>
		
				<table>
					<tr>
						<td><label>Kurs Adı</label></td>
						<td><frm:input path="kurs_adi" required="true"/></td>
					</tr>
					<tr>
						<td><label>Saat</label></td>
						<td><frm:input path="saat" type="number" required="true"/></td>
					</tr>
					<tr>
						<td><label>Öğretmen ID</label></td>
						<td><frm:select path="ogretmen.id" >
							<frm:options items="${ogretmenler}" />
						</frm:select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><frm:button value="save" name="save">Kaydet</frm:button></td>
					</tr>
				</table>
			</frm:form>
		</div>
	</div>
	<br>
</body>
</html>