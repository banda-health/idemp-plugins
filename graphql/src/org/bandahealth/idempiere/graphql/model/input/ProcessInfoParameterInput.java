package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.process.ProcessInfoParameter;

import java.math.BigDecimal;

public class ProcessInfoParameterInput extends ProcessInfoParameter {
	private ForeignEntityInput mAD_Process;

	public ProcessInfoParameterInput() {
		super(null, null, null, null, null);
	}

	/**
	 * Construct Parameter
	 *
	 * @param parameterName parameter name
	 * @param parameter     parameter
	 * @param parameter_To  to parameter
	 * @param info          info
	 * @param info_To       to info
	 */
	public ProcessInfoParameterInput(String parameterName, Object parameter, Object parameter_To, String info,
			String info_To) {
		super(parameterName, parameter, parameter_To, info, info_To);
	}

	@JsonProperty("AD_Process")
	public ForeignEntityInput getAD_Process() {
		return mAD_Process;
	}

	@JsonProperty("AD_Process")
	public void setAD_Process(ForeignEntityInput mAD_Process) {
		this.mAD_Process = mAD_Process;
	}

	@Override
	@JsonProperty("Info")
	public String getInfo() {
		return super.getInfo();
	}

	@Override
	@JsonProperty("Info_To")
	public String getInfo_To() {
		return super.getInfo_To();
	}

	@Override
	@JsonProperty("Parameter")
	public Object getParameter() {
		return super.getParameter();
	}

	@Override
	@JsonProperty("Parameter_To")
	public Object getParameter_To() {
		return super.getParameter_To();
	}

	@Override
	@JsonProperty("ParameterName")
	public String getParameterName() {
		return super.getParameterName();
	}

	@Override
	@JsonProperty("Info")
	public void setInfo(String Info) {
		super.setInfo(Info);
	}

	@Override
	@JsonProperty("Info_To")
	public void setInfo_To(String Info_To) {
		super.setInfo_To(Info_To);
	}

	@Override
	@JsonProperty("Parameter")
	public void setParameter(Object Parameter) {
		super.setParameter(Parameter);
	}

	@Override
	@JsonProperty("Parameter_To")
	public void setParameter_To(Object Parameter_To) {
		super.setParameter_To(Parameter_To);
	}

	@Override
	@JsonProperty("ParameterName")
	public void setParameterName(String ParameterName) {
		super.setParameterName(ParameterName);
	}
}
