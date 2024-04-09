package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Encounter;

/**
 * Generated Interface for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_BH_EncounterInput extends I_BH_Encounter {

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
	 * Set BH_Encounter_Type.
	 *
	 * @param BH_Encounter_Type BH_Encounter_Type
	 */
	void setBH_Encounter_TypeInput(I_AD_Ref_ListInput BH_Encounter_Type);

	/**
	 * Get BH_Encounter_Type.
	 *
	 * @return BH_Encounter_Type
	 */
	I_AD_Ref_ListInput BH_Encounter_Type();

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
	 * Set BH_Visit.
	 *
	 * @param BH_Visit BH_Visit
	 */
	void setBH_VisitInput(ForeignEntityInput BH_Visit);

	/**
	 * Get BH_Visit.
	 *
	 * @return BH_Visit
	 */
	ForeignEntityInput BH_Visit();
}
