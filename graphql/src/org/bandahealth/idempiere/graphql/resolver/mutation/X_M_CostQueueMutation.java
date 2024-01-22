package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CostQueueInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CostQueueInput;
import org.compiere.model.MCostQueue;

import java.util.List;

/**
 * Generated Query Resolver for M_CostQueue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_CostQueueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CostQueueInput.Table_Name;
	}

	public MCostQueue M_CostQueueSave(I_M_CostQueueInput input, DataFetchingEnvironment environment) {
		return (MCostQueue) super.save((X_M_CostQueueInput) input, environment);
	}

	public boolean M_CostQueueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
