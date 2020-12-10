package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.compiere.model.Query;
import org.compiere.util.Env;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(IRestConfigs.ORDERS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderRestService {

	@GET
	public List<MOrder_BH> get(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson) {
		return new Query(Env.getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_IsSOTrx + "=?",
				null).setParameters("Y").setClient_ID().setPage(10, 0).list();
	}
}
