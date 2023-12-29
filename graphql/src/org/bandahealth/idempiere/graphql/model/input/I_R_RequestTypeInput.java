package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_RequestType;

/**
 * Generated Interface for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_R_RequestTypeInput extends I_R_RequestType {

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
	 * Set ConfidentialType_RL.
	 *
	 * @param ConfidentialType_RL Type of Confidentiality
	 */
	void setConfidentialType_RL(I_AD_Ref_ListInput ConfidentialType_RL);

	/**
	 * Get ConfidentialType_RL.
	 *
	 * @return Type of Confidentiality
	 */
	I_AD_Ref_ListInput getConfidentialType_RL();

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
	 * Set R_StatusCategory.
	 *
	 * @param R_StatusCategory Request Status Category
	 */
	void setR_StatusCategory(I_R_StatusCategoryInput R_StatusCategory);

	/**
	 * Get R_StatusCategory.
	 *
	 * @return Request Status Category
	 */
	I_R_StatusCategoryInput getR_StatusCategory();
}
