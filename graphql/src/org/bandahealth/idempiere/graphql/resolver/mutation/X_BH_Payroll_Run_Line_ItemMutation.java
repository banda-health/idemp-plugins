package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payroll_Run_Line_ItemInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payroll_Run_Line_ItemInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payroll_Run_Line_Item - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_Line_ItemMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payroll_Run_Line_ItemInput.Table_Name;
	}

	public MBHPayrollRunLineItem BH_Payroll_Run_Line_ItemSave(I_BH_Payroll_Run_Line_ItemInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayrollRunLineItem) super.save((X_BH_Payroll_Run_Line_ItemInput) Entity, environment);
	}

	public List<MBHPayrollRunLineItem> BH_Payroll_Run_Line_ItemSaveMany(List<I_BH_Payroll_Run_Line_ItemInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payroll_Run_Line_ItemInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayrollRunLineItem) entity).collect(Collectors.toList());
	}

	public boolean BH_Payroll_Run_Line_ItemDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
