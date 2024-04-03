package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BPartner;

import java.sql.Timestamp;

/**
 * Generated Interface for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_BPartnerInput extends I_C_BPartner {

	/**
	 * Set AD_Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	void setAD_LanguageInput(ForeignEntityInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return Language for this entity
	 */
	ForeignEntityInput AD_Language();

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
	 * Column name BH_Birthday
	 */
	static final String COLUMNNAME_BH_Birthday = "BH_Birthday";

	/**
	 * Set Birthday.
	 *
	 * @param BH_Birthday Birthday or Anniversary day
	 */
	void setBH_Birthday(Timestamp BH_Birthday);

	/**
	 * Get Birthday.
	 *
	 * @return Birthday or Anniversary day
	 */
	Timestamp getBH_Birthday();

	/**
	 * Column name BH_EMail
	 */
	static final String COLUMNNAME_BH_EMail = "BH_EMail";

	/**
	 * Set EMail Address.
	 *
	 * @param BH_EMail Electronic Mail Address
	 */
	void setBH_EMail(String BH_EMail);

	/**
	 * Get EMail Address.
	 *
	 * @return Electronic Mail Address
	 */
	String getBH_EMail();

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
	 * Column name BH_IsApproximateDateOfBirth
	 */
	static final String COLUMNNAME_BH_IsApproximateDateOfBirth = "BH_IsApproximateDateOfBirth";

	/**
	 * Set Is Approximate Date Of Birth.
	 *
	 * @param BH_IsApproximateDateOfBirth Is Approximate Date Of Birth
	 */
	void setBH_IsApproximateDateOfBirth(boolean BH_IsApproximateDateOfBirth);

	/**
	 * Get Is Approximate Date Of Birth.
	 *
	 * @return Is Approximate Date Of Birth
	 */
	boolean isBH_IsApproximateDateOfBirth();

	/**
	 * Column name BH_Local_PatientID
	 */
	static final String COLUMNNAME_BH_Local_PatientID = "BH_Local_PatientID";

	/**
	 * Set Local Patient ID.
	 *
	 * @param BH_Local_PatientID Local Patient ID
	 */
	void setBH_Local_PatientID(String BH_Local_PatientID);

	/**
	 * Get Local Patient ID.
	 *
	 * @return Local Patient ID
	 */
	String getBH_Local_PatientID();

	/**
	 * Column name BH_Locked
	 */
	static final String COLUMNNAME_BH_Locked = "BH_Locked";

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	void setBH_Locked(boolean BH_Locked);

	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	boolean isBH_Locked();

	/**
	 * Column name BH_NeedAdditionalVisitInfo
	 */
	static final String COLUMNNAME_BH_NeedAdditionalVisitInfo = "BH_NeedAdditionalVisitInfo";

	/**
	 * Set Need Additional Visit Info.
	 *
	 * @param BH_NeedAdditionalVisitInfo Need Additional Visit Info
	 */
	void setBH_NeedAdditionalVisitInfo(boolean BH_NeedAdditionalVisitInfo);

	/**
	 * Get Need Additional Visit Info.
	 *
	 * @return Need Additional Visit Info
	 */
	boolean isBH_NeedAdditionalVisitInfo();

	/**
	 * Column name bh_nextappointmentdate
	 */
	static final String COLUMNNAME_bh_nextappointmentdate = "bh_nextappointmentdate";

	/**
	 * Set Next Appointment Date.
	 *
	 * @param bh_nextappointmentdate Next Appointment Date
	 */
	void setbh_nextappointmentdate(Timestamp bh_nextappointmentdate);

	/**
	 * Get Next Appointment Date.
	 *
	 * @return Next Appointment Date
	 */
	Timestamp getbh_nextappointmentdate();

	/**
	 * Column name bh_occupation
	 */
	static final String COLUMNNAME_bh_occupation = "bh_occupation";

	/**
	 * Set Occupation.
	 *
	 * @param bh_occupation Occupation
	 */
	void setbh_occupation(String bh_occupation);

	/**
	 * Get Occupation.
	 *
	 * @return Occupation
	 */
	String getbh_occupation();

	/**
	 * Column name BH_PatientID
	 */
	static final String COLUMNNAME_BH_PatientID = "BH_PatientID";

	/**
	 * Set Patient ID.
	 *
	 * @param BH_PatientID A unique identifier for users to manually enter
	 */
	void setBH_PatientID(String BH_PatientID);

	/**
	 * Get Patient ID.
	 *
	 * @return A unique identifier for users to manually enter
	 */
	String getBH_PatientID();

	/**
	 * Column name BH_Phone
	 */
	static final String COLUMNNAME_BH_Phone = "BH_Phone";

	/**
	 * Set Phone.
	 *
	 * @param BH_Phone Identifies a telephone number
	 */
	void setBH_Phone(String BH_Phone);

	/**
	 * Get Phone.
	 *
	 * @return Identifies a telephone number
	 */
	String getBH_Phone();

	/**
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_GroupInput(ForeignEntityInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	ForeignEntityInput C_BP_Group();

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
	 * Set C_Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	void setC_DunningInput(ForeignEntityInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	ForeignEntityInput C_Dunning();

	/**
	 * Set C_Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	void setC_GreetingInput(ForeignEntityInput C_Greeting);

	/**
	 * Get C_Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	ForeignEntityInput C_Greeting();

	/**
	 * Set C_InvoiceSchedule.
	 *
	 * @param C_InvoiceSchedule Schedule for generating Invoices
	 */
	void setC_InvoiceScheduleInput(ForeignEntityInput C_InvoiceSchedule);

	/**
	 * Get C_InvoiceSchedule.
	 *
	 * @return Schedule for generating Invoices
	 */
	ForeignEntityInput C_InvoiceSchedule();

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
	 * Set C_TaxGroup.
	 *
	 * @param C_TaxGroup C_TaxGroup
	 */
	void setC_TaxGroupInput(ForeignEntityInput C_TaxGroup);

	/**
	 * Get C_TaxGroup.
	 *
	 * @return C_TaxGroup
	 */
	ForeignEntityInput C_TaxGroup();

	/**
	 * Set Default1099Box.
	 *
	 * @param Default1099Box Default1099Box
	 */
	void setDefault1099BoxInput(ForeignEntityInput Default1099Box);

	/**
	 * Get Default1099Box.
	 *
	 * @return Default1099Box
	 */
	ForeignEntityInput Default1099Box();

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
	void setInvoice_PrintFormatInput(ForeignEntityInput Invoice_PrintFormat);

	/**
	 * Get Invoice_PrintFormat.
	 *
	 * @return Print Format for printing Invoices
	 */
	ForeignEntityInput Invoice_PrintFormat();

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
	 * Set Logo.
	 *
	 * @param Logo Logo
	 */
	void setLogoInput(ForeignEntityInput Logo);

	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	ForeignEntityInput Logo();

	/**
	 * Set M_DiscountSchema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	void setM_DiscountSchemaInput(ForeignEntityInput M_DiscountSchema);

	/**
	 * Get M_DiscountSchema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	ForeignEntityInput M_DiscountSchema();

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
	 * Column name NationalID
	 */
	static final String COLUMNNAME_NationalID = "NationalID";

	/**
	 * Set NationalID.
	 *
	 * @param NationalID Patient Identity number
	 */
	void setNationalID(String NationalID);

	/**
	 * Get NationalID.
	 *
	 * @return Patient Identity number
	 */
	String getNationalID();

	/**
	 * Column name NextOfKin_Contact
	 */
	static final String COLUMNNAME_NextOfKin_Contact = "NextOfKin_Contact";

	/**
	 * Set Next of Kin Contact.
	 *
	 * @param NextOfKin_Contact Next of Kin Contact
	 */
	void setNextOfKin_Contact(String NextOfKin_Contact);

	/**
	 * Get Next of Kin Contact.
	 *
	 * @return Next of Kin Contact
	 */
	String getNextOfKin_Contact();

	/**
	 * Column name NextOfKin_Name
	 */
	static final String COLUMNNAME_NextOfKin_Name = "NextOfKin_Name";

	/**
	 * Set Next of Kin Name.
	 *
	 * @param NextOfKin_Name Next of Kin Name
	 */
	void setNextOfKin_Name(String NextOfKin_Name);

	/**
	 * Get Next of Kin Name.
	 *
	 * @return Next of Kin Name
	 */
	String getNextOfKin_Name();

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
	void setPO_DiscountSchemaInput(ForeignEntityInput PO_DiscountSchema);

	/**
	 * Get PO_DiscountSchema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	ForeignEntityInput PO_DiscountSchema();

	/**
	 * Set PO_PaymentTerm.
	 *
	 * @param PO_PaymentTerm Payment rules for a purchase order
	 */
	void setPO_PaymentTermInput(ForeignEntityInput PO_PaymentTerm);

	/**
	 * Get PO_PaymentTerm.
	 *
	 * @return Payment rules for a purchase order
	 */
	ForeignEntityInput PO_PaymentTerm();

	/**
	 * Set PO_PriceList.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	void setPO_PriceListInput(ForeignEntityInput PO_PriceList);

	/**
	 * Get PO_PriceList.
	 *
	 * @return Price List used by this Business Partner
	 */
	ForeignEntityInput PO_PriceList();

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
