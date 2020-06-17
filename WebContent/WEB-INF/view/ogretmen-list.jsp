 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Öğretmenler</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id=header>
			<h2>Öğretmen Listeleme</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<br>
			<table>
				<thead>
					<tr>
						<th>ID:</th>
						<th>Isim:</th>
						<th>Soyisim:</th>
						<th>Email:</th>
						<th>İşlem:</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ogretmenler}" var="ogrtmn">
						<c:url var="updateLink" value="/ogretmen/ogretmen-guncelle">
							<c:param name="ogretmenId" value="${ogrtmn.id}" />
						</c:url>

						<c:url var="deleteLink" value="/ogretmen/ogretmen-sil">
							<c:param name="ogretmenId" value="${ogrtmn.id}" />
						</c:url>

						<tr>
							<td>${ogrtmn.id}</td>
							<td>${ogrtmn.ogrtmn_adi}</td>
							<td>${ogrtmn.ogrtmn_soyadi}</td>
							<td>${ogrtmn.email}</td>
							<td>
								<button onclick="window.location.href='${updateLink}'" class="update-button">Güncelle</button>
								<button onclick="if(confirm('Siliyoruz, Emin misin?'))window.location.href='${deleteLink}'"
									class="delete-button">Sil</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<hr>
	<button onclick="window.location.href='ogretmen-ekle'" class="ekle">Öğretmen Ekle</button>
		
</body>
</html>