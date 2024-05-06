package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMatchPODataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderLandedCostAllocationDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MMatchPO;
import org.compiere.model.MOrderLandedCostAllocation;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MOrderLineResolver extends X_C_OrderLineResolver {

	public CompletableFuture<List<MOrderLandedCostAllocation>> C_OrderLandedCostAllocationList(MOrderLine_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MOrderLandedCostAllocation>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MOrderLandedCostAllocationDataLoader.DATALOADER_C_OrderLandedCostAllocation_BY_C_OrderLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_OrderLine_ID()));
	}

	public CompletableFuture<List<MInOutLine>> M_InOutLines(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MInOutLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInOutLineDataLoader.DATALOADER_M_InOutLine_BY_C_OrderLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_OrderLine_ID()));
	}

	public CompletableFuture<List<MMatchPO>> M_MatchPOList(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MMatchPO>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MMatchPODataLoader.DATALOADER_M_MatchPO_BY_C_OrderLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_OrderLine_ID()));
	}
}
