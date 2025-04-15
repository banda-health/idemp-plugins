package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_JournalLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_JournalLineQuery extends POQuery<MJournalLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalLine.Table_Name;
	}

	public CompletableFuture<MJournalLine> GL_JournalLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MJournalLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_JournalLineDataLoader.DATALOADER_GL_JournalLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MJournalLine> GL_JournalLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
