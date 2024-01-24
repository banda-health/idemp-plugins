package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_OfferInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_OfferInput;
import org.compiere.model.X_B_Offer;

import java.util.List;

/**
 * Generated Query Resolver for B_Offer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_B_OfferMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_OfferInput.Table_Name;
	}

	public X_B_Offer B_OfferSave(I_B_OfferInput input, DataFetchingEnvironment environment) {
		return (X_B_Offer) super.save((X_B_OfferInput) input, environment);
	}

	public boolean B_OfferDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
