package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLotCtl;

/**
 * Generated Query Resolver for M_LotCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_LotCtlQuery extends POQuery<MLotCtl> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLotCtl.Table_Name;
	}

	public Connection<MLotCtl> M_LotCtlGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
