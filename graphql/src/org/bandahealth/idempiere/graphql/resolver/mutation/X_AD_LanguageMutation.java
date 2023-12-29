package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LanguageInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LanguageInput;
import org.compiere.model.MLanguage;

import java.util.List;

/**
 * Generated Query Resolver for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LanguageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LanguageInput.Table_Name;
	}

	public MLanguage AD_LanguageSave(I_AD_LanguageInput input, DataFetchingEnvironment environment) {
		return (MLanguage) super.save((X_AD_LanguageInput) input, environment);
	}

	public boolean AD_LanguageDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
