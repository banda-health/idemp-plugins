package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.SerialNumberControl;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.SerialNumberControlDBService;
import org.compiere.model.MSerNoCtl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/serial-number-controls")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SerialNumberControlRestService
		extends BaseRestService<SerialNumberControl, MSerNoCtl, SerialNumberControlDBService> {
	@Autowired
	private SerialNumberControlDBService serialNumberControlDBService;

	@Override
	protected SerialNumberControlDBService getDBService() {
		return serialNumberControlDBService;
	}

	@POST
	@Path("/{uuid}/next")
	public String getNext(@PathParam("uuid") String uuid) {
		SerialNumberControl model = getDBService().getEntity(uuid);
		if (model.getModel() != null) {
			return model.getModel().createSerNo();
		}
		return "";
	}
}
