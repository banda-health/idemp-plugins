package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MColumn;

/**
 * Generated Query Resolver for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ColumnQuery extends POQuery<MColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MColumn.Table_Name;
	}

	public Connection<MColumn> AD_ColumnGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
