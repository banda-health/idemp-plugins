package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SequenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocType_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MGLCategory;
import org.compiere.model.PO;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DocTypeResolver extends POResolver<MDocType_BH> implements GraphQLResolver<MDocType_BH> {



	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Difference Document.
	 *
	 * @return Document type for generating in dispute Shipments
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeDifference(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeDifference_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocTypeDifference_ID());
	}


	/**
	 * Get Document Type for Invoice.
	 *
	 * @return Document type used for invoices generated from this sales document
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeInvoice(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeInvoice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocTypeInvoice_ID());
	}


	/**
	 * Get Document Type for ProForma.
	 *
	 * @return Document type used for pro forma invoices generated from this sales document
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeProforma(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeProforma_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocTypeProforma_ID());
	}


	/**
	 * Get Document Type for Shipment.
	 *
	 * @return Document type used for shipments generated from this sales document
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeShipment(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeShipment_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocTypeShipment_ID());
	}


	/**
	 * Get Definite Sequence.
	 *
	 * @return Definite Sequence
	 */
	public CompletableFuture<MSequence_BH> DefiniteSequence(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDefiniteSequence_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MSequence_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SequenceDataLoader.DATALOADER_AD_Sequence_BY_ID);
		return dataLoader.load(entity.getDefiniteSequence_ID());
	}

	public static Map<String, String> DOCBASETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("GLJ", "1ebaead0-a428-4a01-b5b3-95300caedf4c"); // GL Journal
			put("GLD", "1527e2dd-de8b-485d-992b-977b18d3d545"); // GL Document
			put("API", "22254286-4551-4535-8355-803f27481890"); // AP Invoice
			put("APP", "848c907b-df58-44bd-911c-bc3d6b126c8d"); // AP Payment
			put("ARI", "25caf904-65d5-4d39-85ac-52084222ceb5"); // AR Invoice
			put("ARR", "d3a7478a-3fd5-4d09-916a-bfa18c63d278"); // AR Receipt
			put("SOO", "73b3b54c-cd72-46bb-b5eb-8febb399d004"); // Sales Order
			put("ARF", "f089cb5b-d39d-42c4-ab6c-c3fcb01c0bc7"); // AR Pro Forma Invoice
			put("MMS", "bd2bdbed-739d-43a3-ac49-4e36f7ffbf0a"); // Material Delivery
			put("MMR", "e74d23a5-62a2-4de9-b7d0-2b0f1a01597e"); // Material Receipt
			put("MMM", "5703000d-3ae8-4734-b106-8a37eeeff0f3"); // Material Movement
			put("POO", "a2d3f3f8-7fa4-434c-9946-748cbb1ec019"); // Purchase Order
			put("POR", "01c89c39-47f1-45b3-ba40-bea570103c83"); // Purchase Requisition
			put("MMI", "ba281639-53f2-420f-a95f-035a1f8affe7"); // Material Physical Inventory
			put("APC", "a355c3de-13b9-4396-9e69-c99c8e68a868"); // AP Credit Memo
			put("ARC", "afce85df-3624-41d6-adb8-4d4a3d6e4654"); // AR Credit Memo
			put("CMB", "f4fbcba7-8612-4f2b-9ad1-8f4375782ff4"); // Bank Statement
			put("CMC", "10f0c4ce-675b-4c25-ad97-bf3e7122ad8f"); // Cash Journal
			put("CMA", "a485e645-eb48-417d-aa00-1afbfefd6c7f"); // Payment Allocation
			put("MMP", "1e2b0e68-d97d-47f4-ad8c-b75ddf361872"); // Material Production
			put("MXI", "dccc28e0-5e0e-4bc1-bf46-0e9995dfff11"); // Match Invoice
			put("MXP", "0ba8fd26-1e79-4b0d-9722-3873cb7a86cd"); // Match PO
			put("PJI", "c948ecfc-36f5-430e-9a23-02c4b3614127"); // Project Issue
			put("MOF", "a89f18f0-e253-417b-a1c8-cf7e3483ec67"); // Maintenance Order
			put("MOP", "0e55eb68-2a07-4056-bc6a-102c90880917"); // Manufacturing Order
			put("MQO", "efc21acb-0006-4cf1-ae51-764c10010758"); // Quality Order
			put("HRP", "2ab90cc0-c44e-44fd-bc45-bb3383ec338c"); // Payroll
			put("DOO", "31c4b671-5bdc-41d1-9e33-319c168111e5"); // Distribution Order
			put("MCC", "cd368ff2-7110-4475-b854-57448e89376e"); // Manufacturing Cost Collector
			put("FAA", "fef8f9ac-de6a-4ea9-b117-3a6bcfb2f3d4"); // Fixed Assets Addition
			put("FAD", "98b85394-b7cb-40df-b310-825d53744733"); // Fixed Assets Disposal
			put("FDP", "68763ab2-7781-4d0a-88d4-1d70e3f885e7"); // Fixed Assets Depreciation
		}
	};
	public CompletableFuture<MRefList_BH> DocBaseType(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocBaseType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCBASETYPE_UUIDS_BY_VALUE.get(entity.getDocBaseType()));
	}


	/**
	 * Get Document Sequence.
	 *
	 * @return Document sequence determines the numbering of documents
	 */
	public CompletableFuture<MSequence_BH> DocNoSequence(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDocNoSequence_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MSequence_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SequenceDataLoader.DATALOADER_AD_Sequence_BY_ID);
		return dataLoader.load(entity.getDocNoSequence_ID());
	}

	public static Map<String, String> DOCSUBTYPEINV_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PI", "2d7053e2-3c03-4387-896a-d377e841c4fc"); // Physical Inventory
			put("IU", "7a90eeb2-d13e-4742-92a4-c6c53ead1acd"); // Internal Use Inventory
			put("CA", "9b6ed272-4f67-4ffa-b2b1-971541d27730"); // Cost Adjustment
		}
	};
	public CompletableFuture<MRefList_BH> DocSubTypeInv(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocSubTypeInv())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSUBTYPEINV_UUIDS_BY_VALUE.get(entity.getDocSubTypeInv()));
	}

	public static Map<String, String> DOCSUBTYPESO_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("WI", "8e90ff9c-7e14-4fab-b861-ae0ff04807eb"); // On Credit Order
			put("WR", "a492f314-7cb4-488c-a30c-99deade1fef7"); // POS Order
			put("WP", "e4ec294b-9569-453b-8355-8f78d2494b97"); // Warehouse Order
			put("SO", "0c72b723-7bff-4e68-b0d0-9d0f62718296"); // Standard Order
			put("ON", "2fb5fe60-709b-447a-b84d-be761bcfc1c4"); // Proposal
			put("OB", "e418cfaf-8d7a-469c-9af2-aa7e09a939b5"); // Quotation
			put("RM", "b35de797-a497-4f5b-9cdf-93a96a4b6321"); // Return Material
			put("PR", "7076b162-00e8-4a8f-8391-21afa5698476"); // Prepay Order
		}
	};
	public CompletableFuture<MRefList_BH> DocSubTypeSO(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocSubTypeSO())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSUBTYPESO_UUIDS_BY_VALUE.get(entity.getDocSubTypeSO()));
	}

	/**
	 * Get Document Note.
	 *
	 * @return Additional information for a Document
	 */
	public CompletableFuture<String> DocumentNote(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDocumentNote);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DocType_TrlDataLoader.DATALOADER_C_DocType_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MDocType_BH.COLUMNNAME_DocumentNote) :
						entity.getDocumentNote());
	}


	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	public CompletableFuture<MGLCategory> GL_Category(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Category_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MGLCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_CategoryDataLoader.DATALOADER_GL_Category_BY_ID);
		return dataLoader.load(entity.getGL_Category_ID());
	}

	public Boolean HasCharges(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isHasCharges();
	}

	public Boolean HasProforma(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isHasProforma();
	}

	public Boolean IsAutoGenerateInout(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isAutoGenerateInout();
	}

	public Boolean IsAutoGenerateInvoice(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isAutoGenerateInvoice();
	}

	public Boolean IsChargeOrProductMandatory(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isChargeOrProductMandatory();
	}

	public Boolean IsCreateCounter(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isCreateCounter();
	}

	public Boolean IsDefault(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsDefaultCounterDoc(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isDefaultCounterDoc();
	}

	public Boolean IsDocNoControlled(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isDocNoControlled();
	}

	public Boolean IsIndexed(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isIndexed();
	}

	public Boolean IsInTransit(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isInTransit();
	}

	public Boolean IsNoPriceListCheck(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isNoPriceListCheck();
	}

	public Boolean IsOverwriteDateOnComplete(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteDateOnComplete();
	}

	public Boolean IsOverwriteSeqOnComplete(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteSeqOnComplete();
	}

	public Boolean IsPickQAConfirm(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isPickQAConfirm();
	}

	public Boolean IsPrepareSplitDocument(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isPrepareSplitDocument();
	}

	public Boolean IsShipConfirm(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isShipConfirm();
	}

	public Boolean IsSOTrx(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}

	public Boolean IsSplitWhenDifference(MDocType_BH entity, DataFetchingEnvironment environment) {
		return entity.isSplitWhenDifference();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DocType_TrlDataLoader.DATALOADER_C_DocType_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MDocType_BH.COLUMNNAME_Name) :
						entity.getName());
	}

	/**
	 * Get Print Text.
	 *
	 * @return The label text to be printed on a document or correspondence.
	 */
	public CompletableFuture<String> PrintName(MDocType_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPrintName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DocType_TrlDataLoader.DATALOADER_C_DocType_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MDocType_BH.COLUMNNAME_PrintName) :
						entity.getPrintName());
	}

}
