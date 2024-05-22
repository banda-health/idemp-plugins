package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MPaySelectionLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPaySelectionLineDataLoader extends X_C_PaySelectionLineDataLoader {
	public static String DATALOADER_C_PaySelectionLine_BY_C_PaySelectionCheck_ID =
			"DATALOADER_C_PaySelectionLine_BY_C_PaySelectionCheck_ID";
	public static String DATALOADER_C_PaySelectionLine_BY_C_PaySelection_ID =
			"DATALOADER_C_PaySelectionLine_BY_C_PaySelection_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_PaySelectionLine_BY_C_PaySelectionCheck_ID,
				DataLoader.newMappedDataLoader(getByPaySelectionCheckIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_PaySelectionLine_BY_C_PaySelection_ID,
				DataLoader.newMappedDataLoader(getByPaySelectionIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPaySelectionLine>> getByPaySelectionCheckIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPaySelectionLine::getC_PaySelectionCheck_ID,
				MPaySelectionLine.COLUMNNAME_C_PaySelectionCheck_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MPaySelectionLine>> getByPaySelectionIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPaySelectionLine::getC_PaySelection_ID,
				MPaySelectionLine.COLUMNNAME_C_PaySelection_ID, keys);
	}
}
