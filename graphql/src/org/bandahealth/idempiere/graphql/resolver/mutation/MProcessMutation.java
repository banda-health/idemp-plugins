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
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
import org.compiere.util.Env;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MProcessMutation extends X_AD_ProcessMutation {
	public String AD_ProcessRun(String ID, List<ProcessInfoParameterInput> ProcessInfoParameterList,
			DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(ID)) {
			log.severe("Process not specified");
			return null;
		}
		if (ProcessInfoParameterList == null) {
			ProcessInfoParameterList = new ArrayList<>();
		}
		MProcess process = Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MProcess_BH.Table_Name, null, ID);
		return run(process, ProcessInfoParameterList);
	}

	public byte[] AD_ProcessRunAndExport(String ID, List<ProcessInfoParameterInput> ProcessInfoParameterList,
			ReportOutput reportType, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(ID)) {
			log.severe("Report not specified");
			return null;
		}
		if (ProcessInfoParameterList == null) {
			ProcessInfoParameterList = new ArrayList<>();
		}
		MProcess process = Repository.getByUuid(BandaGraphQLContext.getCtx(environment), MProcess_BH.Table_Name, null, ID);
		if (process == null) {
			throw new AdempiereException("Could not find report");
		}

		if (reportType == null) {
			reportType = ReportOutput.PDF;
		}

		// Initialize report info
		MPInstance mpInstance = new MPInstance(process, 0);
		ProcessInfo processInfo = new ProcessInfo(process.getName(), process.getAD_Process_ID());
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

		if (processInfo.getExportFile() != null) {
			byte[] byteArray = new byte[(int) processInfo.getExportFile().length()];
			try (FileInputStream inputStream = new FileInputStream(processInfo.getExportFile())) {
				int ignored = inputStream.read(byteArray);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return byteArray;
		}

		return null;
	}

	/**
	 * Run an iDempiere process
	 *
	 * @param process                              The process to run
	 * @param processInformationParameterInputList The parameters to pass to the process
	 * @return A string with a response or null if an error occurred
	 */
	private String run(MProcess process, List<ProcessInfoParameterInput> processInformationParameterInputList) {
		// Initialize process info
		MPInstance mpInstance = new MPInstance(process, 0);
		ProcessInfo processInfo = new ProcessInfo(process.getName(), process.getAD_Process_ID());
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
		Map<String, MProcessPara> processParametersByUuidMap =
				Repository.getGroupsByIds(process.getCtx(), MProcessParaInput.Table_Name, process.get_TrxName(),
								MProcessPara::getAD_Process_ID, MProcessPara.COLUMNNAME_AD_Process_ID,
								new HashSet<>(Collections.singletonList(process.get_ID())))
						.getOrDefault(process.get_ID(), new ArrayList<>()).stream()
						.collect(Collectors.toMap(MProcessPara::getAD_Process_Para_UU, processParameter -> processParameter));
		Map<Integer, MReference_BH> referencesByIdMap =
				Repository.getByIds(process.getCtx(), MReference_BH.Table_Name, process.get_TrxName(),
						processParametersByUuidMap.values().stream().map(MProcessPara::getAD_Reference_ID)
								.collect(Collectors.toSet()));

		List<ProcessInfoParameter> processInformationParameters = new ArrayList<>();
		// Now, cycle through and process each parameter passed in
		processInformationParameterInputList.forEach(processInfoParameterInput -> {
			// Get the process parameter
			MProcessPara processParameter =
					processParametersByUuidMap.get(processInfoParameterInput.getAD_Process().getUUID());

			// Get the reference to help determine what type of parameter this is
			MReference referenceForParameter = referencesByIdMap.get(processParameter.getAD_Reference_ID());
			Object parameter = processInfoParameterInput.getParameter();
			if (referenceForParameter.getAD_Reference_ID() == MReference_BH.DATE_AD_REFERENCE_ID) {
				parameter = DateUtil.parseDate(processInfoParameterInput.getParameter().toString());
			}

			if (referenceForParameter.getAD_Reference_ID() == MReference_BH.DATETIME_AD_REFERENCE_ID) {
				if (processInfoParameterInput.getParameter() instanceof Integer) {
					parameter = new Timestamp((Integer) processInfoParameterInput.getParameter());
				} else {
					parameter = DateUtil.getTimestampReportParameter(processInfoParameterInput.getParameter().toString());
				}
			}

			// Since some reports want IDs, we need to convert UUIDs to IDs
			// TODO: Update all reports to use UUIDs instead of IDs
			if (processParameter.getName().toLowerCase().endsWith(MReference_BH.SUFFIX_ID)) {
				if (process.getAD_Process_UU().equalsIgnoreCase(MProcess_BH.PROCESSUUID_THERMAL_RECEIPT_REPORT)) {
					MBHVisit visit = new Query(Env.getCtx(), MBHVisit.Table_Name,
							MBHVisit.COLUMNNAME_BH_Visit_UU + "=?", null)
							.setParameters(parameter.toString()).first();
					parameter = BigDecimal.valueOf(visit.get_ID());
				} else if (process.getAD_Process_UU().equalsIgnoreCase(MProcess_BH.PROCESSUUID_DEBT_PAYMENT_RECEIPT)) {
					MPayment_BH payment = new Query(Env.getCtx(), MPayment_BH.Table_Name,
							MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", null)
							.setParameters(parameter.toString()).first();
					parameter = BigDecimal.valueOf(payment.get_ID());
				}
			}

			// Create a new process info parameter with the name fetched from MProcessParam
			processInformationParameters.add(new ProcessInfoParameter(
					processParametersByUuidMap.get(processInfoParameterInput.getAD_Process().getUUID()).getName(),
					parameter,
					processInfoParameterInput.getParameter_To(),
					processInfoParameterInput.getInfo(),
					processInfoParameterInput.getInfo_To()
			));
			// Also add a parameter matching the column name so either can be used
			// TODO: migrate all parameters to do this in the future
			processInformationParameters.add(new ProcessInfoParameter(
					processParametersByUuidMap.get(processInfoParameterInput.getAD_Process().getUUID()).getColumnName(),
					parameter,
					processInfoParameterInput.getParameter_To(),
					processInfoParameterInput.getInfo(),
					processInfoParameterInput.getInfo_To()
			));
		});

		return processInformationParameters;
	}
}
