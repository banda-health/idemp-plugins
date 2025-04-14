package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ProductionPlan;

/**
 * Generated Interface for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_ProductionPlanInput extends I_M_ProductionPlan {

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
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_LocatorInput(ForeignEntityInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	ForeignEntityInput M_Locator();

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

	/**
	 * Set M_Production.
	 *
	 * @param M_Production Plan for producing a product
	 */
	void setM_ProductionInput(ForeignEntityInput M_Production);

	/**
	 * Get M_Production.
	 *
	 * @return Plan for producing a product
	 */
	ForeignEntityInput M_Production();

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
