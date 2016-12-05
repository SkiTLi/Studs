//класс в котором наход€тс€ методы добавлени€, изменени€, удалени€ строк из таблицы Student с помощью PreparedStatement
//cd /d D:\AndyKotins\Dropbox\Pharma\I_Java_etc\SkiTLi_Java_Projects
//javac -cp "." Lesson10/SubjectDao.java
//java -cp .;Lesson10/test/mysql-connector-java-5.1.39-bin.jar Lesson10.SubjectDao

package students.logic;
import students.logic.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.FileInputStream;	

public class SubjectDao{
    private Connection con = null;
    private PreparedStatement addPs = null;
    private PreparedStatement updatePs = null;
    private PreparedStatement deletePs = null;    
    private PreparedStatement allSubjectsPs = null;
    private static final String addStr="insert into subject (id, names, hours) values (?, ?, ?)";
    private static final String updateStr = "UPDATE subject SET names = ?, hours =? WHERE id = ?";	//!здесь одиночные кавычки не нужны (' '), как в случае с обычной строкой (см. выше)
    private static final String deleteStr = "DELETE FROM subject WHERE id = ?";		    
    private static final String allSubjectsStr = "SELECT id, names, hours FROM subject";    
    
    public SubjectDao() throws DaoException {
    	FileInputStream fis;	       
 	Properties property;	 
        try {	
            fis = new FileInputStream("MySQiTLi.properties");
	    property = new Properties();		
            property.load(fis); 		
            String url = property.getProperty("db.url");		
            String name = property.getProperty("db.name");		
            String password = property.getProperty("db.password");            
 	    con = DriverManager.getConnection(url, name, password);        	    	    
	} catch (Exception e) {
	    throw new DaoException("ошибка соединени€ с Ѕƒ",e);	    
	}
    }

    private PreparedStatement getAddPs() throws DaoException{ // нужен private т.к. будет использоватьс€ только внутри DAO
	try {
	    if (addPs == null) {
		addPs = con.prepareStatement(addStr);
	    }
	    return addPs;
	} catch (Exception e) {
	    throw new DaoException("ошибка создани€ запроса добавлени€ предмета",e);	    
	}
    }

    private PreparedStatement getUpdatePs() throws DaoException{
	try {
	    if (updatePs == null) {
		updatePs = con.prepareStatement(updateStr);
	    }
	    return updatePs;
	} catch (Exception e) {
	    throw new DaoException("ошибка создани€ запроса обновлени€ предмета",e);	    
	}
    }

    private PreparedStatement getDeletePs() throws DaoException{
	try {
	    if (deletePs == null) {
		deletePs = con.prepareStatement(deleteStr);
	    }
	    return deletePs;
	} catch (Exception e) {
	    throw new DaoException("ошибка создани€ запроса удалени€ предмета",e);	    
	}
    }
    
    private PreparedStatement getAllSubjectsPs() throws DaoException{
	try {
	    if (allSubjectsPs == null) {
		allSubjectsPs = con.prepareStatement(allSubjectsStr);
	    }
	    return allSubjectsPs;
	} catch (Exception e) {
	    throw new DaoException("ошибка создани€ запроса выборки всех предметов",e);	    
	}
    }

    //метод добавл€ющий новый предмет в таблицу subject
    public void addSubject(Subject newSubj) throws DaoException {			
	try {
	    getAddPs();	      
	    addPs.setInt(1, newSubj.getId());
	    addPs.setString(2, newSubj.getNames());
	    addPs.setInt(3, newSubj.getHours());		
	    addPs.executeUpdate();	   	    
	} catch (Exception e) {
	    throw new DaoException("ошибка метода добавлени€ студента",e);	    
	} 
    }

    //метод измен€ющий пол€ предмета в таблице Subject
    public void updateSubject(Subject newSubj) throws DaoException {	
	try {
	    getUpdatePs();	    	        	
	    updatePs.setString(1, newSubj.getNames());
	    updatePs.setInt(2, newSubj.getHours());
	    updatePs.setInt(3, newSubj.getId());		
	    updatePs.executeUpdate();	    	        
	} catch (Exception e) {
	    throw new DaoException("ошибка метода обновлени€ предмета",e);	    
	}	    
    }

    //метод удал€ющий предмет из таблицы Subject
    public void deleteSubject(Subject newSubj) throws DaoException{		    
	try {
	    getDeletePs();	           	
	    deletePs.setInt(1, newSubj.getId());
	    deletePs.executeUpdate();	    	   			   
	} catch (Exception e) {
	    throw new DaoException("ошибка метода удалени€ предмета",e);	    
	}
    }
    
    //метод дл€ выборки предмета по его id
    public Subject getSubjs(int newId) throws DaoException{
    	Subject newSubj=null;
	ResultSet rs = null;	
	try {
	    newSubj=new Subject();
	    getAllSubjectsPs();	    
	    rs=allSubjectsPs.executeQuery();
	    while(rs.next()){
	        if (rs.getInt("id")==newId){
		    newSubj.setId(newId);
		    newSubj.setNames(rs.getString("names"));
		    newSubj.setHours(rs.getInt("hours"));
	        }
	    }
	    return newSubj;
	} catch (Exception e) {
	    throw new DaoException("ошибка метода получени€ предмета по его id",e);	    
	}
    }

    //метод дл€ выборки всех предметов из бд
    public List<Subject> getAllSubjs() throws DaoException{	
	Subject newSubj=null;
	ResultSet rs = null;
	try {
	    newSubj = new Subject();
	    getAllSubjectsPs();
	    List <Subject> listSubj = new LinkedList<Subject>();	    
	    rs=allSubjectsPs.executeQuery();
	    while (rs.next()){
		newSubj.setId(rs.getInt("id"));
		newSubj.setNames(rs.getString("names"));
		newSubj.setHours(rs.getInt("hours"));
		listSubj.add(newSubj);	        
	    }	   
	    return listSubj;		    	  			   
	} catch (Exception e) {
	    throw new DaoException("ошибка метода выборки всех предметов",e);	    
	}
    }

    public void close() throws DaoException {    	 
        if (addPs!=null) {	    
	    try {
        	addPs.close();				   
            } catch (Exception e) {
		throw new DaoException("ошибка при закрытии запроса добавлени€ предмета",e);
            }	        
	}
	if (updatePs!=null) {	    
	    try {
        	updatePs.close();				   
            } catch (Exception e) {
		throw new DaoException("ошибка при закрытии запроса обновлени€ предмета",e);
            }	        
	}
	if (deletePs!=null) {	    
	    try {
            	deletePs.close();				   
            } catch (Exception e) {
		throw new DaoException("ошибка при закрытии запроса удалени€ предмета",e);
            }	        
	}
	if (allSubjectsPs!=null) {	    
	    try {
            	allSubjectsPs.close();				   
            } catch (Exception e) {
		throw new DaoException("ошибка при закрытии запроса выборки всех предметов",e);
            }	        
	}
	if (con!=null) {	    
	    try {		
	        con.close();
	    } catch (Exception e) {
		throw new DaoException("ошибка при закрытии соединени€",e);
            }
	}	
    }

    public static void main(String[] args){
	SubjectDao subjDB = null;
	try{
	    subjDB = new SubjectDao();	    	    
	    Subject b1 = new Subject();
/*
	    b1.setId(18);
	    b1.setNames("Philosiphy");
	    b1.setHours(31);
	    subjDB.addSubject(b1);
		
	    b1.setId(10);
	    b1.setNames("MATHS");
	    b1.setHours(76);
	    subjDB.updateSubject(b1);

	    b1.setId(1);
	    subjDB.deleteSubject(b1);
*/
	    subjDB.getAllSubjs();

	    subjDB.getSubjs(2);
	} catch (Exception e) {
	    System.out.println("ошибка метода main");
        } finally{		
	    if (subjDB!=null){
		try {		
	            subjDB.close();
	    	} catch (Exception e) {
		    System.out.println("ошибка метода close");
		}
            }
	}                	 
    }
}







