package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQResponseLine;

/**
 * Generated Query Resolver for C_RfQResponseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQResponseLineQuery extends POQuery<MRfQResponseLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQResponseLine.Table_Name;
	}

	public Connection<MRfQResponseLine> C_RfQResponseLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
