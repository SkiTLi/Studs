<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="Windows-1251"%>
<! Windows-1251 DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>редактор студента</title>
</head>
 
<body>
    <h2>»змените значени€ полей ID и/или NAME,<br>
	если их следует откорректировать.<br>
    </h2>
    <h3>(поле BIRTHDAY устанавливаетс€ автоматически,<br>
	поэтому его изменить нельз€)
    </h3>

    <!-- комментарий!! нижн€€ строка определ€ет адрес новой страницы при нажатии на кнопку -->    
    <form action = "servStud" method="GET">
               
    <table border = "6">
      
    <input type="hidden" name="act3" value="update"/>
    <input type="hidden" name="mot" value="action"/>

    <tr>
	<!-- type number только дл€ html5 не поддерживает firefox -->
        <td><b>ID</b></td>
        <td><input type = "text" name = "id"
            value = "<%= request.getParameter("id") %>" size = "10"/></td>
    </tr>

    <tr>
        <td><b>NAME</b></td>
        <td><input type = "text" name = "name"
            value = "<%= request.getParameter("name") %>" size = "30"/></td>
    </tr>


	<!-- данное поле выставл€етс€ автоматически, поэтому его изменить нельз€ -->
    <tr>
        <td><b>BIRTHDAY</b></td>
        <td><input type = "text" name = "birthday"
            value = "<%= request.getParameter("birthday") %>" size = "20"/></td>
    </tr>    
        
    <tr>
        <td colspan = "19"><input type = "submit" value = "—охранить"/></td>
    </tr>
    </table>
    </form>
</body>
</html>