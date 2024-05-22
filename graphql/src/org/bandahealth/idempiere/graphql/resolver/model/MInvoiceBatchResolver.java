package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInvoiceBatchLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInvoiceBatch;
import org.compiere.model.MInvoiceBatchLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInvoiceBatchResolver extends X_C_InvoiceBatchResolver {

	public CompletableFuture<List<MInvoiceBatchLine>> C_InvoiceBatchLines(MInvoiceBatch entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInvoiceBatchLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInvoiceBatchLineDataLoader.DATALOADER_C_InvoiceBatchLine_BY_C_InvoiceBatch_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_InvoiceBatch_ID()));
	}
}
