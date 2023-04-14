package org.bandahealth.idempiere.rest.service.db;

import java.io.File;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MPInstance;
import org.compiere.model.MProcess;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
import org.compiere.util.Env;

/**
 * Abstracts iDempiere Reports Service
 * 
 * @author andrew
 *
 */
public abstract class BaseReportDBProcess {

	/**
	 * Generates Report
	 * 
	 * @param reportName
	 * @param parameters
	 * @return
	 */
	protected File generateReport(String reportName, String reportOutputType, ProcessInfoParameter[] parameters) {
		MProcess mprocess = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_Name + "=?", null)
				.setOnlyActiveRecords(true).setParameters(reportName).first();

		if (mprocess == null) {
			throw new AdempiereException("Could not find report " + reportName);
		}

		MPInstance mpInstance = new MPInstance(mprocess, 0);

		ProcessInfo processInfo = new ProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(mprocess.getAD_Process_UU());
		processInfo.setIsBatch(true);
		processInfo.setExport(true);
		processInfo.setReportType(reportOutputType.toUpperCase());
		processInfo.setExportFileExtension(reportOutputType.toLowerCase());

		if (parameters != null) {
			processInfo.setParameter(parameters);
		}

		ServerProcessCtl.process(processInfo, null);

		if (processInfo.isError()) {
			throw new AdempiereException("Could not generate report " + reportName);
		}

		if (processInfo.getExportFile() != null) {
			return processInfo.getExportFile();
		}

		return null;
	}

}
