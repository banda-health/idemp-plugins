package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportLineSet;

/**
 * Generated Query Resolver for PA_ReportLineSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportLineSetQuery extends POQuery<MReportLineSet> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportLineSet.Table_Name;
	}

	public Connection<MReportLineSet> PA_ReportLineSetGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
