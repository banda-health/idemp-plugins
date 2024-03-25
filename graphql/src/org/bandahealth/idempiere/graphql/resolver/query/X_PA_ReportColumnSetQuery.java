package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportColumnSet;

/**
 * Generated Query Resolver for PA_ReportColumnSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportColumnSetQuery extends POQuery<MReportColumnSet> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportColumnSet.Table_Name;
	}

	public Connection<MReportColumnSet> PA_ReportColumnSetGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
