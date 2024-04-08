package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MJournalGeneratorLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MJournalGeneratorLineDataLoader extends X_GL_JournalGeneratorLineDataLoader {
	public static String DATALOADER_GL_JournalGeneratorLine_BY_GL_JournalGenerator_ID =
			"DATALOADER_GL_JournalGeneratorLine_BY_GL_JournalGenerator_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_GL_JournalGeneratorLine_BY_GL_JournalGenerator_ID,
				DataLoader.newMappedDataLoader(getByJournalGeneratorIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MJournalGeneratorLine>> getByJournalGeneratorIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MJournalGeneratorLine::getGL_JournalGenerator_ID,
				MJournalGeneratorLine.COLUMNNAME_GL_JournalGenerator_ID, keys);
	}
}
