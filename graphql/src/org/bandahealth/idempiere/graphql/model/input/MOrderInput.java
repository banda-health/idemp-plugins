package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MBPartner;

public class MOrderInput extends X_C_OrderInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Order_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MOrderInput(@JsonProperty("UU") String UUID, @JsonProperty("IsSOTrx") Boolean IsSOTrx) {
		super(UUID);
		// The sales order transaction needs to be set before the BPartner input would be
		if (IsSOTrx != null) {
			setIsSOTrx(IsSOTrx);
		}
	}

	@Override
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		super.setC_BPartnerInput(C_BPartner);
		if (getC_BPartner_ID() > 0) {
			// Since the setter overrides the following properties, get them in case we need to re-set them
			Integer paymentTermID = (Integer) get_Value(COLUMNNAME_C_PaymentTerm_ID);
			Integer priceListID = (Integer) get_Value(COLUMNNAME_M_PriceList_ID);
			String paymentRule = (String) get_Value(COLUMNNAME_PaymentRule);
			Integer bpartnerLocationID = (Integer) get_Value(COLUMNNAME_C_BPartner_Location_ID);
			Integer userID = (Integer) get_Value(COLUMNNAME_AD_User_ID);

			this.setBPartner(MBPartner.get(getCtx(), getC_BPartner_ID()));

			if (paymentTermID != null) {
				this.setC_PaymentTerm_ID(paymentTermID);
			}
			if (priceListID != null) {
				this.setM_PriceList_ID(priceListID);
			}
			if (paymentRule != null) {
				this.setPaymentRule(paymentRule);
			}
			if (bpartnerLocationID != null) {
				this.setC_BPartner_Location_ID(bpartnerLocationID);
			}
			if (userID != null) {
				this.setAD_User_ID(userID);
			}
		}
	}
}
