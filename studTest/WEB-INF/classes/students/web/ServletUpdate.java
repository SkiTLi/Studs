//cd /dD:\AndyKotins\Dropbox\Pharma\I_Java_etc\SkiTLi_Java_Projects\tomcat6x64\webapps\studTest\WEB-INF\classes
//cd /dD:\_Kotlinskii\Dropbox\Dropbox\Pharma\I_Java_etc\SkiTLi_Java_Projects\tomcat6x64\webapps\studTest\WEB-INF\classes
//javac -cp .;servlet-api.jar students\web\*.java students\logic\*.java
//http://localhost:8080/skitlitest/sktl

package students.web;
import students.logic.*;

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

public class ServletUpdate extends javax.servlet.http.HttpServlet {    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=Windows-1251"); //utf-8//Windows-1251//было "text/html;charset=Windows-1251"
	request.getRequestDispatcher("/WEB-INF/otherjsp/updateStud.jsp").forward(request, response);//переход на другую jsp	
    }
}