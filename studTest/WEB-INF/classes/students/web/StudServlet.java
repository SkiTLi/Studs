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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String motion  = request.getParameter("mot");    //параметр определяющий действие
	/*	if (motion == null) {
			// именно в таком порядке mAct() затем printListStud() затем printParam()
			mAct(request, response);// обновляет, удаляет, добавляет студента
			printListStud(request, response);// печатет студентов и кнопки редактирования/удаления
			//printParam(request, response);	//печатает все параметры
		} else {
	*/
			switch (motion) {
				case "update":
					request.getRequestDispatcher("/WEB-INF/otherjsp/updateStud.jsp").forward(request, response);//переходит на другую jsp
					break;
				case "delete":
					request.getRequestDispatcher("/WEB-INF/otherjsp/deleteStud.jsp").forward(request, response);//переходит на другую jsp
					break;
				case "add":
					request.getRequestDispatcher("/WEB-INF/otherjsp/addStud.jsp").forward(request, response);//переходит на другую jsp
					break;
				// именно в таком порядке mAct() затем printListStud() затем printParam(), поэтому без break
				case "action":
					mAct(request, response);// обновляет, удаляет, добавляет студента
				case "print":
					printListStud(request, response);// печатет студентов и кнопки редактирования/удаления
					break;


			}
	//	}
	}

    private void printListStud(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        resp.setContentType("text/html;charset=utf-8"); //utf-8//Windows-1251//???? "text/html;charset=Windows-1251"
		PrintWriter pw = resp.getWriter();
        pw.println("<B>если убрать *;charset=Windows-1251||utf-8*, то русского текста не видно</B>");
        pw.println("<table border=3>");
		try {
			List<Student> l = StudentDao.getInstance().getAllStudents();
			for (Student s:l){
				pw.println("<tr>");
				pw.println("<td>" + s.getId() + "</td>");
				pw.println("<td>" + s.getName() + "</td>");
				pw.println("<td>" + s.getBirthday() + "</td>");
				pw.println("<form action = \"servStud\" method=\"GET\"><td colspan = \"19\">"
					+ "<input type=\"hidden\" name=\"id\" value=\"" + s.getId()
					+ "\" />	<input type=\"hidden\" name=\"name\" value=\"" + s.getName()
					+ "\" />	<input type=\"hidden\" name=\"birthday\" value=\"" + s.getBirthday()
					+ "\" />	<input type=\"hidden\" name=\"mot\" value=\"update\" />"	//??????????? ??????????? ????????, ??????? ?????????? ???????? ? ???? ?? ????????
					+"<input type = \"submit\" value = \"Ред(Update)\"/>	</td></form>");
				pw.println("<form action = \"servStud\" method=\"GET\"><td colspan = \"19\">"
					+ "<input type=\"hidden\" name=\"id\" value=\""	+ s.getId()
					+ "\" />	<input type=\"hidden\" name=\"name\" value=\"" + s.getName()
					+ "\" />	<input type=\"hidden\" name=\"birthday\" value=\"" + s.getBirthday()
					+ "\" />	<input type=\"hidden\" name=\"mot\" value=\"delete\" />" //??????????? ??????????? ????????, ??????? ?????????? ???????? ? ???? ?? ????????
					+"<input type = \"submit\" value = \"Удал(Delete)\"/>	</td></form>");
				pw.println("</tr>");
			}
			pw.println("<form action = \"servStud\" method=\"GET\"><td colspan = \"19\">"
				+ "<input type=\"hidden\" name=\"mot\" value=\"add\" />"				//??????????? ??????????? ????????, ??????? ?????????? ???????? ? ???? ?? ????????
				+ "<input type = \"submit\" value = \"Нов. студ (Add a new student)\"/>	</td></form>");
		} catch (Exception e) {
			throw new ServletException("Eгг0R. you make some mistake!",e);
		}
			pw.println("</table>");
	}

    private void mAct(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		try {
			String act="";
			if (req.getParameter("act3")!=null){
				act=req.getParameter("act3");
			}
			int id1=888;
			if (req.getParameter("id")!=null){
				id1=Integer.parseInt(req.getParameter("id"));//parse нужен для преобразования string в int
			}
			String name1="empty8";
			if (req.getParameter("name")!=null){
				name1=req.getParameter("name");
			}
			Student stud = new Student();
			stud.setId(id1);
			stud.setName(name1);
			switch (act){
				case "add":
					StudentDao.getInstance().addStudent(stud);
					//pw.println("должен был добавться студент");
					break;
				case "update":
					StudentDao.getInstance().updateStudent(stud);
					//pw.println("должен был измениться студент");
					break;
				case "delete":
					StudentDao.getInstance().deleteStudent(stud);
					//pw.println("должен был удалиться студент");
					break;
				default:
					break;
			}
		} catch (Exception e) {
			throw new ServletException("Eгг0R. you make some mistake!",e);
		}
	}

    private void printParam(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        PrintWriter out = response.getWriter();
		try {
	    	response.setContentType("text/html;charset=utf-8");

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