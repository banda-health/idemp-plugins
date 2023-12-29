package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_DeliveryInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_DeliveryInput;
import org.compiere.model.MAssetDelivery;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_DeliveryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_DeliveryInput.Table_Name;
	}

	public MAssetDelivery A_Asset_DeliverySave(I_A_Asset_DeliveryInput input, DataFetchingEnvironment environment) {
		return (MAssetDelivery) super.save((X_A_Asset_DeliveryInput) input, environment);
	}

	public boolean A_Asset_DeliveryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
