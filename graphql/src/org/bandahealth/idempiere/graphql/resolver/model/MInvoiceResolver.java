package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAllocationLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAllocationLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInvoiceResolver extends X_C_InvoiceResolver {
	public CompletableFuture<List<MAllocationLine>> C_AllocationLines(MInvoice_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAllocationLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAllocationLineDataLoader.DATALOADER_C_AllocationLineByC_Invoice_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Invoice_ID()));
	}
}
