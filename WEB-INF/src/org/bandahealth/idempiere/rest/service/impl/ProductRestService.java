package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.ProductDBService;

@Path(IRestConfigs.PRODUCTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductRestService extends BaseEntityRestService<Product> {

	private ProductDBService productService;

	public ProductRestService() {
		productService = new ProductDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Product> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return productService.getAll(getPagingInfo(page, size));
	}

	@POST
	@Path(IRestConfigs.PRODUCT_PATH)
	@Override
	public Product getEntity(@QueryParam("uuid") String uuid) {
		return productService.getEntity(uuid);
	}

	@Override
	public Product updateEntity(Product entity) {
		return null;
	}

	@Override
	public Product createEntity(Product entity) {
		return null;
	}

}
