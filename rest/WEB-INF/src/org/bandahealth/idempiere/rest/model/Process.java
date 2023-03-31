package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.compiere.model.MProcess;

@XmlRootElement(name = "process")
@JsonInclude(value = Include.NON_NULL)
public class Process extends BaseEntity {

	public final static String PROCESSING_MESSAGE = "Processing Transaction";
	private static final long serialVersionUID = 1L;
	private int adFormId;
	private int adReportViewId;
	private int adWorkflowId;
	private String allowMultipleExecution;
	private String classname;
	private String copyFromProcess;
	private String entityType;
	private String executionType;
	private boolean isDirectPrint;
	private boolean isReport;
	private List<ProcessParameter> parameters = new ArrayList<>();
	private boolean needsManualInput;

	public Process() {
		super();
	}

	public Process(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String description, int adFormId, int adReportViewId, int adWorkflowId, String allowMultipleExecution,
			String classname, String copyFromProcess, String entityType, String executionType, boolean isDirectPrint,
			boolean isReport, List<ProcessParameter> parameters) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.adFormId = adFormId;
		this.adReportViewId = adReportViewId;
		this.adWorkflowId = adWorkflowId;
		this.allowMultipleExecution = allowMultipleExecution;
		this.classname = classname;
		this.copyFromProcess = copyFromProcess;
		this.entityType = entityType;
		this.executionType = executionType;
		this.isDirectPrint = isDirectPrint;
		this.isReport = isReport;
		this.parameters = parameters;
	}

	public Process(MProcess_BH model, List<ProcessParameter> parameters) {
		super(model, model.getName(), model.getDescription(), null);

		this.adFormId = model.getAD_Form_ID();
		this.adReportViewId = model.getAD_ReportView_ID();
		this.adWorkflowId = model.getAD_Workflow_ID();
		this.allowMultipleExecution = model.getAllowMultipleExecution();
		this.classname = model.getClassname();
		this.copyFromProcess = model.getCopyFromProcess();
		this.entityType = model.getEntityType();
		this.executionType = model.getExecutionType();
		this.isDirectPrint = model.isDirectPrint();
		this.isReport = model.isReport();
		this.parameters = parameters != null ? parameters : this.parameters;
	}

	@XmlElement
	public int getAdFormId() {
		return adFormId;
	}

	public void setAdFormId(int adFormId) {
		this.adFormId = adFormId;
	}

	@XmlElement
	public int getAdReportViewId() {
		return adReportViewId;
	}

	public void setAdReportViewId(int adReportViewId) {
		this.adReportViewId = adReportViewId;
	}

	@XmlElement
	public int getAdWorkflowId() {
		return adWorkflowId;
	}

	public void setAdWorkflowId(int adWorkflowId) {
		this.adWorkflowId = adWorkflowId;
	}

	@XmlElement
	public String getAllowMultipleExecution() {
		return allowMultipleExecution;
	}

	public void setAllowMultipleExecution(String allowMultipleExecution) {
		this.allowMultipleExecution = allowMultipleExecution;
	}

	@XmlElement
	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@XmlElement
	public String getCopyFromProcess() {
		return copyFromProcess;
	}

	public void setCopyFromProcess(String copyFromProcess) {
		this.copyFromProcess = copyFromProcess;
	}

	@XmlElement
	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@XmlElement
	public String getExecutionType() {
		return executionType;
	}

	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}

	@XmlElement
	public boolean isDirectPrint() {
		return isDirectPrint;
	}

	public void setDirectPrint(boolean isDirectPrint) {
		this.isDirectPrint = isDirectPrint;
	}

	@XmlElement
	public boolean isReport() {
		return isReport;
	}

	public void setReport(boolean isReport) {
		this.isReport = isReport;
	}

	@XmlElement
	public List<ProcessParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<ProcessParameter> parameters) {
		this.parameters = parameters;
	}

	public boolean getNeedsManualInput() {
		return this.needsManualInput;
	}

	public void setNeedsManualInput(boolean needsManualInput) {
		this.needsManualInput = needsManualInput;
	}
}
