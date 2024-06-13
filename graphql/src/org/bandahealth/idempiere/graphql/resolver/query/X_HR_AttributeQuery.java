package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_AttributeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Attribute;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_AttributeQuery extends POQuery<X_HR_Attribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Attribute.Table_Name;
	}

	public CompletableFuture<X_HR_Attribute> HR_Attribute(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Attribute> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_AttributeDataLoader.DATALOADER_HR_Attribute_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Attribute> HR_AttributeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
