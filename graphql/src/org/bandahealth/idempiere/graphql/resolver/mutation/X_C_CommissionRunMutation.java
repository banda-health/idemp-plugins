package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CommissionRunInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CommissionRunInput;
import org.compiere.model.MCommissionRun;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CommissionRunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CommissionRunInput.Table_Name;
	}

	public MCommissionRun C_CommissionRunSave(I_C_CommissionRunInput Entity, DataFetchingEnvironment environment) {
		return (MCommissionRun) super.save((X_C_CommissionRunInput) Entity, environment);
	}

	public List<MCommissionRun> C_CommissionRunSaveMany(List<I_C_CommissionRunInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_CommissionRunInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCommissionRun) entity).collect(Collectors.toList());
	}

	public boolean C_CommissionRunDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
