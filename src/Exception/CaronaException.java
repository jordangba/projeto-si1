package Exception;

import java.io.Serializable;

public class CaronaException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CaronaException(String stringErro) {
		super(stringErro);
	}

}
