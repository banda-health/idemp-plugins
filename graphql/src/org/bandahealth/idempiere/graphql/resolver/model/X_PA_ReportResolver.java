package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportColumnSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportCubeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineSetDataLoader;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCalendar;
import org.compiere.model.MReportCube;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_PA_Report;
import org.compiere.model.X_PA_ReportColumnSet;
import org.compiere.model.X_PA_ReportLineSet;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportResolver extends POResolver<X_PA_Report> implements GraphQLResolver<X_PA_Report> {



	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(X_PA_Report entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_PA_Report entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MCalendar> C_Calendar(X_PA_Report entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCalendar> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CalendarDataLoader.DATALOADER_C_Calendar_BY_ID);
		return dataLoader.load(entity.getC_Calendar_ID());
	}


	/**
	 * Get Jasper Process.
	 *
	 * @return The Jasper Process used by the printengine if any process defined
	 */
	public CompletableFuture<MProcess_BH> JasperProcess(X_PA_Report entity, DataFetchingEnvironment environment) {
		if (entity.getJasperProcess_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getJasperProcess_ID());
	}

	public Boolean ListSources(X_PA_Report entity, DataFetchingEnvironment environment) {
		return entity.isListSources();
	}

	public Boolean ListSourcesXTrx(X_PA_Report entity, DataFetchingEnvironment environment) {
		return entity.isListSourcesXTrx();
	}

	public Boolean ListTrx(X_PA_Report entity, DataFetchingEnvironment environment) {
		return entity.isListTrx();
	}


	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	public CompletableFuture<X_PA_ReportColumnSet> PA_ReportColumnSet(X_PA_Report entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportColumnSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportColumnSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportColumnSetDataLoader.DATALOADER_PA_ReportColumnSet_BY_ID);
		return dataLoader.load(entity.getPA_ReportColumnSet_ID());
	}


	/**
	 * Get Report Cube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	public CompletableFuture<MReportCube> PA_ReportCube(X_PA_Report entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<X_PA_ReportLineSet> PA_ReportLineSet(X_PA_Report entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportLineSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportLineSet> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineSetDataLoader.DATALOADER_PA_ReportLineSet_BY_ID);
		return dataLoader.load(entity.getPA_ReportLineSet_ID());
	}

	public Boolean Processing(X_PA_Report entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
