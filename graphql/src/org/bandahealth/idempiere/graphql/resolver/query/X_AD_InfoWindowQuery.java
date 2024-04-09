package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInfoWindow;

/**
 * Generated Query Resolver for AD_InfoWindow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoWindowQuery extends POQuery<MInfoWindow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInfoWindow.Table_Name;
	}

	public Connection<MInfoWindow> AD_InfoWindowGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
