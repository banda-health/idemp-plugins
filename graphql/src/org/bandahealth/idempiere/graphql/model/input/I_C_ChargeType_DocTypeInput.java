package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ChargeType_DocType;

/**
 * Generated Interface for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ChargeType_DocTypeInput extends I_C_ChargeType_DocType {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

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
	 * Set C_ChargeType.
	 *
	 * @param C_ChargeType C_ChargeType
	 */
	void setC_ChargeTypeInput(I_C_ChargeTypeInput C_ChargeType);

	/**
	 * Get C_ChargeType.
	 *
	 * @return C_ChargeType
	 */
	I_C_ChargeTypeInput C_ChargeType();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(I_C_DocTypeInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	I_C_DocTypeInput C_DocType();
}
