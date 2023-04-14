package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.User;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.UserDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.USERS_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService extends BaseEntityRestService<User> {

	@Autowired
	private UserDBService dbService;

	@GET
	@Path(IRestConfigs.CLINICIANS_PATH)
	public BaseListResponse<User> getClinicians(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size) {
		return dbService.getCliniciansResponse(getPagingInfo(page, size));
	}

	@GET
	@Override
	public BaseListResponse<User> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return dbService.getAll(null, null, getPagingInfo(page, size), sortJson, filterJson);
	}

	@GET
	@Path(IRestConfigs.NON_ADMINS_PATH)
	public BaseListResponse<User> getNonAdmins(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson) {
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

	@POST
	@Override
	public User saveEntity(User entity) {
		return dbService.saveEntity(entity);
	}
}
