package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MChartDatasourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MChartDatasource;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MChartResolver extends X_AD_ChartResolver {

	public CompletableFuture<List<MChartDatasource>> AD_ChartDatasources(MChart entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MChartDatasource>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MChartDatasourceDataLoader.DATALOADER_AD_ChartDatasource_BY_AD_Chart_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Chart_ID()));
	}
}
