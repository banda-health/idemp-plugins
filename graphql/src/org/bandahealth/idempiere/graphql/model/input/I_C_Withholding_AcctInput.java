package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Withholding_Acct;

/**
 * Generated Interface for C_Withholding_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_Withholding_AcctInput extends I_C_Withholding_Acct {

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

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

	/**
	 * Set Withholding_A.
	 *
	 * @param Withholding_A Account for Withholdings
	 */
	void setWithholding_AInput(ForeignEntityInput Withholding_A);

	/**
	 * Get Withholding_A.
	 *
	 * @return Account for Withholdings
	 */
	ForeignEntityInput Withholding_A();
}
