package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_CostHistory;

/**
 * Generated Interface for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_CostHistoryInput extends I_M_CostHistory {

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
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstance();

	/**
	 * Set M_CostDetail.
	 *
	 * @param M_CostDetail Cost Detail Information
	 */
	void setM_CostDetailInput(ForeignEntityInput M_CostDetail);

	/**
	 * Get M_CostDetail.
	 *
	 * @return Cost Detail Information
	 */
	ForeignEntityInput M_CostDetail();

	/**
	 * Set M_CostElement.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	void setM_CostElementInput(ForeignEntityInput M_CostElement);

	/**
	 * Get M_CostElement.
	 *
	 * @return Product Cost Element
	 */
	ForeignEntityInput M_CostElement();

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
	 * Set M_CostType.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	void setM_CostTypeInput(ForeignEntityInput M_CostType);

	/**
	 * Get M_CostType.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	ForeignEntityInput M_CostType();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();
}
