package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
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
		return dbService.getClinicians(getPagingInfo(page, size));
	}

	@Override
	public BaseListResponse<User> getAll(int page, int size, String sortColumn, String sortOrder, String filterJson) {
		return null;
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
