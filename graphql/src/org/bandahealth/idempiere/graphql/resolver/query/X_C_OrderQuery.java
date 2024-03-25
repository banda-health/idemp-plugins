package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderQuery extends POQuery<MOrder_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrder_BH.Table_Name;
	}

	public Connection<MOrder_BH> C_OrderGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
