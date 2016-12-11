<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="Windows-1251"%>
<! Windows-1251 DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
    <title>добавление студента</title>
</head>
 
<body>
    <h2>Заполните значения полей ID и NAME,<br>
	если хотите добавить нового студента.<br>
    </h2>
    <h3>(поле BIRTHDAY устанавливается автоматически,<br>
	поэтому его можно не заполнять)
    </h3>

    <!-- комментарий!! нижняя строка определяет адрес новой страницы при нажатии на кнопку -->    
    <form action = "servStud" method="GET">
               
    <table border = "6">

    <!-- возможно следует выбрать одну из нижних строк -->
    <input type="hidden" name="act3" value="add"/>      
    <input type="hidden" name="mot" value="action"/>

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


	<!-- данное поле выставляется автоматически, поэтому его изменить нельзя -->
    <tr>
        <td><b>BIRTHDAY</b></td>
        <td><input type = "text" name = "birthday"
            value = "" size = "20"/></td>
    </tr>    
        
    <tr>
        <td colspan = "19"><input type = "submit" value = "Сохранить"/></td>
    </tr>
    </table>
    </form>
</body>
</html>