package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShipperPackaging;

/**
 * Generated Query Resolver for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShipperPackagingQuery extends POQuery<MShipperPackaging> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShipperPackaging.Table_Name;
	}

	public Connection<MShipperPackaging> M_ShipperPackagingGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
