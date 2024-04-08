package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPaySelectionLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPaySelectionCheck;
import org.compiere.model.MPaySelectionLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPaySelectionCheckResolver extends X_C_PaySelectionCheckResolver {

	public CompletableFuture<List<MPaySelectionLine>> C_PaySelectionLines(MPaySelectionCheck entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MPaySelectionLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPaySelectionLineDataLoader.DATALOADER_C_PaySelectionLine_BY_C_PaySelectionCheck_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_PaySelectionCheck_ID()));
	}
}
