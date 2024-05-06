package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.MPPProductPlanning;

/**
 * Generated Query Resolver for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Product_PlanningQuery extends POQuery<MPPProductPlanning> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPPProductPlanning.Table_Name;
	}

	public Connection<MPPProductPlanning> PP_Product_PlanningGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
