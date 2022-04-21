package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.AttributeSet;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.AttributeSetDBService;
import org.compiere.model.MAttributeSet;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/attribute-sets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AttributeSetRestService extends BaseRestService<AttributeSet, MAttributeSet, AttributeSetDBService> {
	@Autowired
	private AttributeSetDBService attributeSetDBService;

	@Override
	protected AttributeSetDBService getDBService() {
		return attributeSetDBService;
	}
}
