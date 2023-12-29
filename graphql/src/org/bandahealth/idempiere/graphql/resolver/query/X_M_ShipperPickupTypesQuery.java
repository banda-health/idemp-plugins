package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShipperPickupTypes;

/**
 * Generated Query Resolver for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPickupTypesQuery extends POQuery<MShipperPickupTypes> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShipperPickupTypes.Table_Name;
	}

	public Connection<MShipperPickupTypes> M_ShipperPickupTypesGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
