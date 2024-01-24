package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Observation;

/**
 * Generated Interface for BH_Observation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_BH_ObservationInput extends I_BH_Observation {

	/**
	 * Set AD_Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	void setAD_FieldInput(ForeignEntityInput AD_Field);

	/**
	 * Get AD_Field.
	 *
	 * @return Field on a database table
	 */
	ForeignEntityInput AD_Field();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set BH_Encounter.
	 *
	 * @param BH_Encounter BH_Encounter
	 */
	void setBH_EncounterInput(ForeignEntityInput BH_Encounter);

	/**
	 * Get BH_Encounter.
	 *
	 * @return BH_Encounter
	 */
	ForeignEntityInput BH_Encounter();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();
}
