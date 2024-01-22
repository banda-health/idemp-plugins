package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CommissionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CommissionLineInput;
import org.compiere.model.MCommissionLine;

import java.util.List;

/**
 * Generated Query Resolver for C_CommissionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CommissionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CommissionLineInput.Table_Name;
	}

	public MCommissionLine C_CommissionLineSave(I_C_CommissionLineInput input, DataFetchingEnvironment environment) {
		return (MCommissionLine) super.save((X_C_CommissionLineInput) input, environment);
	}

	public boolean C_CommissionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
