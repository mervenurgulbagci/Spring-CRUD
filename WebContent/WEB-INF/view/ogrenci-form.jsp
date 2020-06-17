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
			<h2>Öğrenci Formu</h2>
			<frm:form action="ogrenci-kaydet" modelAttribute="ogrenci" method="POST">
			<frm:hidden path="id"/>
				<table>
					<tr>
						<td><label>İsim</label></td>
						<td><frm:input path="isim" /></td>
					</tr>
					<tr>
						<td><label>Soyisim</label></td>
						<td><frm:input path="soyisim" /></td>
					</tr>
					<tr>
						<td><label>Öğrenci No</label></td>
						<td><frm:input path="ogrenciNo" /></td>
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