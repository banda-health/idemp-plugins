package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetProduct;

/**
 * Generated Query Resolver for A_Asset_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_ProductQuery extends POQuery<MAssetProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetProduct.Table_Name;
	}

	public Connection<MAssetProduct> A_Asset_ProductGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
