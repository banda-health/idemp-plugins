package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MEXPFormatLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MEXPFormatLineDataLoader extends X_EXP_FormatLineDataLoader {
	public static String DATALOADER_EXP_FormatLine_BY_EXP_Format_ID = "DATALOADER_EXP_FormatLine_BY_EXP_Format_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_EXP_FormatLine_BY_EXP_Format_ID,
				DataLoader.newMappedDataLoader(getByFormatIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MEXPFormatLine>> getByFormatIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MEXPFormatLine::getEXP_Format_ID,
				MEXPFormatLine.COLUMNNAME_EXP_Format_ID, keys);
	}
}
