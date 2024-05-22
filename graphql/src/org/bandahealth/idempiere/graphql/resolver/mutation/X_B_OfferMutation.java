package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_OfferInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_OfferInput;
import org.compiere.model.X_B_Offer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for B_Offer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_OfferMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_OfferInput.Table_Name;
	}

	public X_B_Offer B_OfferSave(I_B_OfferInput Entity, DataFetchingEnvironment environment) {
		return (X_B_Offer) super.save((X_B_OfferInput) Entity, environment);
	}

	public List<X_B_Offer> B_OfferSaveMany(List<I_B_OfferInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_B_OfferInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_B_Offer) entity).collect(Collectors.toList());
	}

	public boolean B_OfferDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
