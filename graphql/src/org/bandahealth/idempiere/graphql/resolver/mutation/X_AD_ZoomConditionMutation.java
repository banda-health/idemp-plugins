package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ZoomConditionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ZoomConditionInput;
import org.compiere.model.MZoomCondition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ZoomCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ZoomConditionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ZoomConditionInput.Table_Name;
	}

	public MZoomCondition AD_ZoomConditionSave(I_AD_ZoomConditionInput entity, DataFetchingEnvironment environment) {
		return (MZoomCondition) super.save((X_AD_ZoomConditionInput) entity, environment);
	}

	public List<MZoomCondition> AD_ZoomConditionSaveMany(List<I_AD_ZoomConditionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ZoomConditionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MZoomCondition) entity).collect(Collectors.toList());
	}

	public boolean AD_ZoomConditionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
