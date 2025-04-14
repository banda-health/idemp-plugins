package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AlertRuleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlertRule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AlertRuleQuery extends POQuery<MAlertRule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlertRule.Table_Name;
	}

	public CompletableFuture<MAlertRule> AD_AlertRule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAlertRule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AlertRuleDataLoader.DATALOADER_AD_AlertRule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAlertRule> AD_AlertRuleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
