<%@ page language="java" 
    contentType="text/html; charset=Windows-1251"
    pageEncoding="Windows-1251"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
    prefix="c" %>

<! Windows-1251 DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!head>
    <!meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
    <!title>��������� ��������<!/title>
<!/head>
 
<body>
    <h1>��� ������ ��� ������ jsp</h1>
    <!-- �����������!! ������ ������ ���������� ����� ����� �������� ��� ������� �� ������ -->    
    <form action = "sktl" method="GET">
               
    <table border = "6"> 

    <c:out value="tekst1, zatem  ${loc}"/><br>
    <!c:out value="tekst2, a potom uje ${calend.time}"/><br>

    ������ �� �� �������� 2-�� �������?
        
    <tr>
        <td colspan = "19"><input type = "submit" value = "��!.."/></td>
    </tr>
    </table>
    </form>
</body>
</html>