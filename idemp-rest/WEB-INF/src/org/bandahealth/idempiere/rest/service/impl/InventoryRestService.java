package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.InventoryDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.STOCK_TAKE_ITEMS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryRestService extends BaseEntityRestService<Inventory> {
	@Autowired
	private InventoryDBService inventoryDBService;

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Inventory> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sorting") String sortJson, @QueryParam("filter") String filterJson) {
		return inventoryDBService.getInventory(getPagingInfo(page, size), sortJson, filterJson);
	}

	@POST
	@Path(IRestConfigs.PATIENT_PATH)
	@Override
	public Inventory getEntity(@PathParam("uuid") String uuid) {
		return inventoryDBService.getEntity(uuid);
	}


	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public Inventory saveEntity(Inventory entity) {
		inventoryDBService.updateStockItem(entity);
		return entity;
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Inventory> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return inventoryDBService.searchInventory(getPagingInfo(page, size), value, sortColumn, sortOrder, null);
	}
}
