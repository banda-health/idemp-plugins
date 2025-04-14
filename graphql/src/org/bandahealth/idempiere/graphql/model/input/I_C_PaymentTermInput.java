package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaymentTerm;

/**
 * Generated Interface for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_PaymentTermInput extends I_C_PaymentTerm {

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
	 * Set NetDay.
	 *
	 * @param NetDay Day when payment is due net
	 */
	void setNetDayInput(ForeignEntityInput NetDay);

	/**
	 * Get NetDay.
	 *
	 * @return Day when payment is due net
	 */
	ForeignEntityInput NetDay();

	/**
	 * Set PaymentTermUsage.
	 *
	 * @param PaymentTermUsage Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	void setPaymentTermUsageInput(ForeignEntityInput PaymentTermUsage);

	/**
	 * Get PaymentTermUsage.
	 *
	 * @return Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	ForeignEntityInput PaymentTermUsage();
}
