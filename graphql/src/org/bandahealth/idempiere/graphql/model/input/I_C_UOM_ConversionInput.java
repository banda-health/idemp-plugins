package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_UOM_Conversion;

/**
 * Generated Interface for C_UOM_Conversion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_UOM_ConversionInput extends I_C_UOM_Conversion {

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
	 * Set C_UOM_To.
	 *
	 * @param C_UOM_To Target or destination Unit of Measure
	 */
	void setC_UOM_ToInput(ForeignEntityInput C_UOM_To);

	/**
	 * Get C_UOM_To.
	 *
	 * @return Target or destination Unit of Measure
	 */
	ForeignEntityInput C_UOM_To();

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
