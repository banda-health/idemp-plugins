package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MBHVisitFamilyPlanningInput extends X_BH_Visit_Family_PlanningInput {
	private List<MBHVisitFamilyPlanningProductInput> BH_Visit_Family_Planning_Products = new ArrayList<>();
	private List<MBHVisitFamilyPlanningLarcRemovalReasonInput> BH_Larc_Removal_Reasons = new ArrayList<>();

	@JsonCreator
	public MBHVisitFamilyPlanningInput(@JsonProperty("UU") String UU) {
		super(UU);
	}

	@JsonProperty("BH_Visit_Family_Planning_Products")
	public List<MBHVisitFamilyPlanningProductInput> getBH_Visit_Family_Planning_Products() {
		return BH_Visit_Family_Planning_Products;
	}

	public void setBH_Visit_Family_Planning_Products(
			List<MBHVisitFamilyPlanningProductInput> BH_Visit_Family_Planning_Products) {
		this.BH_Visit_Family_Planning_Products = BH_Visit_Family_Planning_Products;
	}

	@JsonProperty("BH_Larc_Removal_Reasons")
	public List<MBHVisitFamilyPlanningLarcRemovalReasonInput> getBH_Larc_Removal_Reasons() {
		return BH_Larc_Removal_Reasons;
	}

	public void setBH_Larc_Removal_Reasons(List<MBHVisitFamilyPlanningLarcRemovalReasonInput> BH_Larc_Removal_Reasons) {
		this.BH_Larc_Removal_Reasons = BH_Larc_Removal_Reasons;
	}
}
