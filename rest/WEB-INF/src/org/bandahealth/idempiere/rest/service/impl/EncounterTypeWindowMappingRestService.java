package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindowMapping;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.EncounterTypeWindowMapping;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.EncounterTypeWindowMappingDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.ENCOUNTER_TYPE_WINDOW_MAPPING_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EncounterTypeWindowMappingRestService extends
		BaseRestService<EncounterTypeWindowMapping, MBHEncounterTypeWindowMapping, EncounterTypeWindowMappingDBService> {
	@Autowired
	private EncounterTypeWindowMappingDBService dbService;

	@Override
	protected EncounterTypeWindowMappingDBService getDBService() {
		return dbService;
	}

	@DELETE
	@Path("/{uuid}")
	@Override
	public Boolean deleteEntity(@PathParam("uuid") String uuid) {
		throw new NotImplementedException();
	}
}
