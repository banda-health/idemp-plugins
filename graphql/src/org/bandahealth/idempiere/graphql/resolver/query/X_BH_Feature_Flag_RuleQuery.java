package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Feature_Flag_RuleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Feature_Flag_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_Flag_RuleQuery extends POQuery<MBHFeatureFlagRule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHFeatureFlagRule.Table_Name;
	}

	public CompletableFuture<MBHFeatureFlagRule> BH_Feature_Flag_Rule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHFeatureFlagRule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Feature_Flag_RuleDataLoader.DATALOADER_BH_Feature_Flag_Rule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHFeatureFlagRule> BH_Feature_Flag_RuleGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
