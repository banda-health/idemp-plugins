package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_S_Training_Class;

/**
 * Generated Interface for S_Training_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_S_Training_ClassInput extends I_S_Training_Class {

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
