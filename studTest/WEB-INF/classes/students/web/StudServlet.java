//cd /dD:\AndyKotins\Dropbox\Pharma\I_Java_etc\SkiTLi_Java_Projects\tomcat6x64\webapps\studTest\WEB-INF\classes
//cd /dD:\_Kotlinskii\Dropbox\Dropbox\Pharma\I_Java_etc\SkiTLi_Java_Projects\tomcat6x64\webapps\studTest\WEB-INF\classes
//javac -cp .;servlet-api.jar students\web\*.java students\logic\*.java
//http://localhost:8080/skitlitest/sktl

package students.web;
import students.logic.*;
//import students.web.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudServlet extends javax.servlet.http.HttpServlet {    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	printListStud(request, response);// именно в таком порядке process2 потом 1
	//printParam(request, response);
    }

    private void printListStud(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        resp.setContentType("text/html;charset=Windows-1251"); //utf-8//Windows-1251//было "text/html;charset=Windows-1251"
	PrintWriter pw = resp.getWriter();
        pw.println("<B>если убрать *;charset=Windows-1251*, то русского текста не видно</B>");
        pw.println("<table border=3>");	
	try {	    
            List<Student> l = StudentDao.getInstance().getAllStudents();	    
	    for (Student s:l){           
                pw.println("<tr>");				
                pw.println("<td>" + s.getId() + "</td>"); 
		pw.println("<td>" + s.getName() + "</td>");
		pw.println("<td>" + s.getBirthday() + "</td>");		
		pw.println("<form action = \"/studTest/updateServ\" method=\"GET\"><td colspan = \"19\"><input type=\"hidden\" name=\"id\" value=\""
			+ s.getId() + "\" />	<input type=\"hidden\" name=\"name\" value=\"" 
			+ s.getName() + "\" />	<input type=\"hidden\" name=\"birthday\" value=\"" 
			+ s.getBirthday() + "\" />	<input type = \"submit\" value = \"Редактировать\"/>	</td></form>");
		pw.println("<form action = \"/studTest/deleteServ\" method=\"GET\"><td colspan = \"19\"><input type=\"hidden\" name=\"id\" value=\""
			+ s.getId() + "\" />	<input type=\"hidden\" name=\"name\" value=\"" 
			+ s.getName() + "\" />	<input type=\"hidden\" name=\"birthday\" value=\"" 
			+ s.getBirthday() + "\" />	<input type = \"submit\" value = \"Удалить\"/>	</td></form>");
       
                pw.println("</tr>");
            }
	    pw.println("<form action = \"/studTest/addServ\" method=\"GET\"><td colspan = \"19\"><input type = \"submit\" value = \"Добавить нового студента\"/>	</td></form>");	    		
	
	    String act=req.getParameter("act3");
	    int id1;
	    id1=Integer.parseInt(req.getParameter("id"));//parse нужен для преобразования string в int
/*	    if (id1!=1){
		req.getRequestDispatcher("/WEB-INF/otherjsp/error.jsp").include(req, resp);
	   }
*/
	    pw.println(id1);
	    String name1=req.getParameter("name");	    
	    Student stud = new Student();
	    stud.setId(id1);
	    stud.setName(name1);
	    switch (act){
		case "add":		
		StudentDao.getInstance().addStudent(stud);
		//pw.println("должен добавится студентик");
		break;
		case "update":		
		StudentDao.getInstance().updateStudent(stud);
		//pw.println("должен обновиться студентик");
		break;
		case "delete":				
		StudentDao.getInstance().deleteStudent(stud);
		//pw.println("должен удалиться студентик");
		break;
	    }		
        } catch (Exception e) {
            throw new ServletException("ERROR. you made a mistake when filling in the ID field!",e);
        }
        pw.println("</table>");        
    }

    private void printParam(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        PrintWriter out = response.getWriter();
	try {
	    response.setContentType("text/html;charset=Windows-1251"); 

            // Get the values of all request parameters
            Enumeration en = request.getParameterNames();
            while(en.hasMoreElements()) {
            	// Get the name of the request parameter
                String name = (String)en.nextElement();
                out.println("|----|"+ name);
 
            	// Get the value of the request parameter
                String value = request.getParameter(name);
 
            	// If the request parameter can appear more than once in the query string, get all values
                String[] values = request.getParameterValues(name); 
                for (int i=0; i<values.length; i++) {
                    out.println(" ==== " + values[i]);
                }	
            }
	    out.close();
	} catch (Exception e) {
            throw new ServletException(e);
        }                
    }

}