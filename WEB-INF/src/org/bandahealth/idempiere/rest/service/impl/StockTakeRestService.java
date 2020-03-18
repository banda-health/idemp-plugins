package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.StockTakeItem;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.StockTakeDBService;

@Path(IRestConfigs.STOCK_TAKE_ITEMS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StockTakeRestService extends BaseEntityRestService<StockTakeItem>{
	
	private StockTakeDBService stockTakeDbService;

	public  StockTakeRestService() {
		stockTakeDbService = new StockTakeDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<StockTakeItem> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return stockTakeDbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@Override
	public StockTakeItem getEntity(String uuid) {
		return null;
	}

	@Override
	public StockTakeItem saveEntity(StockTakeItem entity) {
		return null;
	}

}
