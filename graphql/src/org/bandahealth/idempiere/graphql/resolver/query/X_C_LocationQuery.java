package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLocation;

/**
 * Generated Query Resolver for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_LocationQuery extends POQuery<MLocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLocation.Table_Name;
	}

	public Connection<MLocation> C_LocationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
