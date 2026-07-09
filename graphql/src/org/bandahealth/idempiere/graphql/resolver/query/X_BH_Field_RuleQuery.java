package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFieldRule;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Field_RuleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Field_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Field_RuleQuery extends POQuery<MBHFieldRule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHFieldRule.Table_Name;
	}

	public CompletableFuture<MBHFieldRule> BH_Field_Rule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHFieldRule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Field_RuleDataLoader.DATALOADER_BH_Field_Rule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHFieldRule> BH_Field_RuleGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
