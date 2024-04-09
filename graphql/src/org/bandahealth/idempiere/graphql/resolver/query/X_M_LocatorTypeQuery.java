package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLocatorType;

/**
 * Generated Query Resolver for M_LocatorType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_LocatorTypeQuery extends POQuery<MLocatorType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLocatorType.Table_Name;
	}

	public Connection<MLocatorType> M_LocatorTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
