package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Storeroom;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.StoreroomDBService;

@Path(IRestConfigs.WAREHOUSES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StoreroomRestService extends BaseEntityRestService<Storeroom> {
	
	private StoreroomDBService dbService;
	
	public StoreroomRestService() {
		this.dbService = new StoreroomDBService();
	}

	@GET
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Storeroom> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson) {
		return dbService.getAll(null, null, getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@Override
	public BaseListResponse<Storeroom> search(String value, int page, int size, String sortColumn, String sortOrder) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@GET
	@Path(IRestConfigs.UUID_PATH)
	@Override
	public Storeroom getEntity(String uuid) {
		return dbService.getEntity(uuid);
	}

	@Override
	public Storeroom saveEntity(Storeroom entity) {
		throw new UnsupportedOperationException("Not implemented");
	}
}
