package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Phase;

/**
 * Generated Interface for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_PhaseInput extends I_C_Phase {

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
	 * Set C_ProjectType.
	 *
	 * @param C_ProjectType Type of the project
	 */
	void setC_ProjectTypeInput(ForeignEntityInput C_ProjectType);

	/**
	 * Get C_ProjectType.
	 *
	 * @return Type of the project
	 */
	ForeignEntityInput C_ProjectType();

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
