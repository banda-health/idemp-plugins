package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MCash;
import org.compiere.model.MCashBook;
import org.compiere.model.MElementValue;
import org.compiere.model.MProject;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Cash - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashResolver extends POResolver<MCash> implements GraphQLResolver<MCash> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MCash entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.C_Activity_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MCash entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.C_Campaign_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	public CompletableFuture<MCashBook> C_CashBook(MCash entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashBook_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.C_CashBook_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_CashBook_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MCash entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MCash.DOCACTION_Complete, "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put(MCash.DOCACTION_Approve, "f80665a4-0db1-4609-be56-5d69b762d169");
			put(MCash.DOCACTION_Reject, "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put(MCash.DOCACTION_Post, "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put(MCash.DOCACTION_Void, "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put(MCash.DOCACTION_Close, "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put(MCash.DOCACTION_Reverse_Correct, "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put(MCash.DOCACTION_Reverse_Accrual, "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put(MCash.DOCACTION_Invalidate, "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put(MCash.DOCACTION_Re_Activate, "c8f55635-67a3-42ae-b626-2064acb2e260");
			put(MCash.DOCACTION_None, "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put(MCash.DOCACTION_Prepare, "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put(MCash.DOCACTION_Unlock, "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put(MCash.DOCACTION_WaitComplete, "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList> DocAction_RL(MCash entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MCash.DOCSTATUS_Drafted, "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put(MCash.DOCSTATUS_Completed, "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put(MCash.DOCSTATUS_Approved, "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put(MCash.DOCSTATUS_NotApproved, "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put(MCash.DOCSTATUS_Voided, "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put(MCash.DOCSTATUS_Invalid, "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put(MCash.DOCSTATUS_Reversed, "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put(MCash.DOCSTATUS_Closed, "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put(MCash.DOCSTATUS_Unknown, "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put(MCash.DOCSTATUS_InProgress, "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put(MCash.DOCSTATUS_WaitingPayment, "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put(MCash.DOCSTATUS_WaitingConfirmation, "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList> DocStatus_RL(MCash entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	static Map<String, String> POSTED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MCash.POSTED_NotPosted, "f8a3fa32-e816-46b0-8ffa-8f75a9a6f8ce");
			put(MCash.POSTED_Posted, "238cfb09-41c2-43ef-81d3-785f45e69eff");
			put(MCash.POSTED_NotBalanced, "b356ec40-2b7c-45bd-ae61-5f62875b41ac");
			put(MCash.POSTED_NotConvertibleNoRate, "1e0390a8-f7be-4e8b-bd9a-e7c56913f39d");
			put(MCash.POSTED_PeriodClosed, "4afac137-c9db-4bbc-ac61-b0c642f7807e");
			put(MCash.POSTED_PostPrepared, "b2188064-c2e1-4319-8d1d-59145d49842b");
			put(MCash.POSTED_InvalidAccount, "3bd142e3-e397-42b9-ac64-b2c98d970426");
			put(MCash.POSTED_PostingError, "bd259a9b-d9a3-4396-ae5c-124968ae3f4d");
			put(MCash.POSTED_Deferred, "0630b5d2-0fe4-4ef8-9d2f-a14791c02c7d");
		}
	};
	public CompletableFuture<MRefList> Posted_RL(MCash entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPosted())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTED_UUIDS_BY_VALUE.get(entity.getPosted()));
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MCash entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(MCash entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUser2_ID());
	}

}
