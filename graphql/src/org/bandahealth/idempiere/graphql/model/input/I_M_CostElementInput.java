package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_CostElement;

/**
 * Generated Interface for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_CostElementInput extends I_M_CostElement {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set CostElementType_RL.
	 *
	 * @param CostElementType_RL Type of Cost Element
	 */
	void setCostElementType_RL(I_AD_Ref_ListInput CostElementType_RL);

	/**
	 * Get CostElementType_RL.
	 *
	 * @return Type of Cost Element
	 */
	I_AD_Ref_ListInput getCostElementType_RL();

	/**
	 * Set CostingMethod_RL.
	 *
	 * @param CostingMethod_RL Indicates how Costs will be calculated
	 */
	void setCostingMethod_RL(I_AD_Ref_ListInput CostingMethod_RL);

	/**
	 * Get CostingMethod_RL.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	I_AD_Ref_ListInput getCostingMethod_RL();

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
}
