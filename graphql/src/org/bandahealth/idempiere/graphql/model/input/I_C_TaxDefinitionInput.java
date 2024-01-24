package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_C_TaxDefinition;

/**
 * Generated Interface for C_TaxDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_TaxDefinitionInput extends I_C_TaxDefinition {

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
	 * Set AD_OrgType.
	 *
	 * @param AD_OrgType Organization Type
	 */
	void setAD_OrgTypeInput(ForeignEntityInput AD_OrgType);

	/**
	 * Get AD_OrgType.
	 *
	 * @return Organization Type
	 */
	ForeignEntityInput AD_OrgType();

	/**
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_GroupInput(ForeignEntityInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	ForeignEntityInput C_BP_Group();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	void setC_TaxInput(ForeignEntityInput C_Tax);

	/**
	 * Get C_Tax.
	 *
	 * @return Tax identifier
	 */
	ForeignEntityInput C_Tax();

	/**
	 * Set C_TaxBase.
	 *
	 * @param C_TaxBase C_TaxBase
	 */
	void setC_TaxBaseInput(ForeignEntityInput C_TaxBase);

	/**
	 * Get C_TaxBase.
	 *
	 * @return C_TaxBase
	 */
	ForeignEntityInput C_TaxBase();

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

	/**
	 * Set C_TaxGroup.
	 *
	 * @param C_TaxGroup C_TaxGroup
	 */
	void setC_TaxGroupInput(ForeignEntityInput C_TaxGroup);

	/**
	 * Get C_TaxGroup.
	 *
	 * @return C_TaxGroup
	 */
	ForeignEntityInput C_TaxGroup();

	/**
	 * Set C_TaxType.
	 *
	 * @param C_TaxType C_TaxType
	 */
	void setC_TaxTypeInput(ForeignEntityInput C_TaxType);

	/**
	 * Get C_TaxType.
	 *
	 * @return C_TaxType
	 */
	ForeignEntityInput C_TaxType();

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
