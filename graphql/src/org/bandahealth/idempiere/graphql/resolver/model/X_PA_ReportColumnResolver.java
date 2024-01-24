package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesRegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_BudgetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportColumnSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportColumn_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.compiere.model.PO;
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_PA_ReportColumn;
import org.compiere.model.X_PA_ReportColumnSet;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnResolver extends POResolver<X_PA_ReportColumn> implements GraphQLResolver<X_PA_ReportColumn> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public CompletableFuture<MElementValue> C_ElementValue(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValue_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getC_ElementValue_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	public CompletableFuture<MSalesRegion> C_SalesRegion(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_SalesRegion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSalesRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_ID);
		return dataLoader.load(entity.getC_SalesRegion_ID());
	}

	static Map<String, String> CALCULATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "f6ceb249-8184-4e03-869c-21a955349210");
			put("S", "19ad8071-37c2-4c30-86d2-01879fbccfaa");
			put("P", "1ee1c801-b264-42b5-b1f6-2ea14ab792da");
			put("R", "1455fb91-3bd5-4f0f-b156-03bb03073ff9");
		}
	};
	public CompletableFuture<MRefList_BH> CalculationType(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCalculationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(CALCULATIONTYPE_UUIDS_BY_VALUE.get(entity.getCalculationType()));
	}

	static Map<String, String> COLUMNTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R", "0b9bb902-06aa-469d-82a5-c76ca2931aa9");
			put("C", "86874133-72ba-4215-bf88-26f3d0cecd16");
			put("S", "f2a870a8-c5c5-4e9a-afdf-e08770b9758f");
		}
	};
	public CompletableFuture<MRefList_BH> ColumnType(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getColumnType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(COLUMNTYPE_UUIDS_BY_VALUE.get(entity.getColumnType()));
	}

	static Map<String, String> CURRENCYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "a18c164f-5723-4942-a1c4-fbee8e9367bb");
			put("A", "7d2055f8-02e9-46f1-8217-2340028c7723");
		}
	};
	public CompletableFuture<MRefList_BH> CurrencyType(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCurrencyType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(CURRENCYTYPE_UUIDS_BY_VALUE.get(entity.getCurrencyType()));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportColumn_TrlDataLoader.DATALOADER_PA_ReportColumn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_PA_ReportColumn.COLUMNNAME_Description));
	}

	static Map<String, String> ELEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("AC", "1ce3db23-ba22-4658-a7a3-388e2b83e4ec");
			put("AY", "4cebe278-4b2d-4430-97e2-cb07a3da2065");
			put("BP", "e0862e7f-7c5c-4f1f-9afd-156bb18d1344");
			put("LF", "11413fc0-e7e2-4d37-b47d-4e485f2a51c7");
			put("LT", "9de1cf83-3e27-41f7-b5c6-63906d847d5c");
			put("MC", "5be39ed1-223b-46ca-99c4-3d7c56b1b306");
			put("OO", "0c36bf24-5a35-4859-9006-279a917b0d7e");
			put("OT", "3de1fe8f-4130-492a-9426-ccff9f1ef9da");
			put("PJ", "086db93e-bbd8-4ef4-80db-c91f6b6cea77");
			put("PR", "9e1a15f5-26c2-4732-b323-dc171adc0b59");
			put("SA", "2f271ee7-7a2c-427c-83aa-e44a597aa6dd");
			put("SR", "e9a47662-936e-4a12-93bb-5c2156522beb");
			put("U1", "cde38a17-a4b9-48a5-a4fb-12618a9d1590");
			put("U2", "fb11ce5c-4908-4079-88f9-f4b8a4d1c4d7");
			put("X1", "94eaf88d-d638-4910-92d6-b966d899e13c");
			put("X2", "12ddef97-4164-4434-8874-495cba0b8ec7");
			put("CO", "a852a154-ddbe-43a6-b753-c247521d6bf7");
		}
	};
	public CompletableFuture<MRefList_BH> ElementType(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getElementType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ELEMENTTYPE_UUIDS_BY_VALUE.get(entity.getElementType()));
	}

	static Map<String, String> FACTOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("k", "401c2263-9b2e-4f11-a424-58f9f7a31dd6");
			put("M", "89f20031-b524-4cd4-a6a1-6c21fe46335a");
		}
	};
	public CompletableFuture<MRefList_BH> Factor(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFactor())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(FACTOR_UUIDS_BY_VALUE.get(entity.getFactor()));
	}


	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public CompletableFuture<X_GL_Budget> GL_Budget(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Budget_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_GL_Budget> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_BudgetDataLoader.DATALOADER_GL_Budget_BY_ID);
		return dataLoader.load(entity.getGL_Budget_ID());
	}

	public Boolean IsAdhocConversion(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isAdhocConversion();
	}

	public Boolean IsAllowOppositeSign(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isAllowOppositeSign();
	}

	public Boolean IsIncludeNullsActivity(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsActivity();
	}

	public Boolean IsIncludeNullsBPartner(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsBPartner();
	}

	public Boolean IsIncludeNullsCampaign(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsCampaign();
	}

	public Boolean IsIncludeNullsElementValue(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsElementValue();
	}

	public Boolean IsIncludeNullsLocation(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsLocation();
	}

	public Boolean IsIncludeNullsOrg(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsOrg();
	}

	public Boolean IsIncludeNullsOrgTrx(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsOrgTrx();
	}

	public Boolean IsIncludeNullsProduct(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsProduct();
	}

	public Boolean IsIncludeNullsProject(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsProject();
	}

	public Boolean IsIncludeNullsSalesRegion(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsSalesRegion();
	}

	public Boolean IsIncludeNullsUserElement1(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsUserElement1();
	}

	public Boolean IsIncludeNullsUserElement2(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsUserElement2();
	}

	public Boolean IsPrinted(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportColumn_TrlDataLoader.DATALOADER_PA_ReportColumn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_PA_ReportColumn.COLUMNNAME_Name));
	}


	/**
	 * Get Operand 1.
	 *
	 * @return First operand for calculation
	 */
	public CompletableFuture<X_PA_ReportColumn> Oper_1(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getOper_1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportColumnDataLoader.DATALOADER_PA_ReportColumn_BY_ID);
		return dataLoader.load(entity.getOper_1_ID());
	}


	/**
	 * Get Operand 2.
	 *
	 * @return Second operand for calculation
	 */
	public CompletableFuture<X_PA_ReportColumn> Oper_2(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getOper_2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportColumnDataLoader.DATALOADER_PA_ReportColumn_BY_ID);
		return dataLoader.load(entity.getOper_2_ID());
	}


	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	public CompletableFuture<X_PA_ReportColumnSet> PA_ReportColumnSet(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportColumnSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportColumnSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportColumnSetDataLoader.DATALOADER_PA_ReportColumnSet_BY_ID);
		return dataLoader.load(entity.getPA_ReportColumnSet_ID());
	}

	static Map<String, String> PAAMOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "7c4060bf-60d8-433d-9536-68b24ac23482");
			put("C", "35749472-d741-46cc-bcfc-78e18981bdd1");
			put("D", "5cef5908-30a5-4bfa-be8c-863602c731cb");
			put("Q", "e940f395-f29e-42c0-860d-b4a6161525ad");
			put("S", "275d41e4-b6d3-4b96-bee1-054b32174fce");
			put("R", "f6d19951-ac66-4c69-8626-6252daff15ae");
		}
	};
	public CompletableFuture<MRefList_BH> PAAmountType(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPAAmountType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(PAAMOUNTTYPE_UUIDS_BY_VALUE.get(entity.getPAAmountType()));
	}

	static Map<String, String> PAPERIODTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("T", "c674c77f-9cb1-4442-8328-80b476c03aed");
			put("Y", "e83324fd-88ac-4482-b0d6-27b734c0c2f2");
			put("P", "a7860462-93bb-4a22-8c5f-25824c6528f7");
			put("N", "aec483ce-9299-4786-a0cb-a1a851362950");
		}
	};
	public CompletableFuture<MRefList_BH> PAPeriodType(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPAPeriodType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(PAPERIODTYPE_UUIDS_BY_VALUE.get(entity.getPAPeriodType()));
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
	public CompletableFuture<MRefList_BH> PostingType(X_PA_ReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

}
