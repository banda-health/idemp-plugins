package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetDisposed;
import org.compiere.model.MPeriod;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_DisposedResolver extends POResolver<MAssetDisposed> implements GraphQLResolver<MAssetDisposed> {


	static Map<String, String> A_ACTIVATION_METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("AA", "31cd23ed-e20c-43e6-a12a-635f675e23d9");
		}
	};
	public CompletableFuture<MRefList_BH> A_Activation_Method(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Activation_Method())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_ACTIVATION_METHOD_UUIDS_BY_VALUE.get(entity.getA_Activation_Method()));
	}


	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}

	static Map<String, String> A_ASSET_STATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("AC", "d2cdd31e-4373-4f35-8d01-22946c3c6211");
			put("DI", "dd8c1848-6fb8-4829-8855-7c3b314514fd");
			put("DP", "583c5228-ad5d-48cd-819b-97673805b1fa");
			put("NW", "3f742175-42b0-4775-9eb3-ed5fefd0ca7a");
			put("PR", "785b94f6-fbd7-49a7-b752-45a6d0df3888");
			put("RE", "9ac1f818-4159-463f-81c4-b55923e94c9e");
			put("SO", "b2aa86a9-566c-4762-98d5-c4b5c243a2cd");
		}
	};
	public CompletableFuture<MRefList_BH> A_Asset_Status(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Asset_Status())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_ASSET_STATUS_UUIDS_BY_VALUE.get(entity.getA_Asset_Status()));
	}


	/**
	 * Get Asset Trade.
	 *
	 * @return Asset Trade
	 */
	public CompletableFuture<MAsset> A_Asset_Trade(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Trade_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_Trade_ID());
	}

	static Map<String, String> A_DISPOSED_METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "4d4a2476-0f95-48fa-a0aa-fe6df8e89726");
			put("S", "4d25db07-7f89-4e44-a734-a2eb5e0d54db");
			put("T1", "4c1ecbd5-0caf-4532-b62a-b7dcad171e10");
			put("T2", "f567e796-fcac-414d-a166-c3302b4938d1");
			put("C_", "b689ef67-35b6-40c2-b0cb-18417d71b3dc");
			put("PD", "6fafcbd4-e411-4d4e-ae98-6eb7b5f74f1c");
			put("PR", "542d4bc6-837a-456a-8fb4-70ab76215909");
			put("S_", "90cce63c-ef32-4917-97cc-e98bf04c7378");
		}
	};
	public CompletableFuture<MRefList_BH> A_Disposed_Method(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Disposed_Method())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_DISPOSED_METHOD_UUIDS_BY_VALUE.get(entity.getA_Disposed_Method()));
	}

	static Map<String, String> A_DISPOSED_REASON_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "dccec8c5-dad9-49b0-827d-9a559280ce43");
			put("D", "77e5ffb4-c796-47e9-801c-f7fda6215e65");
			put("S", "9b7b547a-0c5b-4c6d-86db-fbb7d6d0b082");
			put("S1", "d1eb86f5-8f63-4bc5-9960-9264f7d41f6d");
			put("S2", "0de27a4b-7fa4-4095-9f68-7c29aa46c0d0");
			put("T", "d8463ca2-d125-46bb-aadb-20eab7873458");
		}
	};
	public CompletableFuture<MRefList_BH> A_Disposed_Reason(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Disposed_Reason())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_DISPOSED_REASON_UUIDS_BY_VALUE.get(entity.getA_Disposed_Reason()));
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine_BH> C_InvoiceLine(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.DATALOADER_C_InvoiceLine_BY_ID);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}


	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_ID);
		return dataLoader.load(entity.getC_Period_ID());
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169");
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260");
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DR", "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put("CO", "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put("AP", "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put("NA", "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put("VO", "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put("IN", "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put("RE", "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put("CL", "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put("??", "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put("IP", "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put("WP", "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put("WC", "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList_BH> DocStatus(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	public Boolean IsApproved(MAssetDisposed entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsDisposed(MAssetDisposed entity, DataFetchingEnvironment environment) {
		return entity.isDisposed();
	}

	public Boolean Posted(MAssetDisposed entity, DataFetchingEnvironment environment) {
		return entity.isPosted();
	}

	static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "3c9d051c-7b7b-459d-90c5-0925e26c1bcc");
			put("B", "07bbb012-66f2-4860-bd6d-dc511618bf4e");
			put("E", "c40ae7b1-be06-4291-ac88-59974f74a46d");
			put("S", "6011c5d4-edcc-48f6-ba32-8d820d42dbfb");
			put("R", "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5");
		}
	};
	public CompletableFuture<MRefList_BH> PostingType(MAssetDisposed entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(MAssetDisposed entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MAssetDisposed entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
