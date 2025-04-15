package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductPO_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_PODataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Product_PO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_Product_POQuery extends POQuery<MProductPO_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductPO_BH.Table_Name;
	}

	public CompletableFuture<MProductPO_BH> M_Product_PO(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProductPO_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_PODataLoader.DATALOADER_M_Product_PO_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProductPO_BH> M_Product_POGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
