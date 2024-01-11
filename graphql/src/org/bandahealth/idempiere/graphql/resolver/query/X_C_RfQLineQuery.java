package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQLine;

/**
 * Generated Query Resolver for C_RfQLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQLineQuery extends POQuery<MRfQLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQLine.Table_Name;
	}

	public Connection<MRfQLine> C_RfQLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
