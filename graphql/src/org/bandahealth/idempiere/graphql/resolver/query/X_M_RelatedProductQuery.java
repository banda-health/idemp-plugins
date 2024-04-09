package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_RelatedProduct;

/**
 * Generated Query Resolver for M_RelatedProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RelatedProductQuery extends POQuery<X_M_RelatedProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_RelatedProduct.Table_Name;
	}

	public Connection<X_M_RelatedProduct> M_RelatedProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
