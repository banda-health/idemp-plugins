package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Attribute_ValueDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Attribute_Value;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Attribute_Value - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Attribute_ValueQuery extends POQuery<X_AD_Attribute_Value> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Attribute_Value.Table_Name;
	}

	public CompletableFuture<X_AD_Attribute_Value> AD_Attribute_Value(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Attribute_Value> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Attribute_ValueDataLoader.DATALOADER_AD_Attribute_Value_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Attribute_Value> AD_Attribute_ValueGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
