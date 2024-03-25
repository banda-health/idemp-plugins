package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportColumn;

/**
 * Generated Query Resolver for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportColumnQuery extends POQuery<MReportColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportColumn.Table_Name;
	}

	public Connection<MReportColumn> PA_ReportColumnGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
