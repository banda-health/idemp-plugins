package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payroll_FilingInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payroll_FilingInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payroll_Filing - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_FilingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payroll_FilingInput.Table_Name;
	}

	public MBHPayrollFiling BH_Payroll_FilingSave(I_BH_Payroll_FilingInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayrollFiling) super.save((X_BH_Payroll_FilingInput) Entity, environment);
	}

	public List<MBHPayrollFiling> BH_Payroll_FilingSaveMany(List<I_BH_Payroll_FilingInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payroll_FilingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayrollFiling) entity).collect(Collectors.toList());
	}

	public boolean BH_Payroll_FilingDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
