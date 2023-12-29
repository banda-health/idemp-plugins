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
	 * Set TenderType_RL.
	 *
	 * @param TenderType_RL Method of Payment
	 */
	void setTenderType_RL(I_AD_Ref_ListInput TenderType_RL);

	/**
	 * Get TenderType_RL.
	 *
	 * @return Method of Payment
	 */
	I_AD_Ref_ListInput getTenderType_RL();
}
