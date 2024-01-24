package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForeignEntityInput {
	@JsonProperty("UUID")
	private String UUID;

	@JsonProperty("UUID")
	public String getUUID() {
		return UUID;
	}

	@JsonProperty("UUID")
	public void setUUID(String UUID) {
		this.UUID = UUID;
	}
}
