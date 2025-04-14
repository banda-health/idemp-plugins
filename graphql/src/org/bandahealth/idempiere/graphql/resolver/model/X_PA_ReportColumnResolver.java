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
import org.compiere.report.MReportColumn;
import org.compiere.report.MReportColumnSet;
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
 * @version Release 13 - $Id$
 */
public class X_PA_ReportColumnResolver extends POResolver<MReportColumn> implements GraphQLResolver<MReportColumn> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
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
	public CompletableFuture<MCampaign> C_Campaign(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 1) {
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
	public CompletableFuture<MCurrency_BH> C_Currency(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
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
	public CompletableFuture<MElementValue> C_ElementValue(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValue_ID() < 1) {
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
	public CompletableFuture<MLocation> C_Location(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() < 1) {
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
	public CompletableFuture<MProject> C_Project(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 1) {
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
	public CompletableFuture<MSalesRegion> C_SalesRegion(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getC_SalesRegion_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MSalesRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_ID);
		return dataLoader.load(entity.getC_SalesRegion_ID());
	}

	public static Map<String, String> CALCULATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "f6ceb249-8184-4e03-869c-21a955349210"); // Add (Op1+Op2)
			put("S", "19ad8071-37c2-4c30-86d2-01879fbccfaa"); // Subtract (Op1-Op2)
			put("P", "1ee1c801-b264-42b5-b1f6-2ea14ab792da"); // Percentage (Op1 of Op2)
			put("R", "1455fb91-3bd5-4f0f-b156-03bb03073ff9"); // Add Range (Op1 to Op2)
		}
	};
	public CompletableFuture<MRefList_BH> CalculationType(MReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCalculationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CALCULATIONTYPE_UUIDS_BY_VALUE.get(entity.getCalculationType()));
	}

	public static Map<String, String> COLUMNTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R", "0b9bb902-06aa-469d-82a5-c76ca2931aa9"); // Relative Period
			put("C", "86874133-72ba-4215-bf88-26f3d0cecd16"); // Calculation
			put("S", "f2a870a8-c5c5-4e9a-afdf-e08770b9758f"); // Segment Value
		}
	};
	public CompletableFuture<MRefList_BH> ColumnType(MReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getColumnType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(COLUMNTYPE_UUIDS_BY_VALUE.get(entity.getColumnType()));
	}

	public static Map<String, String> CURRENCYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "a18c164f-5723-4942-a1c4-fbee8e9367bb"); // Source Currency
			put("A", "7d2055f8-02e9-46f1-8217-2340028c7723"); // Accounting Currency
		}
	};
	public CompletableFuture<MRefList_BH> CurrencyType(MReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCurrencyType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CURRENCYTYPE_UUIDS_BY_VALUE.get(entity.getCurrencyType()));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MReportColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportColumn_TrlDataLoader.DATALOADER_PA_ReportColumn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MReportColumn.COLUMNNAME_Description) :
						entity.getDescription());
	}

	public static Map<String, String> ELEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("AC", "1ce3db23-ba22-4658-a7a3-388e2b83e4ec"); // Account
			put("AY", "4cebe278-4b2d-4430-97e2-cb07a3da2065"); // Activity
			put("BP", "e0862e7f-7c5c-4f1f-9afd-156bb18d1344"); // BPartner
			put("LF", "11413fc0-e7e2-4d37-b47d-4e485f2a51c7"); // Location From
			put("LT", "9de1cf83-3e27-41f7-b5c6-63906d847d5c"); // Location To
			put("MC", "5be39ed1-223b-46ca-99c4-3d7c56b1b306"); // Campaign
			put("OO", "0c36bf24-5a35-4859-9006-279a917b0d7e"); // Organization
			put("OT", "3de1fe8f-4130-492a-9426-ccff9f1ef9da"); // Org Trx
			put("PJ", "086db93e-bbd8-4ef4-80db-c91f6b6cea77"); // Project
			put("PR", "9e1a15f5-26c2-4732-b323-dc171adc0b59"); // Product
			put("SA", "2f271ee7-7a2c-427c-83aa-e44a597aa6dd"); // Sub Account
			put("SR", "e9a47662-936e-4a12-93bb-5c2156522beb"); // Sales Region
			put("U1", "cde38a17-a4b9-48a5-a4fb-12618a9d1590"); // User Element List 1
			put("U2", "fb11ce5c-4908-4079-88f9-f4b8a4d1c4d7"); // User Element List 2
			put("X1", "94eaf88d-d638-4910-92d6-b966d899e13c"); // User Column 1
			put("X2", "12ddef97-4164-4434-8874-495cba0b8ec7"); // User Column 2
			put("CO", "a852a154-ddbe-43a6-b753-c247521d6bf7"); // Combination
		}
	};
	public CompletableFuture<MRefList_BH> ElementType(MReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getElementType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ELEMENTTYPE_UUIDS_BY_VALUE.get(entity.getElementType()));
	}

	public static Map<String, String> FACTOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("k", "401c2263-9b2e-4f11-a424-58f9f7a31dd6"); // Thousand
			put("M", "89f20031-b524-4cd4-a6a1-6c21fe46335a"); // Million
		}
	};
	public CompletableFuture<MRefList_BH> Factor(MReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFactor())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FACTOR_UUIDS_BY_VALUE.get(entity.getFactor()));
	}


	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public CompletableFuture<X_GL_Budget> GL_Budget(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Budget_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_GL_Budget> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_BudgetDataLoader.DATALOADER_GL_Budget_BY_ID);
		return dataLoader.load(entity.getGL_Budget_ID());
	}

	public Boolean IsAdhocConversion(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isAdhocConversion();
	}

	public Boolean IsAllowOppositeSign(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isAllowOppositeSign();
	}

	public Boolean IsIncludeNullsActivity(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsActivity();
	}

	public Boolean IsIncludeNullsBPartner(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsBPartner();
	}

	public Boolean IsIncludeNullsCampaign(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsCampaign();
	}

	public Boolean IsIncludeNullsElementValue(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsElementValue();
	}

	public Boolean IsIncludeNullsLocation(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsLocation();
	}

	public Boolean IsIncludeNullsOrg(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsOrg();
	}

	public Boolean IsIncludeNullsOrgTrx(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsOrgTrx();
	}

	public Boolean IsIncludeNullsProduct(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsProduct();
	}

	public Boolean IsIncludeNullsProject(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsProject();
	}

	public Boolean IsIncludeNullsSalesRegion(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsSalesRegion();
	}

	public Boolean IsIncludeNullsUserElement1(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsUserElement1();
	}

	public Boolean IsIncludeNullsUserElement2(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsUserElement2();
	}

	public Boolean IsPrinted(MReportColumn entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
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
	public CompletableFuture<String> Name(MReportColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportColumn_TrlDataLoader.DATALOADER_PA_ReportColumn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MReportColumn.COLUMNNAME_Name) :
						entity.getName());
	}


	/**
	 * Get Operand 1.
	 *
	 * @return First operand for calculation
	 */
	public CompletableFuture<MReportColumn> Oper_1(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getOper_1_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportColumnDataLoader.DATALOADER_PA_ReportColumn_BY_ID);
		return dataLoader.load(entity.getOper_1_ID());
	}


	/**
	 * Get Operand 2.
	 *
	 * @return Second operand for calculation
	 */
	public CompletableFuture<MReportColumn> Oper_2(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getOper_2_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportColumnDataLoader.DATALOADER_PA_ReportColumn_BY_ID);
		return dataLoader.load(entity.getOper_2_ID());
	}


	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	public CompletableFuture<MReportColumnSet> PA_ReportColumnSet(MReportColumn entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportColumnSet_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportColumnSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportColumnSetDataLoader.DATALOADER_PA_ReportColumnSet_BY_ID);
		return dataLoader.load(entity.getPA_ReportColumnSet_ID());
	}

	public static Map<String, String> PAAMOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "7c4060bf-60d8-433d-9536-68b24ac23482"); // Balance (expected sign)
			put("C", "35749472-d741-46cc-bcfc-78e18981bdd1"); // Credit Only
			put("D", "5cef5908-30a5-4bfa-be8c-863602c731cb"); // Debit Only
			put("Q", "e940f395-f29e-42c0-860d-b4a6161525ad"); // Quantity (expected sign)
			put("S", "275d41e4-b6d3-4b96-bee1-054b32174fce"); // Balance (accounted sign)
			put("R", "f6d19951-ac66-4c69-8626-6252daff15ae"); // Quantity (accounted sign)
		}
	};
	public CompletableFuture<MRefList_BH> PAAmountType(MReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPAAmountType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAAMOUNTTYPE_UUIDS_BY_VALUE.get(entity.getPAAmountType()));
	}

	public static Map<String, String> PAPERIODTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("T", "c674c77f-9cb1-4442-8328-80b476c03aed"); // Total
			put("Y", "e83324fd-88ac-4482-b0d6-27b734c0c2f2"); // Year
			put("P", "a7860462-93bb-4a22-8c5f-25824c6528f7"); // Period
			put("N", "aec483ce-9299-4786-a0cb-a1a851362950"); // Natural
		}
	};
	public CompletableFuture<MRefList_BH> PAPeriodType(MReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPAPeriodType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAPERIODTYPE_UUIDS_BY_VALUE.get(entity.getPAPeriodType()));
	}

	public static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "3c9d051c-7b7b-459d-90c5-0925e26c1bcc"); // Actual
			put("B", "07bbb012-66f2-4860-bd6d-dc511618bf4e"); // Budget
			put("E", "c40ae7b1-be06-4291-ac88-59974f74a46d"); // Commitment
			put("S", "6011c5d4-edcc-48f6-ba32-8d820d42dbfb"); // Statistical
			put("R", "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5"); // Reservation
		}
	};
	public CompletableFuture<MRefList_BH> PostingType(MReportColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

}
