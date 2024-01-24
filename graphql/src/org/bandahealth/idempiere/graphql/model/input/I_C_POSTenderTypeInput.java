package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_POSTenderType;

/**
 * Generated Interface for C_POSTenderType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_POSTenderTypeInput extends I_C_POSTenderType {

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
