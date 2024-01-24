package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_CostElement;

/**
 * Generated Interface for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_CostElementInput extends I_M_CostElement {

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
	 * Set CostElementType.
	 *
	 * @param CostElementType Type of Cost Element
	 */
	void setCostElementTypeInput(I_AD_Ref_ListInput CostElementType);

	/**
	 * Get CostElementType.
	 *
	 * @return Type of Cost Element
	 */
	I_AD_Ref_ListInput CostElementType();

	/**
	 * Set CostingMethod.
	 *
	 * @param CostingMethod Indicates how Costs will be calculated
	 */
	void setCostingMethodInput(I_AD_Ref_ListInput CostingMethod);

	/**
	 * Get CostingMethod.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	I_AD_Ref_ListInput CostingMethod();

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
