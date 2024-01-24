package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CommissionDetailInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CommissionDetailInput;
import org.compiere.model.MCommissionDetail;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CommissionDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionDetailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CommissionDetailInput.Table_Name;
	}

	public MCommissionDetail C_CommissionDetailSave(I_C_CommissionDetailInput entity, DataFetchingEnvironment environment) {
		return (MCommissionDetail) super.save((X_C_CommissionDetailInput) entity, environment);
	}

	public List<MCommissionDetail> C_CommissionDetailSaveMany(List<I_C_CommissionDetailInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CommissionDetailInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCommissionDetail) entity).collect(Collectors.toList());
	}

	public boolean C_CommissionDetailDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
