<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="Windows-1251"%>
<! Windows-1251 DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>�������� ��������</title>
</head>
 
<body>
    <h2>�������� �������� ����� ID �/��� NAME,<br>
	���� �� ������� ����������������.<br>
    </h2>
    <h3>(���� BIRTHDAY ��������������� �������������,<br>
	������� ��� �������� ������)
    </h3>

    <!-- �����������!! ������ ������ ���������� ����� ����� �������� ��� ������� �� ������ -->    
    <form action = "servStud" method="GET">
               
    <table border = "6">
      
    <input type="hidden" name="act3" value="update"/>
    <input type="hidden" name="mot" value="action"/>

    <tr>
	<!-- type number ������ ��� html5 �� ������������ firefox -->
        <td><b>ID</b></td>
        <td><input type = "text" name = "id"
            value = "<%= request.getParameter("id") %>" size = "10"/></td>
    </tr>

    <tr>
        <td><b>NAME</b></td>
        <td><input type = "text" name = "name"
            value = "<%= request.getParameter("name") %>" size = "30"/></td>
    </tr>


	<!-- ������ ���� ������������ �������������, ������� ��� �������� ������ -->
    <tr>
        <td><b>BIRTHDAY</b></td>
        <td><input type = "text" name = "birthday"
            value = "<%= request.getParameter("birthday") %>" size = "20"/></td>
    </tr>    
        
    <tr>
        <td colspan = "19"><input type = "submit" value = "���������"/></td>
    </tr>
    </table>
    </form>
</body>
</html>