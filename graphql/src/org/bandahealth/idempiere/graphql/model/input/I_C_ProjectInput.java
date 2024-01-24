package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Project;

/**
 * Generated Interface for C_Project - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ProjectInput extends I_C_Project {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(ForeignEntityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	ForeignEntityInput C_Activity();

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
	 * Set C_BPartnerSR.
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	void setC_BPartnerSRInput(ForeignEntityInput C_BPartnerSR);

	/**
	 * Get C_BPartnerSR.
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	ForeignEntityInput C_BPartnerSR();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(ForeignEntityInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	ForeignEntityInput C_Campaign();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	ForeignEntityInput C_PaymentTerm();

	/**
	 * Set C_Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	void setC_PhaseInput(ForeignEntityInput C_Phase);

	/**
	 * Get C_Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	ForeignEntityInput C_Phase();

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
	 * Set M_PriceList_Version.
	 *
	 * @param M_PriceList_Version Identifies a unique instance of a Price List
	 */
	void setM_PriceList_VersionInput(ForeignEntityInput M_PriceList_Version);

	/**
	 * Get M_PriceList_Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	ForeignEntityInput M_PriceList_Version();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(ForeignEntityInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	ForeignEntityInput M_Warehouse();

	/**
	 * Set ProjectCategory.
	 *
	 * @param ProjectCategory Project Category
	 */
	void setProjectCategoryInput(I_AD_Ref_ListInput ProjectCategory);

	/**
	 * Get ProjectCategory.
	 *
	 * @return Project Category
	 */
	I_AD_Ref_ListInput ProjectCategory();

	/**
	 * Set ProjectLineLevel.
	 *
	 * @param ProjectLineLevel Project Line Level
	 */
	void setProjectLineLevelInput(I_AD_Ref_ListInput ProjectLineLevel);

	/**
	 * Get ProjectLineLevel.
	 *
	 * @return Project Line Level
	 */
	I_AD_Ref_ListInput ProjectLineLevel();

	/**
	 * Set ProjInvoiceRule.
	 *
	 * @param ProjInvoiceRule Invoice Rule for the project
	 */
	void setProjInvoiceRuleInput(I_AD_Ref_ListInput ProjInvoiceRule);

	/**
	 * Get ProjInvoiceRule.
	 *
	 * @return Invoice Rule for the project
	 */
	I_AD_Ref_ListInput ProjInvoiceRule();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(ForeignEntityInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	ForeignEntityInput SalesRep();
}
