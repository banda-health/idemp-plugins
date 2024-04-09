package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStatusLine;

/**
 * Generated Query Resolver for AD_StatusLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_StatusLineQuery extends POQuery<MStatusLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStatusLine.Table_Name;
	}

	public Connection<MStatusLine> AD_StatusLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
