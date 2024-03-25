package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Product_BOM;

/**
 * Generated Interface for M_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_Product_BOMInput extends I_M_Product_BOM {

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
	 * Set BOMType.
	 *
	 * @param BOMType Type of BOM
	 */
	void setBOMTypeInput(I_AD_Ref_ListInput BOMType);

	/**
	 * Get BOMType.
	 *
	 * @return Type of BOM
	 */
	I_AD_Ref_ListInput BOMType();

	/**
	 * Set M_PartType.
	 *
	 * @param M_PartType M_PartType
	 */
	void setM_PartTypeInput(ForeignEntityInput M_PartType);

	/**
	 * Get M_PartType.
	 *
	 * @return M_PartType
	 */
	ForeignEntityInput M_PartType();

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
	 * Set M_ProductBOM.
	 *
	 * @param M_ProductBOM Bill of Material Component Product
	 */
	void setM_ProductBOMInput(ForeignEntityInput M_ProductBOM);

	/**
	 * Get M_ProductBOM.
	 *
	 * @return Bill of Material Component Product
	 */
	ForeignEntityInput M_ProductBOM();
}
