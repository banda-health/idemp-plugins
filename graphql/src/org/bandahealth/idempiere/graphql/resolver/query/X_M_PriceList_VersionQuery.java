package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPriceListVersion;

/**
 * Generated Query Resolver for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PriceList_VersionQuery extends POQuery<MPriceListVersion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPriceListVersion.Table_Name;
	}

	public Connection<MPriceListVersion> M_PriceList_VersionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
