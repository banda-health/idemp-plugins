package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_BidInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_BidInput;
import org.compiere.model.X_B_Bid;

import java.util.List;

/**
 * Generated Query Resolver for B_Bid - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BidMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_BidInput.Table_Name;
	}

	public X_B_Bid B_BidSave(I_B_BidInput input, DataFetchingEnvironment environment) {
		return (X_B_Bid) super.save((X_B_BidInput) input, environment);
	}

	public boolean B_BidDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
