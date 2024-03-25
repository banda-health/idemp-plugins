package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Withholding;

/**
 * Generated Interface for C_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_WithholdingInput extends I_C_Withholding {

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
	 * Set Benefici.
	 *
	 * @param Benefici Business Partner to whom payment is made
	 */
	void setBeneficiInput(ForeignEntityInput Benefici);

	/**
	 * Get Benefici.
	 *
	 * @return Business Partner to whom payment is made
	 */
	ForeignEntityInput Benefici();

	/**
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	ForeignEntityInput C_PaymentTerm();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();
}
