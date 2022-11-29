package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ProductCategory;
import org.bandahealth.idempiere.rest.service.db.ProductCategoryDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Expose Product Category REST functionality
 */
@Path(IRestConfigs.PRODUCT_CATEGORIES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductCategoryRestService {

	@Autowired
	private ProductCategoryDBService dbService;

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	public List<ProductCategory> get() {
		return dbService.get();
	}
}
