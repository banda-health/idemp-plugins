package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_S_Training;

/**
 * Generated Interface for S_Training - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_S_TrainingInput extends I_S_Training {

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
	 * Set C_TaxCategory.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	void setC_TaxCategoryInput(ForeignEntityInput C_TaxCategory);

	/**
	 * Get C_TaxCategory.
	 *
	 * @return Tax Category
	 */
	ForeignEntityInput C_TaxCategory();

	/**
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOMInput(ForeignEntityInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	ForeignEntityInput C_UOM();

	/**
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	ForeignEntityInput M_Product_Category();

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
