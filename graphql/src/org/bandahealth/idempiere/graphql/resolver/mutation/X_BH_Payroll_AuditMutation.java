package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollAudit;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payroll_AuditInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payroll_AuditInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payroll_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_AuditMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payroll_AuditInput.Table_Name;
	}

	public MBHPayrollAudit BH_Payroll_AuditSave(I_BH_Payroll_AuditInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayrollAudit) super.save((X_BH_Payroll_AuditInput) Entity, environment);
	}

	public List<MBHPayrollAudit> BH_Payroll_AuditSaveMany(List<I_BH_Payroll_AuditInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payroll_AuditInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayrollAudit) entity).collect(Collectors.toList());
	}

	public boolean BH_Payroll_AuditDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
