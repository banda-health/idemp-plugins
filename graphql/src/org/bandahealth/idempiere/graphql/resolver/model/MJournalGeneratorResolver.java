package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MJournalGeneratorLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MJournalGenerator;
import org.compiere.model.MJournalGeneratorLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MJournalGeneratorResolver extends X_GL_JournalGeneratorResolver {

	public CompletableFuture<List<MJournalGeneratorLine>> GL_JournalGeneratorLines(MJournalGenerator entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MJournalGeneratorLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MJournalGeneratorLineDataLoader.DATALOADER_GL_JournalGeneratorLine_BY_GL_JournalGenerator_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getGL_JournalGenerator_ID()));
	}
}
