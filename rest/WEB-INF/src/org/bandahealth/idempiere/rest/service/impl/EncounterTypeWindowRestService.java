package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.EncounterTypeWindow;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.EncounterTypeWindowDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.ENCOUNTER_TYPE_WINDOWS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EncounterTypeWindowRestService extends
		BaseRestService<EncounterTypeWindow, MBHEncounterTypeWindow, EncounterTypeWindowDBService> {
	@Autowired
	private EncounterTypeWindowDBService dbService;

	@Override
	protected EncounterTypeWindowDBService getDBService() {
		return dbService;
	}

	@DELETE
	@Path("/{uuid}")
	@Override
	public Boolean deleteEntity(@PathParam("uuid") String uuid) {
		throw new NotImplementedException();
	}
}
