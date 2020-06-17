<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>HOŞGELDİNİZ</title>
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
 
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
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid #494491;   
        box-sizing: border-box;   
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
         width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid white;   
        box-sizing: border-box;      
    }   
</style>   

</head>
<body>
	<div class="container" align="center">
<div align="center">
		<div class="wrap">
			<button onclick="window.location.href='ogrenci/list'"
				class="listeleme">Öğrenci </button>
		
		</div>


		<div class="wrap">
			<button onclick="window.location.href='kurs/list'"
				class="listeleme">Kurs</button>
	
		</div>


		<div class="wrap">
			<button onclick="window.location.href='employees/list'"
				class="listeleme">Çalışan </button>
		
		</div>
	</div>
</div>
</body>
</html>