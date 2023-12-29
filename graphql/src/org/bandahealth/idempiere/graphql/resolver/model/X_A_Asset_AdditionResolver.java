package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalBatchDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_FixedAssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MatchInvDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAddition;
import org.compiere.model.MConversionType;
import org.compiere.model.MCurrency;
import org.compiere.model.MIFixedAsset;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MLocator;
import org.compiere.model.MMatchInv;
import org.compiere.model.MProject;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_AdditionResolver extends POResolver<MAssetAddition> implements GraphQLResolver<MAssetAddition> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.A_Asset_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_ID());
	}

	static Map<String, String> A_CAPVSEXP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetAddition.A_CAPVSEXP_Capital, "f494c22f-2ce5-471d-aabb-887f528c60da");
			put(MAssetAddition.A_CAPVSEXP_Expense, "4a84ac91-9720-40a2-8529-6a139dabb96a");
		}
	};
	public CompletableFuture<MRefList> A_CapvsExp_RL(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_CapvsExp())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_CAPVSEXP_UUIDS_BY_VALUE.get(entity.getA_CapvsExp()));
	}

	static Map<String, String> A_SOURCETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetAddition.A_SOURCETYPE_Imported, "e805e50b-d411-4e2d-9010-e9fafd0493f0");
			put(MAssetAddition.A_SOURCETYPE_Invoice, "2bded02d-c497-43be-8c3e-7c579ded5f1e");
			put(MAssetAddition.A_SOURCETYPE_JournalEntry, "f446c726-8083-4a37-8b2e-459a415e6476");
			put(MAssetAddition.A_SOURCETYPE_Manual, "8b8cf8d0-dfbf-4532-a0b9-22136bae0c31");
			put(MAssetAddition.A_SOURCETYPE_Project, "3773d29e-2de2-42bb-a4f9-8b5bfbe771ac");
		}
	};
	public CompletableFuture<MRefList> A_SourceType_RL(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_SourceType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_SOURCETYPE_UUIDS_BY_VALUE.get(entity.getA_SourceType()));
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.C_Charge_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public CompletableFuture<MConversionType> C_ConversionType(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MConversionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ConversionTypeDataLoader.C_ConversionType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ConversionType_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(MAssetAddition entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MDocType_BH> C_DocType(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.C_DocType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.C_Invoice_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine> C_InvoiceLine(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.C_InvoiceLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetAddition.DOCACTION_Complete, "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put(MAssetAddition.DOCACTION_Approve, "f80665a4-0db1-4609-be56-5d69b762d169");
			put(MAssetAddition.DOCACTION_Reject, "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put(MAssetAddition.DOCACTION_Post, "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put(MAssetAddition.DOCACTION_Void, "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put(MAssetAddition.DOCACTION_Close, "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put(MAssetAddition.DOCACTION_Reverse_Correct, "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put(MAssetAddition.DOCACTION_Reverse_Accrual, "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put(MAssetAddition.DOCACTION_Invalidate, "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put(MAssetAddition.DOCACTION_Re_Activate, "c8f55635-67a3-42ae-b626-2064acb2e260");
			put(MAssetAddition.DOCACTION_None, "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put(MAssetAddition.DOCACTION_Prepare, "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put(MAssetAddition.DOCACTION_Unlock, "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put(MAssetAddition.DOCACTION_WaitComplete, "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList> DocAction_RL(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetAddition.DOCSTATUS_Drafted, "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put(MAssetAddition.DOCSTATUS_Completed, "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put(MAssetAddition.DOCSTATUS_Approved, "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put(MAssetAddition.DOCSTATUS_NotApproved, "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put(MAssetAddition.DOCSTATUS_Voided, "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put(MAssetAddition.DOCSTATUS_Invalid, "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put(MAssetAddition.DOCSTATUS_Reversed, "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put(MAssetAddition.DOCSTATUS_Closed, "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put(MAssetAddition.DOCSTATUS_Unknown, "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put(MAssetAddition.DOCSTATUS_InProgress, "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put(MAssetAddition.DOCSTATUS_WaitingPayment, "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put(MAssetAddition.DOCSTATUS_WaitingConfirmation, "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList> DocStatus_RL(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	static Map<String, String> DOCUMENTNO_UUIDS_BY_VALUE = new HashMap<>() {
		{
		}
	};
	public CompletableFuture<MRefList> DocumentNo_RL(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocumentNo())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCUMENTNO_UUIDS_BY_VALUE.get(entity.getDocumentNo()));
	}


	/**
	 * Get Journal Batch.
	 *
	 * @return General Ledger Journal Batch
	 */
	public CompletableFuture<MJournalBatch> GL_JournalBatch(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getGL_JournalBatch_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MJournalBatch> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalBatchDataLoader.GL_JournalBatch_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getGL_JournalBatch_ID());
	}


	/**
	 * Get Imported Fixed Asset.
	 *
	 * @return Imported Fixed Asset
	 */
	public CompletableFuture<MIFixedAsset> I_FixedAsset(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getI_FixedAsset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MIFixedAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_I_FixedAssetDataLoader.I_FixedAsset_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getI_FixedAsset_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.M_InOutLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.M_Locator_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Match Invoice.
	 *
	 * @return Match Shipment/Receipt to Invoice
	 */
	public CompletableFuture<MMatchInv> M_MatchInv(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getM_MatchInv_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMatchInv> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MatchInvDataLoader.M_MatchInv_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_MatchInv_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

	static Map<String, String> POSTED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetAddition.POSTED_NotPosted, "f8a3fa32-e816-46b0-8ffa-8f75a9a6f8ce");
			put(MAssetAddition.POSTED_Posted, "238cfb09-41c2-43ef-81d3-785f45e69eff");
			put(MAssetAddition.POSTED_NotBalanced, "b356ec40-2b7c-45bd-ae61-5f62875b41ac");
			put(MAssetAddition.POSTED_NotConvertibleNoRate, "1e0390a8-f7be-4e8b-bd9a-e7c56913f39d");
			put(MAssetAddition.POSTED_PeriodClosed, "4afac137-c9db-4bbc-ac61-b0c642f7807e");
			put(MAssetAddition.POSTED_PostPrepared, "b2188064-c2e1-4319-8d1d-59145d49842b");
			put(MAssetAddition.POSTED_InvalidAccount, "3bd142e3-e397-42b9-ac64-b2c98d970426");
			put(MAssetAddition.POSTED_PostingError, "bd259a9b-d9a3-4396-ae5c-124968ae3f4d");
			put(MAssetAddition.POSTED_Deferred, "0630b5d2-0fe4-4ef8-9d2f-a14791c02c7d");
		}
	};
	public CompletableFuture<MRefList> Posted_RL(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPosted())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTED_UUIDS_BY_VALUE.get(entity.getPosted()));
	}

	static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetAddition.POSTINGTYPE_Actual, "3c9d051c-7b7b-459d-90c5-0925e26c1bcc");
			put(MAssetAddition.POSTINGTYPE_Budget, "07bbb012-66f2-4860-bd6d-dc511618bf4e");
			put(MAssetAddition.POSTINGTYPE_Commitment, "c40ae7b1-be06-4291-ac88-59974f74a46d");
			put(MAssetAddition.POSTINGTYPE_Statistical, "6011c5d4-edcc-48f6-ba32-8d820d42dbfb");
			put(MAssetAddition.POSTINGTYPE_Reservation, "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5");
		}
	};
	public CompletableFuture<MRefList> PostingType_RL(MAssetAddition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

}
