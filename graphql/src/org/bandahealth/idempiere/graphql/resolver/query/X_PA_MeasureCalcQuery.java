package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMeasureCalc;

/**
 * Generated Query Resolver for PA_MeasureCalc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureCalcQuery extends POQuery<MMeasureCalc> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMeasureCalc.Table_Name;
	}

	public Connection<MMeasureCalc> PA_MeasureCalcGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
