package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Lot;

/**
 * Generated Interface for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_LotInput extends I_M_Lot {

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
	 * Set M_LotCtl.
	 *
	 * @param M_LotCtl Product Lot Control
	 */
	void setM_LotCtlInput(ForeignEntityInput M_LotCtl);

	/**
	 * Get M_LotCtl.
	 *
	 * @return Product Lot Control
	 */
	ForeignEntityInput M_LotCtl();

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
