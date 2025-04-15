package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_CostElement;

/**
 * Generated Interface for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_CostElementInput extends I_M_CostElement {

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
	 * Set CostElementType.
	 *
	 * @param CostElementType Type of Cost Element
	 */
	void setCostElementTypeInput(ForeignEntityInput CostElementType);

	/**
	 * Get CostElementType.
	 *
	 * @return Type of Cost Element
	 */
	ForeignEntityInput CostElementType();

	/**
	 * Set CostingMethod.
	 *
	 * @param CostingMethod Indicates how Costs will be calculated
	 */
	void setCostingMethodInput(ForeignEntityInput CostingMethod);

	/**
	 * Get CostingMethod.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	ForeignEntityInput CostingMethod();

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
