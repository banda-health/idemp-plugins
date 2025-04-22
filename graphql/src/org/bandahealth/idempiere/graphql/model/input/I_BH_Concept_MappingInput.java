package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Concept_Mapping;

/**
 * Generated Interface for BH_Concept_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_BH_Concept_MappingInput extends I_BH_Concept_Mapping {

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
	 * Set From_BH_Concept.
	 *
	 * @param From_BH_Concept From_BH_Concept
	 */
	void setFrom_BH_ConceptInput(ForeignEntityInput From_BH_Concept);

	/**
	 * Get From_BH_Concept.
	 *
	 * @return From_BH_Concept
	 */
	ForeignEntityInput From_BH_Concept();

	/**
	 * Set To_BH_Concept.
	 *
	 * @param To_BH_Concept To_BH_Concept
	 */
	void setTo_BH_ConceptInput(ForeignEntityInput To_BH_Concept);

	/**
	 * Get To_BH_Concept.
	 *
	 * @return To_BH_Concept
	 */
	ForeignEntityInput To_BH_Concept();
}
