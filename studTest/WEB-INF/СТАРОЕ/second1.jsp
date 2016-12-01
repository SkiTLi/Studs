<%@ page language="java" 
    contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri=" http://java.sun.com/jsp/jstl/core" 
    prefix="c" %>

<! Windows-1251 DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!head>
    <!meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
    <!title>Начальная страница<!/title>
<!/head>
 
<body>
    <h1>это кстати уже вторая jsp</h1>
    <!-- комментарий!! нижняя строка определяет адрес новой страницы при нажатии на кнопку -->    
    <!form action = "sktl" method="post">
               
    <!table border = "6"> 

    <c:out value="blablabla tekst, zatem"/><br>
    <!c:out value="blabla tekst2, a potom uje ${calend.time}"/><br>

    Хотите ли вы запутить 2-ой сервлет?
        
    <!tr>
        <!td colspan = "19"><input type = "submit" value = "Да!.."/><!/td>
    <!/tr>
    <!/table>
    <!/form>
</body>
</html>