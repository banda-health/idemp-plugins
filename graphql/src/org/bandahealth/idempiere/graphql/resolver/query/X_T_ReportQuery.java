package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_Report;

/**
 * Generated Query Resolver for T_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_ReportQuery extends POQuery<X_T_Report> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_Report.Table_Name;
	}

	public Connection<X_T_Report> T_ReportGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
