package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalGeneratorSourceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalGeneratorSource;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_JournalGeneratorSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_JournalGeneratorSourceQuery extends POQuery<MJournalGeneratorSource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalGeneratorSource.Table_Name;
	}

	public CompletableFuture<MJournalGeneratorSource> GL_JournalGeneratorSource(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MJournalGeneratorSource> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_JournalGeneratorSourceDataLoader.DATALOADER_GL_JournalGeneratorSource_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MJournalGeneratorSource> GL_JournalGeneratorSourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
