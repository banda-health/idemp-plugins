package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLocator;

/**
 * Generated Query Resolver for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_LocatorQuery extends POQuery<MLocator> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLocator.Table_Name;
	}

	public Connection<MLocator> M_LocatorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
