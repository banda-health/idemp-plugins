package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.ReportOutput;
import org.bandahealth.idempiere.graphql.model.input.MProcessParaInput;
import org.bandahealth.idempiere.graphql.model.input.ProcessInfoParameterInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DateUtil;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPInstance;
import org.compiere.model.MProcess;
import org.compiere.model.MProcessPara;
import org.compiere.model.MReference;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.model.SystemIDs;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class MProcessMutation extends X_AD_ProcessMutation {
	public String AD_ProcessRun(String UU, String TableUU, String RecordUU,
			List<ProcessInfoParameterInput> ProcessInfoParameterList, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(UU)) {
			log.severe("Process not specified");
			return null;
		}
		if (ProcessInfoParameterList == null) {
			ProcessInfoParameterList = new ArrayList<>();
		}
		MProcess process =
				Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MProcess_BH.Table_Name, null, UU);
		int tableID = -1;
		int recordID = 0;
		if (!StringUtil.isNullOrEmpty(TableUU) && !StringUtil.isNullOrEmpty(RecordUU)) {
			MTable table =
					Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MTable.Table_Name, null, TableUU);
			if (table != null) {
				tableID = table.get_ID();
				PO record =
						Repository.getByUuid(BandaGraphQLContext.getCtx(environment), table.getTableName(), null, RecordUU);
				recordID = record.get_ID();
			}
		} else {
			RecordUU = null;
		}
		return run(process, tableID, recordID, RecordUU, ProcessInfoParameterList);
	}

	public File AD_ProcessRunAndExport(String UUID, String TableUU, String RecordUU,
			List<ProcessInfoParameterInput> ProcessInfoParameterList, ReportOutput reportType,
			DataFetchingEnvironment environment) throws IOException {
		if (StringUtil.isNullOrEmpty(UUID)) {
			throw new AdempiereException("Could not find report");
		}
		if (ProcessInfoParameterList == null) {
			ProcessInfoParameterList = new ArrayList<>();
		}
		MProcess process =
				Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MProcess_BH.Table_Name, null, UUID);
		if (process == null) {
			throw new AdempiereException("Could not find report");
		}

		if (reportType == null) {
			reportType = ReportOutput.PDF;
		}

		int tableID = -1;
		int recordID = 0;
		if (!StringUtil.isNullOrEmpty(TableUU) && !StringUtil.isNullOrEmpty(RecordUU)) {
			MTable table =
					Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MTable.Table_Name, null, TableUU);
			if (table != null) {
				tableID = table.get_ID();
				PO record =
						Repository.getByUuid(BandaGraphQLContext.getCtx(environment), table.getTableName(), null, RecordUU);
				recordID = record.get_ID();
			}
		} else {
			RecordUU = null;
		}

		// Initialize report info
		MPInstance mpInstance = new MPInstance(process, tableID, recordID, RecordUU);
		ProcessInfo processInfo =
				new ProcessInfo(process.getName(), process.getAD_Process_ID(), mpInstance.getAD_Table_ID(),
						mpInstance.getRecord_ID(), mpInstance.getRecord_UU());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(process.getAD_Process_UU());
		processInfo.setIsBatch(true);
		processInfo.setExport(true);
		processInfo.setReportType(reportType.toString().toUpperCase());
		processInfo.setExportFileExtension(reportType.toString().toLowerCase());

		List<ProcessInfoParameter> processInformationParameters =
				mapProcessInformationParameters(process, ProcessInfoParameterList);
		if (!processInformationParameters.isEmpty()) {
			processInfo.setParameter(processInformationParameters.toArray(ProcessInfoParameter[]::new));
		}

		// Run the report
		ServerProcessCtl.process(processInfo, null);

		if (processInfo.isError()) {
			throw new AdempiereException("Could not generate report " + process.getName());
		}

		return processInfo.getExportFile();
	}

	/**
	 * Run an iDempiere process
	 *
	 * @param process                              The process to run
	 * @param processInformationParameterInputList The parameters to pass to the process
	 * @return A string with a response or null if an error occurred
	 */
	private String run(MProcess process, int TableID, int RecordID, String RecordUU,
			List<ProcessInfoParameterInput> processInformationParameterInputList) {
		// Initialize process info
		MPInstance mpInstance = new MPInstance(process, TableID, RecordID, RecordUU);
		ProcessInfo processInfo =
				new ProcessInfo(process.getName(), process.getAD_Process_ID(), mpInstance.getAD_Table_ID(),
						mpInstance.getRecord_ID(), mpInstance.getRecord_UU());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(process.getAD_Process_UU());
		processInfo.setIsBatch(true);
		processInfo.setExport(false);

		List<ProcessInfoParameter> processInformationParameters =
				mapProcessInformationParameters(process, processInformationParameterInputList);
		if (!processInformationParameters.isEmpty()) {
			processInfo.setParameter(processInformationParameters.toArray(ProcessInfoParameter[]::new));
		}

		// Run the process
		ServerProcessCtl.process(processInfo, null);

		if (processInfo.isError()) {
			throw new AdempiereException("Could not run process " + process.getName());
		}

		if (processInfo.getLogInfo() != null) {
			return processInfo.getLogInfo();
		}

		return null;
	}

	/**
	 * This method takes the Banda Rest plugin process information parameters and maps them to iDempiere's
	 *
	 * @param process                              The process to use
	 * @param processInformationParameterInputList The parameters we want to pass to that process
	 * @return The mapped parameters to pass to the process
	 */
	private List<ProcessInfoParameter> mapProcessInformationParameters(MProcess process,
			List<ProcessInfoParameterInput> processInformationParameterInputList) {
		// Let's process the parameters (really, we only need to convert dates if they're dates)
		// First, batch DB requests so we can avoid many queries
		Map<String, MProcessPara> processParametersByName =
				Repository.getGroupsByIds(process.getCtx(), MProcessParaInput.Table_Name, process.get_TrxName(),
								MProcessPara::getAD_Process_ID, MProcessPara.COLUMNNAME_AD_Process_ID,
								new HashSet<>(Collections.singletonList(process.get_ID())))
						.getOrDefault(process.get_ID(), new ArrayList<>()).stream()
						.collect(Collectors.toMap(MProcessPara::getName, processParameter -> processParameter));
		Map<Integer, MReference_BH> referencesByIdMap =
				Repository.getByIds(process.getCtx(), MReference_BH.Table_Name, process.get_TrxName(),
						processParametersByName.values().stream().map(MProcessPara::getAD_Reference_ID)
								.collect(Collectors.toSet()));

		List<ProcessInfoParameter> processInformationParameters = new ArrayList<>();
		// Now, cycle through and process each parameter passed in
		processInformationParameterInputList.forEach(processInfoParameterInput -> {
			// Get the process parameter
			MProcessPara processParameter = processParametersByName.get(processInfoParameterInput.getParameterName());

			// Get the reference to help determine what type of parameter this is
			MReference referenceForParameter = referencesByIdMap.get(processParameter.getAD_Reference_ID());
			Object parameter = processInfoParameterInput.getParameter();
			if (referenceForParameter.getAD_Reference_ID() == SystemIDs.REFERENCE_DATATYPE_DATE ||
					referenceForParameter.getAD_Reference_ID() == SystemIDs.REFERENCE_DATATYPE_DATETIME) {
				parameter = DateUtil.getAPITimestamp(processInfoParameterInput.getParameter(),
						referenceForParameter.getAD_Reference_ID() == SystemIDs.REFERENCE_DATATYPE_DATE);
			}

			// Since some reports want IDs, we need to convert UUIDs to IDs
			// TODO: Update all reports to use UUIDs instead of IDs
			if (processParameter.getName().toLowerCase().endsWith(MReference_BH.SUFFIX_ID)) {
				if (process.getAD_Process_UU().equalsIgnoreCase(MProcess_BH.PROCESSUUID_THERMAL_RECEIPT_REPORT)) {
					MBHVisit visit = new Query(process.getCtx(), MBHVisit.Table_Name,
							MBHVisit.COLUMNNAME_BH_Visit_UU + "=?", null)
							.setParameters(parameter.toString()).first();
					parameter = BigDecimal.valueOf(visit.get_ID());
				} else if (process.getAD_Process_UU().equalsIgnoreCase(MProcess_BH.PROCESSUUID_DEBT_PAYMENT_RECEIPT)) {
					MPayment_BH payment = new Query(process.getCtx(), MPayment_BH.Table_Name,
							MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", null)
							.setParameters(parameter.toString()).first();
					parameter = BigDecimal.valueOf(payment.get_ID());
				}
			}
			if(processParameter.getName().equals(MReference_BH.TAGS_PARAMETER)) {
				log.info(parameter.toString());
				parameter = Collections.singletonList(parameter);
			}

			// Create a new process info parameter with the name fetched from MProcessParam
			processInformationParameters.add(new ProcessInfoParameter(
					processParameter.getName(),
					parameter,
					processInfoParameterInput.getParameter_To(),
					processInfoParameterInput.getInfo(),
					processInfoParameterInput.getInfo_To()
			));
			// Also add a parameter matching the column name so either can be used
			// TODO: migrate all parameters to do this in the future
			processInformationParameters.add(new ProcessInfoParameter(
					processParameter.getColumnName(),
					parameter,
					processInfoParameterInput.getParameter_To(),
					processInfoParameterInput.getInfo(),
					processInfoParameterInput.getInfo_To()
			));
		});

		return processInformationParameters;
	}
}
