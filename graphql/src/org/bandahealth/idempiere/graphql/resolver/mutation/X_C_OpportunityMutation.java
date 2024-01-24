package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OpportunityInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OpportunityInput;
import org.compiere.model.MOpportunity;

import java.util.List;

/**
 * Generated Query Resolver for C_Opportunity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OpportunityMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OpportunityInput.Table_Name;
	}

	public MOpportunity C_OpportunitySave(I_C_OpportunityInput input, DataFetchingEnvironment environment) {
		return (MOpportunity) super.save((X_C_OpportunityInput) input, environment);
	}

	public boolean C_OpportunityDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
