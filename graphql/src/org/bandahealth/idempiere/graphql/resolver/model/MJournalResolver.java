package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MJournalLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MJournalResolver extends X_GL_JournalResolver {

	public CompletableFuture<List<MJournalLine>> GL_JournalLines(MJournal entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MJournalLine>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MJournalLineDataLoader.DATALOADER_GL_JournalLine_BY_GL_Journal_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getGL_Journal_ID()));
	}
}
