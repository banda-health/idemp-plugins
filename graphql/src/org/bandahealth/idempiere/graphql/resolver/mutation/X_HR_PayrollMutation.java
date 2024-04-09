package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_PayrollInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_PayrollInput;
import org.eevolution.model.X_HR_Payroll;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Payroll - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_PayrollMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_PayrollInput.Table_Name;
	}

	public X_HR_Payroll HR_PayrollSave(I_HR_PayrollInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_Payroll) super.save((X_HR_PayrollInput) Entity, environment);
	}

	public List<X_HR_Payroll> HR_PayrollSaveMany(List<I_HR_PayrollInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_PayrollInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Payroll) entity).collect(Collectors.toList());
	}

	public boolean HR_PayrollDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
