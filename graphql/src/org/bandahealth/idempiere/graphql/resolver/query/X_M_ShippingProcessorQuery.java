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

	public Connection<MShippingProcessor> M_ShippingProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
