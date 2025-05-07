package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_Status;

/**
 * Generated Interface for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_R_StatusInput extends I_R_Status {

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
	 * Set Next_Status.
	 *
	 * @param Next_Status Move to next status automatically after timeout
	 */
	void setNext_StatusInput(ForeignEntityInput Next_Status);

	/**
	 * Get Next_Status.
	 *
	 * @return Move to next status automatically after timeout
	 */
	ForeignEntityInput Next_Status();

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
	 * Set Update_Status.
	 *
	 * @param Update_Status Automatically change the status after entry from web
	 */
	void setUpdate_StatusInput(ForeignEntityInput Update_Status);

	/**
	 * Get Update_Status.
	 *
	 * @return Automatically change the status after entry from web
	 */
	ForeignEntityInput Update_Status();
}
