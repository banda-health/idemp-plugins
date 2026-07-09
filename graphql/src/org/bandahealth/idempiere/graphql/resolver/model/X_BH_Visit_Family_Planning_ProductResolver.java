package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningProduct;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Visit_Family_PlanningDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Visit_Family_Planning_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_ProductResolver extends POResolver<MBHVisitFamilyPlanningProduct> implements GraphQLResolver<MBHVisitFamilyPlanningProduct> {


	public static Map<String, String> BH_FP_METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("oralContraceptive", "6dd430b1-61a1-402c-ad91-5acdd9f8f711"); // Oral contraceptive
			put("injectable", "108b3f54-9578-457c-ab10-16ccb7a57a3d"); // Injectable
			put("implants", "a7ca85eb-7703-4039-a02a-2c8364e4f529"); // Implants
			put("emergencyContraception", "8a044f84-a5e0-44b2-afff-8db4ec3c051b"); // Emergency contraception
			put("iucd", "18d22cae-6b83-40ce-b7f2-15e474d2ea6f"); // IUCD
			put("condomsForFp", "4253b3cb-4e3b-4caf-b07e-ca058fb7fff6"); // Condoms
			put("cycleBeads", "e6f4ae75-5b94-46c9-adb4-c328468b84ee"); // Cycle beads
		}
	};
	public CompletableFuture<MRefList_BH> BH_Fp_Method(MBHVisitFamilyPlanningProduct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Fp_Method())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_FP_METHOD_UUIDS_BY_VALUE.get(entity.getBH_Fp_Method()));
	}

	public static Map<String, String> BH_LINE_ROLE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("male", "a8990a74-aa5e-47d7-8a2f-7fdb0f5cfaf1"); // Male
			put("female", "ba10b443-1ed3-420d-b4bf-2a8268ca934e"); // Female
		}
	};
	public CompletableFuture<MRefList_BH> BH_Line_Role(MBHVisitFamilyPlanningProduct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Line_Role())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_LINE_ROLE_UUIDS_BY_VALUE.get(entity.getBH_Line_Role()));
	}


	/**
	 * Get Visit Family Planning.
	 *
	 * @return Visit Family Planning
	 */
	public CompletableFuture<MBHVisitFamilyPlanning> BH_Visit_Family_Planning(MBHVisitFamilyPlanningProduct entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Visit_Family_Planning_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHVisitFamilyPlanning> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Visit_Family_PlanningDataLoader.DATALOADER_BH_Visit_Family_Planning_BY_ID);
		return dataLoader.load(entity.getBH_Visit_Family_Planning_ID());
	}


	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	public CompletableFuture<MOrderLine_BH> C_OrderLine(MBHVisitFamilyPlanningProduct entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.DATALOADER_C_OrderLine_BY_ID);
		return dataLoader.load(entity.getC_OrderLine_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MBHVisitFamilyPlanningProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
