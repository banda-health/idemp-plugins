package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBHChargeInfoSuggestion;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ChargeInformationSuggestion;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ChargeInformationSuggestionDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.CHARGE_INFORMATION_SUGGESTION_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChargeInformationSuggestionRestService extends
		BaseRestService<ChargeInformationSuggestion, MBHChargeInfoSuggestion, ChargeInformationSuggestionDBService> {
	@Autowired
	private ChargeInformationSuggestionDBService dbService;

	@Override
	protected ChargeInformationSuggestionDBService getDBService() {
		return dbService;
	}
}
