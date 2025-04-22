package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_POSPayment;

/**
 * Generated Interface for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_POSPaymentInput extends I_C_POSPayment {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(ForeignEntityInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	ForeignEntityInput C_Order();

	/**
	 * Set C_Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	void setC_PaymentInput(ForeignEntityInput C_Payment);

	/**
	 * Get C_Payment.
	 *
	 * @return Payment identifier
	 */
	ForeignEntityInput C_Payment();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set C_POSTenderType.
	 *
	 * @param C_POSTenderType C_POSTenderType
	 */
	void setC_POSTenderTypeInput(ForeignEntityInput C_POSTenderType);

	/**
	 * Get C_POSTenderType.
	 *
	 * @return C_POSTenderType
	 */
	ForeignEntityInput C_POSTenderType();

	/**
	 * Set CheckStatus.
	 *
	 * @param CheckStatus CheckStatus
	 */
	void setCheckStatusInput(ForeignEntityInput CheckStatus);

	/**
	 * Get CheckStatus.
	 *
	 * @return CheckStatus
	 */
	ForeignEntityInput CheckStatus();

	/**
	 * Set CreditCardType.
	 *
	 * @param CreditCardType Credit Card (Visa, MC, AmEx)
	 */
	void setCreditCardTypeInput(ForeignEntityInput CreditCardType);

	/**
	 * Get CreditCardType.
	 *
	 * @return Credit Card (Visa, MC, AmEx)
	 */
	ForeignEntityInput CreditCardType();

	/**
	 * Set TenderType.
	 *
	 * @param TenderType Method of Payment
	 */
	void setTenderTypeInput(ForeignEntityInput TenderType);

	/**
	 * Get TenderType.
	 *
	 * @return Method of Payment
	 */
	ForeignEntityInput TenderType();
}
