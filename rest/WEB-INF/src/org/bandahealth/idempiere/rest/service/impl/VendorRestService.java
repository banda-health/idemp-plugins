package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.VendorDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Expose Vendor REST functionality
 *
 * @author andrew
 */
@Path(IRestConfigs.VENDORS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendorRestService extends BaseRestService<Vendor, MBPartner_BH, VendorDBService> {

	@Autowired
	private VendorDBService dbService;

	@Override
	protected VendorDBService getDBService() {
		return dbService;
	}
}
