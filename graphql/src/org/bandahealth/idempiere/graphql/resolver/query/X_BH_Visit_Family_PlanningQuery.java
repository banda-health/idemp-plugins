package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Visit_Family_PlanningDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Visit_Family_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_PlanningQuery extends POQuery<MBHVisitFamilyPlanning> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHVisitFamilyPlanning.Table_Name;
	}

	public CompletableFuture<MBHVisitFamilyPlanning> BH_Visit_Family_Planning(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHVisitFamilyPlanning> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Visit_Family_PlanningDataLoader.DATALOADER_BH_Visit_Family_Planning_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHVisitFamilyPlanning> BH_Visit_Family_PlanningGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
