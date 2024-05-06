package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReport;

/**
 * Generated Query Resolver for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportQuery extends POQuery<MReport> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReport.Table_Name;
	}

	public Connection<MReport> PA_ReportGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
