//����� ����������

package students.logic;
import students.logic.*;

public class DaoException extends Exception{   
    public DaoException(){
	System.out.println("��� ���������� ��������� ��������� ������ 2!");
	//printStackTrace();
    }

    public DaoException(String message){	
	super(message);
	System.out.println("��� ���������� ��������� ��������� ������ 3!"+message);
	//printStackTrace();
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
	System.out.println("��� ���������� ��������� ��������� ������ 4!"+message);
	//printStackTrace();
    }

    public DaoException(Throwable cause) {
        super(cause);
	System.out.println("��� ���������� ��������� ��������� ������ 5!");
	//printStackTrace();
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
	System.out.println("��� ���������� ��������� ��������� ������ 6!"+message);
	//printStackTrace();
    }
}







