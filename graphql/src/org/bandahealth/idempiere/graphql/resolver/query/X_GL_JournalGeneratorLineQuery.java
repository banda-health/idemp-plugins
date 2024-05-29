package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalGeneratorLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalGeneratorLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalGeneratorLineQuery extends POQuery<MJournalGeneratorLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalGeneratorLine.Table_Name;
	}

	public CompletableFuture<MJournalGeneratorLine> GL_JournalGeneratorLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MJournalGeneratorLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_JournalGeneratorLineDataLoader.DATALOADER_GL_JournalGeneratorLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MJournalGeneratorLine> GL_JournalGeneratorLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
