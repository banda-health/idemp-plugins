package org.bandahealth.idempiere.rest.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.annotation.AdministratorOnly;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.BaseDBService;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.PO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/dashboards")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DashboardRestService extends BaseRestService<BaseMetadata, PO, BaseDBService<BaseMetadata, PO>> {

	@Override
	protected BaseDBService<BaseMetadata, PO> getDBService() {
		return null;
	}

	@POST
	@Path("/data/{clientUuid}")
	@AdministratorOnly
	public Object getData(@PathParam("clientUuid") String clientUuid, String sqlQuery) throws JsonProcessingException {
		if (StringUtil.isNullOrEmpty(clientUuid) || StringUtil.isNullOrEmpty(sqlQuery) ||
				!sqlQuery.contains("$P{AD_CLIENT_ID}")) {
			return null;
		}
		return SqlUtil.executeDashboardQueryForClient(sqlQuery, clientUuid);
	}
}
