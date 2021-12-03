package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.WarehouseDBService;

@Path(IRestConfigs.WAREHOUSES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WarehouseRestService extends BaseEntityRestService<Warehouse> {
	
	private WarehouseDBService dbService;
	
	public WarehouseRestService() {
		this.dbService = new WarehouseDBService();
	}

	@GET
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Warehouse> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson, @QueryParam("sorted") String sortJson) {
		return dbService.getAll(null, null, getPagingInfo(page, size), sortColumn, sortOrder, filterJson, sortJson);
	}

	@Override
	public BaseListResponse<Warehouse> search(String value, int page, int size, String sortColumn, String sortOrder) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@GET
	@Path(IRestConfigs.UUID_PATH)
	@Override
	public Warehouse getEntity(String uuid) {
		return dbService.getEntity(uuid);
	}

	@Override
	public Warehouse saveEntity(Warehouse entity) {
		throw new UnsupportedOperationException("Not implemented");
	}
}
