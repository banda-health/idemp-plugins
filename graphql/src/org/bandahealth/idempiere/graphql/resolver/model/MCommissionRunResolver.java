package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MCommissionAmtDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommissionAmt;
import org.compiere.model.MCommissionRun;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MCommissionRunResolver extends X_C_CommissionRunResolver {

	public CompletableFuture<List<MCommissionAmt>> C_CommissionAmts(MCommissionRun entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MCommissionAmt>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MCommissionAmtDataLoader.DATALOADER_C_CommissionAmt_BY_C_CommissionRun_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_CommissionRun_ID()));
	}
}
