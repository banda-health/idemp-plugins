package org.bandahealth.idempiere.rest.exceptions;

import org.adempiere.exceptions.AdempiereException;



/**
 * @author kellym
 * Catch user error: Entry of existing record.
 *
 */
public class DuplicateEntitySaveException extends AdempiereException {

	private static final long serialVersionUID = 1L;


	public DuplicateEntitySaveException(String message) {
		super(message);
	}
}
