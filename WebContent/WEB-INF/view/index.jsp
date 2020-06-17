<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Login Formu</title>
<style>

.hata {
	color: red;
}

Body {
	font-family: Calibri, Helvetica, sans-serif;
	align: center;
	background-color: #494491;
	display: -webkit-box;
	display: -webkit-flex;
	display: -moz-box;
	display: -ms-flexbox;
	display: flex;
	flex-wrap: wrap;
}

button {
	background-color: #ffffff;
	width: 100%;
	color: black;
	padding: 15px;
	margin: 10px 0px;
	border: none;
	cursor: pointer;
}

form {
	border: 3px solid #f1f1f1;
	align: center;
}

h1 {
	width: 100%;
	display: block;
	font-family: OpenSans-Regular;
	font-size: 30px;
	color: #fefefe;
	line-height: 1.2;
	text-transform: uppercase;
	text-align: center;
}

input[type=text], input[type=password] {
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 2px solid #494491;
	box-sizing: border-box;
	font-weight: bold;
}

button:hover {
	opacity: 0.7;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	margin: 10px 5px;
}

.container {
	padding: 25px;
	align: center;
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 2px solid white;
	box-sizing: border-box;
}
</style>
<script>
	function validLogin() {
		if (document.form.kullanici_adi.value == " ") {
			alert("Lütfen Kullanıcı Adı Girin");

			return false;
		}
		if (document.form.sifre.value == " ") {
			alert("Lütfen Şifre Girin");

			return false;
		}
		return true;
	}
</script>

</head>
<body>


	<frm:form action="giris-yap" modelAttribute="user-login" method="POST"
		class="form" onsubmit="validLogin()">
		<div class="group">
				<%
	HttpSession ses = request.getSession();
	String kontrol = (String)ses.getAttribute("oturum-email");
	if(kontrol==null){
		out.print("Lütfen Önce Giriş Yap !");
	}
	%>
		<h1>HESAP GİRİŞ</h1>

		<frm:input type="text" path="email" name="mail" placeholder="Email" />
		</div>
		<frm:errors path="email" cssClass="hata" style="color:white" />
		<input type="password" name="password" placeholder="Password" />
		<frm:errors path="password" cssClass="hata" style="color:white" />
		<button class="button" type="submit">GİRİŞ YAP</button>

	</frm:form>

</body>
</html>