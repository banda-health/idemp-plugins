package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInventoryLineMA;

/**
 * Generated Query Resolver for M_InventoryLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InventoryLineMAQuery extends POQuery<MInventoryLineMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInventoryLineMA.Table_Name;
	}

	public Connection<MInventoryLineMA> M_InventoryLineMAGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
