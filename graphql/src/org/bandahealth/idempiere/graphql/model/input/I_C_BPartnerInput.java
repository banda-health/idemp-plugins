package org.bandahealth.idempiere.graphql.model.input;

import java.sql.Timestamp;
import org.compiere.model.I_C_BPartner;

/**
 * Generated Interface for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_BPartnerInput extends I_C_BPartner {

	/**
	 * Set AD_Language_L.
	 *
	 * @param AD_Language_L Language for this entity
	 */
	void setAD_Language_L(I_AD_LanguageInput AD_Language_L);

	/**
	 * Get AD_Language_L.
	 *
	 * @return Language for this entity
	 */
	I_AD_LanguageInput getAD_Language_L();

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
	 * Column name BH_Birthday
	 */
	public static final String COLUMNNAME_BH_Birthday = "BH_Birthday";

	/**
	 * Set Birthday.
	 *
	 * @param BH_Birthday Birthday or Anniversary day
	 */
	public void setBH_Birthday(Timestamp BH_Birthday);

	/**
	 * Get Birthday.
	 *
	 * @return Birthday or Anniversary day
	 */
	public Timestamp getBH_Birthday();

	/**
	 * Column name BH_EMail
	 */
	public static final String COLUMNNAME_BH_EMail = "BH_EMail";

	/**
	 * Set EMail Address.
	 *
	 * @param BH_EMail Electronic Mail Address
	 */
	public void setBH_EMail(String BH_EMail);

	/**
	 * Get EMail Address.
	 *
	 * @return Electronic Mail Address
	 */
	public String getBH_EMail();

	/**
	 * Column name bh_gender
	 */
	public static final String COLUMNNAME_bh_gender = "bh_gender";

	/**
	 * Set Gender.
	 *
	 * @param bh_gender Gender
	 */
	public void setbh_gender(String bh_gender);

	/**
	 * Get Gender.
	 *
	 * @return Gender
	 */
	public String getbh_gender();

	/**
	 * Set bh_gender_RL.
	 *
	 * @param bh_gender_RL bh_gender_RL
	 */
	void setbh_gender_RL(I_AD_Ref_ListInput bh_gender_RL);

	/**
	 * Get bh_gender_RL.
	 *
	 * @return bh_gender_RL
	 */
	I_AD_Ref_ListInput getbh_gender_RL();

	/**
	 * Column name BH_IsApproximateDateOfBirth
	 */
	public static final String COLUMNNAME_BH_IsApproximateDateOfBirth = "BH_IsApproximateDateOfBirth";

	/**
	 * Set Is Approximate Date Of Birth.
	 *
	 * @param BH_IsApproximateDateOfBirth Is Approximate Date Of Birth
	 */
	public void setBH_IsApproximateDateOfBirth(boolean BH_IsApproximateDateOfBirth);

	/**
	 * Get Is Approximate Date Of Birth.
	 *
	 * @return Is Approximate Date Of Birth
	 */
	public boolean isBH_IsApproximateDateOfBirth();

	/**
	 * Column name BH_Local_PatientID
	 */
	public static final String COLUMNNAME_BH_Local_PatientID = "BH_Local_PatientID";

	/**
	 * Set Local Patient ID.
	 *
	 * @param BH_Local_PatientID Local Patient ID
	 */
	public void setBH_Local_PatientID(String BH_Local_PatientID);

	/**
	 * Get Local Patient ID.
	 *
	 * @return Local Patient ID
	 */
	public String getBH_Local_PatientID();

	/**
	 * Column name BH_Locked
	 */
	public static final String COLUMNNAME_BH_Locked = "BH_Locked";

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked);

	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public boolean isBH_Locked();

	/**
	 * Column name BH_NeedAdditionalVisitInfo
	 */
	public static final String COLUMNNAME_BH_NeedAdditionalVisitInfo = "BH_NeedAdditionalVisitInfo";

	/**
	 * Set Need Additional Visit Info.
	 *
	 * @param BH_NeedAdditionalVisitInfo Need Additional Visit Info
	 */
	public void setBH_NeedAdditionalVisitInfo(boolean BH_NeedAdditionalVisitInfo);

	/**
	 * Get Need Additional Visit Info.
	 *
	 * @return Need Additional Visit Info
	 */
	public boolean isBH_NeedAdditionalVisitInfo();

	/**
	 * Column name bh_nextappointmentdate
	 */
	public static final String COLUMNNAME_bh_nextappointmentdate = "bh_nextappointmentdate";

	/**
	 * Set Next Appointment Date.
	 *
	 * @param bh_nextappointmentdate Next Appointment Date
	 */
	public void setbh_nextappointmentdate(Timestamp bh_nextappointmentdate);

	/**
	 * Get Next Appointment Date.
	 *
	 * @return Next Appointment Date
	 */
	public Timestamp getbh_nextappointmentdate();

	/**
	 * Column name bh_occupation
	 */
	public static final String COLUMNNAME_bh_occupation = "bh_occupation";

	/**
	 * Set Occupation.
	 *
	 * @param bh_occupation Occupation
	 */
	public void setbh_occupation(String bh_occupation);

	/**
	 * Get Occupation.
	 *
	 * @return Occupation
	 */
	public String getbh_occupation();

	/**
	 * Column name BH_PatientID
	 */
	public static final String COLUMNNAME_BH_PatientID = "BH_PatientID";

	/**
	 * Set Patient ID.
	 *
	 * @param BH_PatientID A unique identifier for users to manually enter
	 */
	public void setBH_PatientID(String BH_PatientID);

	/**
	 * Get Patient ID.
	 *
	 * @return A unique identifier for users to manually enter
	 */
	public String getBH_PatientID();

	/**
	 * Column name BH_Phone
	 */
	public static final String COLUMNNAME_BH_Phone = "BH_Phone";

	/**
	 * Set Phone.
	 *
	 * @param BH_Phone Identifies a telephone number
	 */
	public void setBH_Phone(String BH_Phone);

	/**
	 * Get Phone.
	 *
	 * @return Identifies a telephone number
	 */
	public String getBH_Phone();

	/**
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_Group(I_C_BP_GroupInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	I_C_BP_GroupInput getC_BP_Group();

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
	void setC_Dunning(I_C_DunningInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	I_C_DunningInput getC_Dunning();

	/**
	 * Set C_Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	void setC_Greeting(I_C_GreetingInput C_Greeting);

	/**
	 * Get C_Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	I_C_GreetingInput getC_Greeting();

	/**
	 * Set C_InvoiceSchedule.
	 *
	 * @param C_InvoiceSchedule Schedule for generating Invoices
	 */
	void setC_InvoiceSchedule(I_C_InvoiceScheduleInput C_InvoiceSchedule);

	/**
	 * Get C_InvoiceSchedule.
	 *
	 * @return Schedule for generating Invoices
	 */
	I_C_InvoiceScheduleInput getC_InvoiceSchedule();

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
	 * Set C_TaxGroup.
	 *
	 * @param C_TaxGroup C_TaxGroup
	 */
	void setC_TaxGroup(I_C_TaxGroupInput C_TaxGroup);

	/**
	 * Get C_TaxGroup.
	 *
	 * @return C_TaxGroup
	 */
	I_C_TaxGroupInput getC_TaxGroup();

	/**
	 * Set Default1099Box.
	 *
	 * @param Default1099Box Default1099Box
	 */
	void setDefault1099Box(I_C_1099BoxInput Default1099Box);

	/**
	 * Get Default1099Box.
	 *
	 * @return Default1099Box
	 */
	I_C_1099BoxInput getDefault1099Box();

	/**
	 * Set DeliveryRule_RL.
	 *
	 * @param DeliveryRule_RL Defines the timing of Delivery
	 */
	void setDeliveryRule_RL(I_AD_Ref_ListInput DeliveryRule_RL);

	/**
	 * Get DeliveryRule_RL.
	 *
	 * @return Defines the timing of Delivery
	 */
	I_AD_Ref_ListInput getDeliveryRule_RL();

	/**
	 * Set DeliveryViaRule_RL.
	 *
	 * @param DeliveryViaRule_RL How the order will be delivered
	 */
	void setDeliveryViaRule_RL(I_AD_Ref_ListInput DeliveryViaRule_RL);

	/**
	 * Get DeliveryViaRule_RL.
	 *
	 * @return How the order will be delivered
	 */
	I_AD_Ref_ListInput getDeliveryViaRule_RL();

	/**
	 * Set FreightCostRule_RL.
	 *
	 * @param FreightCostRule_RL Method for charging Freight
	 */
	void setFreightCostRule_RL(I_AD_Ref_ListInput FreightCostRule_RL);

	/**
	 * Get FreightCostRule_RL.
	 *
	 * @return Method for charging Freight
	 */
	I_AD_Ref_ListInput getFreightCostRule_RL();

	/**
	 * Set Invoice_PrintFormat.
	 *
	 * @param Invoice_PrintFormat Print Format for printing Invoices
	 */
	void setInvoice_PrintFormat(I_AD_PrintFormatInput Invoice_PrintFormat);

	/**
	 * Get Invoice_PrintFormat.
	 *
	 * @return Print Format for printing Invoices
	 */
	I_AD_PrintFormatInput getInvoice_PrintFormat();

	/**
	 * Set InvoiceRule_RL.
	 *
	 * @param InvoiceRule_RL Frequency and method of invoicing 
	 */
	void setInvoiceRule_RL(I_AD_Ref_ListInput InvoiceRule_RL);

	/**
	 * Get InvoiceRule_RL.
	 *
	 * @return Frequency and method of invoicing 
	 */
	I_AD_Ref_ListInput getInvoiceRule_RL();

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image AD_Image
	 */
	void setAD_Image(I_AD_ImageInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return AD_Image
	 */
	I_AD_ImageInput getAD_Image();

	/**
	 * Set M_DiscountSchema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	void setM_DiscountSchema(I_M_DiscountSchemaInput M_DiscountSchema);

	/**
	 * Get M_DiscountSchema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	I_M_DiscountSchemaInput getM_DiscountSchema();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceList(I_M_PriceListInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	I_M_PriceListInput getM_PriceList();

	/**
	 * Column name NationalID
	 */
	public static final String COLUMNNAME_NationalID = "NationalID";

	/**
	 * Set NationalID.
	 *
	 * @param NationalID Patient Identity number
	 */
	public void setNationalID(String NationalID);

	/**
	 * Get NationalID.
	 *
	 * @return Patient Identity number
	 */
	public String getNationalID();

	/**
	 * Column name NextOfKin_Contact
	 */
	public static final String COLUMNNAME_NextOfKin_Contact = "NextOfKin_Contact";

	/**
	 * Set Next of Kin Contact.
	 *
	 * @param NextOfKin_Contact Next of Kin Contact
	 */
	public void setNextOfKin_Contact(String NextOfKin_Contact);

	/**
	 * Get Next of Kin Contact.
	 *
	 * @return Next of Kin Contact
	 */
	public String getNextOfKin_Contact();

	/**
	 * Column name NextOfKin_Name
	 */
	public static final String COLUMNNAME_NextOfKin_Name = "NextOfKin_Name";

	/**
	 * Set Next of Kin Name.
	 *
	 * @param NextOfKin_Name Next of Kin Name
	 */
	public void setNextOfKin_Name(String NextOfKin_Name);

	/**
	 * Get Next of Kin Name.
	 *
	 * @return Next of Kin Name
	 */
	public String getNextOfKin_Name();

	/**
	 * Set PaymentRule_RL.
	 *
	 * @param PaymentRule_RL How you pay the invoice
	 */
	void setPaymentRule_RL(I_AD_Ref_ListInput PaymentRule_RL);

	/**
	 * Get PaymentRule_RL.
	 *
	 * @return How you pay the invoice
	 */
	I_AD_Ref_ListInput getPaymentRule_RL();

	/**
	 * Set PaymentRulePO_RL.
	 *
	 * @param PaymentRulePO_RL Purchase payment option
	 */
	void setPaymentRulePO_RL(I_AD_Ref_ListInput PaymentRulePO_RL);

	/**
	 * Get PaymentRulePO_RL.
	 *
	 * @return Purchase payment option
	 */
	I_AD_Ref_ListInput getPaymentRulePO_RL();

	/**
	 * Set PO_DiscountSchema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	void setPO_DiscountSchema(I_M_DiscountSchemaInput PO_DiscountSchema);

	/**
	 * Get PO_DiscountSchema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	I_M_DiscountSchemaInput getPO_DiscountSchema();

	/**
	 * Set PO_PaymentTerm.
	 *
	 * @param PO_PaymentTerm Payment rules for a purchase order
	 */
	void setPO_PaymentTerm(I_C_PaymentTermInput PO_PaymentTerm);

	/**
	 * Get PO_PaymentTerm.
	 *
	 * @return Payment rules for a purchase order
	 */
	I_C_PaymentTermInput getPO_PaymentTerm();

	/**
	 * Set PO_PriceList.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	void setPO_PriceList(I_M_PriceListInput PO_PriceList);

	/**
	 * Get PO_PriceList.
	 *
	 * @return Price List used by this Business Partner
	 */
	I_M_PriceListInput getPO_PriceList();

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

	/**
	 * Set SOCreditStatus_RL.
	 *
	 * @param SOCreditStatus_RL Business Partner Credit Status
	 */
	void setSOCreditStatus_RL(I_AD_Ref_ListInput SOCreditStatus_RL);

	/**
	 * Get SOCreditStatus_RL.
	 *
	 * @return Business Partner Credit Status
	 */
	I_AD_Ref_ListInput getSOCreditStatus_RL();
}
