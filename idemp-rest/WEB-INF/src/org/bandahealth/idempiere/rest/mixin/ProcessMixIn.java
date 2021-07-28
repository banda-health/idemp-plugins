package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"parameters", "parameter", "javaProcess", "forceBackground", "forceForeground",
		"workflow", "ad_CtxHelp", "ad_Form", "ad_PrintFormat", "ad_ReportView", "ad_Workflow"})
public abstract class ProcessMixIn implements POMixIn {
}
