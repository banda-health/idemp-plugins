package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Visit_Family_Planning_Larc_Removal_Reason;

/**
 * Generated Interface for BH_Visit_Family_Planning_Larc_Removal_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Visit_Family_Planning_Larc_Removal_ReasonInput extends I_BH_Visit_Family_Planning_Larc_Removal_Reason {

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
	 * Set BH_Larc_Removal_Reason.
	 *
	 * @param BH_Larc_Removal_Reason BH_Larc_Removal_Reason
	 */
	void setBH_Larc_Removal_ReasonInput(ForeignEntityInput BH_Larc_Removal_Reason);

	/**
	 * Get BH_Larc_Removal_Reason.
	 *
	 * @return BH_Larc_Removal_Reason
	 */
	ForeignEntityInput BH_Larc_Removal_Reason();

	/**
	 * Set BH_Visit_Family_Planning.
	 *
	 * @param BH_Visit_Family_Planning BH_Visit_Family_Planning
	 */
	void setBH_Visit_Family_PlanningInput(ForeignEntityInput BH_Visit_Family_Planning);

	/**
	 * Get BH_Visit_Family_Planning.
	 *
	 * @return BH_Visit_Family_Planning
	 */
	ForeignEntityInput BH_Visit_Family_Planning();

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
