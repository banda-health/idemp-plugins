package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Visit_Family_Planning_Product;

/**
 * Generated Interface for BH_Visit_Family_Planning_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Visit_Family_Planning_ProductInput extends I_BH_Visit_Family_Planning_Product {

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
	 * Set BH_Fp_Method.
	 *
	 * @param BH_Fp_Method BH_Fp_Method
	 */
	void setBH_Fp_MethodInput(ForeignEntityInput BH_Fp_Method);

	/**
	 * Get BH_Fp_Method.
	 *
	 * @return BH_Fp_Method
	 */
	ForeignEntityInput BH_Fp_Method();

	/**
	 * Set BH_Line_Role.
	 *
	 * @param BH_Line_Role BH_Line_Role
	 */
	void setBH_Line_RoleInput(ForeignEntityInput BH_Line_Role);

	/**
	 * Get BH_Line_Role.
	 *
	 * @return BH_Line_Role
	 */
	ForeignEntityInput BH_Line_Role();

	/**
	 * Set BH_Visit_Family_Planning.
	 *
	 * @param BH_Visit_Family_Planning BH_Visit_Family_Planning
	 */
	void setBH_Visit_Family_PlanningInput(ForeignEntityInput BH_Visit_Family_Planning);

	/**
	 * Get BH_Visit_Family_Planning.
	 *
	 * @return BH_Visit_Family_Planning
	 */
	ForeignEntityInput BH_Visit_Family_Planning();

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
	 * Set C_OrderLine.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	void setC_OrderLineInput(ForeignEntityInput C_OrderLine);

	/**
	 * Get C_OrderLine.
	 *
	 * @return Sales Order Line
	 */
	ForeignEntityInput C_OrderLine();

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
