package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDiscountSchemaBreakDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDiscountSchemaLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDiscountSchemaBreak;
import org.compiere.model.MDiscountSchemaLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MDiscountSchemaResolver extends X_M_DiscountSchemaResolver {

	public CompletableFuture<List<MDiscountSchemaLine>> M_DiscountSchemaLines(MDiscountSchema entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDiscountSchemaLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDiscountSchemaLineDataLoader.DATALOADER_M_DiscountSchemaLine_BY_M_DiscountSchema_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_DiscountSchema_ID()));
	}

	public CompletableFuture<List<MDiscountSchemaBreak>> M_DiscountSchemaBreaks(MDiscountSchema entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDiscountSchemaBreak>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDiscountSchemaBreakDataLoader.DATALOADER_M_DiscountSchemaBreak_BY_M_DiscountSchema_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_DiscountSchema_ID()));
	}
}
