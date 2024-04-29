package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRfQResponseLineQtyDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRfQResponseLine;
import org.compiere.model.MRfQResponseLineQty;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRfQResponseLineResolver extends X_C_RfQResponseLineResolver {

	public CompletableFuture<List<MRfQResponseLineQty>> C_RfQResponseLineQtyList(MRfQResponseLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRfQResponseLineQty>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRfQResponseLineQtyDataLoader.DATALOADER_C_RfQResponseLineQty_BY_C_RfQResponseLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_RfQResponseLine_ID()));
	}
}
