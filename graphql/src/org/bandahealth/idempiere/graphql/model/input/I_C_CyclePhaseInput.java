package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CyclePhase;

/**
 * Generated Interface for C_CyclePhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_CyclePhaseInput extends I_C_CyclePhase {

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
	 * Set C_CycleStep.
	 *
	 * @param C_CycleStep The step for this Cycle
	 */
	void setC_CycleStepInput(ForeignEntityInput C_CycleStep);

	/**
	 * Get C_CycleStep.
	 *
	 * @return The step for this Cycle
	 */
	ForeignEntityInput C_CycleStep();

	/**
	 * Set C_Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	void setC_PhaseInput(ForeignEntityInput C_Phase);

	/**
	 * Get C_Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	ForeignEntityInput C_Phase();
}
