<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KURS LİSTE</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id=header>
			<h2>Kurs Listeleme</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<br>
			<table>
				<thead>
					<tr>
						<th>ID:</th>
						<th>Kursun Adı:</th>
						<th>Kurs Saati:</th>
						<th>Ogretmen </th>
						<th>İşlem:</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${kurslar}" var="kurs">
						<c:url var="updateLink" value="/kurs/kurs-guncelle">
							<c:param name="kursID" value="${kurs.id}" />
						</c:url>
						<c:url var="deleteLink" value="/kurs/kurs-sil">
							<c:param name="kursID" value="${kurs.id}" />
						</c:url>
						<tr>
							<td>${kurs.id}</td>
							<td>${kurs.kurs_adi}</td>
							<td>${kurs.saat}</td>
							<td>${kurs.ogretmen}</td>
							<td> <button onclick="window.location.href='${updateLink}'" class="update-button">Güncelle</button>
							<button onclick="if(confirm('Siliyoruz, Emin misin?'))window.location.href='${deleteLink}'" class="delete-button">Sil</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<hr>
<button onclick="window.location.href='kurs-ekle'" class="ekle">Kurs
		Ekle</button>
</body>
</html>