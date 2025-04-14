package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_ActivityInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_ActivityInput;
import org.compiere.model.X_AD_WF_Activity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WF_ActivityMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_ActivityInput.Table_Name;
	}

	public X_AD_WF_Activity AD_WF_ActivitySave(I_AD_WF_ActivityInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_Activity) super.save((X_AD_WF_ActivityInput) Entity, environment);
	}

	public List<X_AD_WF_Activity> AD_WF_ActivitySaveMany(List<I_AD_WF_ActivityInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WF_ActivityInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_Activity) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_ActivityDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
