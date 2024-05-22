package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MPeriodControl;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPeriodControlDataLoader extends X_C_PeriodControlDataLoader {
	public static String DATALOADER_C_PeriodControl_BY_C_Period_ID = "DATALOADER_C_PeriodControl_BY_C_Period_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_PeriodControl_BY_C_Period_ID,
				DataLoader.newMappedDataLoader(getByPeriodIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPeriodControl>> getByPeriodIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPeriodControl::getC_Period_ID,
				MPeriodControl.COLUMNNAME_C_Period_ID, keys);
	}
}
