package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_ProcessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_ProcessInput;
import org.compiere.model.X_AD_WF_Process;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WF_ProcessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_ProcessInput.Table_Name;
	}

	public X_AD_WF_Process AD_WF_ProcessSave(I_AD_WF_ProcessInput entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_Process) super.save((X_AD_WF_ProcessInput) entity, environment);
	}

	public List<X_AD_WF_Process> AD_WF_ProcessSaveMany(List<I_AD_WF_ProcessInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_WF_ProcessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_Process) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_ProcessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
