package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReportCube;

/**
 * Generated Query Resolver for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportCubeQuery extends POQuery<MReportCube> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportCube.Table_Name;
	}

	public Connection<MReportCube> PA_ReportCubeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
