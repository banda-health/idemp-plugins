package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Allergy;

/**
 * Generated Interface for BH_Allergy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_AllergyInput extends I_BH_Allergy {

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
	 * Set BH_Concept.
	 *
	 * @param BH_Concept BH_Concept
	 */
	void setBH_ConceptInput(ForeignEntityInput BH_Concept);

	/**
	 * Get BH_Concept.
	 *
	 * @return BH_Concept
	 */
	ForeignEntityInput BH_Concept();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set Severity_Concept.
	 *
	 * @param Severity_Concept Severity_Concept
	 */
	void setSeverity_ConceptInput(ForeignEntityInput Severity_Concept);

	/**
	 * Get Severity_Concept.
	 *
	 * @return Severity_Concept
	 */
	ForeignEntityInput Severity_Concept();
}
