package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCurrency;
import org.compiere.model.MDepreciationEntry;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Depreciation_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_EntryResolver extends POResolver<MDepreciationEntry> implements GraphQLResolver<MDepreciationEntry> {


	static Map<String, String> A_ENTRY_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDepreciationEntry.A_ENTRY_TYPE_Depreciation, "ac52889b-ad80-4c72-8a90-35eaf234de74");
			put(MDepreciationEntry.A_ENTRY_TYPE_Disposals, "0775c222-fe4d-44bb-9ec1-6bccce458a83");
			put(MDepreciationEntry.A_ENTRY_TYPE_Forecasts, "b8f42168-eb32-4eb2-beda-8d7e1f4cc9e6");
			put(MDepreciationEntry.A_ENTRY_TYPE_New, "1320a810-50d5-4b98-922b-6f04dea06cb8");
			put(MDepreciationEntry.A_ENTRY_TYPE_Splits, "5695ac1e-1cf6-4ef7-9255-16b9c6780643");
			put(MDepreciationEntry.A_ENTRY_TYPE_Transfers, "52189c27-fea7-4c43-a88f-ca2a9b5511a0");
		}
	};
	public CompletableFuture<MRefList> A_Entry_Type_RL(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Entry_Type())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_ENTRY_TYPE_UUIDS_BY_VALUE.get(entity.getA_Entry_Type()));
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.C_AcctSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.C_DocType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.C_Period_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Period_ID());
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDepreciationEntry.DOCACTION_Complete, "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put(MDepreciationEntry.DOCACTION_Approve, "f80665a4-0db1-4609-be56-5d69b762d169");
			put(MDepreciationEntry.DOCACTION_Reject, "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put(MDepreciationEntry.DOCACTION_Post, "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put(MDepreciationEntry.DOCACTION_Void, "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put(MDepreciationEntry.DOCACTION_Close, "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put(MDepreciationEntry.DOCACTION_Reverse_Correct, "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put(MDepreciationEntry.DOCACTION_Reverse_Accrual, "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put(MDepreciationEntry.DOCACTION_Invalidate, "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put(MDepreciationEntry.DOCACTION_Re_Activate, "c8f55635-67a3-42ae-b626-2064acb2e260");
			put(MDepreciationEntry.DOCACTION_None, "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put(MDepreciationEntry.DOCACTION_Prepare, "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put(MDepreciationEntry.DOCACTION_Unlock, "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put(MDepreciationEntry.DOCACTION_WaitComplete, "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList> DocAction_RL(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDepreciationEntry.DOCSTATUS_Drafted, "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put(MDepreciationEntry.DOCSTATUS_Completed, "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put(MDepreciationEntry.DOCSTATUS_Approved, "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put(MDepreciationEntry.DOCSTATUS_NotApproved, "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put(MDepreciationEntry.DOCSTATUS_Voided, "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put(MDepreciationEntry.DOCSTATUS_Invalid, "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put(MDepreciationEntry.DOCSTATUS_Reversed, "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put(MDepreciationEntry.DOCSTATUS_Closed, "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put(MDepreciationEntry.DOCSTATUS_Unknown, "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put(MDepreciationEntry.DOCSTATUS_InProgress, "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put(MDepreciationEntry.DOCSTATUS_WaitingPayment, "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put(MDepreciationEntry.DOCSTATUS_WaitingConfirmation, "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList> DocStatus_RL(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	static Map<String, String> POSTED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDepreciationEntry.POSTED_NotPosted, "f8a3fa32-e816-46b0-8ffa-8f75a9a6f8ce");
			put(MDepreciationEntry.POSTED_Posted, "238cfb09-41c2-43ef-81d3-785f45e69eff");
			put(MDepreciationEntry.POSTED_NotBalanced, "b356ec40-2b7c-45bd-ae61-5f62875b41ac");
			put(MDepreciationEntry.POSTED_NotConvertibleNoRate, "1e0390a8-f7be-4e8b-bd9a-e7c56913f39d");
			put(MDepreciationEntry.POSTED_PeriodClosed, "4afac137-c9db-4bbc-ac61-b0c642f7807e");
			put(MDepreciationEntry.POSTED_PostPrepared, "b2188064-c2e1-4319-8d1d-59145d49842b");
			put(MDepreciationEntry.POSTED_InvalidAccount, "3bd142e3-e397-42b9-ac64-b2c98d970426");
			put(MDepreciationEntry.POSTED_PostingError, "bd259a9b-d9a3-4396-ae5c-124968ae3f4d");
			put(MDepreciationEntry.POSTED_Deferred, "0630b5d2-0fe4-4ef8-9d2f-a14791c02c7d");
		}
	};
	public CompletableFuture<MRefList> Posted_RL(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPosted())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTED_UUIDS_BY_VALUE.get(entity.getPosted()));
	}

	static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDepreciationEntry.POSTINGTYPE_Actual, "3c9d051c-7b7b-459d-90c5-0925e26c1bcc");
			put(MDepreciationEntry.POSTINGTYPE_Budget, "07bbb012-66f2-4860-bd6d-dc511618bf4e");
			put(MDepreciationEntry.POSTINGTYPE_Commitment, "c40ae7b1-be06-4291-ac88-59974f74a46d");
			put(MDepreciationEntry.POSTINGTYPE_Statistical, "6011c5d4-edcc-48f6-ba32-8d820d42dbfb");
			put(MDepreciationEntry.POSTINGTYPE_Reservation, "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5");
		}
	};
	public CompletableFuture<MRefList> PostingType_RL(MDepreciationEntry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

}
