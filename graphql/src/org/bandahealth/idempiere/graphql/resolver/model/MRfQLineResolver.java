package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRfQLineQtyDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRfQLine;
import org.compiere.model.MRfQLineQty;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRfQLineResolver extends X_C_RfQLineResolver {

	public CompletableFuture<List<MRfQLineQty>> C_RfQLineQtyList(MRfQLine entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MRfQLineQty>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRfQLineQtyDataLoader.DATALOADER_C_RfQLineQty_BY_C_RfQLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_RfQLine_ID()));
	}
}
