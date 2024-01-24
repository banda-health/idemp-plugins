package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_RequestUpdate;

/**
 * Generated Interface for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_R_RequestUpdateInput extends I_R_RequestUpdate {

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
	 * Set ConfidentialTypeEntry.
	 *
	 * @param ConfidentialTypeEntry Confidentiality of the individual entry
	 */
	void setConfidentialTypeEntryInput(I_AD_Ref_ListInput ConfidentialTypeEntry);

	/**
	 * Get ConfidentialTypeEntry.
	 *
	 * @return Confidentiality of the individual entry
	 */
	I_AD_Ref_ListInput ConfidentialTypeEntry();

	/**
	 * Set M_ProductSpent.
	 *
	 * @param M_ProductSpent Product/Resource/Service used in Request
	 */
	void setM_ProductSpentInput(ForeignEntityInput M_ProductSpent);

	/**
	 * Get M_ProductSpent.
	 *
	 * @return Product/Resource/Service used in Request
	 */
	ForeignEntityInput M_ProductSpent();

	/**
	 * Set R_Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	void setR_RequestInput(ForeignEntityInput R_Request);

	/**
	 * Get R_Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	ForeignEntityInput R_Request();

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
