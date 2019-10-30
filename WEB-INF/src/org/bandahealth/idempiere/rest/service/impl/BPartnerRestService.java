package org.bandahealth.idempiere.rest.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BPartner;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.BPartnerDBService;

/**
 * Expose BPartner REST functionality
 * 
 * TODO: Error handling and logging.
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.BPARTNER_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BPartnerRestService extends BaseEntityRestService<BPartner> {

	public BPartnerRestService() {
	}

	@POST
	@Path("/bpartners")
	@Override
	public List<BPartner> getAll(@QueryParam("page") int page, @QueryParam("size") int size) {
		return BPartnerDBService.getAll(page, size);
	}

	@POST
	@Path("/bpartners/{uuid}")
	@Override
	public BPartner getEntity(@PathParam("uuid") String uuid) {
		return BPartnerDBService.getBPartner(uuid);
	}

	@POST
	@Path("/update")
	@Override
	public BPartner updateEntity(BPartner entity) {
		return null;
	}

	@POST
	@Path("/create")
	@Override
	public BPartner createEntity(BPartner entity) {
		return null;
	}
}
