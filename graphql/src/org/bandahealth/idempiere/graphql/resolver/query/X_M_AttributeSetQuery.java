package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_AttributeSetQuery extends POQuery<MAttributeSet_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttributeSet_BH.Table_Name;
	}

	public CompletableFuture<MAttributeSet_BH> M_AttributeSet(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAttributeSet_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_AttributeSetDataLoader.DATALOADER_M_AttributeSet_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAttributeSet_BH> M_AttributeSetGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
