package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"lookup", "referenceTableName", "ad_Element", "ad_Process", "ad_Reference",
		"ad_Reference_Value", "ad_Val_Rule"})
public abstract class ProcessParameterMixIn implements POMixIn {
}
