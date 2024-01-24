package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_RegistrationProduct;

/**
 * Generated Interface for A_RegistrationProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_RegistrationProductInput extends I_A_RegistrationProduct {

	/**
	 * Set A_RegistrationAttribute.
	 *
	 * @param A_RegistrationAttribute Asset Registration Attribute
	 */
	void setA_RegistrationAttributeInput(ForeignEntityInput A_RegistrationAttribute);

	/**
	 * Get A_RegistrationAttribute.
	 *
	 * @return Asset Registration Attribute
	 */
	ForeignEntityInput A_RegistrationAttribute();

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
}
