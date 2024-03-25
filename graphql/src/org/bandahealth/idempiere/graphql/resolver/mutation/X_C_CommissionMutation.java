package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CommissionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CommissionInput;
import org.compiere.model.MCommission;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Commission - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CommissionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CommissionInput.Table_Name;
	}

	public MCommission C_CommissionSave(I_C_CommissionInput entity, DataFetchingEnvironment environment) {
		return (MCommission) super.save((X_C_CommissionInput) entity, environment);
	}

	public List<MCommission> C_CommissionSaveMany(List<I_C_CommissionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CommissionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCommission) entity).collect(Collectors.toList());
	}

	public boolean C_CommissionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
