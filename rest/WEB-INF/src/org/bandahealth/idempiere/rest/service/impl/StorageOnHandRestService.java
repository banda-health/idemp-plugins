package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.StorageOnHand;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ProductDBService;
import org.bandahealth.idempiere.rest.service.db.StorageOnHandDBService;
import org.compiere.model.MStorageOnHand;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.STORAGE_ON_HAND_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StorageOnHandRestService extends BaseRestService<StorageOnHand, MStorageOnHand, StorageOnHandDBService> {

	private final ProductDBService productDBService = new ProductDBService();

	@Override
	protected StorageOnHandDBService getDBService() {
		return productDBService.getStorageOnHandDBService();
	}

}
