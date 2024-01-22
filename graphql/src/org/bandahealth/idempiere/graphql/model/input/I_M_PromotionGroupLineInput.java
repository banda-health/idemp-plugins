package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PromotionGroupLine;

/**
 * Generated Interface for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_PromotionGroupLineInput extends I_M_PromotionGroupLine {

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
