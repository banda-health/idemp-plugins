package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectLine;

/**
 * Generated Query Resolver for C_ProjectLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectLineQuery extends POQuery<MProjectLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectLine.Table_Name;
	}

	public Connection<MProjectLine> C_ProjectLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
