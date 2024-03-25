package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_Product;

/**
 * Generated Query Resolver for I_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_ProductQuery extends POQuery<X_I_Product> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Product.Table_Name;
	}

	public Connection<X_I_Product> I_ProductGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
