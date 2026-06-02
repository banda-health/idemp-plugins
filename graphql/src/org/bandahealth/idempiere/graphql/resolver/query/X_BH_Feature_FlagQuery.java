package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFeatureFlag;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Feature_FlagDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Feature_Flag - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_FlagQuery extends POQuery<MBHFeatureFlag> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHFeatureFlag.Table_Name;
	}

	public CompletableFuture<MBHFeatureFlag> BH_Feature_Flag(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHFeatureFlag> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Feature_FlagDataLoader.DATALOADER_BH_Feature_Flag_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHFeatureFlag> BH_Feature_FlagGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
