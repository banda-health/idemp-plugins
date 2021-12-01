package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.MenuGroupLineItem;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.MenuGroupDBService;

/**
 * Expose Menu group line items functionality
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.MENU_LINES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuLineRestService extends BaseEntityRestService<MenuGroupLineItem> {

	private MenuGroupDBService dbService;

	public MenuLineRestService() {
		dbService = new MenuGroupDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<MenuGroupLineItem> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson, @QueryParam("sorted") String sortJson) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@Override
	public MenuGroupLineItem getEntity(String uuid) {
		return null;
	}

	@Override
	public MenuGroupLineItem saveEntity(MenuGroupLineItem entity) {
		return null;
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<MenuGroupLineItem> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return null;
	}
	
	@Override
	protected Paging getPagingInfo(int page, int size) {
		Paging paging = new Paging(page, size);
		if (!Paging.isValid(paging)) {
			paging = Paging.ALL.getInstance();
		}

		return paging;
	}
}
