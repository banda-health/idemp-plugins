package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Language;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.LanguageDBService;
import org.compiere.model.MLanguage;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.LANGUAGES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LanguageRestService extends BaseRestService<Language, MLanguage, LanguageDBService> {
	private final LanguageDBService languageDBService = new LanguageDBService();

	@Override
	protected LanguageDBService getDBService() {
		return languageDBService;
	}
}
