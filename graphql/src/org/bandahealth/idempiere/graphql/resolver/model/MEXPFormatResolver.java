package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MEXPFormatLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPFormat;
import org.compiere.model.MEXPFormatLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MEXPFormatResolver extends X_EXP_FormatResolver {

	public CompletableFuture<List<MEXPFormatLine>> EXP_FormatLines(MEXPFormat entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MEXPFormatLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MEXPFormatLineDataLoader.DATALOADER_EXP_FormatLine_BY_EXP_Format_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getEXP_Format_ID()));
	}
}
