package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Concept;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ConceptDBService;

@Path(IRestConfigs.CONCEPTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConceptRestService extends BaseRestService<Concept, MBHConcept, ConceptDBService> {

	private final ConceptDBService dbService = new ConceptDBService();

	@Override
	protected ConceptDBService getDBService() {
		return dbService;
	}
}
