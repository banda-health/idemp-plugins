package org.bandahealth.idempiere.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "processinfo")
public class BHProcessInfo extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private String title;
	private int processId;
	private int tableId;
	private int recordId;
	private String summary;
	private boolean error;
	private boolean batch;
	private boolean timeout;
	private int pinstanceId;

	private List<BHProcessInfoParameter> parameters;

	public BHProcessInfo() {
	}

	public BHProcessInfo(String title, int processId, int tableId, int recordId) {
		this.title = title;
		this.processId = processId;
		this.tableId = tableId;
		this.recordId = recordId;
	}

	public BHProcessInfo(String title, int processId) {
		this(title, processId, 0, 0);
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	@XmlElement
	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@XmlElement
	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	@XmlElement
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@XmlElement
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public boolean isBatch() {
		return batch;
	}

	public void setBatch(boolean batch) {
		this.batch = batch;
	}

	@XmlElement
	public boolean isTimeout() {
		return timeout;
	}

	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}

	@XmlElement
	public int getPinstanceId() {
		return pinstanceId;
	}

	public void setPinstanceId(int pinstanceId) {
		this.pinstanceId = pinstanceId;
	}

	@XmlElement
	public List<BHProcessInfoParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<BHProcessInfoParameter> parameters) {
		this.parameters = parameters;
	}

}
