package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.Query;

import java.sql.Timestamp;

public class MInvoiceInput extends X_C_InvoiceInput {
	private String explicitPaymentRule;
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Invoice_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInvoiceInput(@JsonProperty("UU") String UUID, @JsonProperty("IsSOTrx") Boolean IsSOTrx) {
		super(UUID);
		// The sales order transaction needs to be set before the BPartner input would be
		if (IsSOTrx != null) {
			setIsSOTrx(IsSOTrx);
		}
	}

	@Override
	public void setPaymentRuleInput(ForeignEntityInput PaymentRule) {
		super.setPaymentRuleInput(PaymentRule);
		if (PaymentRule != null) {
			explicitPaymentRule = getPaymentRule();
		}
	}

	@Override
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		super.setC_BPartnerInput(C_BPartner);
		if (getC_BPartner_ID() > 0) {
			// Since the setter overrides the following properties, get them in case we need to re-set them
			Integer paymentTermID = (Integer) get_Value(COLUMNNAME_C_PaymentTerm_ID);
			Integer priceListID = (Integer) get_Value(COLUMNNAME_M_PriceList_ID);
			String paymentRule = explicitPaymentRule != null ? explicitPaymentRule :
					(String) get_Value(COLUMNNAME_PaymentRule);
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

	@Override
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		super.setC_OrderInput(C_Order);
		if (getC_Order_ID() > 0) {
			// Since the setter overrides the following properties, get them in case we need to re-set them
			Boolean isDiscountPrinted = (Boolean) get_Value(COLUMNNAME_IsDiscountPrinted);
			Boolean isSelfService = (Boolean) get_Value(COLUMNNAME_IsSelfService);
			Boolean sendEMail = (Boolean) get_Value(COLUMNNAME_SendEMail);
			//
			Integer priceListID = (Integer) get_Value(COLUMNNAME_M_PriceList_ID);
			Boolean isTaxIncluded = (Boolean) get_Value(COLUMNNAME_IsTaxIncluded);
			Integer currencyID = (Integer) get_Value(COLUMNNAME_C_Currency_ID);
			Integer conversionTypeID = (Integer) get_Value(COLUMNNAME_C_ConversionType_ID);
			//
			String paymentRule = (String) get_Value(COLUMNNAME_PaymentRule);
			Integer paymentTermID = (Integer) get_Value(COLUMNNAME_C_PaymentTerm_ID);
			String poReference = (String) get_Value(COLUMNNAME_POReference);
			String description = (String) get_Value(COLUMNNAME_Description);
			Timestamp dateOrdered = (Timestamp) get_Value(COLUMNNAME_DateOrdered);
			//
			Integer orgTrxID = (Integer) get_Value(COLUMNNAME_AD_OrgTrx_ID);
			Integer projectID = (Integer) get_Value(COLUMNNAME_C_Project_ID);
			Integer campaignID = (Integer) get_Value(COLUMNNAME_C_Campaign_ID);
			Integer activityID = (Integer) get_Value(COLUMNNAME_C_Activity_ID);
			Integer user1ID = (Integer) get_Value(COLUMNNAME_User1_ID);
			Integer user2ID = (Integer) get_Value(COLUMNNAME_User2_ID);

			this.setOrder(new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?",
					get_TrxName()).setParameters(getC_Order_ID()).first());

			if (isDiscountPrinted != null) {
				this.setIsDiscountPrinted(isDiscountPrinted);
			}
			if (isSelfService != null) {
				this.setIsSelfService(isSelfService);
			}
			if (sendEMail != null) {
				this.setSendEMail(sendEMail);
			}
			if (priceListID != null) {
				this.setM_PriceList_ID(priceListID);
			}
			if (isTaxIncluded != null) {
				this.setIsTaxIncluded(isTaxIncluded);
			}
			if (currencyID != null) {
				this.setC_Currency_ID(currencyID);
			}
			if (conversionTypeID != null) {
				this.setC_ConversionType_ID(conversionTypeID);
			}
			if (paymentRule != null) {
				this.setPaymentRule(paymentRule);
			}
			if (paymentTermID != null) {
				this.setC_PaymentTerm_ID(paymentTermID);
			}
			if (poReference != null) {
				this.setPOReference(poReference);
			}
			if (description != null) {
				this.setDescription(description);
			}
			if (dateOrdered != null) {
				this.setDateOrdered(dateOrdered);
			}
			if (orgTrxID != null) {
				this.setAD_OrgTrx_ID(orgTrxID);
			}
			if (projectID != null) {
				this.setC_Project_ID(projectID);
			}
			if (campaignID != null) {
				this.setC_Campaign_ID(campaignID);
			}
			if (activityID != null) {
				this.setC_Activity_ID(activityID);
			}
			if (user1ID != null) {
				this.setUser1_ID(user1ID);
			}
			if (user2ID != null) {
				this.setUser2_ID(user2ID);
			}
		}
	}
}
