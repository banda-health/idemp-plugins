package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_FieldSuggestionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_FieldSuggestionInput;
import org.compiere.model.MFieldSuggestion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_FieldSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_FieldSuggestionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_FieldSuggestionInput.Table_Name;
	}

	public MFieldSuggestion AD_FieldSuggestionSave(I_AD_FieldSuggestionInput entity, DataFetchingEnvironment environment) {
		return (MFieldSuggestion) super.save((X_AD_FieldSuggestionInput) entity, environment);
	}

	public List<MFieldSuggestion> AD_FieldSuggestionSaveMany(List<I_AD_FieldSuggestionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_FieldSuggestionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MFieldSuggestion) entity).collect(Collectors.toList());
	}

	public boolean AD_FieldSuggestionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
