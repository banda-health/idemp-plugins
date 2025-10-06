package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalBatchDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalBatch;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_JournalBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_JournalBatchQuery extends POQuery<MJournalBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalBatch.Table_Name;
	}

	public CompletableFuture<MJournalBatch> GL_JournalBatch(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MJournalBatch> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_JournalBatchDataLoader.DATALOADER_GL_JournalBatch_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MJournalBatch> GL_JournalBatchGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
