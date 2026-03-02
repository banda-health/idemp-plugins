package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MBPGroup;

public class MBPartnerInput extends X_C_BPartnerInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BPartner_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBPartnerInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}

	@Override
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		super.setC_BP_GroupInput(C_BP_Group);
		if (getC_BP_Group_ID() > 0) {
			// Since the setter overrides the following properties, get them in case we need to re-set them
			Integer dunningID = (Integer) get_Value(COLUMNNAME_C_Dunning_ID);
			Integer priceListID = (Integer) get_Value(COLUMNNAME_M_PriceList_ID);
			Integer poPriceListID = (Integer) get_Value(COLUMNNAME_PO_PriceList_ID);
			Integer discountSchemaID = (Integer) get_Value(COLUMNNAME_M_DiscountSchema_ID);
			Integer poDiscountSchemaID = (Integer) get_Value(COLUMNNAME_PO_DiscountSchema_ID);

			this.setBPGroup(MBPGroup.get(getCtx(), getC_BP_Group_ID()));

			if (dunningID != null) {
				this.setC_Dunning_ID(dunningID);
			}
			if (priceListID != null) {
				this.setM_PriceList_ID(priceListID);
			}
			if (poPriceListID != null) {
				this.setPO_PriceList_ID(poPriceListID);
			}
			if (discountSchemaID != null) {
				this.setM_DiscountSchema_ID(discountSchemaID);
			}
			if (poDiscountSchemaID != null) {
				this.setPO_DiscountSchema_ID(poDiscountSchemaID);
			}
		}
	}
}
