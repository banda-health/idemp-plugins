package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Encounter;

/**
 * Generated Interface for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_BH_EncounterInput extends I_BH_Encounter {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

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
	 * Set BH_Visit.
	 *
	 * @param BH_Visit BH_Visit
	 */
	void setBH_VisitInput(I_BH_VisitInput BH_Visit);

	/**
	 * Get BH_Visit.
	 *
	 * @return BH_Visit
	 */
	I_BH_VisitInput BH_Visit();
}
