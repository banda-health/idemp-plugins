package org.bandahealth.idempiere.rest.exceptions;

import org.adempiere.exceptions.AdempiereException;



/**
 * @author icarus
 *
 */
public class ProductSaveException extends AdempiereException {

	private static final long serialVersionUID = 1L;


	public ProductSaveException(String message) {
		super(message);
	}

}
