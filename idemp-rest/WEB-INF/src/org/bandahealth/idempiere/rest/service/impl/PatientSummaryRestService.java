package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.PatientSummary;
import org.bandahealth.idempiere.rest.service.db.PatientSummaryDBService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Expose Patient Summary REST functionality
 *
 * @author andrew
 */
@Path(IRestConfigs.PATIENT_SUMMARY_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientSummaryRestService {

	@Autowired
	private PatientSummaryDBService dbService;

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	public PatientSummary get(@QueryParam("period") String period) {
		if (period == null) {
			period = "all";
		}

		return dbService.get(period);
	}

}
