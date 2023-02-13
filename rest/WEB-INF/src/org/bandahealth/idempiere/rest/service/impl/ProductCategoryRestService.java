package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ProductCategory;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ProductCategoryDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Expose Product Category REST functionality
 */
@Path(IRestConfigs.PRODUCT_CATEGORIES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductCategoryRestService
		extends BaseRestService<ProductCategory, MProductCategory_BH, ProductCategoryDBService> {

	@Autowired
	private ProductCategoryDBService dbService;

	@Override
	protected ProductCategoryDBService getDBService() {
		return dbService;
	}
}
