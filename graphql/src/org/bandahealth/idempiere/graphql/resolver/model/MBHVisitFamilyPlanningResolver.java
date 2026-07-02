package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningLarcRemovalReason;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningProduct;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitFamilyPlanningLarcRemovalReasonDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitFamilyPlanningProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHVisitFamilyPlanningResolver extends X_BH_Visit_Family_PlanningResolver {

	public CompletableFuture<List<MBHVisitFamilyPlanningProduct>> BH_Visit_Family_Planning_Products(
			MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHVisitFamilyPlanningProduct>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(
						MBHVisitFamilyPlanningProductDataLoader.DATALOADER_BH_Visit_Family_Planning_Product_BY_BH_Visit_Family_Planning_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_Family_Planning_ID()));
	}

	public CompletableFuture<List<MBHVisitFamilyPlanningLarcRemovalReason>> BH_Larc_Removal_Reasons(
			MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHVisitFamilyPlanningLarcRemovalReason>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(
						MBHVisitFamilyPlanningLarcRemovalReasonDataLoader.DATALOADER_BH_Visit_Family_Planning_Larc_Removal_Reason_BY_BH_Visit_Family_Planning_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_Family_Planning_ID()));
	}
}
