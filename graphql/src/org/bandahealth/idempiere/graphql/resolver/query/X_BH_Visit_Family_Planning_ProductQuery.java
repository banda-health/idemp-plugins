package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningProduct;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Visit_Family_Planning_ProductDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Visit_Family_Planning_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_ProductQuery extends POQuery<MBHVisitFamilyPlanningProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHVisitFamilyPlanningProduct.Table_Name;
	}

	public CompletableFuture<MBHVisitFamilyPlanningProduct> BH_Visit_Family_Planning_Product(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHVisitFamilyPlanningProduct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Visit_Family_Planning_ProductDataLoader.DATALOADER_BH_Visit_Family_Planning_Product_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHVisitFamilyPlanningProduct> BH_Visit_Family_Planning_ProductGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
