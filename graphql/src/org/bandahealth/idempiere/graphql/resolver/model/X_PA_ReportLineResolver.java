package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_BudgetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLine_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.PO;
import org.compiere.model.X_GL_Budget;
import org.compiere.report.MReportLine;
import org.compiere.report.MReportLineSet;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_ReportLineResolver extends POResolver<MReportLine> implements GraphQLResolver<MReportLine> {


	public static Map<String, String> CALCULATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "f6ceb249-8184-4e03-869c-21a955349210"); // Add (Op1+Op2)
			put("S", "19ad8071-37c2-4c30-86d2-01879fbccfaa"); // Subtract (Op1-Op2)
			put("P", "1ee1c801-b264-42b5-b1f6-2ea14ab792da"); // Percentage (Op1 of Op2)
			put("R", "1455fb91-3bd5-4f0f-b156-03bb03073ff9"); // Add Range (Op1 to Op2)
		}
	};
	public CompletableFuture<MRefList_BH> CalculationType(MReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCalculationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CALCULATIONTYPE_UUIDS_BY_VALUE.get(entity.getCalculationType()));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MReportLine entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportLine_TrlDataLoader.DATALOADER_PA_ReportLine_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MReportLine.COLUMNNAME_Description) :
						entity.getDescription());
	}


	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public CompletableFuture<X_GL_Budget> GL_Budget(MReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Budget_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_GL_Budget> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_BudgetDataLoader.DATALOADER_GL_Budget_BY_ID);
		return dataLoader.load(entity.getGL_Budget_ID());
	}

	public Boolean IsInverseDebitCreditOnly(MReportLine entity, DataFetchingEnvironment environment) {
		return entity.isInverseDebitCreditOnly();
	}

	public Boolean IsPrinted(MReportLine entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsShowOppositeSign(MReportLine entity, DataFetchingEnvironment environment) {
		return entity.isShowOppositeSign();
	}

	public static Map<String, String> LINETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "3bcc58fe-4444-4f03-96fb-bde74db0e4cc"); // Segment Value
			put("C", "310ab480-fcc0-4b0e-bee4-bba7fc0e5628"); // Calculation
			put("B", "bb000455-9057-4c8a-a656-b0f1074e3fd3"); // Blank line
		}
	};
	public CompletableFuture<MRefList_BH> LineType(MReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLineType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LINETYPE_UUIDS_BY_VALUE.get(entity.getLineType()));
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MReportLine entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportLine_TrlDataLoader.DATALOADER_PA_ReportLine_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MReportLine.COLUMNNAME_Name) :
						entity.getName());
	}


	/**
	 * Get Operand 1.
	 *
	 * @return First operand for calculation
	 */
	public CompletableFuture<MReportLine> Oper_1(MReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getOper_1_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineDataLoader.DATALOADER_PA_ReportLine_BY_ID);
		return dataLoader.load(entity.getOper_1_ID());
	}


	/**
	 * Get Operand 2.
	 *
	 * @return Second operand for calculation
	 */
	public CompletableFuture<MReportLine> Oper_2(MReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getOper_2_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineDataLoader.DATALOADER_PA_ReportLine_BY_ID);
		return dataLoader.load(entity.getOper_2_ID());
	}

	public static Map<String, String> OVERLINESTROKETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DT", "e61955b1-37f0-45ed-8bd3-d7b72f5f730b"); // Dotted
			put("DS", "035f9d9e-4650-43e8-a0ec-e931e07270d8"); // Dashed
			put("DDT", "011c9ad0-34a9-4bd4-9af3-50615790ffb6"); // Double Dotted
			put("DDS", "13cd13e4-af78-4252-957e-3b1e45f33497"); // Double Dashed
			put("DSD", "e39cde64-0d54-4cf9-93c1-5068c0e97ee6"); // Double Solid
			put("SD", "9e450ade-e54b-46e1-b96f-36c02b3090eb"); // Solid
		}
	};
	public CompletableFuture<MRefList_BH> OverlineStrokeType(MReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOverlineStrokeType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(OVERLINESTROKETYPE_UUIDS_BY_VALUE.get(entity.getOverlineStrokeType()));
	}


	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	public CompletableFuture<MReportLineSet> PA_ReportLineSet(MReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportLineSet_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportLineSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineSetDataLoader.DATALOADER_PA_ReportLineSet_BY_ID);
		return dataLoader.load(entity.getPA_ReportLineSet_ID());
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
	public CompletableFuture<MRefList_BH> PAAmountType(MReportLine entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> PAPeriodType(MReportLine entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> PostingType(MReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public static Map<String, String> UNDERLINESTROKETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DT", "e61955b1-37f0-45ed-8bd3-d7b72f5f730b"); // Dotted
			put("DS", "035f9d9e-4650-43e8-a0ec-e931e07270d8"); // Dashed
			put("DDT", "011c9ad0-34a9-4bd4-9af3-50615790ffb6"); // Double Dotted
			put("DDS", "13cd13e4-af78-4252-957e-3b1e45f33497"); // Double Dashed
			put("DSD", "e39cde64-0d54-4cf9-93c1-5068c0e97ee6"); // Double Solid
			put("SD", "9e450ade-e54b-46e1-b96f-36c02b3090eb"); // Solid
		}
	};
	public CompletableFuture<MRefList_BH> UnderlineStrokeType(MReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getUnderlineStrokeType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(UNDERLINESTROKETYPE_UUIDS_BY_VALUE.get(entity.getUnderlineStrokeType()));
	}

}
