package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.process.ProcessInfoParameter;

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

	public ForeignEntityInput getAD_Process() {
		return mAD_Process;
	}

	public void setAD_Process(ForeignEntityInput mAD_Process) {
		this.mAD_Process = mAD_Process;
	}
}
