package org.bandahealth.idempiere.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.adempiere.exceptions.AdempiereException;

/**
 * Have a nice way to return exceptions
 *
 * @author andrew
 *
 */
@Provider
public class AdempiereExceptionMapper implements ExceptionMapper<AdempiereException> {

	@Override
	public Response toResponse(AdempiereException exception) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.header("Exception", exception.getMessage()).build();
	}

}
