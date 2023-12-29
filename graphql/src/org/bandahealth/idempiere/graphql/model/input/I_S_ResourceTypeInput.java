package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_S_ResourceType;

/**
 * Generated Interface for S_ResourceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_S_ResourceTypeInput extends I_S_ResourceType {

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
	 * Set C_TaxCategory.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	void setC_TaxCategory(I_C_TaxCategoryInput C_TaxCategory);

	/**
	 * Get C_TaxCategory.
	 *
	 * @return Tax Category
	 */
	I_C_TaxCategoryInput getC_TaxCategory();

	/**
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOM(I_C_UOMInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	I_C_UOMInput getC_UOM();

	/**
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_Category(I_M_Product_CategoryInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	I_M_Product_CategoryInput getM_Product_Category();

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
