package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Concept_Category;

/**
 * Generated Interface for HR_Concept_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_HR_Concept_CategoryInput extends I_HR_Concept_Category {

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
	 * Set HR_Concept_A.
	 *
	 * @param HR_Concept_A HR_Concept_A
	 */
	void setHR_Concept_AInput(ForeignEntityInput HR_Concept_A);

	/**
	 * Get HR_Concept_A.
	 *
	 * @return HR_Concept_A
	 */
	ForeignEntityInput HR_Concept_A();

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
}
