package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHVisitFamilyPlanningProductInput extends X_BH_Visit_Family_Planning_ProductInput {
	@JsonCreator
	public MBHVisitFamilyPlanningProductInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}
