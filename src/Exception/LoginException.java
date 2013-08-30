package Exception;

import java.io.Serializable;

public class LoginException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginException(String stringErro){
		super(stringErro);
	}

}
