//класс в котором наход€тс€ методы добавлени€, изменени€, удалени€ строк из таблицы mark с помощью PreparedStatement
//cd /d D:\AndyKotins\Dropbox\Pharma\I_Java_etc\SkiTLi_Java_Projects
//javac -cp "." Lesson10/MarkDao.java
//java -cp .;Lesson10/test/mysql-connector-java-5.1.39-bin.jar Lesson10.MarkDao

package students.logic;
import students.logic.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.io.FileInputStream;	

public class MarkDao{
    private Connection con = null;
    private PreparedStatement addPs = null;
    private PreparedStatement updatePs = null;
    private PreparedStatement deletePs = null;
    private static final String addStr="insert into mark (id, rmark, studentID, subjectID) values (?, ?, ?, ?)";
    private static final String updateStr = "UPDATE mark SET rmark = ?, studentID = ?, subjectID = ? WHERE id = ?";
    private static final String deleteStr = "DELETE FROM mark WHERE id = ?";		    

    public MarkDao() throws DaoException {
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
	    throw new DaoException("ошибка создани€ запроса добавлени€ оценки",e);	    
	}
    }

    private PreparedStatement getUpdatePs() throws DaoException{
	try {
	    if (updatePs == null) {
		updatePs = con.prepareStatement(updateStr);
	    }
	    return updatePs;
	} catch (Exception e) {
	    throw new DaoException("ошибка создани€ запроса обнавлени€ оценки",e);	    
	}
    }

    private PreparedStatement getDeletePs() throws DaoException{
	try {
	    if (deletePs == null) {
		deletePs = con.prepareStatement(deleteStr);
	    }
	    return deletePs;
	} catch (Exception e) {
	    throw new DaoException("ошибка создани€ запроса удалени€ оценки",e);	    
	}
    }

    //метод добавл€ющий новый предмет в таблицу Mark
    public void addMark(Mark newMark) throws DaoException {			
	try {
	    getAddPs();	      
	    addPs.setInt(1, newMark.getId());
	    addPs.setInt(2, newMark.getRmark());
	    addPs.setInt(3, newMark.getStudentID());
	    addPs.setInt(4, newMark.getSubjectID());		
	    addPs.executeUpdate();	   	    
	} catch (Exception e) {
	    throw new DaoException("ошибка метода добавлени€ оценки",e);	    
	} 
    }

    //метод измен€ющий пол€ предмета в таблице Mark
    public void updateMark(Mark newMark) throws DaoException {		
	try {
	    getUpdatePs();	    
	    updatePs.setInt(1, newMark.getRmark());
	    updatePs.setInt(2, newMark.getStudentID());
	    updatePs.setInt(3, newMark.getSubjectID());
	    updatePs.setInt(4, newMark.getId());		
	    updatePs.executeUpdate();	    	        
	} catch (Exception e) {
	    throw new DaoException("ошибка метода обновлени€ оценки",e);	    
	}	    
    }

    //метод удал€ющий предмет из таблицы Mark
    public void deleteMark(Mark newMark) throws DaoException{		    
	try {
	    getDeletePs();	           	
	    deletePs.setInt(1, newMark.getId());
	    deletePs.executeUpdate();	    	   			   
	} catch (Exception e) {
	    throw new DaoException("ошибка метода удалени€ оценки",e);	    
	}
    }    

    public void close() throws DaoException {    	 
        if (addPs!=null) {	    
	    try {
        	addPs.close();			   
            } catch (Exception e) {
		throw new DaoException("ошибка при закрытии запроса добавлени€ оценки",e);
            }	        
	}
	if (updatePs!=null) {	    
	    try {
        	updatePs.close();			   
            } catch (Exception e) {
		throw new DaoException("ошибка при закрытии запроса обнавлени€ оценки",e);
            }	        
	}
	if (deletePs!=null) {	    
	    try {
            	deletePs.close();			   
            } catch (Exception e) {
		throw new DaoException("ошибка при закрытии запроса удалени€ оценки",e);
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
	MarkDao markDB = null;
	try{	
		markDB = new MarkDao();    	    
		Mark m1 = new Mark();
/*				
		m1.setId(9);
		m1.setRmark(9);
		m1.setStudentID(3);
		m1.setSubjectID(4);
		markDB.addMark(m1);
		
		m1.setId(10);
		m1.setRmark(7);		
		m1.setStudentID(2);
		m1.setSubjectID(2);
		markDB.updateMark(m1);
		
		m1.setId(11);
		markDB.deleteMark(m1);
*/				
	}catch (Exception e) {
	    System.out.println("ошибка метода main");
	} finally{		
	    if (markDB!=null){
		try {		
	            markDB.close();
	    	} catch (Exception e) {
		    System.out.println("ошибка метода close");
		}
            }
	}        
    }
}







