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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

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
	 * Set NetDay_RL.
	 *
	 * @param NetDay_RL Day when payment is due net
	 */
	void setNetDay_RL(I_AD_Ref_ListInput NetDay_RL);

	/**
	 * Get NetDay_RL.
	 *
	 * @return Day when payment is due net
	 */
	I_AD_Ref_ListInput getNetDay_RL();

	/**
	 * Set PaymentTermUsage_RL.
	 *
	 * @param PaymentTermUsage_RL Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	void setPaymentTermUsage_RL(I_AD_Ref_ListInput PaymentTermUsage_RL);

	/**
	 * Get PaymentTermUsage_RL.
	 *
	 * @return Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	I_AD_Ref_ListInput getPaymentTermUsage_RL();
}
