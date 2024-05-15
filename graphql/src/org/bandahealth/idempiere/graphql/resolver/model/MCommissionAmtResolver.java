package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MCommissionDetailDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommissionAmt;
import org.compiere.model.MCommissionDetail;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MCommissionAmtResolver extends X_C_CommissionAmtResolver {

	public CompletableFuture<List<MCommissionDetail>> C_CommissionDetails(MCommissionAmt entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MCommissionDetail>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MCommissionDetailDataLoader.DATALOADER_C_CommissionDetail_BY_C_CommissionAmt_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_CommissionAmt_ID()));
	}
}
