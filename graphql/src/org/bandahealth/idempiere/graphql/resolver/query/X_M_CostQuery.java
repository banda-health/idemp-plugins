package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCost;

/**
 * Generated Query Resolver for M_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostQuery extends POQuery<MCost> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCost.Table_Name;
	}

	public Connection<MCost> M_CostGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
