package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.compiere.model.MBPGroup;
import org.compiere.model.Query;

public class MBPartnerInput extends X_C_BPartnerInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BPartner_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBPartnerInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}

	@Override
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		super.setC_BP_GroupInput(C_BP_Group);
		if (getC_BP_Group_ID() > 0) {
			this.setBPGroup(MBPGroup.get(getCtx(), getC_BP_Group_ID()));
		}
	}
}
