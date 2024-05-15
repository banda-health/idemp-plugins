package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MJournalGeneratorSource;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MJournalGeneratorSourceDataLoader extends X_GL_JournalGeneratorSourceDataLoader {
	public static String DATALOADER_GL_JournalGeneratorSource_BY_GL_JournalGeneratorLine_ID =
			"DATALOADER_GL_JournalGeneratorSource_BY_GL_JournalGeneratorLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_GL_JournalGeneratorSource_BY_GL_JournalGeneratorLine_ID,
				DataLoader.newMappedDataLoader(getByJournalGeneratorLineIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MJournalGeneratorSource>> getByJournalGeneratorLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null,
				MJournalGeneratorSource::getGL_JournalGeneratorLine_ID,
				MJournalGeneratorSource.COLUMNNAME_GL_JournalGeneratorLine_ID, keys);
	}
}
