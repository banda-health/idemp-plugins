package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChartDatasource;

/**
 * Generated Query Resolver for AD_ChartDatasource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ChartDatasourceQuery extends POQuery<MChartDatasource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChartDatasource.Table_Name;
	}

	public Connection<MChartDatasource> AD_ChartDatasourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
