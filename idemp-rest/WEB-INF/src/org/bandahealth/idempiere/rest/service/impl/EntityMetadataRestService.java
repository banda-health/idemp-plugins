package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.EntityMetadata;
import org.bandahealth.idempiere.rest.service.db.EntityMetadataDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.METADATA_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntityMetadataRestService {

	@Autowired
	private EntityMetadataDBService dbService;

	@GET
	public EntityMetadata getAll() {
		return dbService.getAll();
	}
}
