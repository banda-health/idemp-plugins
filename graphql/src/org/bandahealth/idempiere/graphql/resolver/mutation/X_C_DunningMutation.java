package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningInput;
import org.compiere.model.MDunning;

import java.util.List;

/**
 * Generated Query Resolver for C_Dunning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningInput.Table_Name;
	}

	public MDunning C_DunningSave(I_C_DunningInput input, DataFetchingEnvironment environment) {
		return (MDunning) super.save((X_C_DunningInput) input, environment);
	}

	public boolean C_DunningDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
