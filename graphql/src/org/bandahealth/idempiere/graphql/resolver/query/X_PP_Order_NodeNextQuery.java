package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_Order_NodeNext;

/**
 * Generated Query Resolver for PP_Order_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_Order_NodeNextQuery extends POQuery<X_PP_Order_NodeNext> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_NodeNext.Table_Name;
	}

	public Connection<X_PP_Order_NodeNext> PP_Order_NodeNextGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
