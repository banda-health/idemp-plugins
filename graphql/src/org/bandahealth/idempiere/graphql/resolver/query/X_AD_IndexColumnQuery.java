package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIndexColumn;

/**
 * Generated Query Resolver for AD_IndexColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_IndexColumnQuery extends POQuery<MIndexColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIndexColumn.Table_Name;
	}

	public Connection<MIndexColumn> AD_IndexColumnGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
