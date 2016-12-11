<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="Windows-1251"%>
<! Windows-1251 DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!--<meta charset="utf-8">-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Начальная страница</title>
</head>
 
<body>
    <h1>Хотите ли Вы запустить ServletStudents?</h1>
    <!-- комментарий!! нижняя строка определяет адрес новой страницы при нажатии на кнопку -->    
    <form action = "servStud" method="GET">
               
    <table border = "6">     
    
    <input type="hidden" name="mot" value="print"/>
   
    <tr>
        <td colspan = "19"><input type = "submit" value = "Да!"/></td>
    </tr>
    </table>
    </form>
</body>
</html>