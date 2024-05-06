package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MChartDatasource;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MChartDatasourceDataLoader extends X_AD_ChartDatasourceDataLoader {
	public static String DATALOADER_AD_ChartDatasource_BY_AD_Chart_ID = "DATALOADER_AD_ChartDatasource_BY_AD_Chart_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_ChartDatasource_BY_AD_Chart_ID,
				DataLoader.newMappedDataLoader(getByChartIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MChartDatasource>> getByChartIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MChartDatasource::getAD_Chart_ID,
				MChartDatasource.COLUMNNAME_AD_Chart_ID, keys);
	}
}
