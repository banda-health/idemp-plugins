package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Movement;
import org.bandahealth.idempiere.rest.service.DocumentRestService;
import org.bandahealth.idempiere.rest.service.db.MovementDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.MOVEMENTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovementRestService extends DocumentRestService<Movement, MMovement_BH, MovementDBService> {

	@Autowired
	private MovementDBService dbService;

	@Override
	protected MovementDBService getDBService() {
		return dbService;
	}
}
