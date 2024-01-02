package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BPartner;

/**
 * Generated Interface for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_BPartnerInput extends I_C_BPartner {

	/**
	 * Set AD_Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	void setAD_LanguageInput(I_AD_LanguageInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return Language for this entity
	 */
	I_AD_LanguageInput AD_Language();

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
	 * Set bh_gender.
	 *
	 * @param bh_gender bh_gender
	 */
	void setbh_genderInput(I_AD_Ref_ListInput bh_gender);

	/**
	 * Get bh_gender.
	 *
	 * @return bh_gender
	 */
	I_AD_Ref_ListInput bh_gender();

	/**
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_GroupInput(I_C_BP_GroupInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	I_C_BP_GroupInput C_BP_Group();

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
	 * Set C_Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	void setC_DunningInput(I_C_DunningInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	I_C_DunningInput C_Dunning();

	/**
	 * Set C_Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	void setC_GreetingInput(I_C_GreetingInput C_Greeting);

	/**
	 * Get C_Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	I_C_GreetingInput C_Greeting();

	/**
	 * Set C_InvoiceSchedule.
	 *
	 * @param C_InvoiceSchedule Schedule for generating Invoices
	 */
	void setC_InvoiceScheduleInput(I_C_InvoiceScheduleInput C_InvoiceSchedule);

	/**
	 * Get C_InvoiceSchedule.
	 *
	 * @return Schedule for generating Invoices
	 */
	I_C_InvoiceScheduleInput C_InvoiceSchedule();

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
	 * Set C_TaxGroup.
	 *
	 * @param C_TaxGroup C_TaxGroup
	 */
	void setC_TaxGroupInput(I_C_TaxGroupInput C_TaxGroup);

	/**
	 * Get C_TaxGroup.
	 *
	 * @return C_TaxGroup
	 */
	I_C_TaxGroupInput C_TaxGroup();

	/**
	 * Set Default1099Box.
	 *
	 * @param Default1099Box Default1099Box
	 */
	void setDefault1099BoxInput(I_C_1099BoxInput Default1099Box);

	/**
	 * Get Default1099Box.
	 *
	 * @return Default1099Box
	 */
	I_C_1099BoxInput Default1099Box();

	/**
	 * Set DeliveryRule.
	 *
	 * @param DeliveryRule Defines the timing of Delivery
	 */
	void setDeliveryRuleInput(I_AD_Ref_ListInput DeliveryRule);

	/**
	 * Get DeliveryRule.
	 *
	 * @return Defines the timing of Delivery
	 */
	I_AD_Ref_ListInput DeliveryRule();

	/**
	 * Set DeliveryViaRule.
	 *
	 * @param DeliveryViaRule How the order will be delivered
	 */
	void setDeliveryViaRuleInput(I_AD_Ref_ListInput DeliveryViaRule);

	/**
	 * Get DeliveryViaRule.
	 *
	 * @return How the order will be delivered
	 */
	I_AD_Ref_ListInput DeliveryViaRule();

	/**
	 * Set FreightCostRule.
	 *
	 * @param FreightCostRule Method for charging Freight
	 */
	void setFreightCostRuleInput(I_AD_Ref_ListInput FreightCostRule);

	/**
	 * Get FreightCostRule.
	 *
	 * @return Method for charging Freight
	 */
	I_AD_Ref_ListInput FreightCostRule();

	/**
	 * Set Invoice_PrintFormat.
	 *
	 * @param Invoice_PrintFormat Print Format for printing Invoices
	 */
	void setInvoice_PrintFormatInput(I_AD_PrintFormatInput Invoice_PrintFormat);

	/**
	 * Get Invoice_PrintFormat.
	 *
	 * @return Print Format for printing Invoices
	 */
	I_AD_PrintFormatInput Invoice_PrintFormat();

	/**
	 * Set InvoiceRule.
	 *
	 * @param InvoiceRule Frequency and method of invoicing 
	 */
	void setInvoiceRuleInput(I_AD_Ref_ListInput InvoiceRule);

	/**
	 * Get InvoiceRule.
	 *
	 * @return Frequency and method of invoicing 
	 */
	I_AD_Ref_ListInput InvoiceRule();

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image AD_Image
	 */
	void setAD_ImageInput(I_AD_ImageInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return AD_Image
	 */
	I_AD_ImageInput AD_Image();

	/**
	 * Set M_DiscountSchema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	void setM_DiscountSchemaInput(I_M_DiscountSchemaInput M_DiscountSchema);

	/**
	 * Get M_DiscountSchema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	I_M_DiscountSchemaInput M_DiscountSchema();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceListInput(I_M_PriceListInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	I_M_PriceListInput M_PriceList();

	/**
	 * Set PaymentRule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	void setPaymentRuleInput(I_AD_Ref_ListInput PaymentRule);

	/**
	 * Get PaymentRule.
	 *
	 * @return How you pay the invoice
	 */
	I_AD_Ref_ListInput PaymentRule();

	/**
	 * Set PaymentRulePO.
	 *
	 * @param PaymentRulePO Purchase payment option
	 */
	void setPaymentRulePOInput(I_AD_Ref_ListInput PaymentRulePO);

	/**
	 * Get PaymentRulePO.
	 *
	 * @return Purchase payment option
	 */
	I_AD_Ref_ListInput PaymentRulePO();

	/**
	 * Set PO_DiscountSchema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	void setPO_DiscountSchemaInput(I_M_DiscountSchemaInput PO_DiscountSchema);

	/**
	 * Get PO_DiscountSchema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	I_M_DiscountSchemaInput PO_DiscountSchema();

	/**
	 * Set PO_PaymentTerm.
	 *
	 * @param PO_PaymentTerm Payment rules for a purchase order
	 */
	void setPO_PaymentTermInput(I_C_PaymentTermInput PO_PaymentTerm);

	/**
	 * Get PO_PaymentTerm.
	 *
	 * @return Payment rules for a purchase order
	 */
	I_C_PaymentTermInput PO_PaymentTerm();

	/**
	 * Set PO_PriceList.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	void setPO_PriceListInput(I_M_PriceListInput PO_PriceList);

	/**
	 * Get PO_PriceList.
	 *
	 * @return Price List used by this Business Partner
	 */
	I_M_PriceListInput PO_PriceList();

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

	/**
	 * Set SOCreditStatus.
	 *
	 * @param SOCreditStatus Business Partner Credit Status
	 */
	void setSOCreditStatusInput(I_AD_Ref_ListInput SOCreditStatus);

	/**
	 * Get SOCreditStatus.
	 *
	 * @return Business Partner Credit Status
	 */
	I_AD_Ref_ListInput SOCreditStatus();
}
