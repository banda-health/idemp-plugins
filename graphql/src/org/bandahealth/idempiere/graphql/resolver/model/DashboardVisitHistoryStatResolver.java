package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRefListDataLoader;
import org.bandahealth.idempiere.graphql.model.DashboardVisitHistoryStat;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class DashboardVisitHistoryStatResolver implements GraphQLResolver<DashboardVisitHistoryStat> {

	public CompletableFuture<MRefList_BH> BH_PatientType(DashboardVisitHistoryStat Entity,
			DataFetchingEnvironment environment) {
		if (Entity.getReferenceListId() == null || Entity.getReferenceListId() < 1) {
			return null;
		}
		DataLoader<Integer, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MRefListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(Entity.getReferenceListId());
	}
}
