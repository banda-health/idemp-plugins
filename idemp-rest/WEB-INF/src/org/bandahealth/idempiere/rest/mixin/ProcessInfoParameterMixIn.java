package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"parameterAsInt", "parameterAsBoolean", "parameter_ToAsInt", "parameter_ToAsBoolean",
		"parameter_ToAsTimestamp", "parameterAsTimestamp", "parameterAsString", "parameterAsBigDecimal"})
public abstract class ProcessInfoParameterMixIn extends ProcessInfoParameter implements POMixIn {
	@JsonCreator
	public ProcessInfoParameterMixIn(@JsonProperty("parameterName") String parameterName,
			@JsonProperty("parameter") Object parameter, @JsonProperty("parameter_To") Object parameter_To,
			@JsonProperty("info") String info, @JsonProperty("info_To") String info_To) {
		super(parameterName, parameter, parameter_To, info, info_To);
	}
}
