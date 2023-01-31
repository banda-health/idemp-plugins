package org.bandahealth.idempiere.rest.exceptions;

import org.adempiere.exceptions.AdempiereException;

public class DocumentProcessException extends AdempiereException {
	public DocumentProcessException() {
		super();
	}

	public DocumentProcessException(String message) {
		super(message);
	}

	public DocumentProcessException(Throwable cause) {
		super(cause);
	}

	public DocumentProcessException(String message, Throwable cause) {
		super(message, cause);
	}
}
