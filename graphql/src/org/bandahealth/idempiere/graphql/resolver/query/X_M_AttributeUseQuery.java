package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeUseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttributeUse;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeUseQuery extends POQuery<MAttributeUse> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttributeUse.Table_Name;
	}

	public CompletableFuture<MAttributeUse> M_AttributeUse(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAttributeUse> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_AttributeUseDataLoader.DATALOADER_M_AttributeUse_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAttributeUse> M_AttributeUseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
