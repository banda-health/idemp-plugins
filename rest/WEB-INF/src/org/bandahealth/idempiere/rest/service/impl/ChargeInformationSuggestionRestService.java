package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.ChargeInformationSuggestion;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.ChargeInformationSuggestionDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(IRestConfigs.CHARGE_INFORMATION_SUGGESTION_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChargeInformationSuggestionRestService extends BaseEntityRestService<ChargeInformationSuggestion> {
	@Autowired
	private ChargeInformationSuggestionDBService chargeInformationSuggestionDBService;

	@GET
	public List<ChargeInformationSuggestion> get() {
		return chargeInformationSuggestionDBService.get();
	}

	@Override
	@GET
	@Path("all")
	public BaseListResponse<ChargeInformationSuggestion> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	@GET
	@Path(IRestConfigs.SEARCH_PATH)
	public BaseListResponse<ChargeInformationSuggestion> search(String value, int page, int size, String sortColumn,
			String sortOrder) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	@GET
	@Path(IRestConfigs.UUID_PATH)
	public ChargeInformationSuggestion getEntity(@PathParam("uuid") String uuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	@POST
	public ChargeInformationSuggestion saveEntity(ChargeInformationSuggestion entity) {
		throw new UnsupportedOperationException("Not implemented");
	}
}
