package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPeriodControlDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPeriod;
import org.compiere.model.MPeriodControl;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPeriodResolver extends X_C_PeriodResolver {

	public CompletableFuture<List<MPeriodControl>> C_PeriodControls(MPeriod entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MPeriodControl>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPeriodControlDataLoader.DATALOADER_C_PeriodControl_BY_C_Period_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Period_ID()));
	}
}
