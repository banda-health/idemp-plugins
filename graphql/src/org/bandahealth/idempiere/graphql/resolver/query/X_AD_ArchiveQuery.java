package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ArchiveDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MArchive;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Archive - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ArchiveQuery extends POQuery<MArchive> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MArchive.Table_Name;
	}

	public CompletableFuture<MArchive> AD_Archive(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MArchive> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ArchiveDataLoader.DATALOADER_AD_Archive_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MArchive> AD_ArchiveGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
