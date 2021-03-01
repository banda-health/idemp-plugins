package org.bandahealth.idempiere.rest.model;

import java.util.List;

public class ProcessInfo extends BaseEntity {
	private String processId;
	private String title;
	private List<ProcessInfoParameter> parameters;
	private ReportOutput reportOutputType;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ProcessInfoParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<ProcessInfoParameter> parameters) {
		this.parameters = parameters;
	}

	public ReportOutput getReportOutputType() {
		return reportOutputType;
	}

	public void setReportOutputType(ReportOutput reportOutputType) {
		this.reportOutputType = reportOutputType;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
}
