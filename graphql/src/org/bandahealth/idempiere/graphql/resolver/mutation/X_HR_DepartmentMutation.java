package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_DepartmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_DepartmentInput;
import org.eevolution.model.X_HR_Department;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Department - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_DepartmentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_DepartmentInput.Table_Name;
	}

	public X_HR_Department HR_DepartmentSave(I_HR_DepartmentInput entity, DataFetchingEnvironment environment) {
		return (X_HR_Department) super.save((X_HR_DepartmentInput) entity, environment);
	}

	public List<X_HR_Department> HR_DepartmentSaveMany(List<I_HR_DepartmentInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_HR_DepartmentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Department) entity).collect(Collectors.toList());
	}

	public boolean HR_DepartmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
