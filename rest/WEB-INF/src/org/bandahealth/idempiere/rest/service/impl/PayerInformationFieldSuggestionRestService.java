package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldSuggestion;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.PayerInformationFieldSuggestionDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.PAYER_INFORMATION_FIELD_SUGGESTION_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PayerInformationFieldSuggestionRestService extends
		BaseRestService<PayerInformationFieldSuggestion, MBHPayerInfoFldSug,
				PayerInformationFieldSuggestionDBService> {
	private final PayerInformationFieldSuggestionDBService dbService = new PayerInformationFieldSuggestionDBService();

	@Override
	protected PayerInformationFieldSuggestionDBService getDBService() {
		return dbService;
	}
}
