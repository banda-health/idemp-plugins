package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.MPPProductPlanning;

/**
 * Generated Query Resolver for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_PlanningQuery extends POQuery<MPPProductPlanning> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPPProductPlanning.Table_Name;
	}

	public Connection<MPPProductPlanning> PP_Product_PlanningGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
