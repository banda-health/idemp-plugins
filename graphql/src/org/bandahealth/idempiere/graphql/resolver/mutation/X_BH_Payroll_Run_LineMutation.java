package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payroll_Run_LineInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payroll_Run_LineInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payroll_Run_Line - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_LineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payroll_Run_LineInput.Table_Name;
	}

	public MBHPayrollRunLine BH_Payroll_Run_LineSave(I_BH_Payroll_Run_LineInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayrollRunLine) super.save((X_BH_Payroll_Run_LineInput) Entity, environment);
	}

	public List<MBHPayrollRunLine> BH_Payroll_Run_LineSaveMany(List<I_BH_Payroll_Run_LineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payroll_Run_LineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayrollRunLine) entity).collect(Collectors.toList());
	}

	public boolean BH_Payroll_Run_LineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
