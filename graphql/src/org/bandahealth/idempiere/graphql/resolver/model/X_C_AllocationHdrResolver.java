package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AllocationHdrDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAllocationHdr;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_AllocationHdr - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AllocationHdrResolver extends POResolver<MAllocationHdr> implements GraphQLResolver<MAllocationHdr> {



	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MAllocationHdr entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MAllocationHdr entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
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
	public CompletableFuture<MRefList_BH> DocAction(MAllocationHdr entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> DocStatus(MAllocationHdr entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	public Boolean IsApproved(MAllocationHdr entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsManual(MAllocationHdr entity, DataFetchingEnvironment environment) {
		return entity.isManual();
	}

	public Boolean Posted(MAllocationHdr entity, DataFetchingEnvironment environment) {
		return entity.isPosted();
	}

	public Boolean Processed(MAllocationHdr entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MAllocationHdr entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public CompletableFuture<MAllocationHdr> Reversal(MAllocationHdr entity, DataFetchingEnvironment environment) {
		if (entity.getReversal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAllocationHdr> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AllocationHdrDataLoader.DATALOADER_C_AllocationHdr_BY_ID);
		return dataLoader.load(entity.getReversal_ID());
	}

}
