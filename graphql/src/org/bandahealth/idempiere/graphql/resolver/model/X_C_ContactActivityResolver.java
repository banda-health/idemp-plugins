package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OpportunityDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MOpportunity;
import org.compiere.model.X_C_ContactActivity;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_ContactActivity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ContactActivityResolver extends POResolver<X_C_ContactActivity> implements GraphQLResolver<X_C_ContactActivity> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_C_ContactActivity entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Sales Opportunity.
	 *
	 * @return Sales Opportunity
	 */
	public CompletableFuture<MOpportunity> C_Opportunity(X_C_ContactActivity entity, DataFetchingEnvironment environment) {
		if (entity.getC_Opportunity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOpportunity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OpportunityDataLoader.DATALOADER_C_Opportunity_BY_ID);
		return dataLoader.load(entity.getC_Opportunity_ID());
	}

	static Map<String, String> CONTACTACTIVITYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("EM", "7aaa10b7-533b-466b-af01-483a2a446410");
			put("PC", "2e5297d8-2465-4010-b344-604c4a9eeb91");
			put("ME", "bda29ee3-2d43-4666-ac94-4603102b3437");
			put("TA", "1a636c57-9c1d-4e9b-b8a1-87530849df3c");
		}
	};
	public CompletableFuture<MRefList_BH> ContactActivityType(X_C_ContactActivity entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getContactActivityType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(CONTACTACTIVITYTYPE_UUIDS_BY_VALUE.get(entity.getContactActivityType()));
	}

	public Boolean IsComplete(X_C_ContactActivity entity, DataFetchingEnvironment environment) {
		return entity.isComplete();
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(X_C_ContactActivity entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}
