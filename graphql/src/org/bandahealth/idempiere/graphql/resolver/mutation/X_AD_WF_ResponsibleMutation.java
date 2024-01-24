package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_ResponsibleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_ResponsibleInput;
import org.compiere.model.X_AD_WF_Responsible;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_Responsible - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ResponsibleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_ResponsibleInput.Table_Name;
	}

	public X_AD_WF_Responsible AD_WF_ResponsibleSave(I_AD_WF_ResponsibleInput entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_Responsible) super.save((X_AD_WF_ResponsibleInput) entity, environment);
	}

	public List<X_AD_WF_Responsible> AD_WF_ResponsibleSaveMany(List<I_AD_WF_ResponsibleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_WF_ResponsibleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_Responsible) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_ResponsibleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
