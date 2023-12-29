package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SequenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MGLCategory;
import org.compiere.model.MRefList;
import org.compiere.model.X_AD_PrintFormat;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DocTypeResolver extends POResolver<MDocType_BH> implements GraphQLResolver<MDocType_BH> {



	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Difference Document.
	 *
	 * @return Document type for generating in dispute Shipments
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeDifference(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeDifference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.C_DocType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_DocTypeDifference_ID());
	}


	/**
	 * Get Document Type for Invoice.
	 *
	 * @return Document type used for invoices generated from this sales document
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeInvoice(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeInvoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.C_DocType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_DocTypeInvoice_ID());
	}


	/**
	 * Get Document Type for ProForma.
	 *
	 * @return Document type used for pro forma invoices generated from this sales document
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeProforma(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeProforma_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.C_DocType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_DocTypeProforma_ID());
	}


	/**
	 * Get Document Type for Shipment.
	 *
	 * @return Document type used for shipments generated from this sales document
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeShipment(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeShipment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.C_DocType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_DocTypeShipment_ID());
	}


	/**
	 * Get Definite Sequence.
	 *
	 * @return Definite Sequence
	 */
	public CompletableFuture<MSequence_BH> DefiniteSequence(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDefiniteSequence_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSequence_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SequenceDataLoader.AD_Sequence_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDefiniteSequence_ID());
	}

	static Map<String, String> DOCBASETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDocType_BH.DOCBASETYPE_GLJournal, "1ebaead0-a428-4a01-b5b3-95300caedf4c");
			put(MDocType_BH.DOCBASETYPE_GLDocument, "1527e2dd-de8b-485d-992b-977b18d3d545");
			put(MDocType_BH.DOCBASETYPE_APInvoice, "22254286-4551-4535-8355-803f27481890");
			put(MDocType_BH.DOCBASETYPE_APPayment, "848c907b-df58-44bd-911c-bc3d6b126c8d");
			put(MDocType_BH.DOCBASETYPE_ARInvoice, "25caf904-65d5-4d39-85ac-52084222ceb5");
			put(MDocType_BH.DOCBASETYPE_ARReceipt, "d3a7478a-3fd5-4d09-916a-bfa18c63d278");
			put(MDocType_BH.DOCBASETYPE_SalesOrder, "73b3b54c-cd72-46bb-b5eb-8febb399d004");
			put(MDocType_BH.DOCBASETYPE_ARProFormaInvoice, "f089cb5b-d39d-42c4-ab6c-c3fcb01c0bc7");
			put(MDocType_BH.DOCBASETYPE_MaterialDelivery, "bd2bdbed-739d-43a3-ac49-4e36f7ffbf0a");
			put(MDocType_BH.DOCBASETYPE_MaterialReceipt, "e74d23a5-62a2-4de9-b7d0-2b0f1a01597e");
			put(MDocType_BH.DOCBASETYPE_MaterialMovement, "5703000d-3ae8-4734-b106-8a37eeeff0f3");
			put(MDocType_BH.DOCBASETYPE_PurchaseOrder, "a2d3f3f8-7fa4-434c-9946-748cbb1ec019");
			put(MDocType_BH.DOCBASETYPE_PurchaseRequisition, "01c89c39-47f1-45b3-ba40-bea570103c83");
			put(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, "ba281639-53f2-420f-a95f-035a1f8affe7");
			put(MDocType_BH.DOCBASETYPE_APCreditMemo, "a355c3de-13b9-4396-9e69-c99c8e68a868");
			put(MDocType_BH.DOCBASETYPE_ARCreditMemo, "afce85df-3624-41d6-adb8-4d4a3d6e4654");
			put(MDocType_BH.DOCBASETYPE_BankStatement, "f4fbcba7-8612-4f2b-9ad1-8f4375782ff4");
			put(MDocType_BH.DOCBASETYPE_CashJournal, "10f0c4ce-675b-4c25-ad97-bf3e7122ad8f");
			put(MDocType_BH.DOCBASETYPE_PaymentAllocation, "a485e645-eb48-417d-aa00-1afbfefd6c7f");
			put(MDocType_BH.DOCBASETYPE_MaterialProduction, "1e2b0e68-d97d-47f4-ad8c-b75ddf361872");
			put(MDocType_BH.DOCBASETYPE_MatchInvoice, "dccc28e0-5e0e-4bc1-bf46-0e9995dfff11");
			put(MDocType_BH.DOCBASETYPE_MatchPO, "0ba8fd26-1e79-4b0d-9722-3873cb7a86cd");
			put(MDocType_BH.DOCBASETYPE_ProjectIssue, "c948ecfc-36f5-430e-9a23-02c4b3614127");
			put(MDocType_BH.DOCBASETYPE_MaintenanceOrder, "a89f18f0-e253-417b-a1c8-cf7e3483ec67");
			put(MDocType_BH.DOCBASETYPE_ManufacturingOrder, "0e55eb68-2a07-4056-bc6a-102c90880917");
			put(MDocType_BH.DOCBASETYPE_QualityOrder, "efc21acb-0006-4cf1-ae51-764c10010758");
			put(MDocType_BH.DOCBASETYPE_Payroll, "2ab90cc0-c44e-44fd-bc45-bb3383ec338c");
			put(MDocType_BH.DOCBASETYPE_DistributionOrder, "31c4b671-5bdc-41d1-9e33-319c168111e5");
			put(MDocType_BH.DOCBASETYPE_ManufacturingCostCollector, "cd368ff2-7110-4475-b854-57448e89376e");
			put(MDocType_BH.DOCBASETYPE_FixedAssetsAddition, "fef8f9ac-de6a-4ea9-b117-3a6bcfb2f3d4");
			put(MDocType_BH.DOCBASETYPE_FixedAssetsDisposal, "98b85394-b7cb-40df-b310-825d53744733");
			put(MDocType_BH.DOCBASETYPE_FixedAssetsDepreciation, "68763ab2-7781-4d0a-88d4-1d70e3f885e7");
		}
	};
	public CompletableFuture<MRefList> DocBaseType_RL(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocBaseType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCBASETYPE_UUIDS_BY_VALUE.get(entity.getDocBaseType()));
	}


	/**
	 * Get Document Sequence.
	 *
	 * @return Document sequence determines the numbering of documents
	 */
	public CompletableFuture<MSequence_BH> DocNoSequence(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDocNoSequence_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSequence_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SequenceDataLoader.AD_Sequence_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDocNoSequence_ID());
	}

	static Map<String, String> DOCSUBTYPEINV_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDocType_BH.DOCSUBTYPEINV_PhysicalInventory, "2d7053e2-3c03-4387-896a-d377e841c4fc");
			put(MDocType_BH.DOCSUBTYPEINV_InternalUseInventory, "7a90eeb2-d13e-4742-92a4-c6c53ead1acd");
			put(MDocType_BH.DOCSUBTYPEINV_CostAdjustment, "9b6ed272-4f67-4ffa-b2b1-971541d27730");
		}
	};
	public CompletableFuture<MRefList> DocSubTypeInv_RL(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocSubTypeInv())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCSUBTYPEINV_UUIDS_BY_VALUE.get(entity.getDocSubTypeInv()));
	}

	static Map<String, String> DOCSUBTYPESO_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDocType_BH.DOCSUBTYPESO_OnCreditOrder, "8e90ff9c-7e14-4fab-b861-ae0ff04807eb");
			put(MDocType_BH.DOCSUBTYPESO_POSOrder, "a492f314-7cb4-488c-a30c-99deade1fef7");
			put(MDocType_BH.DOCSUBTYPESO_WarehouseOrder, "e4ec294b-9569-453b-8355-8f78d2494b97");
			put(MDocType_BH.DOCSUBTYPESO_StandardOrder, "0c72b723-7bff-4e68-b0d0-9d0f62718296");
			put(MDocType_BH.DOCSUBTYPESO_Proposal, "2fb5fe60-709b-447a-b84d-be761bcfc1c4");
			put(MDocType_BH.DOCSUBTYPESO_Quotation, "e418cfaf-8d7a-469c-9af2-aa7e09a939b5");
			put(MDocType_BH.DOCSUBTYPESO_ReturnMaterial, "b35de797-a497-4f5b-9cdf-93a96a4b6321");
			put(MDocType_BH.DOCSUBTYPESO_PrepayOrder, "7076b162-00e8-4a8f-8391-21afa5698476");
		}
	};
	public CompletableFuture<MRefList> DocSubTypeSO_RL(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocSubTypeSO())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCSUBTYPESO_UUIDS_BY_VALUE.get(entity.getDocSubTypeSO()));
	}


	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	public CompletableFuture<MGLCategory> GL_Category(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MGLCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_CategoryDataLoader.GL_Category_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getGL_Category_ID());
	}

}
