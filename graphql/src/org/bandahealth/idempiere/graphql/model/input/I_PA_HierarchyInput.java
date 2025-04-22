package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Hierarchy;

/**
 * Generated Interface for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_PA_HierarchyInput extends I_PA_Hierarchy {

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
	 * Set AD_Tree_Account.
	 *
	 * @param AD_Tree_Account Tree for Natural Account Tree
	 */
	void setAD_Tree_AccountInput(ForeignEntityInput AD_Tree_Account);

	/**
	 * Get AD_Tree_Account.
	 *
	 * @return Tree for Natural Account Tree
	 */
	ForeignEntityInput AD_Tree_Account();

	/**
	 * Set AD_Tree_Activity.
	 *
	 * @param AD_Tree_Activity Trees are used for (financial) reporting
	 */
	void setAD_Tree_ActivityInput(ForeignEntityInput AD_Tree_Activity);

	/**
	 * Get AD_Tree_Activity.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_Activity();

	/**
	 * Set AD_Tree_BPartner.
	 *
	 * @param AD_Tree_BPartner Trees are used for (financial) reporting
	 */
	void setAD_Tree_BPartnerInput(ForeignEntityInput AD_Tree_BPartner);

	/**
	 * Get AD_Tree_BPartner.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_BPartner();

	/**
	 * Set AD_Tree_Campaign.
	 *
	 * @param AD_Tree_Campaign Trees are used for (financial) reporting
	 */
	void setAD_Tree_CampaignInput(ForeignEntityInput AD_Tree_Campaign);

	/**
	 * Get AD_Tree_Campaign.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_Campaign();

	/**
	 * Set AD_Tree_Org.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	void setAD_Tree_OrgInput(ForeignEntityInput AD_Tree_Org);

	/**
	 * Get AD_Tree_Org.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	ForeignEntityInput AD_Tree_Org();

	/**
	 * Set AD_Tree_Product.
	 *
	 * @param AD_Tree_Product Trees are used for (financial) reporting
	 */
	void setAD_Tree_ProductInput(ForeignEntityInput AD_Tree_Product);

	/**
	 * Get AD_Tree_Product.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_Product();

	/**
	 * Set AD_Tree_Project.
	 *
	 * @param AD_Tree_Project Trees are used for (financial) reporting
	 */
	void setAD_Tree_ProjectInput(ForeignEntityInput AD_Tree_Project);

	/**
	 * Get AD_Tree_Project.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_Project();

	/**
	 * Set AD_Tree_SalesRegion.
	 *
	 * @param AD_Tree_SalesRegion Trees are used for (financial) reporting
	 */
	void setAD_Tree_SalesRegionInput(ForeignEntityInput AD_Tree_SalesRegion);

	/**
	 * Get AD_Tree_SalesRegion.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_SalesRegion();

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
}
