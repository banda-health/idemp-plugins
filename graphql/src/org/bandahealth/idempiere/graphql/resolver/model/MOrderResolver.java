package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MOrderResolver extends X_C_OrderResolver {
	public CompletableFuture<List<MInOut_BH>> M_InOuts(MOrder_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MInOut_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MInOutDataLoader.DATALOADER_M_InOut_BY_C_Order_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}

	public CompletableFuture<List<MOrderLine_BH>> C_OrderLines(MOrder_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MOrderLine_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MOrderLineDataLoader.DATALOADER_C_OrderLine_BY_C_Order_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}
}
