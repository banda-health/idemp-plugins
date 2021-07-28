package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface POMixIn {
	@JsonProperty("id") int get_ID();
	@JsonProperty("clientId") int getAD_Client_ID();
	@JsonProperty("organizationId") int getAD_Org_ID();
	@JsonProperty("isActive") boolean isActive();
}
