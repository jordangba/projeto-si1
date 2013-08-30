package Exception;

import java.io.Serializable;

public class UsuarioException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioException(String stringErro) {
		super(stringErro);
	}
	
}
