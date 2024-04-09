package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MIndexColumnDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MIndexColumn;
import org.compiere.model.MTableIndex;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MTableIndexResolver extends X_AD_TableIndexResolver {

	public CompletableFuture<List<MIndexColumn>> AD_IndexColumns(MTableIndex entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MIndexColumn>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MIndexColumnDataLoader.DATALOADER_AD_IndexColumn_BY_AD_TableIndex_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_TableIndex_ID()));
	}
}
