package org.bandahealth.idempiere.rest.service.impl;


import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.InventoryTransaction;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.service.db.InventoryTransactionDBService;
import org.compiere.util.CLogger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/inventory-transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryTransactionRestService {
	final CLogger log = CLogger.getCLogger(InventoryTransactionRestService.class);
	@Autowired
	private InventoryTransactionDBService inventoryTransactionDBService;

	/**
	 * The base method to fetch all data in a paged format matching a specific filter and sort criteria
	 *
	 * @param page       The page to be fetched
	 * @param size       How many records can be on the page
	 * @param sortJson   Any sorting criteria, modeled after the form described in
	 *                   {@link org.bandahealth.idempiere.rest.utils.SortUtil}
	 * @param filterJson Any filter criteria, modeled after the form described in
	 *                   {@link org.bandahealth.idempiere.rest.utils.FilterUtil}
	 * @return A list of data matching the input information
	 */
	@GET
	public BaseListResponse<InventoryTransaction> get(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sorting") String sortJson, @QueryParam("filter") String filterJson) {
		Paging paging = new Paging(page, size);
		if (!Paging.isValid(paging)) {
			paging = Paging.DEFAULT.getInstance();
		}
		return inventoryTransactionDBService.getAll(paging, sortJson, filterJson);
	}
}
