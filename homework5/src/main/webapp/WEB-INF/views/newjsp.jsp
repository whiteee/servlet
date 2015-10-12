
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>

</body>
</html>



out.print("<h1>Регистрация</h1>"
+"<form action= 'http://localhost:8080/main' method = 'post'"
+"<label>Ваш e-mail: <br>"
+"<input type ='text' name = 'mail'></label> <br>"
+"<label>Пароль: <br>"
+"<input type ='password' name='pwd'></label> <br>"
+"<input type='radio' name='sex' value='1'> Муж"
+"<input type='radio' name='sex' value='0'> Жен <br>"
+"<label><input type ='checkbox' name='chb'></label>Подписаться на новости <br>"
+"<input type ='submit' value='Зарегестрироваться'>"
+ s +"</form>"
);