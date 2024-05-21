package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MCommissionLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommission;
import org.compiere.model.MCommissionLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MCommissionResolver extends X_C_CommissionResolver {

	public CompletableFuture<List<MCommissionLine>> C_CommissionLines(MCommission entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MCommissionLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MCommissionLineDataLoader.DATALOADER_C_CommissionLine_BY_C_Commission_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Commission_ID()));
	}
}
