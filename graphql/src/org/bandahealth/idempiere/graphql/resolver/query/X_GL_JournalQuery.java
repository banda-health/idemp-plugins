package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournal;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_Journal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_JournalQuery extends POQuery<MJournal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournal.Table_Name;
	}

	public CompletableFuture<MJournal> GL_Journal(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MJournal> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_JournalDataLoader.DATALOADER_GL_Journal_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MJournal> GL_JournalGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
