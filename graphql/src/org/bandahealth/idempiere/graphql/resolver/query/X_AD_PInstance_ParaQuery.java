package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstance_ParaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPInstancePara;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PInstance_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PInstance_ParaQuery extends POQuery<MPInstancePara> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPInstancePara.Table_Name;
	}

	public CompletableFuture<MPInstancePara> AD_PInstance_Para(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPInstancePara> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PInstance_ParaDataLoader.DATALOADER_AD_PInstance_Para_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPInstancePara> AD_PInstance_ParaGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
