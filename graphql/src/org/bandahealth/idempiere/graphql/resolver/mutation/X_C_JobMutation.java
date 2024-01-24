package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_JobInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_JobInput;
import org.compiere.model.X_C_Job;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_JobMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_JobInput.Table_Name;
	}

	public X_C_Job C_JobSave(I_C_JobInput entity, DataFetchingEnvironment environment) {
		return (X_C_Job) super.save((X_C_JobInput) entity, environment);
	}

	public List<X_C_Job> C_JobSaveMany(List<I_C_JobInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_JobInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Job) entity).collect(Collectors.toList());
	}

	public boolean C_JobDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
