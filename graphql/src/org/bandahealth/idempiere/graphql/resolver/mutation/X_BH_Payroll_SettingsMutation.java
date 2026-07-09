package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollSettings;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payroll_SettingsInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payroll_SettingsInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payroll_Settings - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_SettingsMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payroll_SettingsInput.Table_Name;
	}

	public MBHPayrollSettings BH_Payroll_SettingsSave(I_BH_Payroll_SettingsInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayrollSettings) super.save((X_BH_Payroll_SettingsInput) Entity, environment);
	}

	public List<MBHPayrollSettings> BH_Payroll_SettingsSaveMany(List<I_BH_Payroll_SettingsInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payroll_SettingsInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayrollSettings) entity).collect(Collectors.toList());
	}

	public boolean BH_Payroll_SettingsDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
