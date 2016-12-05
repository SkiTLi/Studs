//Объектное представление сущности Предмет.

package students.logic;
import students.logic.*;

public class Subject {
    private Integer id = null;
    private String names;
    private int hours;   

    public Integer getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}