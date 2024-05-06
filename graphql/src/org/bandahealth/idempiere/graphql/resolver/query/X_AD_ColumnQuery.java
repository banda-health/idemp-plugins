package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MColumn;

/**
 * Generated Query Resolver for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ColumnQuery extends POQuery<MColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MColumn.Table_Name;
	}

	public Connection<MColumn> AD_ColumnGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
