package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Account;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.AccountDBService;
import org.compiere.model.MElementValue;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Expose Account REST functionality
 *
 * @author kevin
 */
@Path(IRestConfigs.ACCOUNTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountRestService extends BaseRestService<Account, MElementValue, AccountDBService> {
	@Autowired
	private AccountDBService dbService;

	protected AccountDBService getDBService() {
		return dbService;
	}
}
