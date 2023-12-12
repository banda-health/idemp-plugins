package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Encounter;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.EncounterDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.ENCOUNTER_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EncounterRestService extends BaseRestService<Encounter, MBHEncounter, EncounterDBService> {
	@Autowired
	private EncounterDBService dbService;

	@Override
	protected EncounterDBService getDBService() {
		return dbService;
	}
}
