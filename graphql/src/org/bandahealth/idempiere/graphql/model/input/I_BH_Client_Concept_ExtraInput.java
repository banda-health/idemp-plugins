package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Client_Concept_Extra;

/**
 * Generated Interface for BH_Client_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Client_Concept_ExtraInput extends I_BH_Client_Concept_Extra {

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
	 * Set BH_Concept_Mapping.
	 *
	 * @param BH_Concept_Mapping BH_Concept_Mapping
	 */
	void setBH_Concept_MappingInput(ForeignEntityInput BH_Concept_Mapping);

	/**
	 * Get BH_Concept_Mapping.
	 *
	 * @return BH_Concept_Mapping
	 */
	ForeignEntityInput BH_Concept_Mapping();
}
