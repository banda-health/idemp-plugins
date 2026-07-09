package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payroll_RunInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payroll_RunInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payroll_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_RunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payroll_RunInput.Table_Name;
	}

	public MBHPayrollRun BH_Payroll_RunSave(I_BH_Payroll_RunInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayrollRun) super.save((X_BH_Payroll_RunInput) Entity, environment);
	}

	public List<MBHPayrollRun> BH_Payroll_RunSaveMany(List<I_BH_Payroll_RunInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payroll_RunInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayrollRun) entity).collect(Collectors.toList());
	}

	public boolean BH_Payroll_RunDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
