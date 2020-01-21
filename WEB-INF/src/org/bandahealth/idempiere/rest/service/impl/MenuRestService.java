package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.MenuGroupItem;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.MenuGroupDBService;

/**
 * Expose Menu group and line items functionality
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.MENUS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuRestService extends BaseEntityRestService<MenuGroupItem> {

	private MenuGroupDBService dbService;

	public MenuRestService() {
		dbService = new MenuGroupDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<MenuGroupItem> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return dbService.getMenuGroupItems(getPagingInfo(page, size));
	}

	@POST
	@Path(IRestConfigs.MENU_PATH)
	@Override
	public MenuGroupItem getEntity(String uuid) {
		return dbService.getMenuGroupItem(uuid);
	}

	@Override
	public MenuGroupItem updateEntity(MenuGroupItem entity) {
		throw new RuntimeException("Not permitted");
	}

	@Override
	public MenuGroupItem createEntity(MenuGroupItem entity) {
		throw new RuntimeException("Not permitted");
	}

}
