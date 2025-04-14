package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_JobInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_JobInput;
import org.eevolution.model.X_HR_Job;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_JobMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_JobInput.Table_Name;
	}

	public X_HR_Job HR_JobSave(I_HR_JobInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_Job) super.save((X_HR_JobInput) Entity, environment);
	}

	public List<X_HR_Job> HR_JobSaveMany(List<I_HR_JobInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_JobInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Job) entity).collect(Collectors.toList());
	}

	public boolean HR_JobDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
