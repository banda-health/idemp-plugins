package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MJournalDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalBatch;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MJournalBatchResolver extends X_GL_JournalBatchResolver {

	public CompletableFuture<List<MJournal>> GL_JournalList(MJournalBatch entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MJournal>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MJournalDataLoader.DATALOADER_GL_Journal_BY_GL_JournalBatch_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getGL_JournalBatch_ID()));
	}
}
