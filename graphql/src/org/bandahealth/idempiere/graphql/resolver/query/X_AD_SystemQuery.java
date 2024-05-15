package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSystem;

/**
 * Generated Query Resolver for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SystemQuery extends POQuery<MSystem> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSystem.Table_Name;
	}

	public Connection<MSystem> AD_SystemGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
