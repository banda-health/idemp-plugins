package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCostDetail;

/**
 * Generated Query Resolver for M_CostDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostDetailQuery extends POQuery<MCostDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCostDetail.Table_Name;
	}

	public Connection<MCostDetail> M_CostDetailGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
