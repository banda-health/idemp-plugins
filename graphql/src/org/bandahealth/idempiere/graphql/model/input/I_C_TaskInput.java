package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Task;

/**
 * Generated Interface for C_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_TaskInput extends I_C_Task {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	void setC_Phase(I_C_PhaseInput C_Phase);

	/**
	 * Get C_Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	I_C_PhaseInput getC_Phase();

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
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_Product(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput getM_Product();
}
