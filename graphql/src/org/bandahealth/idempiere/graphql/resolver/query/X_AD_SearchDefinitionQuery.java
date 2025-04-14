package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SearchDefinitionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSearchDefinition;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_SearchDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SearchDefinitionQuery extends POQuery<MSearchDefinition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSearchDefinition.Table_Name;
	}

	public CompletableFuture<MSearchDefinition> AD_SearchDefinition(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSearchDefinition> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_SearchDefinitionDataLoader.DATALOADER_AD_SearchDefinition_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSearchDefinition> AD_SearchDefinitionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
