package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReportView;

/**
 * Generated Query Resolver for AD_ReportView - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReportViewQuery extends POQuery<MReportView> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportView.Table_Name;
	}

	public Connection<MReportView> AD_ReportViewGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
