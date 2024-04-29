package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_BP_Price;

/**
 * Generated Query Resolver for M_BP_Price - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_BP_PriceQuery extends POQuery<X_M_BP_Price> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_BP_Price.Table_Name;
	}

	public Connection<X_M_BP_Price> M_BP_PriceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
