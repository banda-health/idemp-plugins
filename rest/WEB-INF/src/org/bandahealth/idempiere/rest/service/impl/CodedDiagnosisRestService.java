package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.CodedDiagnosis;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.CodedDiagnosisDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.CODED_DIAGNOSES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CodedDiagnosisRestService
		extends BaseRestService<CodedDiagnosis, MBHCodedDiagnosis, CodedDiagnosisDBService> {

	@Autowired
	private CodedDiagnosisDBService dbService;

	@Override
	protected CodedDiagnosisDBService getDBService() {
		return dbService;
	}
}
