package org.bandahealth.idempiere.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.service.IEntityRestService;
import org.compiere.util.CLogger;
import org.idempiere.adinterface.CompiereService;

public abstract class BaseRestService<T extends BaseMetadata> implements IEntityRestService<T> {

	private static final String COMPIERE_SERVICE = "CompiereService";
	@Context
	protected org.apache.cxf.jaxrs.ext.MessageContext jaxrsContext; // rest context

	protected static CLogger log = CLogger.getCLogger(BaseRestService.class);

	private CompiereService compiereService;

	public BaseRestService() {
		if (compiereService == null) {
			// compiereService = getCompiereService();
		}
	}

	/**
	 * 
	 * @return Compiere Service object for current request
	 */
	private CompiereService getCompiereService() {

		HttpServletRequest req = getHttpServletRequest();

		CompiereService m_cs = (CompiereService) req.getAttribute(COMPIERE_SERVICE);
		if (m_cs == null) {
			m_cs = new CompiereService();
			req.setAttribute(COMPIERE_SERVICE, m_cs);
		}
		return m_cs;
	}

	/**
	 * Get HttpServletRequest object
	 * 
	 * @return HttpServletRequest
	 */
	private HttpServletRequest getHttpServletRequest() {
		HttpServletRequest req = null;
		if (jaxrsContext != null) {
			req = (HttpServletRequest) jaxrsContext.getHttpServletRequest();
		}

		return req;
	}
}
