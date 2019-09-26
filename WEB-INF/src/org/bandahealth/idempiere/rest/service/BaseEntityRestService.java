package org.bandahealth.idempiere.rest.service;

import javax.ws.rs.core.Context;

import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.compiere.util.CLogger;
import org.apache.cxf.jaxrs.ext.MessageContext;

public abstract class BaseEntityRestService<T extends BaseMetadata> implements IEntityRestService<T> {

	@Context
	private MessageContext context; // rest context

	protected static CLogger log = CLogger.getCLogger(BaseEntityRestService.class);

	public BaseEntityRestService() {
	}

	protected MessageContext getContext() {
		return context;
	}

}
