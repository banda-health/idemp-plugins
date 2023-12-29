package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_ShippingProcessorCfg;

/**
 * Generated Query Resolver for M_ShippingProcessorCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingProcessorCfgQuery extends POQuery<X_M_ShippingProcessorCfg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_ShippingProcessorCfg.Table_Name;
	}

	public Connection<X_M_ShippingProcessorCfg> M_ShippingProcessorCfgGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
