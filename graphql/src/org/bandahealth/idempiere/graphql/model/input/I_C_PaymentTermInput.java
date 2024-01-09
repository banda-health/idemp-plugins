package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaymentTerm;

/**
 * Generated Interface for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_PaymentTermInput extends I_C_PaymentTerm {

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
	 * Set NetDay.
	 *
	 * @param NetDay Day when payment is due net
	 */
	void setNetDayInput(I_AD_Ref_ListInput NetDay);

	/**
	 * Get NetDay.
	 *
	 * @return Day when payment is due net
	 */
	I_AD_Ref_ListInput NetDay();

	/**
	 * Set PaymentTermUsage.
	 *
	 * @param PaymentTermUsage Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	void setPaymentTermUsageInput(I_AD_Ref_ListInput PaymentTermUsage);

	/**
	 * Get PaymentTermUsage.
	 *
	 * @return Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	I_AD_Ref_ListInput PaymentTermUsage();
}
