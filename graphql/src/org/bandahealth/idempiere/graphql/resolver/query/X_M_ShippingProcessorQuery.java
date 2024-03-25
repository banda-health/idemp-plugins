package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShippingProcessor;

/**
 * Generated Query Resolver for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShippingProcessorQuery extends POQuery<MShippingProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShippingProcessor.Table_Name;
	}

	public Connection<MShippingProcessor> M_ShippingProcessorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
