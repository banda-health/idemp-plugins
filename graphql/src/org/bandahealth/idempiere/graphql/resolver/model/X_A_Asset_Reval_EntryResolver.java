package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MGLCategory;
import org.compiere.model.MPeriod;
import org.compiere.model.X_A_Asset_Reval_Entry;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Reval_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Reval_EntryResolver extends POResolver<X_A_Asset_Reval_Entry> implements GraphQLResolver<X_A_Asset_Reval_Entry> {


	static Map<String, String> A_REV_CODE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R01", "f9d5c700-9d0a-46c7-bf06-bf22a808b37d");
			put("R02", "678f01f7-e046-4f14-a64e-f8fd86e64ff4");
			put("R03", "374da497-243b-46a1-a10d-5690d37271c5");
		}
	};
	public CompletableFuture<MRefList_BH> A_Rev_Code(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Rev_Code())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_REV_CODE_UUIDS_BY_VALUE.get(entity.getA_Rev_Code()));
	}

	static Map<String, String> A_REVAL_CAL_METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DFT", "c11a5c1d-7b50-4462-92f3-5fd512c7c3f9");
			put("IDF", "82c0032e-1d8f-4001-b365-39f9a8cc2b05");
			put("YBF", "2e54c6d4-f45a-474c-b4ab-6c7679f913dd");
		}
	};
	public CompletableFuture<MRefList_BH> A_Reval_Cal_Method(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Reval_Cal_Method())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_REVAL_CAL_METHOD_UUIDS_BY_VALUE.get(entity.getA_Reval_Cal_Method()));
	}

	static Map<String, String> A_REVAL_EFFECTIVE_DATE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DA", "f20a49c2-43db-4df5-acfe-4272a089423a");
			put("RD", "46a86834-cdb1-478c-bf2b-f0f82cda336c");
			put("SD", "29a40d61-8a8c-483b-9f43-03f25c4e5209");
		}
	};
	public CompletableFuture<MRefList_BH> A_Reval_Effective_Date(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Reval_Effective_Date())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_REVAL_EFFECTIVE_DATE_UUIDS_BY_VALUE.get(entity.getA_Reval_Effective_Date()));
	}

	static Map<String, String> A_REVAL_MULTIPLIER_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("FAC", "4d179af6-49ab-4e58-907f-ba46f9b7d071");
			put("IND", "a3202410-8fba-4439-95fb-de3a1f32c568");
		}
	};
	public CompletableFuture<MRefList_BH> A_Reval_Multiplier(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Reval_Multiplier())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_REVAL_MULTIPLIER_UUIDS_BY_VALUE.get(entity.getA_Reval_Multiplier()));
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MCurrency_BH> C_Currency(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MPeriod> C_Period(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.C_Period_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Period_ID());
	}


	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	public CompletableFuture<MGLCategory> GL_Category(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MGLCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_CategoryDataLoader.GL_Category_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getGL_Category_ID());
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
	public CompletableFuture<MRefList_BH> PostingType(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_A_Asset_Reval_Entry entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
