package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payroll_ComponentInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payroll_ComponentInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payroll_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_ComponentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payroll_ComponentInput.Table_Name;
	}

	public MBHPayrollComponent BH_Payroll_ComponentSave(I_BH_Payroll_ComponentInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayrollComponent) super.save((X_BH_Payroll_ComponentInput) Entity, environment);
	}

	public List<MBHPayrollComponent> BH_Payroll_ComponentSaveMany(List<I_BH_Payroll_ComponentInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payroll_ComponentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayrollComponent) entity).collect(Collectors.toList());
	}

	public boolean BH_Payroll_ComponentDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
