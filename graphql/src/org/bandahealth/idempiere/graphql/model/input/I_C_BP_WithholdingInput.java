package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_Withholding;

/**
 * Generated Interface for C_BP_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_BP_WithholdingInput extends I_C_BP_Withholding {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

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
	 * Set C_Withholding.
	 *
	 * @param C_Withholding Withholding type defined
	 */
	void setC_WithholdingInput(ForeignEntityInput C_Withholding);

	/**
	 * Get C_Withholding.
	 *
	 * @return Withholding type defined
	 */
	ForeignEntityInput C_Withholding();
}
