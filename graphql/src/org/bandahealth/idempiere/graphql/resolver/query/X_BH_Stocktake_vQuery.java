package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Stocktake_v - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Stocktake_vQuery extends POQuery<X_BH_Stocktake_v> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_BH_Stocktake_v.Table_Name;
	}

	public Connection<X_BH_Stocktake_v> BH_Stocktake_vGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
