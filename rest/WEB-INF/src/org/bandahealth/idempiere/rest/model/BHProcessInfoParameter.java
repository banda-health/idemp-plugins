package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "processinfoparameter")
public class BHProcessInfoParameter extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private String parameterName;
	private Object parameter;
	private Object parameterTo;
	private String info;
	private String infoTo;

	public BHProcessInfoParameter() {
	}

	public BHProcessInfoParameter(String parameterName, Object parameter, Object parameterTo, String info,
			String infoTo) {
		this.parameterName = parameterName;
		this.parameter = parameter;
		this.parameterTo = parameterTo;
		this.info = info;
		this.infoTo = infoTo;
	}

	@XmlElement
	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	@XmlElement
	public Object getParameter() {
		return parameter;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}

	@XmlElement
	public Object getParameterTo() {
		return parameterTo;
	}

	public void setParameterTo(Object parameterTo) {
		this.parameterTo = parameterTo;
	}

	@XmlElement
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@XmlElement
	public String getInfoTo() {
		return infoTo;
	}

	public void setInfoTo(String infoTo) {
		this.infoTo = infoTo;
	}

}
