package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTable;

/**
 * Generated Query Resolver for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TableQuery extends POQuery<MTable> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTable.Table_Name;
	}

	public Connection<MTable> AD_TableGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
