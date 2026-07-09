package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningLarcRemovalReason;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Visit_Family_PlanningDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Visit_Family_Planning_Larc_Removal_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_Larc_Removal_ReasonResolver extends POResolver<MBHVisitFamilyPlanningLarcRemovalReason> implements GraphQLResolver<MBHVisitFamilyPlanningLarcRemovalReason> {


	public static Map<String, String> BH_LARC_REMOVAL_REASON_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("maturity", "9b447846-f85e-472c-86a7-3c35b5d6d169"); // Maturity
			put("desireToConceive", "2815d721-777c-4e89-99df-1852784beca0"); // Desire to conceive
			put("healthConcernsSideEffects", "055148ea-b8b8-43ae-aae6-4b4a097c9c7c"); // Health concerns/side effects
			put("methodSwitch", "198d26ea-9e8c-43ea-95bd-ce2076e691f6"); // Method switch
			put("methodFailure", "124ada25-1fbd-45ea-826c-ff96f43b89b5"); // Method failure
			put("others", "def70b72-e781-4e21-9182-e97292ed053a"); // Others
		}
	};
	public CompletableFuture<MRefList_BH> BH_Larc_Removal_Reason(MBHVisitFamilyPlanningLarcRemovalReason entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Larc_Removal_Reason())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_LARC_REMOVAL_REASON_UUIDS_BY_VALUE.get(entity.getBH_Larc_Removal_Reason()));
	}


	/**
	 * Get Visit Family Planning.
	 *
	 * @return Visit Family Planning
	 */
	public CompletableFuture<MBHVisitFamilyPlanning> BH_Visit_Family_Planning(MBHVisitFamilyPlanningLarcRemovalReason entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Visit_Family_Planning_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHVisitFamilyPlanning> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Visit_Family_PlanningDataLoader.DATALOADER_BH_Visit_Family_Planning_BY_ID);
		return dataLoader.load(entity.getBH_Visit_Family_Planning_ID());
	}

}
