package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_Inventory;

/**
 * Generated Query Resolver for I_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_InventoryQuery extends POQuery<X_I_Inventory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Inventory.Table_Name;
	}

	public Connection<X_I_Inventory> I_InventoryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
