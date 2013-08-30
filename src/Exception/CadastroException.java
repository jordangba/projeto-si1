package Exception;

import java.io.Serializable;

public class CadastroException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CadastroException(String stringErro) {
		super(stringErro);
	}
	
}
