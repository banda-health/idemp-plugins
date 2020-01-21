package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.VendorDBService;

/**
 * Expose Vendor REST functionality
 * 
 * TODO: Error handling and logging.
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.VENDORS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendorRestService extends BaseEntityRestService<Vendor> {

	private VendorDBService dbService;

	public VendorRestService() {
		dbService = new VendorDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Vendor> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@POST
	@Path(IRestConfigs.VENDOR_PATH)
	@Override
	public Vendor getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.UPDATE_PATH)
	@Override
	public Vendor updateEntity(Vendor entity) {
		return null;
	}

	@POST
	@Path(IRestConfigs.CREATE_PATH)
	@Override
	public Vendor createEntity(Vendor entity) {
		return null;
	}
}
