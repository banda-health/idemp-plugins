package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Encounter_Diagnostic;

/**
 * Generated Interface for BH_Encounter_Diagnostic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Encounter_DiagnosticInput extends I_BH_Encounter_Diagnostic {

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
	 * Set BH_Diagnostic_Status.
	 *
	 * @param BH_Diagnostic_Status BH_Diagnostic_Status
	 */
	void setBH_Diagnostic_StatusInput(ForeignEntityInput BH_Diagnostic_Status);

	/**
	 * Get BH_Diagnostic_Status.
	 *
	 * @return BH_Diagnostic_Status
	 */
	ForeignEntityInput BH_Diagnostic_Status();

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
	 * Set Selected_Panel.
	 *
	 * @param Selected_Panel Selected_Panel
	 */
	void setSelected_PanelInput(ForeignEntityInput Selected_Panel);

	/**
	 * Get Selected_Panel.
	 *
	 * @return Selected_Panel
	 */
	ForeignEntityInput Selected_Panel();
}
