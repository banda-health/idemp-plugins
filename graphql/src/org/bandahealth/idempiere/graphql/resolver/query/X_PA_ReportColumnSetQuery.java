package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_ReportColumnSet;

/**
 * Generated Query Resolver for PA_ReportColumnSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnSetQuery extends POQuery<X_PA_ReportColumnSet> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportColumnSet.Table_Name;
	}

	public Connection<X_PA_ReportColumnSet> PA_ReportColumnSetGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
