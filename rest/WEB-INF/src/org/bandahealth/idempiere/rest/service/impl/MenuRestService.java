package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Menu;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.MenuDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Expose Greenlight Menu functionality
 */
@Path(IRestConfigs.MENUS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuRestService extends BaseRestService<Menu, MMenu_BH, MenuDBService> {

	@Autowired
	private MenuDBService dbService;

	@Override
	protected MenuDBService getDBService() {
		return dbService;
	}

	@GET
	@Path("/root/{rootId}")
	public BaseListResponse<Menu> getByRootId(@PathParam("rootId") String rootId,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page, @QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return dbService.getAll(rootId, getPagingInfo(page, size), sortJson, filterJson);
	}
}
