package org.bandahealth.idempiere.rest.service;

import javax.ws.rs.core.Context;

import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.model.Paging;
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

	protected Paging getPagingInfo(int page, int size) {
		Paging paging = new Paging(page, size);
		if (!Paging.isValid(paging)) {
			paging = Paging.DEFAULT.getInstance();
		}

		return paging;
	}
}
