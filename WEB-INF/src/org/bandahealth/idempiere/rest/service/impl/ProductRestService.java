package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.SearchProduct;
import org.bandahealth.idempiere.rest.repository.ProductRepository;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.ProductDBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path(IRestConfigs.PRODUCTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductRestService extends BaseEntityRestService<Product> {

	private ProductDBService dbService;
	private final ProductRepository productRepository;

	public ProductRestService() {
		dbService = new ProductDBService();
		productRepository = new ProductRepository();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	public BaseListResponse<Product> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@POST
	@Path(IRestConfigs.PRODUCT_PATH)
	@Override
	public Product getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public Product saveEntity(Product entity) {
		return dbService.saveEntity(entity) ;
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Product> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@POST
	@Path(IRestConfigs.SEARCH_ITEMS_PATH)
	public BaseListResponse<SearchProduct> searchItems(@QueryParam("value") String query) {
		return dbService.searchItems(query);
	}

	@GET
	public List<MProduct_BH> get(@QueryParam("ids") Set<Integer> ids) {
		return new ArrayList<>(productRepository.getByIds(ids).values());
	}

	@GET
	@Path("/items")
	public List<MProduct_BH> getItems(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return productRepository.getItems(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/items/paginginfo")
	public Paging getItemsPagingInfo(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return productRepository.getItemsPagingInfo(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/services")
	public List<MProduct_BH> getServices(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return productRepository.getServices(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/services/paginginfo")
	public Paging getServicesPagingInfo(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return productRepository.getServicesPagingInfo(filterJson, sort, new Paging(page, size));
	}
}
