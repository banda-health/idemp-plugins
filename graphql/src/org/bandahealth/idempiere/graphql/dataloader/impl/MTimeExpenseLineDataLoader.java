package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MTimeExpenseLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MTimeExpenseLineDataLoader extends X_S_TimeExpenseLineDataLoader {
	public static String DATALOADER_S_TimeExpenseLine_BY_S_TimeExpense_ID =
			"DATALOADER_S_TimeExpenseLine_BY_S_TimeExpense_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_S_TimeExpenseLine_BY_S_TimeExpense_ID,
				DataLoader.newMappedDataLoader(getByTimeExpenseIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MTimeExpenseLine>> getByTimeExpenseIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MTimeExpenseLine::getS_TimeExpense_ID,
				MTimeExpenseLine.COLUMNNAME_S_TimeExpense_ID, keys);
	}
}
