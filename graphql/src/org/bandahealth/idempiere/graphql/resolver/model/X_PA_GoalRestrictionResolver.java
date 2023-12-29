package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_GoalDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MGoal;
import org.compiere.model.MGoalRestriction;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_GoalRestrictionResolver extends POResolver<MGoalRestriction> implements GraphQLResolver<MGoalRestriction> {



	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(MGoalRestriction entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.C_BP_Group_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MGoalRestriction entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}

	static Map<String, String> GOALRESTRICTIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MGoalRestriction.GOALRESTRICTIONTYPE_Organization, "cc49d971-7f08-4a31-8c12-c3d318cb81ef");
			put(MGoalRestriction.GOALRESTRICTIONTYPE_BusinessPartner, "3c91757a-962d-42a0-b378-281fbe889243");
			put(MGoalRestriction.GOALRESTRICTIONTYPE_Product, "d013683b-2c53-407e-a7fa-f83f1b8803d7");
			put(MGoalRestriction.GOALRESTRICTIONTYPE_BusPartnerGroup, "8de8a1da-ba61-4fab-b387-1146ceae5191");
			put(MGoalRestriction.GOALRESTRICTIONTYPE_ProductCategory, "6f38fb28-8838-4e46-81bc-3f2019527c87");
		}
	};
	public CompletableFuture<MRefList> GoalRestrictionType_RL(MGoalRestriction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getGoalRestrictionType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(GOALRESTRICTIONTYPE_UUIDS_BY_VALUE.get(entity.getGoalRestrictionType()));
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(MGoalRestriction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.M_Product_Category_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MGoalRestriction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Goal.
	 *
	 * @return Performance Goal
	 */
	public CompletableFuture<MGoal> PA_Goal(MGoalRestriction entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Goal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MGoal> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_GoalDataLoader.PA_Goal_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_Goal_ID());
	}

}
