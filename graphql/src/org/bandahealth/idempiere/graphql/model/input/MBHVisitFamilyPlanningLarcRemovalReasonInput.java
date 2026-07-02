package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHVisitFamilyPlanningLarcRemovalReasonInput extends X_BH_Visit_Family_Planning_Larc_Removal_ReasonInput {
	@JsonCreator
	public MBHVisitFamilyPlanningLarcRemovalReasonInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}
