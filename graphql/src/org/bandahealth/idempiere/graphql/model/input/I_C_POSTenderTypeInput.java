package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_POSTenderType;

/**
 * Generated Interface for C_POSTenderType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_POSTenderTypeInput extends I_C_POSTenderType {

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
