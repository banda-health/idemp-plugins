package org.bandahealth.idempiere.rest.filter;

import org.bandahealth.idempiere.rest.annotation.AdministratorOnly;
import org.compiere.model.MUser;
import org.compiere.util.Env;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * If a method is marked as {@link org.bandahealth.idempiere.rest.annotation.AdministratorOnly}, then make sure that's
 * what the user is
 */
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AdministratorFilter implements ContainerRequestFilter {

	@Context
	ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// If either the method or the class are only meant for admins, make sure the user is one before proceeding
		if (resourceInfo.getResourceClass().isAnnotationPresent(AdministratorOnly.class) ||
				resourceInfo.getResourceMethod().isAnnotationPresent(AdministratorOnly.class)) {
			if (!MUser.get(Env.getCtx()).isAdministrator()) {
				requestContext.abortWith(Response.status(Response.Status.NOT_FOUND).build());
			}
		}
	}
}
