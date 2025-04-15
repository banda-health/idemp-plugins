package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AttributeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Attribute;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AttributeQuery extends POQuery<X_AD_Attribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Attribute.Table_Name;
	}

	public CompletableFuture<X_AD_Attribute> AD_Attribute(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Attribute> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AttributeDataLoader.DATALOADER_AD_Attribute_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Attribute> AD_AttributeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
