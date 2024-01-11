package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Encounter_Diagnosis;

/**
 * Generated Interface for BH_Encounter_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_BH_Encounter_DiagnosisInput extends I_BH_Encounter_Diagnosis {

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
	 * Set BH_Coded_Diagnosis.
	 *
	 * @param BH_Coded_Diagnosis BH_Coded_Diagnosis
	 */
	void setBH_Coded_DiagnosisInput(ForeignEntityInput BH_Coded_Diagnosis);

	/**
	 * Get BH_Coded_Diagnosis.
	 *
	 * @return BH_Coded_Diagnosis
	 */
	ForeignEntityInput BH_Coded_Diagnosis();

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
}
