package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.WarehouseDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.WAREHOUSES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WarehouseRestService extends BaseRestService<Warehouse, MWarehouse_BH, WarehouseDBService> {
	@Autowired
	private WarehouseDBService dbService;

	@Override
	protected WarehouseDBService getDBService() {
		return dbService;
	}
}
