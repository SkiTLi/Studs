//Объектное представление сущности Судент.

package students.logic;
import students.logic.*;
import java.util.Date;
import java.text.SimpleDateFormat;

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

	@Override
	public int hashCode() {
		final int prime = 31;//не знаю почему именно 31
		int result = 1;
		result = prime * result + getId();
		result = prime * result + getName().length()+getName().hashCode();
        //System.out.println ("hashCode() of the *name*: "+getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){ //исходный метод
			return true;
		}
		if (obj == null) {
            return false;
        }
		if (getClass() != obj.getClass()) {
            return false;
        }
		Student other = (Student) obj;
		if (getId() != other.getId()) {
            return false;
        }
		if (getName() != other.getName()) {
            return false;
        }
        /*
        //не работает т.к. нужно применять методы equals или compareTo
        if (getBirthday() != other.getBirthday()) {
            return false;
        }
        */
        if (!getBirthday().equals(other.getBirthday())) {
            //System.out.println (getBirthday()+" <=> "+other.getBirthday());
            return false;
        }
		return true;
	}

    @Override
    public String toString()
    {
        return getId()+", "+getName()+", "+getSimpleBirthday()+".";
    }

    private String getSimpleBirthday()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        return ft.format(getBirthday());
    }
}