package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Record_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecordAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Record_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Record_AccessQuery extends POQuery<MRecordAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecordAccess.Table_Name;
	}

	public CompletableFuture<MRecordAccess> AD_Record_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRecordAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Record_AccessDataLoader.DATALOADER_AD_Record_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRecordAccess> AD_Record_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
