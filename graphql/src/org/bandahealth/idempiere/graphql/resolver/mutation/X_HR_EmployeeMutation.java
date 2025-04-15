package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_EmployeeInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_EmployeeInput;
import org.eevolution.model.X_HR_Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Employee - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_EmployeeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_EmployeeInput.Table_Name;
	}

	public X_HR_Employee HR_EmployeeSave(I_HR_EmployeeInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_Employee) super.save((X_HR_EmployeeInput) Entity, environment);
	}

	public List<X_HR_Employee> HR_EmployeeSaveMany(List<I_HR_EmployeeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_EmployeeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Employee) entity).collect(Collectors.toList());
	}

	public boolean HR_EmployeeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
