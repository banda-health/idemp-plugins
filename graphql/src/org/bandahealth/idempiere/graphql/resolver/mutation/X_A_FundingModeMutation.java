package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_FundingModeInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_FundingModeInput;
import org.compiere.model.X_A_FundingMode;

import java.util.List;

/**
 * Generated Query Resolver for A_FundingMode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_FundingModeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_FundingModeInput.Table_Name;
	}

	public X_A_FundingMode A_FundingModeSave(I_A_FundingModeInput input, DataFetchingEnvironment environment) {
		return (X_A_FundingMode) super.save((X_A_FundingModeInput) input, environment);
	}

	public boolean A_FundingModeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
