package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.StorageOnHand;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.StorageOnHandDBService;
import org.compiere.model.MStorageOnHand;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.STORAGE_ON_HAND_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StorageOnHandRestService extends BaseRestService<StorageOnHand, MStorageOnHand, StorageOnHandDBService>{

	@Autowired
	private StorageOnHandDBService storageOnHandDBService;
	
	@Override
	protected StorageOnHandDBService getDBService() {
		return storageOnHandDBService;
	}

}
