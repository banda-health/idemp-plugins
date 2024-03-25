package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQResponseLineQty;

/**
 * Generated Query Resolver for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQResponseLineQtyQuery extends POQuery<MRfQResponseLineQty> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQResponseLineQty.Table_Name;
	}

	public Connection<MRfQResponseLineQty> C_RfQResponseLineQtyGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
