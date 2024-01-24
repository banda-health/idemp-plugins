package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_POSPayment;

/**
 * Generated Interface for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_POSPaymentInput extends I_C_POSPayment {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

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
	void setCheckStatusInput(I_AD_Ref_ListInput CheckStatus);

	/**
	 * Get CheckStatus.
	 *
	 * @return CheckStatus
	 */
	I_AD_Ref_ListInput CheckStatus();

	/**
	 * Set CreditCardType.
	 *
	 * @param CreditCardType Credit Card (Visa, MC, AmEx)
	 */
	void setCreditCardTypeInput(I_AD_Ref_ListInput CreditCardType);

	/**
	 * Get CreditCardType.
	 *
	 * @return Credit Card (Visa, MC, AmEx)
	 */
	I_AD_Ref_ListInput CreditCardType();

	/**
	 * Set TenderType.
	 *
	 * @param TenderType Method of Payment
	 */
	void setTenderTypeInput(I_AD_Ref_ListInput TenderType);

	/**
	 * Get TenderType.
	 *
	 * @return Method of Payment
	 */
	I_AD_Ref_ListInput TenderType();
}
