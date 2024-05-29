package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_WinDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefWin;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserDef_Win - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_WinQuery extends POQuery<MUserDefWin> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefWin.Table_Name;
	}

	public CompletableFuture<MUserDefWin> AD_UserDef_Win(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserDefWin> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDef_WinDataLoader.DATALOADER_AD_UserDef_Win_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserDefWin> AD_UserDef_WinGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
