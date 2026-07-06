package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningLarcRemovalReason;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Visit_Family_Planning_Larc_Removal_ReasonDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Visit_Family_Planning_Larc_Removal_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_Larc_Removal_ReasonQuery extends POQuery<MBHVisitFamilyPlanningLarcRemovalReason> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHVisitFamilyPlanningLarcRemovalReason.Table_Name;
	}

	public CompletableFuture<MBHVisitFamilyPlanningLarcRemovalReason> BH_Visit_Family_Planning_Larc_Removal_Reason(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHVisitFamilyPlanningLarcRemovalReason> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Visit_Family_Planning_Larc_Removal_ReasonDataLoader.DATALOADER_BH_Visit_Family_Planning_Larc_Removal_Reason_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHVisitFamilyPlanningLarcRemovalReason> BH_Visit_Family_Planning_Larc_Removal_ReasonGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
