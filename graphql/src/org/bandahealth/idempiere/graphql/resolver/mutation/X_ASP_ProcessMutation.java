package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_ProcessInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_ProcessInput;
import org.compiere.model.X_ASP_Process;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_ProcessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_ProcessInput.Table_Name;
	}

	public X_ASP_Process ASP_ProcessSave(I_ASP_ProcessInput Entity, DataFetchingEnvironment environment) {
		return (X_ASP_Process) super.save((X_ASP_ProcessInput) Entity, environment);
	}

	public List<X_ASP_Process> ASP_ProcessSaveMany(List<I_ASP_ProcessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_ASP_ProcessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Process) entity).collect(Collectors.toList());
	}

	public boolean ASP_ProcessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
