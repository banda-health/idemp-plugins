package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.ChargeInfoSuggestion;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.ChargeInfoSuggestionDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(IRestConfigs.CHARGE_INFO_SUGGESTION_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChargeInfoSuggestionRestService extends BaseEntityRestService<ChargeInfoSuggestion> {
	private final ChargeInfoSuggestionDBService chargeInfoSuggestionDBService;

	public ChargeInfoSuggestionRestService() {
		chargeInfoSuggestionDBService = new ChargeInfoSuggestionDBService();
	}

	@GET
	public List<ChargeInfoSuggestion> get() {
		return chargeInfoSuggestionDBService.get();
	}

	@Override
	@GET
	@Path("all")
	public BaseListResponse<ChargeInfoSuggestion> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	@GET
	@Path(IRestConfigs.SEARCH_PATH)
	public BaseListResponse<ChargeInfoSuggestion> search(String value, int page, int size, String sortColumn, String sortOrder) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	@GET
	@Path(IRestConfigs.UUID_PATH)
	public ChargeInfoSuggestion getEntity(@PathParam("uuid") String uuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	@POST
	public ChargeInfoSuggestion saveEntity(ChargeInfoSuggestion entity) {
		throw new UnsupportedOperationException("Not implemented");
	}
}
