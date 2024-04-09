package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlert;

/**
 * Generated Query Resolver for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertQuery extends POQuery<MAlert> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlert.Table_Name;
	}

	public Connection<MAlert> AD_AlertGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
