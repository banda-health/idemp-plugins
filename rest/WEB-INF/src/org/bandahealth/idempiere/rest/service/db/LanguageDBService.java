package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Language;
import org.bandahealth.idempiere.rest.model.Paging;
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
public class LanguageDBService extends BaseDBService<Language, MLanguage> {

	@Override
	public BaseListResponse<Language> getAll(Paging pagingInfo, String sortJson, String filterJson) {
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
		return new BaseListResponse<>(languages.stream().map(Language::new).collect(Collectors.toList()),
				new Paging(0, languages.size()));
	}

	@Override
	public Language saveEntity(Language entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Language createInstanceWithDefaultFields(MLanguage instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Language createInstanceWithAllFields(MLanguage instance) {
		return new Language(instance);
	}

	@Override
	protected Language createInstanceWithSearchFields(MLanguage instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MLanguage getModelInstance() {
		return new MLanguage(Env.getCtx(), 0, null);
	}
}
