package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DemandInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DemandInput;
import org.compiere.model.X_M_Demand;

import java.util.List;

/**
 * Generated Query Resolver for M_Demand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DemandMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DemandInput.Table_Name;
	}

	public X_M_Demand M_DemandSave(I_M_DemandInput input, DataFetchingEnvironment environment) {
		return (X_M_Demand) super.save((X_M_DemandInput) input, environment);
	}

	public boolean M_DemandDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
