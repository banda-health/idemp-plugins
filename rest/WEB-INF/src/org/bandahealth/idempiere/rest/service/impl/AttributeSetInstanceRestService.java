package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.AttributeSetInstanceDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.ATTRIBUTE_SET_INSTANCES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceRestService
		extends BaseRestService<AttributeSetInstance, MAttributeSetInstance_BH, AttributeSetInstanceDBService> {
	@Autowired
	private AttributeSetInstanceDBService dbService;

	@Override
	protected AttributeSetInstanceDBService getDBService() {
		return dbService;
	}
}
