package org.bandahealth.idempiere.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DocumentProcessExceptionMapper implements ExceptionMapper<DocumentProcessException> {

	@Override
	public Response toResponse(DocumentProcessException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getLocalizedMessage()).build();
	}
}
