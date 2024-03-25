package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportSourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.X_I_ReportLine;
import org.compiere.report.MReportLine;
import org.compiere.report.MReportLineSet;
import org.compiere.report.MReportSource;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_ReportLineResolver extends POResolver<X_I_ReportLine> implements GraphQLResolver<X_I_ReportLine> {



	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public CompletableFuture<MElementValue> C_ElementValue(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValue_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getC_ElementValue_ID());
	}

	static Map<String, String> CALCULATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "f6ceb249-8184-4e03-869c-21a955349210");
			put("S", "19ad8071-37c2-4c30-86d2-01879fbccfaa");
			put("P", "1ee1c801-b264-42b5-b1f6-2ea14ab792da");
			put("R", "1455fb91-3bd5-4f0f-b156-03bb03073ff9");
		}
	};
	public CompletableFuture<MRefList_BH> CalculationType(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCalculationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CALCULATIONTYPE_UUIDS_BY_VALUE.get(entity.getCalculationType()));
	}

	public Boolean I_IsImported(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean IsPrinted(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsSummary(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	static Map<String, String> LINETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "3bcc58fe-4444-4f03-96fb-bde74db0e4cc");
			put("C", "310ab480-fcc0-4b0e-bee4-bba7fc0e5628");
			put("B", "bb000455-9057-4c8a-a656-b0f1074e3fd3");
		}
	};
	public CompletableFuture<MRefList_BH> LineType(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLineType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LINETYPE_UUIDS_BY_VALUE.get(entity.getLineType()));
	}


	/**
	 * Get Report Line.
	 *
	 * @return Report Line
	 */
	public CompletableFuture<MReportLine> PA_ReportLine(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineDataLoader.DATALOADER_PA_ReportLine_BY_ID);
		return dataLoader.load(entity.getPA_ReportLine_ID());
	}


	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	public CompletableFuture<MReportLineSet> PA_ReportLineSet(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportLineSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportLineSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineSetDataLoader.DATALOADER_PA_ReportLineSet_BY_ID);
		return dataLoader.load(entity.getPA_ReportLineSet_ID());
	}


	/**
	 * Get Report Source.
	 *
	 * @return Restriction of what will be shown in Report Line
	 */
	public CompletableFuture<MReportSource> PA_ReportSource(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportSource_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportSource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportSourceDataLoader.DATALOADER_PA_ReportSource_BY_ID);
		return dataLoader.load(entity.getPA_ReportSource_ID());
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
	public CompletableFuture<MRefList_BH> PAAmountType(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPAAmountType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
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
	public CompletableFuture<MRefList_BH> PAPeriodType(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPAPeriodType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
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
	public CompletableFuture<MRefList_BH> PostingType(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_ReportLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
