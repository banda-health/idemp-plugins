package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_BOM;

/**
 * Generated Interface for M_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_BOMInput extends I_M_BOM {

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
	 * Set BOMUse.
	 *
	 * @param BOMUse The use of the Bill of Material
	 */
	void setBOMUseInput(I_AD_Ref_ListInput BOMUse);

	/**
	 * Get BOMUse.
	 *
	 * @return The use of the Bill of Material
	 */
	I_AD_Ref_ListInput BOMUse();

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
	 * Set M_ChangeNotice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice);

	/**
	 * Get M_ChangeNotice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	ForeignEntityInput M_ChangeNotice();

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
