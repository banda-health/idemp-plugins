package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.service.DocumentRestService;
import org.bandahealth.idempiere.rest.service.db.InventoryDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static org.bandahealth.idempiere.rest.IRestConfigs.AUTHENTICATION_PATH;

@Path(AUTHENTICATION_PATH + "/inventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryRestService extends DocumentRestService<Inventory, MInventory_BH, InventoryDBService> {
	@Autowired
	private InventoryDBService dbService;

	@Override
	protected InventoryDBService getDBService() {
		return dbService;
	}
}
