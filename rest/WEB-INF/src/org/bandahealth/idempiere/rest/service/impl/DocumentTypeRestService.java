package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.DocumentType;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.DocumentTypeDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/document-types")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentTypeRestService extends BaseRestService<DocumentType, MDocType_BH, DocumentTypeDBService> {
	private final DocumentTypeDBService documentTypeDBService = new DocumentTypeDBService();

	@Override
	protected DocumentTypeDBService getDBService() {
		return documentTypeDBService;
	}
}
