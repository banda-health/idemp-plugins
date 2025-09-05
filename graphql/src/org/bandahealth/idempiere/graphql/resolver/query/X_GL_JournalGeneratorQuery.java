package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalGeneratorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalGenerator;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_JournalGenerator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_JournalGeneratorQuery extends POQuery<MJournalGenerator> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalGenerator.Table_Name;
	}

	public CompletableFuture<MJournalGenerator> GL_JournalGenerator(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MJournalGenerator> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_JournalGeneratorDataLoader.DATALOADER_GL_JournalGenerator_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MJournalGenerator> GL_JournalGeneratorGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
