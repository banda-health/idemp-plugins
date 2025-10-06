package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_FreightCategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFreightCategory;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_FreightCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_FreightCategoryQuery extends POQuery<MFreightCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFreightCategory.Table_Name;
	}

	public CompletableFuture<MFreightCategory> M_FreightCategory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MFreightCategory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_FreightCategoryDataLoader.DATALOADER_M_FreightCategory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MFreightCategory> M_FreightCategoryGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
