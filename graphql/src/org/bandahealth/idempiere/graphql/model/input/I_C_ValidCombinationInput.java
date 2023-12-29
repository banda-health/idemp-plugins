package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ValidCombination;

/**
 * Generated Interface for C_ValidCombination - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ValidCombinationInput extends I_C_ValidCombination {

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	void setAccount(I_C_ElementValueInput Account);

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	I_C_ElementValueInput getAccount();

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	I_C_AcctSchemaInput getC_AcctSchema();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_Activity(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput getC_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_Campaign(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput getC_Campaign();

	/**
	 * Set C_LocFrom.
	 *
	 * @param C_LocFrom Location that inventory was moved from
	 */
	void setC_LocFrom(I_C_LocationInput C_LocFrom);

	/**
	 * Get C_LocFrom.
	 *
	 * @return Location that inventory was moved from
	 */
	I_C_LocationInput getC_LocFrom();

	/**
	 * Set C_LocTo.
	 *
	 * @param C_LocTo Location that inventory was moved to
	 */
	void setC_LocTo(I_C_LocationInput C_LocTo);

	/**
	 * Get C_LocTo.
	 *
	 * @return Location that inventory was moved to
	 */
	I_C_LocationInput getC_LocTo();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

	/**
	 * Set C_SalesRegion.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	void setC_SalesRegion(I_C_SalesRegionInput C_SalesRegion);

	/**
	 * Get C_SalesRegion.
	 *
	 * @return Sales coverage region
	 */
	I_C_SalesRegionInput getC_SalesRegion();

	/**
	 * Set C_SubAcct.
	 *
	 * @param C_SubAcct Sub account for Element Value
	 */
	void setC_SubAcct(I_C_SubAcctInput C_SubAcct);

	/**
	 * Get C_SubAcct.
	 *
	 * @return Sub account for Element Value
	 */
	I_C_SubAcctInput getC_SubAcct();

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

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1(I_C_ElementValueInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	I_C_ElementValueInput getUser1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2(I_C_ElementValueInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	I_C_ElementValueInput getUser2();
}
