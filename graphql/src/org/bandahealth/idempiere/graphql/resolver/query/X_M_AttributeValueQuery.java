package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeValueDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttributeValue;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeValueQuery extends POQuery<MAttributeValue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttributeValue.Table_Name;
	}

	public CompletableFuture<MAttributeValue> M_AttributeValue(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAttributeValue> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_AttributeValueDataLoader.DATALOADER_M_AttributeValue_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAttributeValue> M_AttributeValueGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
