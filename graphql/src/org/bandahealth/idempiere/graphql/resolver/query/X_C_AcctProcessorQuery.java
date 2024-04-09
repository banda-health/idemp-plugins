package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctProcessor;

/**
 * Generated Query Resolver for C_AcctProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctProcessorQuery extends POQuery<MAcctProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctProcessor.Table_Name;
	}

	public Connection<MAcctProcessor> C_AcctProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
