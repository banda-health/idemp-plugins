package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPriceList;

/**
 * Generated Query Resolver for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PriceListQuery extends POQuery<MPriceList> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPriceList.Table_Name;
	}

	public Connection<MPriceList> M_PriceListGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
