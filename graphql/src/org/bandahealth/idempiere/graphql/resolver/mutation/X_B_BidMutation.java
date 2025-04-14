package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_BidInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_BidInput;
import org.compiere.model.X_B_Bid;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for B_Bid - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_BidMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_BidInput.Table_Name;
	}

	public X_B_Bid B_BidSave(I_B_BidInput Entity, DataFetchingEnvironment environment) {
		return (X_B_Bid) super.save((X_B_BidInput) Entity, environment);
	}

	public List<X_B_Bid> B_BidSaveMany(List<I_B_BidInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_B_BidInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_B_Bid) entity).collect(Collectors.toList());
	}

	public boolean B_BidDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
