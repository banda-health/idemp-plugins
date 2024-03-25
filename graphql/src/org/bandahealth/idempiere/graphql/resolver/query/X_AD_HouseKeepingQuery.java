package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MHouseKeeping;

/**
 * Generated Query Resolver for AD_HouseKeeping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_HouseKeepingQuery extends POQuery<MHouseKeeping> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MHouseKeeping.Table_Name;
	}

	public Connection<MHouseKeeping> AD_HouseKeepingGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
