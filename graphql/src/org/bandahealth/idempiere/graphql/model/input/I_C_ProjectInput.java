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
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput AD_User();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput C_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput C_BPartner_Location();

	/**
	 * Set C_BPartnerSR.
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	void setC_BPartnerSRInput(I_C_BPartnerInput C_BPartnerSR);

	/**
	 * Get C_BPartnerSR.
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	I_C_BPartnerInput C_BPartnerSR();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput C_Campaign();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput C_Currency();

	/**
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTermInput(I_C_PaymentTermInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	I_C_PaymentTermInput C_PaymentTerm();

	/**
	 * Set C_Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	void setC_PhaseInput(I_C_PhaseInput C_Phase);

	/**
	 * Get C_Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	I_C_PhaseInput C_Phase();

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
	 * Set M_PriceList_Version.
	 *
	 * @param M_PriceList_Version Identifies a unique instance of a Price List
	 */
	void setM_PriceList_VersionInput(I_M_PriceList_VersionInput M_PriceList_Version);

	/**
	 * Get M_PriceList_Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	I_M_PriceList_VersionInput M_PriceList_Version();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput M_Warehouse();

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
	void setSalesRepInput(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput SalesRep();
}
