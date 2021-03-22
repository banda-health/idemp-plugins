package org.bandahealth.idempiere.rest.model;

public class ProcessInfoParameter extends BaseMetadata {
	private String processParameterUuid;
	private String parameterName;
	private Object parameter;
	private Object parameterTo;
	private String info;
	private String infoTo;

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public Object getParameter() {
		return parameter;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}

	public Object getParameterTo() {
		return parameterTo;
	}

	public void setParameterTo(Object parameterTo) {
		this.parameterTo = parameterTo;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	public String getInfoTo() {
		return infoTo;
	}

	public void setInfoTo(String infoTo) {
		this.infoTo = infoTo;
	}

	public String getProcessParameterUuid() {
		return processParameterUuid;
	}

	public void setProcessParameterUuid(String processParameterUuid) {
		this.processParameterUuid = processParameterUuid;
	}
}
