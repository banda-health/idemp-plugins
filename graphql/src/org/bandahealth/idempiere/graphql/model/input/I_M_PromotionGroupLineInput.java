package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PromotionGroupLine;

/**
 * Generated Interface for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_PromotionGroupLineInput extends I_M_PromotionGroupLine {

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
	 * Set M_PromotionGroup.
	 *
	 * @param M_PromotionGroup M_PromotionGroup
	 */
	void setM_PromotionGroupInput(ForeignEntityInput M_PromotionGroup);

	/**
	 * Get M_PromotionGroup.
	 *
	 * @return M_PromotionGroup
	 */
	ForeignEntityInput M_PromotionGroup();

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
