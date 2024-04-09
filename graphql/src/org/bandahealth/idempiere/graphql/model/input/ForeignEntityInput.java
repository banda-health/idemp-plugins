package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForeignEntityInput {
	@JsonProperty("UU")
	private String UU;

	@JsonProperty("UU")
	public String getUU() {
		return UU;
	}

	@JsonProperty("UU")
	public void setUU(String UU) {
		this.UU = UU;
	}
}
