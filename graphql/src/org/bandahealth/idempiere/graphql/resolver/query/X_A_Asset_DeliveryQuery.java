package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetDelivery;

/**
 * Generated Query Resolver for A_Asset_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_DeliveryQuery extends POQuery<MAssetDelivery> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetDelivery.Table_Name;
	}

	public Connection<MAssetDelivery> A_Asset_DeliveryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
