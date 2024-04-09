package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LanguageInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LanguageInput;
import org.compiere.model.MLanguage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LanguageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LanguageInput.Table_Name;
	}

	public MLanguage AD_LanguageSave(I_AD_LanguageInput Entity, DataFetchingEnvironment environment) {
		return (MLanguage) super.save((X_AD_LanguageInput) Entity, environment);
	}

	public List<MLanguage> AD_LanguageSaveMany(List<I_AD_LanguageInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_LanguageInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLanguage) entity).collect(Collectors.toList());
	}

	public boolean AD_LanguageDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
