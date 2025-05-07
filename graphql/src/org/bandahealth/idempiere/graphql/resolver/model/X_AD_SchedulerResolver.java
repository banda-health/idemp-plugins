package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailTextDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MMailText;
import org.compiere.model.MSchedule;
import org.compiere.model.MScheduler;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_PrintFormat;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Scheduler - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_SchedulerResolver extends POResolver<MScheduler> implements GraphQLResolver<MScheduler> {



	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(MScheduler entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MScheduler entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Schedule.
	 *
	 * @return Schedule
	 */
	public CompletableFuture<MSchedule> AD_Schedule(MScheduler entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Schedule_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MSchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ScheduleDataLoader.DATALOADER_AD_Schedule_BY_ID);
		return dataLoader.load(entity.getAD_Schedule_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MScheduler entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean Processing(MScheduler entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public static Map<String, String> REPORTOUTPUTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PDF", "303c23cc-5dcf-4f5a-a105-8b62f856165a"); // PDF
			put("HTML", "67cf2cdf-75a2-441c-ab33-12033e121e69"); // HTML
			put("XLS", "0190b839-041b-43ae-a5f5-a52efb120e9d"); // XLS
			put("CSV", "e0aa166a-b354-46d5-8a60-e2e21bf49f44"); // CSV
			put("XLSX", "2ebce9b0-ffa1-429d-aa8e-42be54bc161b"); // XLSX
		}
	};
	public CompletableFuture<MRefList_BH> ReportOutputType(MScheduler entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getReportOutputType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(REPORTOUTPUTTYPE_UUIDS_BY_VALUE.get(entity.getReportOutputType()));
	}


	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	public CompletableFuture<MMailText> R_MailText(MScheduler entity, DataFetchingEnvironment environment) {
		if (entity.getR_MailText_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.DATALOADER_R_MailText_BY_ID);
		return dataLoader.load(entity.getR_MailText_ID());
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(MScheduler entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}

}
