package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_DepartmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_DepartmentInput;
import org.eevolution.model.X_HR_Department;

import java.util.List;

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

	public X_HR_Department HR_DepartmentSave(I_HR_DepartmentInput input, DataFetchingEnvironment environment) {
		return (X_HR_Department) super.save((X_HR_DepartmentInput) input, environment);
	}

	public boolean HR_DepartmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
