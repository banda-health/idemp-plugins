package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MValRule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Val_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Val_RuleQuery extends POQuery<MValRule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MValRule.Table_Name;
	}

	public CompletableFuture<MValRule> AD_Val_Rule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MValRule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MValRule> AD_Val_RuleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
