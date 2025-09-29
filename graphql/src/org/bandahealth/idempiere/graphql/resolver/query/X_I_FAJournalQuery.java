package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_FAJournalDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MXIFAJournal;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_FAJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_FAJournalQuery extends POQuery<MXIFAJournal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MXIFAJournal.Table_Name;
	}

	public CompletableFuture<MXIFAJournal> I_FAJournal(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MXIFAJournal> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_FAJournalDataLoader.DATALOADER_I_FAJournal_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MXIFAJournal> I_FAJournalGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
