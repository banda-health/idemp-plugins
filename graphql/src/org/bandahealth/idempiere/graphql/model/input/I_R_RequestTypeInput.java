package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_RequestType;

/**
 * Generated Interface for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_R_RequestTypeInput extends I_R_RequestType {

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
	 * Set ConfidentialType.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	void setConfidentialTypeInput(ForeignEntityInput ConfidentialType);

	/**
	 * Get ConfidentialType.
	 *
	 * @return Type of Confidentiality
	 */
	ForeignEntityInput ConfidentialType();

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
