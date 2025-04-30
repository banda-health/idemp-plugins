package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Ocl_Originating_Source;

/**
 * Generated Interface for BH_Ocl_Originating_Source - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Ocl_Originating_SourceInput extends I_BH_Ocl_Originating_Source {

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
	 * Set BH_Ocl_Source.
	 *
	 * @param BH_Ocl_Source BH_Ocl_Source
	 */
	void setBH_Ocl_SourceInput(ForeignEntityInput BH_Ocl_Source);

	/**
	 * Get BH_Ocl_Source.
	 *
	 * @return BH_Ocl_Source
	 */
	ForeignEntityInput BH_Ocl_Source();
}
