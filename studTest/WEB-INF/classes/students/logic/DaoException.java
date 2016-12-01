//класс исключений

package students.logic;
import students.logic.*;

public class DaoException extends Exception{   
    public DaoException(){
	System.out.println("при выполнении программы произошла ошибка 2!");
	//printStackTrace();
    }

    public DaoException(String message){	
	super(message);
	System.out.println("при выполнении программы произошла ошибка 3!"+message);
	//printStackTrace();
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
	System.out.println("при выполнении программы произошла ошибка 4!"+message);
	//printStackTrace();
    }

    public DaoException(Throwable cause) {
        super(cause);
	System.out.println("при выполнении программы произошла ошибка 5!");
	//printStackTrace();
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
	System.out.println("при выполнении программы произошла ошибка 6!"+message);
	//printStackTrace();
    }
}







