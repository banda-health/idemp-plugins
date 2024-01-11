package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_S_Training_Class;

/**
 * Generated Interface for S_Training_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_S_Training_ClassInput extends I_S_Training_Class {

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
	 * Set S_Training.
	 *
	 * @param S_Training Repeated Training
	 */
	void setS_TrainingInput(ForeignEntityInput S_Training);

	/**
	 * Get S_Training.
	 *
	 * @return Repeated Training
	 */
	ForeignEntityInput S_Training();
}
