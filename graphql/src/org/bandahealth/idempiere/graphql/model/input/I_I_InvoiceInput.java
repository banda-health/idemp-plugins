package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_Invoice;

/**
 * Generated Interface for I_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_I_InvoiceInput extends I_I_Invoice {

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
	 * Set C_1099Box.
	 *
	 * @param C_1099Box C_1099Box
	 */
	void setC_1099BoxInput(ForeignEntityInput C_1099Box);

	/**
	 * Get C_1099Box.
	 *
	 * @return C_1099Box
	 */
	ForeignEntityInput C_1099Box();

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

	/**
	 * Set C_Country.
	 *
	 * @param C_Country Country 
	 */
	void setC_CountryInput(ForeignEntityInput C_Country);

	/**
	 * Get C_Country.
	 *
	 * @return Country 
	 */
	ForeignEntityInput C_Country();

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
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(ForeignEntityInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	ForeignEntityInput C_DocType();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_InvoiceInput(ForeignEntityInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	ForeignEntityInput C_Invoice();

	/**
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	ForeignEntityInput C_InvoiceLine();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(ForeignEntityInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	ForeignEntityInput C_Location();

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
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

	/**
	 * Set C_Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	void setC_RegionInput(ForeignEntityInput C_Region);

	/**
	 * Get C_Region.
	 *
	 * @return Identifies a geographical Region
	 */
	ForeignEntityInput C_Region();

	/**
	 * Set C_Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	void setC_TaxInput(ForeignEntityInput C_Tax);

	/**
	 * Get C_Tax.
	 *
	 * @return Tax identifier
	 */
	ForeignEntityInput C_Tax();

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
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceListInput(ForeignEntityInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	ForeignEntityInput M_PriceList();

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
