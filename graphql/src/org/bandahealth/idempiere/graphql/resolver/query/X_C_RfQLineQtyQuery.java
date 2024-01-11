package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQLineQty;

/**
 * Generated Query Resolver for C_RfQLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQLineQtyQuery extends POQuery<MRfQLineQty> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQLineQty.Table_Name;
	}

	public Connection<MRfQLineQty> C_RfQLineQtyGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
