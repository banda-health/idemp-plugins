package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_T_DistributionRunDetail;

/**
 * Generated Interface for T_DistributionRunDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_T_DistributionRunDetailInput extends I_T_DistributionRunDetail {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	ForeignEntityInput C_BPartner_Location();

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
	 * Set M_DistributionListLine.
	 *
	 * @param M_DistributionListLine Distribution List Line with Business Partner and Quantity/Percentage
	 */
	void setM_DistributionListLineInput(ForeignEntityInput M_DistributionListLine);

	/**
	 * Get M_DistributionListLine.
	 *
	 * @return Distribution List Line with Business Partner and Quantity/Percentage
	 */
	ForeignEntityInput M_DistributionListLine();

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
	 * Set M_DistributionRunLine.
	 *
	 * @param M_DistributionRunLine Distribution Run Lines define Distribution List, the Product and Quantities
	 */
	void setM_DistributionRunLineInput(ForeignEntityInput M_DistributionRunLine);

	/**
	 * Get M_DistributionRunLine.
	 *
	 * @return Distribution Run Lines define Distribution List, the Product and Quantities
	 */
	ForeignEntityInput M_DistributionRunLine();

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
}
