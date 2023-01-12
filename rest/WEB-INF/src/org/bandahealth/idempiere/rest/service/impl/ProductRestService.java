package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ProductDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.PRODUCTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductRestService extends BaseRestService<Product, MProduct_BH, ProductDBService> {

	@Autowired
	private ProductDBService dbService;

	@GET
	@Path(IRestConfigs.SEARCH_ITEMS_PATH)
	public BaseListResponse<Product> searchItems(@QueryParam("value") String query) {
		return dbService.searchItems(query);
	}

	@Override
	protected ProductDBService getDBService() {
		return dbService;
	}
}
