package org.bandahealth.idempiere.rest.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.model.User;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.UserDBService;

@Path(IRestConfigs.USERS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService extends BaseEntityRestService<User> {

	private UserDBService dbService;

	public UserRestService() {
		dbService = new UserDBService();
	}

	@GET
	@Path(IRestConfigs.CLINICIANS_PATH)
	public BaseListResponse<User> getClinicians(@QueryParam("page") int page, @QueryParam("size") int size) {
		return dbService.getCliniciansResponse(getPagingInfo(page, size));
	}

	@GET
	@Path(IRestConfigs.ROOT_PATH)
	public BaseListResponse<User> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson) {
		return dbService.getNonAdmins(getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}
	
	@Override
	public BaseListResponse<User> search(String value, int page, int size, String sortColumn, String sortOrder) {
		return null;
	}

	@Override
	public User getEntity(String uuid) {
		return null;
	}

	@Override
	public User saveEntity(User entity) {
		return null;
	}
}
