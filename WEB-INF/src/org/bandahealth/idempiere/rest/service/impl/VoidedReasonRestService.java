package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.VoidedReason;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.VoidedReasonDBService;

@Path(IRestConfigs.VOIDED_REASONS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VoidedReasonRestService extends BaseEntityRestService<VoidedReason> {

	private VoidedReasonDBService dbService;

	public VoidedReasonRestService() {
		this.dbService = new VoidedReasonDBService();
	}

	@GET
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<VoidedReason> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson) {
		return dbService.getAll(null, null, getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@Override
	public BaseListResponse<VoidedReason> search(String value, int page, int size, String sortColumn,
			String sortOrder) {
		return null;
	}

	@Override
	public VoidedReason getEntity(String uuid) {
		return null;
	}

	@Override
	public VoidedReason saveEntity(VoidedReason entity) {
		return null;
	}

}
