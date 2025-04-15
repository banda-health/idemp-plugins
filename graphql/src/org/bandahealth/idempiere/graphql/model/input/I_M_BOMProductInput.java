package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_BOMProduct;

/**
 * Generated Interface for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_BOMProductInput extends I_M_BOMProduct {

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
	 * Set BOMProductType.
	 *
	 * @param BOMProductType BOM Product Type
	 */
	void setBOMProductTypeInput(ForeignEntityInput BOMProductType);

	/**
	 * Get BOMProductType.
	 *
	 * @return BOM Product Type
	 */
	ForeignEntityInput BOMProductType();

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
	 * Set M_BOM.
	 *
	 * @param M_BOM Bill of Material
	 */
	void setM_BOMInput(ForeignEntityInput M_BOM);

	/**
	 * Get M_BOM.
	 *
	 * @return Bill of Material
	 */
	ForeignEntityInput M_BOM();

	/**
	 * Set M_BOMAlternative.
	 *
	 * @param M_BOMAlternative Product BOM Alternative Group
	 */
	void setM_BOMAlternativeInput(ForeignEntityInput M_BOMAlternative);

	/**
	 * Get M_BOMAlternative.
	 *
	 * @return Product BOM Alternative Group
	 */
	ForeignEntityInput M_BOMAlternative();

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

	/**
	 * Set M_ProductOperation.
	 *
	 * @param M_ProductOperation Product Manufacturing Operation
	 */
	void setM_ProductOperationInput(ForeignEntityInput M_ProductOperation);

	/**
	 * Get M_ProductOperation.
	 *
	 * @return Product Manufacturing Operation
	 */
	ForeignEntityInput M_ProductOperation();
}
