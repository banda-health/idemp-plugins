package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWarehousePrice;

/**
 * Generated Query Resolver for RV_WarehousePrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_RV_WarehousePriceQuery extends POQuery<MWarehousePrice> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWarehousePrice.Table_Name;
	}

	public Connection<MWarehousePrice> RV_WarehousePriceGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
