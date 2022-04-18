package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Menu;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.MenuDBService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Expose Greenlight Menu functionality
 */
@Path(IRestConfigs.MENUS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuRestService extends BaseEntityRestService<Menu> {

	@Autowired
	private MenuDBService dbService;

	@GET
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Menu> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortJson, filterJson);
	}

	@Override
	protected Paging getPagingInfo(int page, int size) {
		Paging paging = new Paging(page, size);
		if (!Paging.isValid(paging)) {
			paging = Paging.ALL.getInstance();
		}

		return paging;
	}

	@GET
	@Path("/root/{rootId}")
	public BaseListResponse<Menu> getByRootId(@PathParam("rootId") String rootId,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page, @QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return dbService.getAll(rootId, getPagingInfo(page, size), sortJson, filterJson);
	}

	@Override
	public Menu getEntity(String uuid) {
		return null;
	}

	@Override
	public Menu saveEntity(Menu entity) {
		return null;
	}

	@Override
	public BaseListResponse<Menu> search(String value, int page, int size, String sortColumn, String sortOrder) {
		return null;
	}
}
