package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostTypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostType;
import org.compiere.model.MCurrency;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchemaResolver extends POResolver<MAcctSchema> implements GraphQLResolver<MAcctSchema> {



	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.C_Period_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Period_ID());
	}

	static Map<String, String> COMMITMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAcctSchema.COMMITMENTTYPE_POCommitmentOnly, "1be67031-d46a-4519-8888-d9c63e01d3dd");
			put(MAcctSchema.COMMITMENTTYPE_POCommitmentReservation, "eee976d9-bd85-477f-be29-c6a84875af91");
			put(MAcctSchema.COMMITMENTTYPE_None, "0d79afb6-a0b9-4a89-8802-da1d6966944d");
			put(MAcctSchema.COMMITMENTTYPE_POSOCommitmentReservation, "6a24d75b-d67a-419e-afbe-ff685ad306ec");
			put(MAcctSchema.COMMITMENTTYPE_SOCommitmentOnly, "14f78d5d-456b-4f9f-844b-85fe3506b60a");
			put(MAcctSchema.COMMITMENTTYPE_POSOCommitment, "fcc2f5f5-6882-440b-8ce8-46050cf2e9d3");
		}
	};
	public CompletableFuture<MRefList> CommitmentType_RL(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCommitmentType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(COMMITMENTTYPE_UUIDS_BY_VALUE.get(entity.getCommitmentType()));
	}

	static Map<String, String> COSTINGLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAcctSchema.COSTINGLEVEL_Client, "b9ccb6ca-ac26-47cd-9bc5-86d3ab30fa2f");
			put(MAcctSchema.COSTINGLEVEL_Organization, "94923c72-8b13-4fe6-8d48-510bbd85ab5d");
			put(MAcctSchema.COSTINGLEVEL_BatchLot, "582aa0b8-f288-4ad0-a1a0-eaf48e93e00d");
		}
	};
	public CompletableFuture<MRefList> CostingLevel_RL(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingLevel())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(COSTINGLEVEL_UUIDS_BY_VALUE.get(entity.getCostingLevel()));
	}

	static Map<String, String> COSTINGMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAcctSchema.COSTINGMETHOD_StandardCosting, "d3ba6803-5479-4b30-ba20-6b40e658c5d8");
			put(MAcctSchema.COSTINGMETHOD_AveragePO, "29b356c5-1757-4bab-a331-a01b9415f4e6");
			put(MAcctSchema.COSTINGMETHOD_Lifo, "fb47834b-767e-4ffe-b7ea-f690279d4345");
			put(MAcctSchema.COSTINGMETHOD_Fifo, "835a19ab-521e-406c-b0b2-f3e4c64c44b7");
			put(MAcctSchema.COSTINGMETHOD_LastPOPrice, "01741faf-094c-46ed-9266-2d3adac2c504");
			put(MAcctSchema.COSTINGMETHOD_AverageInvoice, "9127a623-4d9b-4a1a-8462-b31d8ddb24ed");
			put(MAcctSchema.COSTINGMETHOD_LastInvoice, "f4296d4f-761c-4545-a2ec-ca5c86e1b741");
			put(MAcctSchema.COSTINGMETHOD_UserDefined, "10ca122c-b77e-410e-8755-5033f17405d4");
			put(MAcctSchema.COSTINGMETHOD__, "c788f7ef-7cf6-479e-85fc-7212ae0a9f9b");
		}
	};
	public CompletableFuture<MRefList> CostingMethod_RL(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingMethod())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(COSTINGMETHOD_UUIDS_BY_VALUE.get(entity.getCostingMethod()));
	}

	static Map<String, String> GAAP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAcctSchema.GAAP_InternationalGAAP, "1d934a30-398b-4ddc-a9ba-38deb4abb3ee");
			put(MAcctSchema.GAAP_USGAAP, "7e422d7f-0ec7-4be3-8873-7fe52a27bc16");
			put(MAcctSchema.GAAP_GermanHGB, "dcf29b12-aad4-4f35-81d4-11f6b8abcf46");
			put(MAcctSchema.GAAP_FrenchAccountingStandard, "9178fdf5-55f7-4443-bb75-b13734a2d8b9");
			put(MAcctSchema.GAAP_CustomAccountingRules, "1d43bbff-e3f6-4c95-8dc8-b12af94558c2");
		}
	};
	public CompletableFuture<MRefList> GAAP_RL(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getGAAP())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(GAAP_UUIDS_BY_VALUE.get(entity.getGAAP()));
	}


	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	public CompletableFuture<MCostType> M_CostType(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostTypeDataLoader.M_CostType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_CostType_ID());
	}

	static Map<String, String> TAXCORRECTIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAcctSchema.TAXCORRECTIONTYPE_None, "cfca959d-5054-4516-9b12-8b6c9ca6ab6c");
			put(MAcctSchema.TAXCORRECTIONTYPE_Write_OffOnly, "52f20f99-823e-4528-851d-30834782dc4b");
			put(MAcctSchema.TAXCORRECTIONTYPE_DiscountOnly, "d7ca69d7-ed0b-4646-8b9b-9363da37ffc0");
			put(MAcctSchema.TAXCORRECTIONTYPE_Write_OffAndDiscount, "0b419d8a-34cc-4dbb-8378-529df0598282");
		}
	};
	public CompletableFuture<MRefList> TaxCorrectionType_RL(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTaxCorrectionType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(TAXCORRECTIONTYPE_UUIDS_BY_VALUE.get(entity.getTaxCorrectionType()));
	}

}
