package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.Language;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LanguageDBService {
	public List<Language> getAll() {
		List<String> supportedLoginLanguages = Env.getLoginLanguages();
		String[] availableLanguages = org.compiere.util.Language.getNames();
		Set<String> languageNamesOfLanguagesToReturn = new HashSet<>();
		for (String langName : availableLanguages) {
			org.compiere.util.Language language = org.compiere.util.Language.getLanguage(langName);
			if (!supportedLoginLanguages.contains(language.getAD_Language())) {
				continue;
			}
			languageNamesOfLanguagesToReturn.add(language.getAD_Language());
		}
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(languageNamesOfLanguagesToReturn,
				parameters);
		List<MLanguage> languages = new Query(Env.getCtx(), MLanguage.Table_Name,
				MLanguage.COLUMNNAME_AD_Language + " IN (" + whereCondition + ")", null)
				.setParameters(parameters).list();
		return languages.stream().map(Language::new).collect(Collectors.toList());
	}
}
