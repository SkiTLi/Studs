<%@ page language="java" contentType="text/html; charset=Windows-1251"
    pageEncoding="Windows-1251"%>
<! Windows-1251 DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
    <title>Начальная страница</title>
</head>
 
<body>
    <h1>JSP студента</h1>
    <!-- комментарий!! нижняя строка определяет адрес новой страницы при нажатии на кнопку -->    
    <form action = "hello" method="GET">
               
    <table border = "6"> 

    <tr>
        <td><b>Действие:</b></td>
        <td>
            <select name = "act3">
                <option value = "add">Добавить студента</option>
                <option value = "update">Обновить студента</option>
                <option value = "delete"> Удалить студента</option>                
            </select>
        </td>
    </tr>    
 
    <tr>
	<!-- type number только для html5 не поддерживает firefox -->
        <td><b>ID</b></td>
        <td><input type = "text" name = "id"
            value = "" size = "10"/></td>
    </tr>

    <tr>
        <td><b>NAME</b></td>
        <td><input type = "text" name = "name"
            value = "" size = "30"/></td>
    </tr>

    <!tr>
        <!td><!bBIRTHDAY!/b><!/td>
        <!td><!input type = "text" name = "birthday"
            value = "" size = "20"/><!/td>
    <!/tr>    
        
    <tr>
        <td colspan = "19"><input type = "submit" value = "Выполнить"/></td>
    </tr>
    </table>
    </form>
</body>
</html>