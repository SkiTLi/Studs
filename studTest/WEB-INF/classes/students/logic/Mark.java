//Объектное представление сущности Оценка.

package students.logic;
import students.logic.*;

public class Mark {
    private Integer id = null;
    private int rmark;
    private int studentID;
    private int subjectID;		
   

    public Integer getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getRmark() {
        return rmark;
    }

    public void setRmark(int rmark) {
        this.rmark = rmark;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

}