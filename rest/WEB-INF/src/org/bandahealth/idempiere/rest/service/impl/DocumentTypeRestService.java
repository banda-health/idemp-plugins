package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.DocumentType;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.DocumentTypeDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/document-types")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentTypeRestService extends BaseRestService<DocumentType, MDocType_BH, DocumentTypeDBService> {
	@Autowired
	private DocumentTypeDBService documentTypeDBService;

	@Override
	protected DocumentTypeDBService getDBService() {
		return documentTypeDBService;
	}
}
