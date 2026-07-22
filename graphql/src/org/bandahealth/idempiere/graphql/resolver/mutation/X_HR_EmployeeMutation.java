package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.graphql.model.input.I_HR_EmployeeInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_EmployeeInput;

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

	public MHREmployee_BH HR_EmployeeSave(I_HR_EmployeeInput Entity, DataFetchingEnvironment environment) {
		return (MHREmployee_BH) super.save((X_HR_EmployeeInput) Entity, environment);
	}

	public List<MHREmployee_BH> HR_EmployeeSaveMany(List<I_HR_EmployeeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_EmployeeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MHREmployee_BH) entity).collect(Collectors.toList());
	}

	public boolean HR_EmployeeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
