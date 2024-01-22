package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Substitute;

/**
 * Generated Interface for M_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_SubstituteInput extends I_M_Substitute {

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
	 * Set Substitute.
	 *
	 * @param Substitute Entity which can be used in place of this entity
	 */
	void setSubstituteInput(ForeignEntityInput Substitute);

	/**
	 * Get Substitute.
	 *
	 * @return Entity which can be used in place of this entity
	 */
	ForeignEntityInput Substitute();
}
