package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportColumnSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportCubeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineSetDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCalendar;
import org.compiere.model.MReportCube;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.report.MReport;
import org.compiere.report.MReportColumnSet;
import org.compiere.report.MReportLineSet;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportResolver extends POResolver<MReport> implements GraphQLResolver<MReport> {



	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(MReport entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MReport entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public CompletableFuture<MCalendar> C_Calendar(MReport entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCalendar> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CalendarDataLoader.DATALOADER_C_Calendar_BY_ID);
		return dataLoader.load(entity.getC_Calendar_ID());
	}

	static Map<String, String> EXCLUDEADJUSTMENTPERIODS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "f04dfda3-2f17-4d27-83d2-696941a8a181");
			put("1", "540fdd4a-4c09-46ee-b1b1-92c6b79c2f76");
			put("2", "3b897a74-e4c7-4832-87ee-936bf71cf182");
		}
	};
	public CompletableFuture<MRefList_BH> ExcludeAdjustmentPeriods(MReport entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getExcludeAdjustmentPeriods())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(EXCLUDEADJUSTMENTPERIODS_UUIDS_BY_VALUE.get(entity.getExcludeAdjustmentPeriods()));
	}


	/**
	 * Get Jasper Process.
	 *
	 * @return The Jasper Process used by the print engine if any process defined
	 */
	public CompletableFuture<MProcess_BH> JasperProcess(MReport entity, DataFetchingEnvironment environment) {
		if (entity.getJasperProcess_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getJasperProcess_ID());
	}

	public Boolean ListSources(MReport entity, DataFetchingEnvironment environment) {
		return entity.isListSources();
	}

	public Boolean ListSourcesXTrx(MReport entity, DataFetchingEnvironment environment) {
		return entity.isListSourcesXTrx();
	}

	public Boolean ListTrx(MReport entity, DataFetchingEnvironment environment) {
		return entity.isListTrx();
	}


	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	public CompletableFuture<MReportColumnSet> PA_ReportColumnSet(MReport entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportColumnSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportColumnSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportColumnSetDataLoader.DATALOADER_PA_ReportColumnSet_BY_ID);
		return dataLoader.load(entity.getPA_ReportColumnSet_ID());
	}


	/**
	 * Get Report Cube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	public CompletableFuture<MReportCube> PA_ReportCube(MReport entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportCube_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportCube> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportCubeDataLoader.DATALOADER_PA_ReportCube_BY_ID);
		return dataLoader.load(entity.getPA_ReportCube_ID());
	}


	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	public CompletableFuture<MReportLineSet> PA_ReportLineSet(MReport entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportLineSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportLineSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineSetDataLoader.DATALOADER_PA_ReportLineSet_BY_ID);
		return dataLoader.load(entity.getPA_ReportLineSet_ID());
	}

	public Boolean Processing(MReport entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
