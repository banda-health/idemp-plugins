package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_ShipperPickupTypesCfg;

/**
 * Generated Query Resolver for M_ShipperPickupTypesCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperPickupTypesCfgQuery extends POQuery<X_M_ShipperPickupTypesCfg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperPickupTypesCfg.Table_Name;
	}

	public Connection<X_M_ShipperPickupTypesCfg> M_ShipperPickupTypesCfgGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
