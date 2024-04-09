package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBOMProduct;

/**
 * Generated Query Resolver for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_BOMProductQuery extends POQuery<MBOMProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBOMProduct.Table_Name;
	}

	public Connection<MBOMProduct> M_BOMProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
