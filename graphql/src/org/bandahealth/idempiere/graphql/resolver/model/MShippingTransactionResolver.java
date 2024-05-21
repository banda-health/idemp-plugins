package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MShippingTransactionLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MShippingTransaction;
import org.compiere.model.MShippingTransactionLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MShippingTransactionResolver extends X_M_ShippingTransactionResolver {

	public CompletableFuture<List<MShippingTransactionLine>> M_ShippingTransactionLines(MShippingTransaction entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MShippingTransactionLine>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MShippingTransactionLineDataLoader.DATALOADER_M_ShippingTransactionLine_BY_M_ShippingTransaction_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_ShippingTransaction_ID()));
	}
}
