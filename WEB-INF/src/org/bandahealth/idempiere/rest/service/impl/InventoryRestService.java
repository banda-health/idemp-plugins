package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.InventoryDBService;

@Path(IRestConfigs.STOCK_TAKE_ITEMS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryRestService extends BaseEntityRestService<Inventory>{
	
	private InventoryDBService inventoryDBService;

	public  InventoryRestService() {
		inventoryDBService = new InventoryDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Inventory> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return inventoryDBService.getInventory(getPagingInfo(page, size));
	}

	@Override
	public Inventory getEntity(String uuid) {
		return null;
	}

	@Override
	public Inventory saveEntity(Inventory entity) {
		return null;
	}

}
