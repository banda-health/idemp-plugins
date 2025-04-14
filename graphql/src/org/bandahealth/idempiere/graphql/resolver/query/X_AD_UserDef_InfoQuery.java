package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_InfoDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefInfo;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserDef_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDef_InfoQuery extends POQuery<MUserDefInfo> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefInfo.Table_Name;
	}

	public CompletableFuture<MUserDefInfo> AD_UserDef_Info(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserDefInfo> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDef_InfoDataLoader.DATALOADER_AD_UserDef_Info_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserDefInfo> AD_UserDef_InfoGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
