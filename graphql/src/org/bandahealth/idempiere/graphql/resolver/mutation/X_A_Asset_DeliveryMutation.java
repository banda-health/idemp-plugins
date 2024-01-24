package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_DeliveryInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_DeliveryInput;
import org.compiere.model.MAssetDelivery;

import java.util.List;
import java.util.stream.Collectors;

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

	public MAssetDelivery A_Asset_DeliverySave(I_A_Asset_DeliveryInput entity, DataFetchingEnvironment environment) {
		return (MAssetDelivery) super.save((X_A_Asset_DeliveryInput) entity, environment);
	}

	public List<MAssetDelivery> A_Asset_DeliverySaveMany(List<I_A_Asset_DeliveryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Asset_DeliveryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetDelivery) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_DeliveryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
