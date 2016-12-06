//����� � ������� ��������� ������ ����������, ���������, �������� ����� �� ������� Student � ������� PreparedStatement
//javac -cp .;servlet-api.jar students\web\*.java students\logic\*.java


package students.logic;
import students.logic.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.Properties;
import java.io.InputStream;

public class StudentDao{
    private Connection con = null;
    private static StudentDao instance = null;//��� ����� ��� ������ � ��������������
    private PreparedStatement addPs = null;
    private PreparedStatement updatePs = null;
    private PreparedStatement deletePs = null;    
    private PreparedStatement allStudentsPs = null;
    private PreparedStatement subjectsMarksOfStudentPs = null;    
    //String uq = "UPDATE student SET name = '"+newStud.getName()+"', birthday ='"+ft.format(newStud.getBirthday())+"' WHERE id ="+ newStud.getId(); //��������  ��������
    private static final String ADD_STR = "insert into student (id, name, birthday) values (?, ?, ?)";
    private static final String UPDATE_STR = "UPDATE student SET name = ?, birthday =? WHERE id = ?";	//!����� ��������� ������� �� ����� (' '), ��� � ������ � ������� ������� (��. ����)
    private static final SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
    private static final String DELETE_STR = "DELETE FROM student WHERE id = ?";		    
    private static final String ALL_STUDS_STR = "SELECT id, name, birthday FROM student";	    
    private static final String SUBJS_MARKS_OF_STUDS_STR = "SELECT id, rmark, studentID, subjectID FROM mark WHERE studentID = ?";    

/*
	//������ �� �����
	public HashSet<CloudFilesConflictStates> getConflictStates() {
		if (conflictStates == null) {
			conflictStates = new HashSet<>();
		}
		if (conflictStates.isEmpty()) {
			conflictStates.add(CloudFilesConflictStates.None);
		}
		return conflictStates;
	}
*/
    //���� �� ������� ������� �������������
    private PreparedStatement getAddPs() throws DaoException{ // ����� private �.�. ����� �������������� ������ ������ DAO
	try {
	    if (addPs == null) {
		addPs = con.prepareStatement(ADD_STR);
	    }
	    return addPs;
	} catch (Exception e) {
	    throw new DaoException("������ �������� ������� ���������� ��������",e);	    
	}
    }

    private PreparedStatement getUpdatePs() throws DaoException{
	try {
	    if (updatePs == null) {
		updatePs = con.prepareStatement(UPDATE_STR);
	    }
	    return updatePs;
	} catch (Exception e) {
	    throw new DaoException("������ �������� ������� ���������� ��������",e);	    
	}
    }

    private PreparedStatement getDeletePs() throws DaoException{
	try {
	    if (deletePs == null) {
		deletePs = con.prepareStatement(DELETE_STR);
	    }
	    return deletePs;
	} catch (Exception e) {
	    throw new DaoException("������ �������� ������� �������� ��������",e);	    
	}
    }
    
    private PreparedStatement getAllStudentsPs() throws DaoException{
	try {
	    if (allStudentsPs == null) {
		allStudentsPs = con.prepareStatement(ALL_STUDS_STR);
	    }
	    return allStudentsPs;
	} catch (Exception e) {
	    throw new DaoException("������ �������� ������� ������� ���� ���������",e);	    
	}
    }

    private PreparedStatement getSubjectsMarksOfStudentPs() throws DaoException{
	try {
	    if (subjectsMarksOfStudentPs == null) {
		subjectsMarksOfStudentPs = con.prepareStatement(SUBJS_MARKS_OF_STUDS_STR);
	    }
	    return subjectsMarksOfStudentPs;
	} catch (Exception e) {
	    throw new DaoException("������ �������� ������� ������� ������ � ��������� ����������� ��������",e);	    
	}
    }


    public StudentDao() throws DaoException {		       
 	Properties property;	 
        try {	
    
	    Class.forName("com.mysql.jdbc.Driver"); //����� ��� ������ �� ���������� � apache tomcat
	    property = new Properties();
	    String propFileName = "MySQiTLi.properties";
	    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);	    
	    property.load(inputStream);
	    String url = property.getProperty("db.url");		
            String name = property.getProperty("db.name");		
            String password = property.getProperty("db.password");

	    con = DriverManager.getConnection(url, name, password);
	    System.out.println("����������� � ��. ��� ���");
	         	    	    
	} catch (Exception e) {
	    throw new DaoException("������ ���������� � ��",e);	    
	}	
    }

    //��� � �����, ��� ������ � ������������ � ������� ������ ���� �����
    public static synchronized StudentDao getInstance() throws Exception {
        if (instance == null) {
            instance = new StudentDao();
        }
        return instance;
    }

    //����� ����������� ������ �������� � ������� Student
    public void addStudent(Student newStud) throws DaoException {
	//SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");		
	try {	
	    getAddPs();      
	    addPs.setInt(1, newStud.getId());
	    addPs.setString(2, newStud.getName());
	    addPs.setString(3, ft.format(newStud.getBirthday()));		
	    addPs.executeUpdate();	   	    
	} catch (Exception e) {
	    throw new DaoException("������ ������ ���������� ��������",e);	    
	} 
    }

    //����� ���������� ���� �������� � ������� Student
    public void updateStudent(Student newStud) throws DaoException {	    
	//SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");	
	try {
	    getUpdatePs();	    	        	
	    updatePs.setString(1, newStud.getName());
	    updatePs.setString(2, ft.format(newStud.getBirthday()));
	    updatePs.setInt(3, newStud.getId());		
	    updatePs.executeUpdate();	    	        
	} catch (Exception e) {
	    throw new DaoException("������ ������ ���������� ��������",e);	    
	}	    
    }

    //����� ��������� �������� �� ������� Student
    public void deleteStudent(Student newStud) throws DaoException{		    
	try {
	    getDeletePs();	           	
	    deletePs.setInt(1, newStud.getId());
	    deletePs.executeUpdate();	    	   			   
	} catch (Exception e) {
	    throw new DaoException("������ ������ �������� ��������",e);	    
	}
    }

    //����� ��� ������� ���� ��������� �� ��
    public List<Student> getAllStudents() throws DaoException{	
	Student newStud = null;
	ResultSet rs = null;
	List <Student> listStud =null;	
	try {
	    //newStud = new Student(); //����� � ���� ���� ������ � �������� �������� ������ 
	    //� � ����� � ��� ��� ������ �� ���������� �������� � ��
	    getAllStudentsPs();
	    listStud = new LinkedList<Student>();
	    rs=allStudentsPs.executeQuery();	
	    while (rs.next()){
		newStud = new Student();		
		newStud.setId(rs.getInt("id"));			
		newStud.setName(rs.getString("name"));
		//System.out.println(rs.getString("name"));		
		newStud.setBirthday(rs.getDate("birthday"));		
		listStud.add(newStud);
		//updateStudent(newStud);//�� ���� ������ ������� ������ ������ ����������� � ��			        
	    }	   
	    return listStud;	       	  			   
	} catch (Exception e) {
	    throw new DaoException("������ ������ ������� ���� ���������",e);	    
	}
    }
/*
    //�������� ��� �������� ������ �������� ������ � �� ��������    
    public Map<Subject, Mark> getSubjectsMarksOfStudent(Student newStud) throws DaoException{	
	Map <Subject, Mark> mapSubs = null;
	ResultSet rs = null;
	Subject newSub=null;
	Mark newMark=null;
	SubjectDao newSD = null;	
	try {	    
	    mapSubs = new HashMap<Subject, Mark>();	    	    
	    newSub=new Subject();
	    newMark=new Mark();
	    getSubjectsMarksOfStudentPs();
	    subjectsMarksOfStudentPs.setInt(1, newStud.getId());
	    rs=subjectsMarksOfStudentPs.executeQuery();
	    newSD = new SubjectDao();	    	   
	    while (rs.next()){				
		newSub=newSD.getSubjs(rs.getInt("subjectID")); //���� ����� ����� ������� � SubjectDao (����� ���������� ������� �� ��� id)		
		newMark.setId(rs.getInt("id"));		
		newMark.setRmark(rs.getInt("rmark"));		
		newMark.setSubjectID(rs.getInt("subjectID"));		
		newMark.setStudentID(rs.getInt("studentID"));		
		mapSubs.put(newSub, newMark);			        
	    }
	    //System.out.println(mapSubs.keySet());	    	 	   
	    return mapSubs;	    	       	  			   
	} catch (Exception e) {
	    throw new DaoException("������ ������ ������� ������ � ��������� ����������� ��������",e);	    
	}
    }
*/
    public void close() throws DaoException {    	 
        if (addPs!=null) {	    
	    try {
        	addPs.close();				   
            } catch (Exception e) {
		throw new DaoException("������ ��� �������� ������� ���������� ��������",e);
            }	        
	}
	if (updatePs!=null) {	    
	    try {
        	updatePs.close();				   
            } catch (Exception e) {
		throw new DaoException("������ ��� �������� ������� ���������� ��������",e);
            }	        
	}
	if (deletePs!=null) {	    
	    try {
            	deletePs.close();				   
            } catch (Exception e) {
		throw new DaoException("������ ��� �������� ������� �������� ��������",e);
            }	        
	}
	if (allStudentsPs!=null) {	    
	    try {
            	allStudentsPs.close();				   
            } catch (Exception e) {
		throw new DaoException("������ ��� �������� ������� ������� ���� ���������",e);
            }	        
	}
	if (subjectsMarksOfStudentPs!=null) {	    
	    try {
            	subjectsMarksOfStudentPs.close();				   
            } catch (Exception e) {
		throw new DaoException("������ ��� �������� ������� ������� ������ � ��������� ����������� ��������",e);
            }	        
	}

	if (con!=null) {	    
	    try {		
	        con.close();
	    } catch (Exception e) {
		throw new DaoException("������ ��� �������� ����������",e);
            }
	}
/*	try {
	    System.out.println("con.isClosed() = "+con.isClosed());
	    System.out.println("aps.isClosed() = "+aps.isClosed());
	    System.out.println("ups.isClosed() = "+ups.isClosed());
	    System.out.println("dps.isClosed() = "+dps.isClosed());
	    System.out.println("allps.isClosed() = "+allps.isClosed());
	    System.out.println("bigps.isClosed() = "+bigps.isClosed());
	} catch (Exception e) {
	    throw new DaoException(e);
        }
*/
    }

    public static void main(String[] args) {
	StudentDao studDB = null;
	try{	   
		studDB = new StudentDao(); 	    
		Student a1 = new Student();
/*		
		a1.setId(70);
		a1.setName("Stas");
		studDB.addStudent(a1);

		a1.setId(71);
		a1.setName("Veronika");
		studDB.updateStudent(a1);

		a1.setId(70);
		studDB.deleteStudent(a1);
*/
//		studDB.getAllStudents();

//		a1.setId(2);
//		studDB.getSubjectsMarksOfStudent(a1);				
                
	} catch (Exception e) {
	    System.out.println("������ ������ main");
        } finally{		
	    if (studDB!=null){
		try {		
	            studDB.close();
	    	} catch (Exception e) {
		    System.out.println("������ ������ close");
		}
            }
	}
    }

}







