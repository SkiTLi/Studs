<%@ page language="java" contentType="text/html; charset=Windows-1251"
    pageEncoding="Windows-1251"%>
<! Windows-1251 DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
    <title>�������� ��������</title>
</head>
 
<body>
    <h2>�� ������������� ������ ������� ������� ��������?<br>
    </h2>
    
    <!-- �����������!! ������ ������ ���������� ����� ����� �������� ��� ������� �� ������ -->    
    <form action = "servStud" method="GET">
               
    <table border = "6">
      
    <input type="hidden" name="act3" value="delete"/>

    <tr>
    <!-- ������ �������� ������������ ��� ������ �������� ��� �������� --> 
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>"/>	
        <td><b>ID</b></td>
        <td><%= request.getParameter("id") %></td>
    </tr>

    <tr>
        <td><b>NAME</b></td>
        <td><%= request.getParameter("name") %></td>
    </tr>


	<!-- ������ ���� ������������ �������������, ������� ��� �������� ������ -->
    <tr>
        <td><b>BIRTHDAY</b></td>
        <td><%= request.getParameter("birthday") %></td>
    </tr>    
        
    <tr>
        <td colspan = "19"><input type = "submit" value = "��"/></td>
    </tr>
    </table>
    </form>
</body>
</html>