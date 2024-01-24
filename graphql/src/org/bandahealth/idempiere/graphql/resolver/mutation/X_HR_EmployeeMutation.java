package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_EmployeeInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_EmployeeInput;
import org.eevolution.model.X_HR_Employee;

import java.util.List;

/**
 * Generated Query Resolver for HR_Employee - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_EmployeeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_EmployeeInput.Table_Name;
	}

	public X_HR_Employee HR_EmployeeSave(I_HR_EmployeeInput input, DataFetchingEnvironment environment) {
		return (X_HR_Employee) super.save((X_HR_EmployeeInput) input, environment);
	}

	public boolean HR_EmployeeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
