package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_BlackListChequeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBlackListCheque;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for U_BlackListCheque - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_U_BlackListChequeQuery extends POQuery<MBlackListCheque> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBlackListCheque.Table_Name;
	}

	public CompletableFuture<MBlackListCheque> U_BlackListCheque(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBlackListCheque> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_U_BlackListChequeDataLoader.DATALOADER_U_BlackListCheque_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBlackListCheque> U_BlackListChequeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
