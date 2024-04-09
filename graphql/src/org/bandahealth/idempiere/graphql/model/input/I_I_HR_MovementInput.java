package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_I_HR_Movement;

/**
 * Generated Interface for I_HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_I_HR_MovementInput extends I_I_HR_Movement {

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
	 * Set HR_Concept.
	 *
	 * @param HR_Concept HR_Concept
	 */
	void setHR_ConceptInput(ForeignEntityInput HR_Concept);

	/**
	 * Get HR_Concept.
	 *
	 * @return HR_Concept
	 */
	ForeignEntityInput HR_Concept();

	/**
	 * Set HR_Movement.
	 *
	 * @param HR_Movement HR_Movement
	 */
	void setHR_MovementInput(ForeignEntityInput HR_Movement);

	/**
	 * Get HR_Movement.
	 *
	 * @return HR_Movement
	 */
	ForeignEntityInput HR_Movement();

	/**
	 * Set HR_Process.
	 *
	 * @param HR_Process HR_Process
	 */
	void setHR_ProcessInput(ForeignEntityInput HR_Process);

	/**
	 * Get HR_Process.
	 *
	 * @return HR_Process
	 */
	ForeignEntityInput HR_Process();

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
}
