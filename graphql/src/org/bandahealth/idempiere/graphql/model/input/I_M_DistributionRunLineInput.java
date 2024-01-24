package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_DistributionRunLine;

/**
 * Generated Interface for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_DistributionRunLineInput extends I_M_DistributionRunLine {

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
	 * Set M_DistributionList.
	 *
	 * @param M_DistributionList Distribution Lists allow to distribute products to a selected list of partners
	 */
	void setM_DistributionListInput(ForeignEntityInput M_DistributionList);

	/**
	 * Get M_DistributionList.
	 *
	 * @return Distribution Lists allow to distribute products to a selected list of partners
	 */
	ForeignEntityInput M_DistributionList();

	/**
	 * Set M_DistributionRun.
	 *
	 * @param M_DistributionRun Distribution Run create Orders to distribute products to a selected list of partners
	 */
	void setM_DistributionRunInput(ForeignEntityInput M_DistributionRun);

	/**
	 * Get M_DistributionRun.
	 *
	 * @return Distribution Run create Orders to distribute products to a selected list of partners
	 */
	ForeignEntityInput M_DistributionRun();

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
