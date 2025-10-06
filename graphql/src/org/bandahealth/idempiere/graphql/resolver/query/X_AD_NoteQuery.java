package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_NoteDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MNote;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_NoteQuery extends POQuery<MNote> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MNote.Table_Name;
	}

	public CompletableFuture<MNote> AD_Note(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MNote> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_NoteDataLoader.DATALOADER_AD_Note_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MNote> AD_NoteGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
