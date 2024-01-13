package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostTypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostType;
import org.compiere.model.MPeriod;
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


	public Boolean AutoPeriodControl(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isAutoPeriodControl();
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_ID);
		return dataLoader.load(entity.getC_Period_ID());
	}

	static Map<String, String> COMMITMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "1be67031-d46a-4519-8888-d9c63e01d3dd");
			put("B", "eee976d9-bd85-477f-be29-c6a84875af91");
			put("N", "0d79afb6-a0b9-4a89-8802-da1d6966944d");
			put("A", "6a24d75b-d67a-419e-afbe-ff685ad306ec");
			put("S", "14f78d5d-456b-4f9f-844b-85fe3506b60a");
			put("O", "fcc2f5f5-6882-440b-8ce8-46050cf2e9d3");
		}
	};
	public CompletableFuture<MRefList_BH> CommitmentType(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCommitmentType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(COMMITMENTTYPE_UUIDS_BY_VALUE.get(entity.getCommitmentType()));
	}

	static Map<String, String> COSTINGLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "b9ccb6ca-ac26-47cd-9bc5-86d3ab30fa2f");
			put("O", "94923c72-8b13-4fe6-8d48-510bbd85ab5d");
			put("B", "582aa0b8-f288-4ad0-a1a0-eaf48e93e00d");
		}
	};
	public CompletableFuture<MRefList_BH> CostingLevel(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingLevel())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(COSTINGLEVEL_UUIDS_BY_VALUE.get(entity.getCostingLevel()));
	}

	static Map<String, String> COSTINGMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "d3ba6803-5479-4b30-ba20-6b40e658c5d8");
			put("A", "29b356c5-1757-4bab-a331-a01b9415f4e6");
			put("L", "fb47834b-767e-4ffe-b7ea-f690279d4345");
			put("F", "835a19ab-521e-406c-b0b2-f3e4c64c44b7");
			put("p", "01741faf-094c-46ed-9266-2d3adac2c504");
			put("I", "9127a623-4d9b-4a1a-8462-b31d8ddb24ed");
			put("i", "f4296d4f-761c-4545-a2ec-ca5c86e1b741");
			put("U", "10ca122c-b77e-410e-8755-5033f17405d4");
			put("x", "c788f7ef-7cf6-479e-85fc-7212ae0a9f9b");
		}
	};
	public CompletableFuture<MRefList_BH> CostingMethod(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(COSTINGMETHOD_UUIDS_BY_VALUE.get(entity.getCostingMethod()));
	}

	static Map<String, String> GAAP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("UN", "1d934a30-398b-4ddc-a9ba-38deb4abb3ee");
			put("US", "7e422d7f-0ec7-4be3-8873-7fe52a27bc16");
			put("DE", "dcf29b12-aad4-4f35-81d4-11f6b8abcf46");
			put("FR", "9178fdf5-55f7-4443-bb75-b13734a2d8b9");
			put("XX", "1d43bbff-e3f6-4c95-8dc8-b12af94558c2");
		}
	};
	public CompletableFuture<MRefList_BH> GAAP(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getGAAP())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(GAAP_UUIDS_BY_VALUE.get(entity.getGAAP()));
	}

	public Boolean HasAlias(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isHasAlias();
	}

	public Boolean HasCombination(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isHasCombination();
	}

	public Boolean IsAccrual(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isAccrual();
	}

	public Boolean IsAdjustCOGS(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isAdjustCOGS();
	}

	public Boolean IsAllowNegativePosting(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isAllowNegativePosting();
	}

	public Boolean IsDiscountCorrectsTax(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isDiscountCorrectsTax();
	}

	public Boolean IsExplicitCostAdjustment(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isExplicitCostAdjustment();
	}

	public Boolean IsPostIfClearingEqual(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isPostIfClearingEqual();
	}

	public Boolean IsPostServices(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isPostServices();
	}

	public Boolean IsTradeDiscountPosted(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isTradeDiscountPosted();
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostTypeDataLoader.DATALOADER_M_CostType_BY_ID);
		return dataLoader.load(entity.getM_CostType_ID());
	}

	public Boolean Processing(MAcctSchema entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> TAXCORRECTIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "cfca959d-5054-4516-9b12-8b6c9ca6ab6c");
			put("W", "52f20f99-823e-4528-851d-30834782dc4b");
			put("D", "d7ca69d7-ed0b-4646-8b9b-9363da37ffc0");
			put("B", "0b419d8a-34cc-4dbb-8378-529df0598282");
		}
	};
	public CompletableFuture<MRefList_BH> TaxCorrectionType(MAcctSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTaxCorrectionType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(TAXCORRECTIONTYPE_UUIDS_BY_VALUE.get(entity.getTaxCorrectionType()));
	}

}
