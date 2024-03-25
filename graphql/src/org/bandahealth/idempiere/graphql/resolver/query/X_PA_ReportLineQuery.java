package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportLine;

/**
 * Generated Query Resolver for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportLineQuery extends POQuery<MReportLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportLine.Table_Name;
	}

	public Connection<MReportLine> PA_ReportLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
