package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_Order_Node_Product;

/**
 * Generated Query Resolver for PP_Order_Node_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Order_Node_ProductQuery extends POQuery<X_PP_Order_Node_Product> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_Node_Product.Table_Name;
	}

	public Connection<X_PP_Order_Node_Product> PP_Order_Node_ProductGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
