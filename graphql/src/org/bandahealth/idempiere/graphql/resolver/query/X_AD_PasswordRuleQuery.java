package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PasswordRuleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPasswordRule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PasswordRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PasswordRuleQuery extends POQuery<MPasswordRule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPasswordRule.Table_Name;
	}

	public CompletableFuture<MPasswordRule> AD_PasswordRule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPasswordRule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PasswordRuleDataLoader.DATALOADER_AD_PasswordRule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPasswordRule> AD_PasswordRuleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
