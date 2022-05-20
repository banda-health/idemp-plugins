package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.SerialNumberControl;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.SerialNumberControlDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/serial-number-controls")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SerialNumberControlRestService
		extends BaseRestService<SerialNumberControl, MSerNoCtl_BH, SerialNumberControlDBService> {
	@Autowired
	private SerialNumberControlDBService serialNumberControlDBService;

	@Override
	protected SerialNumberControlDBService getDBService() {
		return serialNumberControlDBService;
	}

	@POST
	@Path("/{uuid}/next")
	public String getNext(@PathParam("uuid") String uuid) {
		MSerNoCtl_BH model = getDBService().getByUuids(Collections.singleton(uuid)).get(uuid);
		if (model != null) {
			return model.createSerNo();
		}
		return "";
	}
}
