package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_ActivityResultInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_ActivityResultInput;
import org.compiere.model.X_AD_WF_ActivityResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_ActivityResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_ActivityResultMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_ActivityResultInput.Table_Name;
	}

	public X_AD_WF_ActivityResult AD_WF_ActivityResultSave(I_AD_WF_ActivityResultInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_ActivityResult) super.save((X_AD_WF_ActivityResultInput) Entity, environment);
	}

	public List<X_AD_WF_ActivityResult> AD_WF_ActivityResultSaveMany(List<I_AD_WF_ActivityResultInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WF_ActivityResultInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_ActivityResult) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_ActivityResultDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
