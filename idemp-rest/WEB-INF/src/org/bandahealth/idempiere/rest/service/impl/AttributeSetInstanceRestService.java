package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.AttributeSetInstanceDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.ATTRIBUTE_SET_INSTANCES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceRestService extends BaseEntityRestService<AttributeSetInstance> {
	@Autowired
	private AttributeSetInstanceDBService attributeSetInstanceDBService;

	@Override
	@GET
	public BaseListResponse<AttributeSetInstance> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size, @QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		throw new NotImplementedException();
	}

	@Override
	@GET
	@Path(IRestConfigs.SEARCH_PATH)
	public BaseListResponse<AttributeSetInstance> search(@QueryParam("value") String value,
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		throw new NotImplementedException();
	}

	@Override
	@GET
	@Path(IRestConfigs.UUID_PATH)
	public AttributeSetInstance getEntity(@PathParam("uuid") String uuid) {
		return attributeSetInstanceDBService.getEntity(uuid);
	}

	@Override
	@POST
	public AttributeSetInstance saveEntity(AttributeSetInstance entity) {
		return attributeSetInstanceDBService.saveEntity(entity);
	}
}
