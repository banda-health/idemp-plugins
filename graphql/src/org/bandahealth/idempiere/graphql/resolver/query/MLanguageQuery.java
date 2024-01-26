package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Language;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MLanguageQuery extends X_AD_LanguageQuery {
	@Override
	public Connection<MLanguage> get(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		ServerContext.setCurrentInstance(BandaGraphQLContext.getCtx(environment));
		Env.setCtx(BandaGraphQLContext.getCtx(environment));
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
		List<MLanguage> languages = new Query(BandaGraphQLContext.getCtx(environment), MLanguage.Table_Name,
				MLanguage.COLUMNNAME_AD_Language + " IN (" + whereCondition + ")", null)
				.setParameters(parameters).list();
		return new Connection<>(languages, new PagingInfo(0, languages.size()));
	}
}
