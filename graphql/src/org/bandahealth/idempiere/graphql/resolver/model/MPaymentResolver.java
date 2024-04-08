package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAllocationLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPaymentAllocateDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MPaymentAllocate;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPaymentResolver extends X_C_PaymentResolver {
	public CompletableFuture<List<MAllocationLine>> C_AllocationLines(MPayment_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAllocationLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAllocationLineDataLoader.DATALOADER_C_AllocationLine_BY_C_Payment_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Payment_ID()));
	}

	public CompletableFuture<List<MPaymentAllocate>> C_PaymentAllocateList(MPayment_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MPaymentAllocate>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPaymentAllocateDataLoader.DATALOADER_C_PaymentAllocate_BY_C_Payment_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Payment_ID()));
	}
}
