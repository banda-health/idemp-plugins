package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSLAMeasure;

/**
 * Generated Query Resolver for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_SLA_MeasureQuery extends POQuery<MSLAMeasure> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSLAMeasure.Table_Name;
	}

	public Connection<MSLAMeasure> PA_SLA_MeasureGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
