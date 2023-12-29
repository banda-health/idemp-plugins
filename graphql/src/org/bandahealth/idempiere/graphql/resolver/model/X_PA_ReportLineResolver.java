package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_BudgetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineSetDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_PA_ReportLine;
import org.compiere.model.X_PA_ReportLineSet;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineResolver extends POResolver<X_PA_ReportLine> implements GraphQLResolver<X_PA_ReportLine> {


	static Map<String, String> CALCULATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_PA_ReportLine.CALCULATIONTYPE_AddOp1PlusOp2, "f6ceb249-8184-4e03-869c-21a955349210");
			put(X_PA_ReportLine.CALCULATIONTYPE_SubtractOp1_Op2, "19ad8071-37c2-4c30-86d2-01879fbccfaa");
			put(X_PA_ReportLine.CALCULATIONTYPE_PercentageOp1OfOp2, "1ee1c801-b264-42b5-b1f6-2ea14ab792da");
			put(X_PA_ReportLine.CALCULATIONTYPE_AddRangeOp1ToOp2, "1455fb91-3bd5-4f0f-b156-03bb03073ff9");
		}
	};
	public CompletableFuture<MRefList> CalculationType_RL(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCalculationType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CALCULATIONTYPE_UUIDS_BY_VALUE.get(entity.getCalculationType()));
	}


	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public CompletableFuture<X_GL_Budget> GL_Budget(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Budget_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_GL_Budget> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_BudgetDataLoader.GL_Budget_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getGL_Budget_ID());
	}

	static Map<String, String> LINETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_PA_ReportLine.LINETYPE_SegmentValue, "3bcc58fe-4444-4f03-96fb-bde74db0e4cc");
			put(X_PA_ReportLine.LINETYPE_Calculation, "310ab480-fcc0-4b0e-bee4-bba7fc0e5628");
			put(X_PA_ReportLine.LINETYPE_BlankLine, "bb000455-9057-4c8a-a656-b0f1074e3fd3");
		}
	};
	public CompletableFuture<MRefList> LineType_RL(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLineType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(LINETYPE_UUIDS_BY_VALUE.get(entity.getLineType()));
	}


	/**
	 * Get Operand 1.
	 *
	 * @return First operand for calculation
	 */
	public CompletableFuture<X_PA_ReportLine> Oper_1(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getOper_1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineDataLoader.PA_ReportLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getOper_1_ID());
	}


	/**
	 * Get Operand 2.
	 *
	 * @return Second operand for calculation
	 */
	public CompletableFuture<X_PA_ReportLine> Oper_2(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getOper_2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineDataLoader.PA_ReportLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getOper_2_ID());
	}

	static Map<String, String> OVERLINESTROKETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_PA_ReportLine.OVERLINESTROKETYPE_Dotted, "e61955b1-37f0-45ed-8bd3-d7b72f5f730b");
			put(X_PA_ReportLine.OVERLINESTROKETYPE_Dashed, "035f9d9e-4650-43e8-a0ec-e931e07270d8");
			put(X_PA_ReportLine.OVERLINESTROKETYPE_DoubleDotted, "011c9ad0-34a9-4bd4-9af3-50615790ffb6");
			put(X_PA_ReportLine.OVERLINESTROKETYPE_DoubleDashed, "13cd13e4-af78-4252-957e-3b1e45f33497");
			put(X_PA_ReportLine.OVERLINESTROKETYPE_DoubleSolid, "e39cde64-0d54-4cf9-93c1-5068c0e97ee6");
			put(X_PA_ReportLine.OVERLINESTROKETYPE_Solid, "9e450ade-e54b-46e1-b96f-36c02b3090eb");
		}
	};
	public CompletableFuture<MRefList> OverlineStrokeType_RL(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOverlineStrokeType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(OVERLINESTROKETYPE_UUIDS_BY_VALUE.get(entity.getOverlineStrokeType()));
	}


	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	public CompletableFuture<X_PA_ReportLineSet> PA_ReportLineSet(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportLineSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportLineSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineSetDataLoader.PA_ReportLineSet_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_ReportLineSet_ID());
	}

	static Map<String, String> PAAMOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_PA_ReportLine.PAAMOUNTTYPE_BalanceExpectedSign, "7c4060bf-60d8-433d-9536-68b24ac23482");
			put(X_PA_ReportLine.PAAMOUNTTYPE_CreditOnly, "35749472-d741-46cc-bcfc-78e18981bdd1");
			put(X_PA_ReportLine.PAAMOUNTTYPE_DebitOnly, "5cef5908-30a5-4bfa-be8c-863602c731cb");
			put(X_PA_ReportLine.PAAMOUNTTYPE_QuantityExpectedSign, "e940f395-f29e-42c0-860d-b4a6161525ad");
			put(X_PA_ReportLine.PAAMOUNTTYPE_BalanceAccountedSign, "275d41e4-b6d3-4b96-bee1-054b32174fce");
			put(X_PA_ReportLine.PAAMOUNTTYPE_QuantityAccountedSign, "f6d19951-ac66-4c69-8626-6252daff15ae");
		}
	};
	public CompletableFuture<MRefList> PAAmountType_RL(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPAAmountType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PAAMOUNTTYPE_UUIDS_BY_VALUE.get(entity.getPAAmountType()));
	}

	static Map<String, String> PAPERIODTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_PA_ReportLine.PAPERIODTYPE_Total, "c674c77f-9cb1-4442-8328-80b476c03aed");
			put(X_PA_ReportLine.PAPERIODTYPE_Year, "e83324fd-88ac-4482-b0d6-27b734c0c2f2");
			put(X_PA_ReportLine.PAPERIODTYPE_Period, "a7860462-93bb-4a22-8c5f-25824c6528f7");
			put(X_PA_ReportLine.PAPERIODTYPE_Natural, "aec483ce-9299-4786-a0cb-a1a851362950");
		}
	};
	public CompletableFuture<MRefList> PAPeriodType_RL(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPAPeriodType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PAPERIODTYPE_UUIDS_BY_VALUE.get(entity.getPAPeriodType()));
	}

	static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_PA_ReportLine.POSTINGTYPE_Actual, "3c9d051c-7b7b-459d-90c5-0925e26c1bcc");
			put(X_PA_ReportLine.POSTINGTYPE_Budget, "07bbb012-66f2-4860-bd6d-dc511618bf4e");
			put(X_PA_ReportLine.POSTINGTYPE_Commitment, "c40ae7b1-be06-4291-ac88-59974f74a46d");
			put(X_PA_ReportLine.POSTINGTYPE_Statistical, "6011c5d4-edcc-48f6-ba32-8d820d42dbfb");
			put(X_PA_ReportLine.POSTINGTYPE_Reservation, "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5");
		}
	};
	public CompletableFuture<MRefList> PostingType_RL(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	static Map<String, String> UNDERLINESTROKETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_PA_ReportLine.UNDERLINESTROKETYPE_Dotted, "e61955b1-37f0-45ed-8bd3-d7b72f5f730b");
			put(X_PA_ReportLine.UNDERLINESTROKETYPE_Dashed, "035f9d9e-4650-43e8-a0ec-e931e07270d8");
			put(X_PA_ReportLine.UNDERLINESTROKETYPE_DoubleDotted, "011c9ad0-34a9-4bd4-9af3-50615790ffb6");
			put(X_PA_ReportLine.UNDERLINESTROKETYPE_DoubleDashed, "13cd13e4-af78-4252-957e-3b1e45f33497");
			put(X_PA_ReportLine.UNDERLINESTROKETYPE_DoubleSolid, "e39cde64-0d54-4cf9-93c1-5068c0e97ee6");
			put(X_PA_ReportLine.UNDERLINESTROKETYPE_Solid, "9e450ade-e54b-46e1-b96f-36c02b3090eb");
		}
	};
	public CompletableFuture<MRefList> UnderlineStrokeType_RL(X_PA_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getUnderlineStrokeType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(UNDERLINESTROKETYPE_UUIDS_BY_VALUE.get(entity.getUnderlineStrokeType()));
	}

}
