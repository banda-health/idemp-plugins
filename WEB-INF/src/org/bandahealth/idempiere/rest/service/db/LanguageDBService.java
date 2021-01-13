package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Language;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LanguageDBService {
	public List<MLanguage> getAll() {
		List<String> supportedLoginLanguages = Env.getLoginLanguages();
		String[] availableLanguages = Language.getNames();
		Set<String> languageNamesOfLanguagesToReturn = new HashSet<>();
		for (String langName : availableLanguages) {
			Language language = Language.getLanguage(langName);
			if (!supportedLoginLanguages.contains(language.getAD_Language())) {
				continue;
			}
			languageNamesOfLanguagesToReturn.add(language.getAD_Language());
		}
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(languageNamesOfLanguagesToReturn,
				parameters);
		return new Query(Env.getCtx(), MLanguage.Table_Name,
				MLanguage.COLUMNNAME_AD_Language + " IN (" + whereCondition + ")", null)
				.setParameters(parameters).list();
	}
}
