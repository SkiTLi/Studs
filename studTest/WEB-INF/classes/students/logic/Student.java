//Объектное представление сущности Судент.

package students.logic;
import students.logic.*;
import java.util.Date;

public class Student  {
    private Integer id = null;
    private String name;
    private Date birthday = new Date(); //присваиваем текущую дату по умолчанию   

    public Integer getId() {
        return id;
    }

    public void setId(int id) { //а был protected
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    public Date getBirthday() {	
        return birthday;	
    }
    
    public void setBirthday(Date birthday) {	
        this.birthday = birthday;	
    }
}