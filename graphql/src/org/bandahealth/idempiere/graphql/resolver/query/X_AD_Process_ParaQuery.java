package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Process_ParaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProcessPara;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Process_ParaQuery extends POQuery<MProcessPara> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProcessPara.Table_Name;
	}

	public CompletableFuture<MProcessPara> AD_Process_Para(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProcessPara> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Process_ParaDataLoader.DATALOADER_AD_Process_Para_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProcessPara> AD_Process_ParaGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
