package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_NextConditionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_NextConditionInput;
import org.compiere.model.X_AD_WF_NextCondition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_NextCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_NextConditionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_NextConditionInput.Table_Name;
	}

	public X_AD_WF_NextCondition AD_WF_NextConditionSave(I_AD_WF_NextConditionInput entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_NextCondition) super.save((X_AD_WF_NextConditionInput) entity, environment);
	}

	public List<X_AD_WF_NextCondition> AD_WF_NextConditionSaveMany(List<I_AD_WF_NextConditionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_WF_NextConditionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_NextCondition) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_NextConditionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
