package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCashLine;

/**
 * Generated Query Resolver for C_CashLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashLineQuery extends POQuery<MCashLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCashLine.Table_Name;
	}

	public Connection<MCashLine> C_CashLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
