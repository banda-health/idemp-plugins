package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_CtxHelpSuggestionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_CtxHelpSuggestionInput;
import org.compiere.model.MCtxHelpSuggestion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_CtxHelpSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpSuggestionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_CtxHelpSuggestionInput.Table_Name;
	}

	public MCtxHelpSuggestion AD_CtxHelpSuggestionSave(I_AD_CtxHelpSuggestionInput entity, DataFetchingEnvironment environment) {
		return (MCtxHelpSuggestion) super.save((X_AD_CtxHelpSuggestionInput) entity, environment);
	}

	public List<MCtxHelpSuggestion> AD_CtxHelpSuggestionSaveMany(List<I_AD_CtxHelpSuggestionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_CtxHelpSuggestionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCtxHelpSuggestion) entity).collect(Collectors.toList());
	}

	public boolean AD_CtxHelpSuggestionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
