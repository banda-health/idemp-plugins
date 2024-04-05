package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDepositBatchLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDepositBatch;
import org.compiere.model.MDepositBatchLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MDepositBatchResolver extends X_C_DepositBatchResolver {

	public CompletableFuture<List<MDepositBatchLine>> C_DepositBatchLines(MDepositBatch entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDepositBatchLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDepositBatchLineDataLoader.DATALOADER_C_DepositBatchLine_BY_C_DepositBatch_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_DepositBatch_ID()));
	}
}
