package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ReplenishInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ReplenishInput;
import org.compiere.model.MReplenish;

import java.util.List;

/**
 * Generated Query Resolver for M_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ReplenishMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ReplenishInput.Table_Name;
	}

	public MReplenish M_ReplenishSave(I_M_ReplenishInput input, DataFetchingEnvironment environment) {
		return (MReplenish) super.save((X_M_ReplenishInput) input, environment);
	}

	public boolean M_ReplenishDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
