package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Account;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.AccountDBService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Expose Account REST functionality
 * 
 * @author kevin
 *
 */
@Path(IRestConfigs.ACCOUNTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountRestService extends BaseEntityRestService<Account> {

	private AccountDBService dbService;

	public AccountRestService() {
		this.dbService = new AccountDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Account> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson, @QueryParam("sorted") String sortJson) {
		return dbService.getAll(null, null, getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@POST
	@Path(IRestConfigs.ACCOUNTS_UUID_PATH)
	@Override
	public Account getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public Account saveEntity(Account entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Account> search(@QueryParam("value") String value, @QueryParam("page") int page,
																									@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
																									@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}
}
