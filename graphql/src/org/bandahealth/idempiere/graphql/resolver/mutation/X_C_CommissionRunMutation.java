package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CommissionRunInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CommissionRunInput;
import org.compiere.model.MCommissionRun;

import java.util.List;

/**
 * Generated Query Resolver for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CommissionRunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CommissionRunInput.Table_Name;
	}

	public MCommissionRun C_CommissionRunSave(I_C_CommissionRunInput input, DataFetchingEnvironment environment) {
		return (MCommissionRun) super.save((X_C_CommissionRunInput) input, environment);
	}

	public boolean C_CommissionRunDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
