package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_CtxHelpSuggestionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_CtxHelpSuggestionInput;
import org.compiere.model.MCtxHelpSuggestion;

import java.util.List;

/**
 * Generated Query Resolver for AD_CtxHelpSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_CtxHelpSuggestionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_CtxHelpSuggestionInput.Table_Name;
	}

	public MCtxHelpSuggestion AD_CtxHelpSuggestionSave(I_AD_CtxHelpSuggestionInput input, DataFetchingEnvironment environment) {
		return (MCtxHelpSuggestion) super.save((X_AD_CtxHelpSuggestionInput) input, environment);
	}

	public boolean AD_CtxHelpSuggestionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
