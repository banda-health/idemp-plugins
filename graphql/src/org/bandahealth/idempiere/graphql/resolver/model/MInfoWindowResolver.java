package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInfoColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInfoProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInfoRelatedDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MInfoWindow;
import org.compiere.model.X_AD_InfoProcess;
import org.compiere.model.X_AD_InfoRelated;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInfoWindowResolver extends X_AD_InfoWindowResolver {

	public CompletableFuture<List<MInfoColumn>> AD_InfoColumns(MInfoWindow entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInfoColumn>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInfoColumnDataLoader.DATALOADER_AD_InfoColumn_BY_AD_InfoWindow_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_InfoWindow_ID()));
	}

	public CompletableFuture<List<X_AD_InfoProcess>> AD_InfoProcesses(MInfoWindow entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<X_AD_InfoProcess>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInfoProcessDataLoader.DATALOADER_AD_InfoRelated_BY_AD_InfoWindow_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_InfoWindow_ID()));
	}

	public CompletableFuture<List<X_AD_InfoRelated>> AD_InfoRelatedList(MInfoWindow entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<X_AD_InfoRelated>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInfoRelatedDataLoader.DATALOADER_AD_InfoRelated_BY_AD_InfoWindow_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_InfoWindow_ID()));
	}
}
