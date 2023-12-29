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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

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
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput getC_BPartner_Location();

	/**
	 * Set C_BPartnerSR.
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	void setC_BPartnerSR(I_C_BPartnerInput C_BPartnerSR);

	/**
	 * Get C_BPartnerSR.
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	I_C_BPartnerInput getC_BPartnerSR();

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
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

	/**
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTerm(I_C_PaymentTermInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	I_C_PaymentTermInput getC_PaymentTerm();

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
	 * Set M_PriceList_Version.
	 *
	 * @param M_PriceList_Version Identifies a unique instance of a Price List
	 */
	void setM_PriceList_Version(I_M_PriceList_VersionInput M_PriceList_Version);

	/**
	 * Get M_PriceList_Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	I_M_PriceList_VersionInput getM_PriceList_Version();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_Warehouse(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput getM_Warehouse();

	/**
	 * Set ProjectCategory_RL.
	 *
	 * @param ProjectCategory_RL Project Category
	 */
	void setProjectCategory_RL(I_AD_Ref_ListInput ProjectCategory_RL);

	/**
	 * Get ProjectCategory_RL.
	 *
	 * @return Project Category
	 */
	I_AD_Ref_ListInput getProjectCategory_RL();

	/**
	 * Set ProjectLineLevel_RL.
	 *
	 * @param ProjectLineLevel_RL Project Line Level
	 */
	void setProjectLineLevel_RL(I_AD_Ref_ListInput ProjectLineLevel_RL);

	/**
	 * Get ProjectLineLevel_RL.
	 *
	 * @return Project Line Level
	 */
	I_AD_Ref_ListInput getProjectLineLevel_RL();

	/**
	 * Set ProjInvoiceRule_RL.
	 *
	 * @param ProjInvoiceRule_RL Invoice Rule for the project
	 */
	void setProjInvoiceRule_RL(I_AD_Ref_ListInput ProjInvoiceRule_RL);

	/**
	 * Get ProjInvoiceRule_RL.
	 *
	 * @return Invoice Rule for the project
	 */
	I_AD_Ref_ListInput getProjInvoiceRule_RL();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRep(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput getSalesRep();
}
