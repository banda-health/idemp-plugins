package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.User;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.UserDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.USERS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService extends BaseRestService<User, MUser_BH, UserDBService> {

	@Autowired
	private UserDBService dbService;

	@GET
	@Path(IRestConfigs.CLINICIANS_PATH)
	public BaseListResponse<User> getClinicians(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size) {
		return dbService.getCliniciansResponse(getPagingInfo(page, size));
	}

	@GET
	@Path(IRestConfigs.NON_ADMINS_PATH)
	public BaseListResponse<User> getNonAdmins(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sorting") String sortJson, @QueryParam("filter") String filterJson) {
		return dbService.getNonAdmins(getPagingInfo(page, size), sortJson, filterJson);
	}

	@Override
	protected UserDBService getDBService() {
		return dbService;
	}
}
