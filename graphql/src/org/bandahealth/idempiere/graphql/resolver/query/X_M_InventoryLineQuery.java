package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInventoryLine;

/**
 * Generated Query Resolver for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InventoryLineQuery extends POQuery<MInventoryLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInventoryLine.Table_Name;
	}

	public Connection<MInventoryLine> M_InventoryLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
