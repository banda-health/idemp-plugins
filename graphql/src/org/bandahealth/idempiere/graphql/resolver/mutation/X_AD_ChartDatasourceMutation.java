package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ChartDatasourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ChartDatasourceInput;
import org.compiere.model.MChartDatasource;

import java.util.List;

/**
 * Generated Query Resolver for AD_ChartDatasource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartDatasourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ChartDatasourceInput.Table_Name;
	}

	public MChartDatasource AD_ChartDatasourceSave(I_AD_ChartDatasourceInput input, DataFetchingEnvironment environment) {
		return (MChartDatasource) super.save((X_AD_ChartDatasourceInput) input, environment);
	}

	public boolean AD_ChartDatasourceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
