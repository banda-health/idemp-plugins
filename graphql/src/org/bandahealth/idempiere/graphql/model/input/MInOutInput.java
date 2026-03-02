package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MBPartner;

public class MInOutInput extends X_M_InOutInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_InOut_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInOutInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}

	@Override
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		super.setC_BPartnerInput(C_BPartner);
		if (getC_BPartner_ID() > 0) {
			// Since the setter overrides the following properties, get them in case we need to re-set them
			Integer bpartnerLocationID = (Integer) get_Value(COLUMNNAME_C_BPartner_Location_ID);
			Integer userID = (Integer) get_Value(COLUMNNAME_AD_User_ID);

			this.setBPartner(MBPartner.get(getCtx(), getC_BPartner_ID()));

			if (bpartnerLocationID != null) {
				this.setC_BPartner_Location_ID(bpartnerLocationID);
			}
			if (userID != null) {
				this.setAD_User_ID(userID);
			}
		}
	}
}
