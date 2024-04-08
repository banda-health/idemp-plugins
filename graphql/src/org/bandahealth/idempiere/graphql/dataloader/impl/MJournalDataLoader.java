package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MJournal;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MJournalDataLoader extends X_GL_JournalDataLoader {
	public static String DATALOADER_GL_Journal_BY_GL_JournalBatch_ID = "DATALOADER_GL_Journal_BY_GL_JournalBatch_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_GL_Journal_BY_GL_JournalBatch_ID,
				DataLoader.newMappedDataLoader(getByGLJournalBatchIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MJournal>> getByGLJournalBatchIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MJournal::getGL_JournalBatch_ID,
				MJournal.COLUMNNAME_GL_JournalBatch_ID, keys);
	}
}
