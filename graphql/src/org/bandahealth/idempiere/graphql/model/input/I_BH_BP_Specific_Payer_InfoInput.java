package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_BP_Specific_Payer_Info;

/**
 * Generated Interface for BH_BP_Specific_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_BH_BP_Specific_Payer_InfoInput extends I_BH_BP_Specific_Payer_Info {

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

	/**
	 * Set BH_Payer_Info_Fld.
	 *
	 * @param BH_Payer_Info_Fld BH_Payer_Info_Fld
	 */
	void setBH_Payer_Info_FldInput(ForeignEntityInput BH_Payer_Info_Fld);

	/**
	 * Get BH_Payer_Info_Fld.
	 *
	 * @return BH_Payer_Info_Fld
	 */
	ForeignEntityInput BH_Payer_Info_Fld();

	/**
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	ForeignEntityInput C_InvoiceLine();
}
