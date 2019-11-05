package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.model.ProcessParameter;
import org.bandahealth.idempiere.rest.model.BHProcessInfo;
import org.bandahealth.idempiere.rest.model.BHProcessInfoParameter;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.MPInstance;
import org.compiere.model.MProcess;
import org.compiere.model.MProcessPara;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
import org.compiere.util.Env;

public class ProcessDBService {

	public static BHProcessInfo runProcess(BHProcessInfo request) {
		if (request == null) {
			return null;
		}

		MProcess mprocess = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_AD_Process_UU + "=?", null)
				.setOnlyActiveRecords(true).setParameters(request.getUuid()).first();

		MPInstance mpInstance = new MPInstance(mprocess, 0);

		ProcessInfo processInfo = new ProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Client_ID(Env.getAD_Client_ID(Env.getCtx()));
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(mprocess.getAD_Process_UU());

		if (request.getParameters() != null && !request.getParameters().isEmpty()) {
			processInfo.setParameter(getInfoParameters(request.getParameters()));
		}

		ServerProcessCtl.process(processInfo, null);

		BHProcessInfo response = new BHProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		response.setPinstanceId(processInfo.getAD_PInstance_ID());
		response.setSummary(processInfo.getSummary());
		response.setError(processInfo.isError());

		return response;
	}

	public static BaseListResponse<Process> getAll(Paging pagingInfo) {
		List<Process> results = new ArrayList<>();
		List<MProcess> processes;
		Query query = new Query(Env.getCtx(), MProcess.Table_Name, null, null).setOnlyActiveRecords(true)
				.setParameters(true).setClient_ID();

		pagingInfo.setTotalRecordCount(query.count());
		query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
		processes = query.list();

		if (!processes.isEmpty()) {
			for (MProcess process : processes) {
				List<MProcessPara> params = new Query(Env.getCtx(), MProcessPara.Table_Name,
						MProcessPara.COLUMNNAME_AD_Process_ID + "=?", null).setOnlyActiveRecords(true)
								.setParameters(process.get_ID()).list();
				List<ProcessParameter> parameters = new ArrayList<>();
				for (MProcessPara param : params) {
					parameters.add(createProcessParameterInstance(param));
				}

				results.add(createProcessInstance(process, parameters));
			}
		}

		return new BaseListResponse<Process>(results, pagingInfo);
	}

	public static Process getProcess(String uuid) {
		MProcess process = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_AD_Process_UU + "=?", null)
				.setOnlyActiveRecords(true).setParameters(uuid).first();

		if (process != null) {
			List<MProcessPara> params = new Query(Env.getCtx(), MProcessPara.Table_Name,
					MProcessPara.COLUMNNAME_AD_Process_ID + "=?", null).setOnlyActiveRecords(true)
							.setParameters(process.get_ID()).list();
			List<ProcessParameter> parameters = new ArrayList<>();
			for (MProcessPara param : params) {
				parameters.add(createProcessParameterInstance(param));
			}

			return createProcessInstance(process, parameters);
		}

		return null;
	}

	private static Process createProcessInstance(MProcess process, List<ProcessParameter> parameters) {
		return new Process(process.getAD_Client_ID(), process.getAD_Org_ID(), process.getAD_Process_UU(),
				process.isActive(), process.getCreated(), process.getCreatedBy(), process.getDescription(),
				process.getName(), process.getAD_Form_ID(), process.getAD_ReportView_ID(), process.getAD_Workflow_ID(),
				process.getAllowMultipleExecution(), process.getClassname(), process.getCopyFromProcess(),
				process.getEntityType(), process.getExecutionType(), process.isDirectPrint(), process.isReport(),
				parameters);
	}

	private static ProcessParameter createProcessParameterInstance(MProcessPara param) {
		return new ProcessParameter(param.getAD_Client_ID(), param.getAD_Org_ID(), param.getAD_Process_Para_UU(),
				param.isActive(), param.getCreated(), param.getCreatedBy(), param.getName(), param.getDescription(),
				param.getAD_Element_ID(), param.getAD_Reference_ID(), param.getAD_Reference_Value_ID(),
				param.getAD_Val_Rule_ID(), param.getDefaultValue(), param.getDefaultValue2(), param.getDisplayLogic(),
				param.getEntityType(), param.getFieldLength(), param.isEncrypted(), param.isMandatory(),
				param.isRange(), param.getMandatoryLogic());
	}

	private static ProcessInfoParameter[] getInfoParameters(List<BHProcessInfoParameter> params) {
		ProcessInfoParameter[] results = new ProcessInfoParameter[params.size()];
		for (int index = 0; index < params.size(); index++) {
			BHProcessInfoParameter param = params.get(index);
			results[index] = new ProcessInfoParameter(param.getParameterName(), param.getParameter(),
					param.getParameterTo(), param.getInfo(), param.getInfoTo());
		}

		return results;
	}
}
