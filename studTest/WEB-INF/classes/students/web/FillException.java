//класс исключений

package students.web;
import students.logic.*;

public class FillException extends Exception{   
    public FillException(){
	System.out.println("при выполнении программы произошла ошибка 22!");
	//printStackTrace();
    }

    public FillException(String message){	
	super(message);
	System.out.println("при выполнении программы произошла ошибка 33!"+message);
	//printStackTrace();
    }

    public FillException(String message, Throwable cause) {
        super(message, cause);
	System.out.println("при выполнении программы произошла ошибка 44!"+message);
	//printStackTrace();
    }

    public FillException(Throwable cause) {
        super(cause);
	System.out.println("при выполнении программы произошла ошибка 55!");
	//printStackTrace();
    }

    public FillException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
	System.out.println("при выполнении программы произошла ошибка 6!"+message);
	//printStackTrace();
    }
}







