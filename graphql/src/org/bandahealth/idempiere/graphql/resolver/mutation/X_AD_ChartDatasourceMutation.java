package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ChartDatasourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ChartDatasourceInput;
import org.compiere.model.MChartDatasource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ChartDatasource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ChartDatasourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ChartDatasourceInput.Table_Name;
	}

	public MChartDatasource AD_ChartDatasourceSave(I_AD_ChartDatasourceInput Entity, DataFetchingEnvironment environment) {
		return (MChartDatasource) super.save((X_AD_ChartDatasourceInput) Entity, environment);
	}

	public List<MChartDatasource> AD_ChartDatasourceSaveMany(List<I_AD_ChartDatasourceInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ChartDatasourceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MChartDatasource) entity).collect(Collectors.toList());
	}

	public boolean AD_ChartDatasourceDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
