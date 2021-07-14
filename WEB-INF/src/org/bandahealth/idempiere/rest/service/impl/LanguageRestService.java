package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Language;
import org.bandahealth.idempiere.rest.service.db.LanguageDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(IRestConfigs.LANGUAGES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LanguageRestService {
	private final LanguageDBService languageDBService;

	public LanguageRestService() {
		languageDBService = new LanguageDBService();
	}

	@GET
	public List<Language> getAll() {
		return languageDBService.getAll();
	}
}
