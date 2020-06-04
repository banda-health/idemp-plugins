package org.bandahealth.idempiere.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;


/**
 * @author icarus
 *
 */
@Provider
public class ProductSaveExceptionMapper implements ExceptionMapper<ProductSaveException> {

	public ProductSaveExceptionMapper() {
	}

	@Override
	public Response toResponse(ProductSaveException exception) {
		ResponseBuilderImpl builder = new ResponseBuilderImpl();
		builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		builder.entity(exception.getMessage());
		builder.header("Exception", exception.getMessage());
		builder.header("Content-Type", "application/json");
		Response response = builder.build();
		return response;
	}

}
