package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MJournalGeneratorSourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MJournalGeneratorLine;
import org.compiere.model.MJournalGeneratorSource;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MJournalGeneratorLineResolver extends X_GL_JournalGeneratorLineResolver {

	public CompletableFuture<List<MJournalGeneratorSource>> GL_JournalGeneratorSources(MJournalGeneratorLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MJournalGeneratorSource>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MJournalGeneratorSourceDataLoader.DATALOADER_GL_JournalGeneratorSource_BY_GL_JournalGeneratorLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getGL_JournalGeneratorLine_ID()));
	}
}
