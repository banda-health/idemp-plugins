package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_RequestType;

/**
 * Generated Interface for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_R_RequestTypeInput extends I_R_RequestType {

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
	 * Set ConfidentialType.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	void setConfidentialTypeInput(I_AD_Ref_ListInput ConfidentialType);

	/**
	 * Get ConfidentialType.
	 *
	 * @return Type of Confidentiality
	 */
	I_AD_Ref_ListInput ConfidentialType();

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
	 * Set R_StatusCategory.
	 *
	 * @param R_StatusCategory Request Status Category
	 */
	void setR_StatusCategoryInput(ForeignEntityInput R_StatusCategory);

	/**
	 * Get R_StatusCategory.
	 *
	 * @return Request Status Category
	 */
	ForeignEntityInput R_StatusCategory();
}
