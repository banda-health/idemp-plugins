package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDunning;
import org.compiere.model.MImage;
import org.compiere.model.MInvoiceSchedule;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_C_1099Box;
import org.compiere.model.X_C_BPartner;
import org.compiere.model.X_C_Greeting;
import org.compiere.util.Env;
import org.eevolution.model.X_C_TaxGroup;

/**
 * Generated Model for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BPartnerInput extends X_C_BPartner implements I_C_BPartnerInput {

	 private I_AD_ImageInput AD_Image;
	 private I_AD_LanguageInput AD_Language_L;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintFormatInput Invoice_PrintFormat;
	 private I_AD_Ref_ListInput DeliveryRule_RL;
	 private I_AD_Ref_ListInput DeliveryViaRule_RL;
	 private I_AD_Ref_ListInput FreightCostRule_RL;
	 private I_AD_Ref_ListInput InvoiceRule_RL;
	 private I_AD_Ref_ListInput PaymentRulePO_RL;
	 private I_AD_Ref_ListInput PaymentRule_RL;
	 private I_AD_Ref_ListInput SOCreditStatus_RL;
	 private I_AD_Ref_ListInput bh_gender_RL;
	 private I_AD_UserInput SalesRep;
	 private I_C_1099BoxInput Default1099Box;
	 private I_C_BP_GroupInput C_BP_Group;
	 private I_C_DunningInput C_Dunning;
	 private I_C_GreetingInput C_Greeting;
	 private I_C_InvoiceScheduleInput C_InvoiceSchedule;
	 private I_C_PaymentTermInput C_PaymentTerm;
	 private I_C_PaymentTermInput PO_PaymentTerm;
	 private I_C_TaxGroupInput C_TaxGroup;
	 private I_M_DiscountSchemaInput M_DiscountSchema;
	 private I_M_DiscountSchemaInput PO_DiscountSchema;
	 private I_M_PriceListInput M_PriceList;
	 private I_M_PriceListInput PO_PriceList;

	/**
	 * Standard constructor
	 */
	public X_C_BPartnerInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Language.
	 *
	 * @param AD_Language_L Language for this entity
	 */
	public void setAD_Language_L(I_AD_LanguageInput AD_Language_L) {
		this.AD_Language_L = AD_Language_L;
		MLanguage foreignEntity;
		if (AD_Language_L != null &&
				(foreignEntity = new Query(getCtx(), MLanguage.Table_Name, MLanguage.COLUMNNAME_AD_Language_UU + "=?", get_TrxName())
						.setParameters(AD_Language_L.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Language(foreignEntity.getAD_Language());
		} else {
			this.setAD_Language(null);
		}
	}

	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	public I_AD_LanguageInput getAD_Language_L() {
		return AD_Language_L;
	}
	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */

	public void setAD_Language(String AD_Language) {
		if (get_ID() == 0) {
			super.setAD_Language(AD_Language);
		}
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Birthday.
	 *
	 * @param BH_Birthday Birthday or Anniversary day
	 */
	public void setBH_Birthday(Timestamp BH_Birthday) {
		set_Value(COLUMNNAME_BH_Birthday, BH_Birthday);
	}


	/**
	 * Get Birthday.
	 *
	 * @return Birthday or Anniversary day
	 */
	public Timestamp getBH_Birthday() {
 		return (Timestamp) get_Value(COLUMNNAME_BH_Birthday);
	}


	/**
	 * Set EMail Address.
	 *
	 * @param BH_EMail Electronic Mail Address
	 */
	public void setBH_EMail(String BH_EMail) {
		set_Value(COLUMNNAME_BH_EMail, BH_EMail);
	}


	/**
	 * Get EMail Address.
	 *
	 * @return Electronic Mail Address
	 */
	public String getBH_EMail() {
 		return (String) get_Value(COLUMNNAME_BH_EMail);
	}

	/**
	 * Female = female
	 */
	public static final String BH_GENDER_Female = "female";
	/**
	 * Male = male
	 */
	public static final String BH_GENDER_Male = "male";

	/**
	 * Set Gender.
	 *
	 * @param bh_gender Gender
	 */
	public void setbh_gender(String bh_gender) {

		set_Value(COLUMNNAME_bh_gender, bh_gender);
	}


	/**
	 * Get Gender.
	 *
	 * @return Gender
	 */
	public String getbh_gender() {
 		return (String) get_Value(COLUMNNAME_bh_gender);
	}


	/**
	 * Set Gender.
	 *
	 * @param bh_gender_RL Gender
	 */
	public void setbh_gender_RL(I_AD_Ref_ListInput bh_gender_RL) {
		this.bh_gender_RL = bh_gender_RL;
		MRefList foreignEntity;
		if (bh_gender_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(bh_gender_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setbh_gender(foreignEntity.getValue());
		} else {
			this.setbh_gender(null);
		}
	}

	/**
	 * Get Gender.
	 *
	 * @return Gender
	 */
	public I_AD_Ref_ListInput getbh_gender_RL() {
		return bh_gender_RL;
	}

	/**
	 * Set Is Approximate Date Of Birth.
	 *
	 * @param BH_IsApproximateDateOfBirth Is Approximate Date Of Birth
	 */
	public void setBH_IsApproximateDateOfBirth(boolean BH_IsApproximateDateOfBirth) {
		set_Value(COLUMNNAME_BH_IsApproximateDateOfBirth, BH_IsApproximateDateOfBirth);
	}


	/**
	 * Get Is Approximate Date Of Birth.
	 *
	 * @return Is Approximate Date Of Birth
	 */
	public boolean isBH_IsApproximateDateOfBirth() {
 		Object columnValue = get_Value(COLUMNNAME_BH_IsApproximateDateOfBirth);
		if (columnValue != null) {
			if (columnValue instanceof Boolean) {
				return ((Boolean) columnValue);
			}
			return "Y".equals(columnValue);
		}
		return false;
	}


	/**
	 * Set Local Patient ID.
	 *
	 * @param BH_Local_PatientID Local Patient ID
	 */
	public void setBH_Local_PatientID(String BH_Local_PatientID) {
		set_Value(COLUMNNAME_BH_Local_PatientID, BH_Local_PatientID);
	}


	/**
	 * Get Local Patient ID.
	 *
	 * @return Local Patient ID
	 */
	public String getBH_Local_PatientID() {
 		return (String) get_Value(COLUMNNAME_BH_Local_PatientID);
	}


	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked) {
		set_Value(COLUMNNAME_BH_Locked, BH_Locked);
	}


	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public boolean isBH_Locked() {
 		Object columnValue = get_Value(COLUMNNAME_BH_Locked);
		if (columnValue != null) {
			if (columnValue instanceof Boolean) {
				return ((Boolean) columnValue);
			}
			return "Y".equals(columnValue);
		}
		return false;
	}


	/**
	 * Set Need Additional Visit Info.
	 *
	 * @param BH_NeedAdditionalVisitInfo Need Additional Visit Info
	 */
	public void setBH_NeedAdditionalVisitInfo(boolean BH_NeedAdditionalVisitInfo) {
		set_Value(COLUMNNAME_BH_NeedAdditionalVisitInfo, BH_NeedAdditionalVisitInfo);
	}


	/**
	 * Get Need Additional Visit Info.
	 *
	 * @return Need Additional Visit Info
	 */
	public boolean isBH_NeedAdditionalVisitInfo() {
 		Object columnValue = get_Value(COLUMNNAME_BH_NeedAdditionalVisitInfo);
		if (columnValue != null) {
			if (columnValue instanceof Boolean) {
				return ((Boolean) columnValue);
			}
			return "Y".equals(columnValue);
		}
		return false;
	}


	/**
	 * Set Next Appointment Date.
	 *
	 * @param bh_nextappointmentdate Next Appointment Date
	 */
	public void setbh_nextappointmentdate(Timestamp bh_nextappointmentdate) {
		set_Value(COLUMNNAME_bh_nextappointmentdate, bh_nextappointmentdate);
	}


	/**
	 * Get Next Appointment Date.
	 *
	 * @return Next Appointment Date
	 */
	public Timestamp getbh_nextappointmentdate() {
 		return (Timestamp) get_Value(COLUMNNAME_bh_nextappointmentdate);
	}


	/**
	 * Set Occupation.
	 *
	 * @param bh_occupation Occupation
	 */
	public void setbh_occupation(String bh_occupation) {
		set_Value(COLUMNNAME_bh_occupation, bh_occupation);
	}


	/**
	 * Get Occupation.
	 *
	 * @return Occupation
	 */
	public String getbh_occupation() {
 		return (String) get_Value(COLUMNNAME_bh_occupation);
	}


	/**
	 * Set Patient ID.
	 *
	 * @param BH_PatientID A unique identifier for users to manually enter
	 */
	public void setBH_PatientID(String BH_PatientID) {
		set_Value(COLUMNNAME_BH_PatientID, BH_PatientID);
	}


	/**
	 * Get Patient ID.
	 *
	 * @return A unique identifier for users to manually enter
	 */
	public String getBH_PatientID() {
 		return (String) get_Value(COLUMNNAME_BH_PatientID);
	}


	/**
	 * Set Phone.
	 *
	 * @param BH_Phone Identifies a telephone number
	 */
	public void setBH_Phone(String BH_Phone) {
		set_Value(COLUMNNAME_BH_Phone, BH_Phone);
	}


	/**
	 * Get Phone.
	 *
	 * @return Identifies a telephone number
	 */
	public String getBH_Phone() {
 		return (String) get_Value(COLUMNNAME_BH_Phone);
	}


	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	public void setC_BP_Group(I_C_BP_GroupInput C_BP_Group) {
		this.C_BP_Group = C_BP_Group;
		MBPGroup_BH foreignEntity;
		if (C_BP_Group != null &&
				(foreignEntity = new Query(getCtx(), MBPGroup_BH.Table_Name, MBPGroup_BH.COLUMNNAME_C_BP_Group_UU + "=?", get_TrxName())
						.setParameters(C_BP_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BP_Group_ID(foreignEntity.get_ID());
		} else {
			this.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public I_C_BP_GroupInput getC_BP_Group() {
		return C_BP_Group;
	}
	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner_ID Identifies a Business Partner
	 */

	public void setC_BPartner_ID(int C_BPartner_ID) {
		if (get_ID() == 0) {
			super.setC_BPartner_ID(C_BPartner_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BPartner_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BPartner_UU();
	}

	/**
	 * Set Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	public void setC_Dunning(I_C_DunningInput C_Dunning) {
		this.C_Dunning = C_Dunning;
		MDunning foreignEntity;
		if (C_Dunning != null &&
				(foreignEntity = new Query(getCtx(), MDunning.Table_Name, MDunning.COLUMNNAME_C_Dunning_UU + "=?", get_TrxName())
						.setParameters(C_Dunning.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Dunning_ID(foreignEntity.get_ID());
		} else {
			this.setC_Dunning_ID(0);
		}
	}

	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	public I_C_DunningInput getC_Dunning() {
		return C_Dunning;
	}

	/**
	 * Set Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	public void setC_Greeting(I_C_GreetingInput C_Greeting) {
		this.C_Greeting = C_Greeting;
		X_C_Greeting foreignEntity;
		if (C_Greeting != null &&
				(foreignEntity = new Query(getCtx(), X_C_Greeting.Table_Name, X_C_Greeting.COLUMNNAME_C_Greeting_UU + "=?", get_TrxName())
						.setParameters(C_Greeting.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Greeting_ID(foreignEntity.get_ID());
		} else {
			this.setC_Greeting_ID(0);
		}
	}

	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	public I_C_GreetingInput getC_Greeting() {
		return C_Greeting;
	}

	/**
	 * Set Invoice Schedule.
	 *
	 * @param C_InvoiceSchedule Schedule for generating Invoices
	 */
	public void setC_InvoiceSchedule(I_C_InvoiceScheduleInput C_InvoiceSchedule) {
		this.C_InvoiceSchedule = C_InvoiceSchedule;
		MInvoiceSchedule foreignEntity;
		if (C_InvoiceSchedule != null &&
				(foreignEntity = new Query(getCtx(), MInvoiceSchedule.Table_Name, MInvoiceSchedule.COLUMNNAME_C_InvoiceSchedule_UU + "=?", get_TrxName())
						.setParameters(C_InvoiceSchedule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_InvoiceSchedule_ID(foreignEntity.get_ID());
		} else {
			this.setC_InvoiceSchedule_ID(0);
		}
	}

	/**
	 * Get Invoice Schedule.
	 *
	 * @return Schedule for generating Invoices
	 */
	public I_C_InvoiceScheduleInput getC_InvoiceSchedule() {
		return C_InvoiceSchedule;
	}

	/**
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	public void setC_PaymentTerm(I_C_PaymentTermInput C_PaymentTerm) {
		this.C_PaymentTerm = C_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (C_PaymentTerm != null &&
				(foreignEntity = new Query(getCtx(), MPaymentTerm.Table_Name, MPaymentTerm.COLUMNNAME_C_PaymentTerm_UU + "=?", get_TrxName())
						.setParameters(C_PaymentTerm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_PaymentTerm_ID(foreignEntity.get_ID());
		} else {
			this.setC_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public I_C_PaymentTermInput getC_PaymentTerm() {
		return C_PaymentTerm;
	}
	/**
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm_ID The terms of Payment (timing, discount)
	 */

	public void setC_PaymentTerm_ID(int C_PaymentTerm_ID) {
		if (get_ID() == 0) {
			super.setC_PaymentTerm_ID(C_PaymentTerm_ID);
		}
	}

	/**
	 * Set Tax Group.
	 *
	 * @param C_TaxGroup Tax Group
	 */
	public void setC_TaxGroup(I_C_TaxGroupInput C_TaxGroup) {
		this.C_TaxGroup = C_TaxGroup;
		X_C_TaxGroup foreignEntity;
		if (C_TaxGroup != null &&
				(foreignEntity = new Query(getCtx(), X_C_TaxGroup.Table_Name, X_C_TaxGroup.COLUMNNAME_C_TaxGroup_UU + "=?", get_TrxName())
						.setParameters(C_TaxGroup.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_TaxGroup_ID(foreignEntity.get_ID());
		} else {
			this.setC_TaxGroup_ID(0);
		}
	}

	/**
	 * Get Tax Group.
	 *
	 * @return Tax Group
	 */
	public I_C_TaxGroupInput getC_TaxGroup() {
		return C_TaxGroup;
	}

	/**
	 * Set Default 1099 Box.
	 *
	 * @param Default1099Box Default 1099 Box
	 */
	public void setDefault1099Box(I_C_1099BoxInput Default1099Box) {
		this.Default1099Box = Default1099Box;
		X_C_1099Box foreignEntity;
		if (Default1099Box != null &&
				(foreignEntity = new Query(getCtx(), X_C_1099Box.Table_Name, X_C_1099Box.COLUMNNAME_C_1099Box_UU + "=?", get_TrxName())
						.setParameters(Default1099Box.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDefault1099Box_ID(foreignEntity.get_ID());
		} else {
			this.setDefault1099Box_ID(0);
		}
	}

	/**
	 * Get Default 1099 Box.
	 *
	 * @return Default 1099 Box
	 */
	public I_C_1099BoxInput getDefault1099Box() {
		return Default1099Box;
	}
	/**
	 * Set Default 1099 Box.
	 *
	 * @param Default1099Box_ID Default 1099 Box
	 */

	public void setDefault1099Box_ID(int Default1099Box_ID) {
		if (get_ID() == 0) {
			super.setDefault1099Box_ID(Default1099Box_ID);
		}
	}

	/**
	 * Set Delivery Rule.
	 *
	 * @param DeliveryRule_RL Defines the timing of Delivery
	 */
	public void setDeliveryRule_RL(I_AD_Ref_ListInput DeliveryRule_RL) {
		this.DeliveryRule_RL = DeliveryRule_RL;
		MRefList foreignEntity;
		if (DeliveryRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DeliveryRule_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDeliveryRule(foreignEntity.getValue());
		} else {
			this.setDeliveryRule(null);
		}
	}

	/**
	 * Get Delivery Rule.
	 *
	 * @return Defines the timing of Delivery
	 */
	public I_AD_Ref_ListInput getDeliveryRule_RL() {
		return DeliveryRule_RL;
	}

	/**
	 * Set Delivery Via.
	 *
	 * @param DeliveryViaRule_RL How the order will be delivered
	 */
	public void setDeliveryViaRule_RL(I_AD_Ref_ListInput DeliveryViaRule_RL) {
		this.DeliveryViaRule_RL = DeliveryViaRule_RL;
		MRefList foreignEntity;
		if (DeliveryViaRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DeliveryViaRule_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDeliveryViaRule(foreignEntity.getValue());
		} else {
			this.setDeliveryViaRule(null);
		}
	}

	/**
	 * Get Delivery Via.
	 *
	 * @return How the order will be delivered
	 */
	public I_AD_Ref_ListInput getDeliveryViaRule_RL() {
		return DeliveryViaRule_RL;
	}

	/**
	 * Set Freight Cost Rule.
	 *
	 * @param FreightCostRule_RL Method for charging Freight
	 */
	public void setFreightCostRule_RL(I_AD_Ref_ListInput FreightCostRule_RL) {
		this.FreightCostRule_RL = FreightCostRule_RL;
		MRefList foreignEntity;
		if (FreightCostRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FreightCostRule_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFreightCostRule(foreignEntity.getValue());
		} else {
			this.setFreightCostRule(null);
		}
	}

	/**
	 * Get Freight Cost Rule.
	 *
	 * @return Method for charging Freight
	 */
	public I_AD_Ref_ListInput getFreightCostRule_RL() {
		return FreightCostRule_RL;
	}

	/**
	 * Set Invoice Print Format.
	 *
	 * @param Invoice_PrintFormat Print Format for printing Invoices
	 */
	public void setInvoice_PrintFormat(I_AD_PrintFormatInput Invoice_PrintFormat) {
		this.Invoice_PrintFormat = Invoice_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Invoice_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFormat.Table_Name, X_AD_PrintFormat.COLUMNNAME_AD_PrintFormat_UU + "=?", get_TrxName())
						.setParameters(Invoice_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInvoice_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			this.setInvoice_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Invoice Print Format.
	 *
	 * @return Print Format for printing Invoices
	 */
	public I_AD_PrintFormatInput getInvoice_PrintFormat() {
		return Invoice_PrintFormat;
	}
	/**
	 * Set Invoice Print Format.
	 *
	 * @param Invoice_PrintFormat_ID Print Format for printing Invoices
	 */

	public void setInvoice_PrintFormat_ID(int Invoice_PrintFormat_ID) {
		if (get_ID() == 0) {
			super.setInvoice_PrintFormat_ID(Invoice_PrintFormat_ID);
		}
	}

	/**
	 * Set Invoice Rule.
	 *
	 * @param InvoiceRule_RL Frequency and method of invoicing 
	 */
	public void setInvoiceRule_RL(I_AD_Ref_ListInput InvoiceRule_RL) {
		this.InvoiceRule_RL = InvoiceRule_RL;
		MRefList foreignEntity;
		if (InvoiceRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceRule_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInvoiceRule(foreignEntity.getValue());
		} else {
			this.setInvoiceRule(null);
		}
	}

	/**
	 * Get Invoice Rule.
	 *
	 * @return Frequency and method of invoicing 
	 */
	public I_AD_Ref_ListInput getInvoiceRule_RL() {
		return InvoiceRule_RL;
	}

	/**
	 * Set Logo.
	 *
	 * @param AD_Image Logo
	 */
	public void setAD_Image(I_AD_ImageInput AD_Image) {
		this.AD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + "=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLogo_ID(foreignEntity.get_ID());
		} else {
			this.setLogo_ID(0);
		}
	}

	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	public I_AD_ImageInput getAD_Image() {
		return AD_Image;
	}

	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	public void setM_DiscountSchema(I_M_DiscountSchemaInput M_DiscountSchema) {
		this.M_DiscountSchema = M_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (M_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(M_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			this.setM_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	public I_M_DiscountSchemaInput getM_DiscountSchema() {
		return M_DiscountSchema;
	}
	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema_ID Schema to calculate the trade discount percentage
	 */

	public void setM_DiscountSchema_ID(int M_DiscountSchema_ID) {
		if (get_ID() == 0) {
			super.setM_DiscountSchema_ID(M_DiscountSchema_ID);
		}
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	public void setM_PriceList(I_M_PriceListInput M_PriceList) {
		this.M_PriceList = M_PriceList;
		MPriceList foreignEntity;
		if (M_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(M_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_PriceList_ID(foreignEntity.get_ID());
		} else {
			this.setM_PriceList_ID(0);
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public I_M_PriceListInput getM_PriceList() {
		return M_PriceList;
	}

	/**
	 * Set NationalID.
	 *
	 * @param NationalID Patient Identity number
	 */
	public void setNationalID(String NationalID) {
		set_Value(COLUMNNAME_NationalID, NationalID);
	}


	/**
	 * Get NationalID.
	 *
	 * @return Patient Identity number
	 */
	public String getNationalID() {
 		return (String) get_Value(COLUMNNAME_NationalID);
	}


	/**
	 * Set Next of Kin Contact.
	 *
	 * @param NextOfKin_Contact Next of Kin Contact
	 */
	public void setNextOfKin_Contact(String NextOfKin_Contact) {
		set_Value(COLUMNNAME_NextOfKin_Contact, NextOfKin_Contact);
	}


	/**
	 * Get Next of Kin Contact.
	 *
	 * @return Next of Kin Contact
	 */
	public String getNextOfKin_Contact() {
 		return (String) get_Value(COLUMNNAME_NextOfKin_Contact);
	}


	/**
	 * Set Next of Kin Name.
	 *
	 * @param NextOfKin_Name Next of Kin Name
	 */
	public void setNextOfKin_Name(String NextOfKin_Name) {
		set_Value(COLUMNNAME_NextOfKin_Name, NextOfKin_Name);
	}


	/**
	 * Get Next of Kin Name.
	 *
	 * @return Next of Kin Name
	 */
	public String getNextOfKin_Name() {
 		return (String) get_Value(COLUMNNAME_NextOfKin_Name);
	}


	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRule_RL How you pay the invoice
	 */
	public void setPaymentRule_RL(I_AD_Ref_ListInput PaymentRule_RL) {
		this.PaymentRule_RL = PaymentRule_RL;
		MRefList foreignEntity;
		if (PaymentRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentRule_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPaymentRule(foreignEntity.getValue());
		} else {
			this.setPaymentRule(null);
		}
	}

	/**
	 * Get Payment Rule.
	 *
	 * @return How you pay the invoice
	 */
	public I_AD_Ref_ListInput getPaymentRule_RL() {
		return PaymentRule_RL;
	}

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRulePO_RL Purchase payment option
	 */
	public void setPaymentRulePO_RL(I_AD_Ref_ListInput PaymentRulePO_RL) {
		this.PaymentRulePO_RL = PaymentRulePO_RL;
		MRefList foreignEntity;
		if (PaymentRulePO_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentRulePO_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPaymentRulePO(foreignEntity.getValue());
		} else {
			this.setPaymentRulePO(null);
		}
	}

	/**
	 * Get Payment Rule.
	 *
	 * @return Purchase payment option
	 */
	public I_AD_Ref_ListInput getPaymentRulePO_RL() {
		return PaymentRulePO_RL;
	}

	/**
	 * Set PO Discount Schema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	public void setPO_DiscountSchema(I_M_DiscountSchemaInput PO_DiscountSchema) {
		this.PO_DiscountSchema = PO_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (PO_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(PO_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPO_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			this.setPO_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get PO Discount Schema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	public I_M_DiscountSchemaInput getPO_DiscountSchema() {
		return PO_DiscountSchema;
	}
	/**
	 * Set PO Discount Schema.
	 *
	 * @param PO_DiscountSchema_ID Schema to calculate the purchase trade discount percentage
	 */

	public void setPO_DiscountSchema_ID(int PO_DiscountSchema_ID) {
		if (get_ID() == 0) {
			super.setPO_DiscountSchema_ID(PO_DiscountSchema_ID);
		}
	}

	/**
	 * Set PO Payment Term.
	 *
	 * @param PO_PaymentTerm Payment rules for a purchase order
	 */
	public void setPO_PaymentTerm(I_C_PaymentTermInput PO_PaymentTerm) {
		this.PO_PaymentTerm = PO_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (PO_PaymentTerm != null &&
				(foreignEntity = new Query(getCtx(), MPaymentTerm.Table_Name, MPaymentTerm.COLUMNNAME_C_PaymentTerm_UU + "=?", get_TrxName())
						.setParameters(PO_PaymentTerm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPO_PaymentTerm_ID(foreignEntity.get_ID());
		} else {
			this.setPO_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get PO Payment Term.
	 *
	 * @return Payment rules for a purchase order
	 */
	public I_C_PaymentTermInput getPO_PaymentTerm() {
		return PO_PaymentTerm;
	}
	/**
	 * Set PO Payment Term.
	 *
	 * @param PO_PaymentTerm_ID Payment rules for a purchase order
	 */

	public void setPO_PaymentTerm_ID(int PO_PaymentTerm_ID) {
		if (get_ID() == 0) {
			super.setPO_PaymentTerm_ID(PO_PaymentTerm_ID);
		}
	}

	/**
	 * Set Purchase Pricelist.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	public void setPO_PriceList(I_M_PriceListInput PO_PriceList) {
		this.PO_PriceList = PO_PriceList;
		MPriceList foreignEntity;
		if (PO_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(PO_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPO_PriceList_ID(foreignEntity.get_ID());
		} else {
			this.setPO_PriceList_ID(0);
		}
	}

	/**
	 * Get Purchase Pricelist.
	 *
	 * @return Price List used by this Business Partner
	 */
	public I_M_PriceListInput getPO_PriceList() {
		return PO_PriceList;
	}
	/**
	 * Set Purchase Pricelist.
	 *
	 * @param PO_PriceList_ID Price List used by this Business Partner
	 */

	public void setPO_PriceList_ID(int PO_PriceList_ID) {
		if (get_ID() == 0) {
			super.setPO_PriceList_ID(PO_PriceList_ID);
		}
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	public void setSalesRep(I_AD_UserInput SalesRep) {
		this.SalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			this.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public I_AD_UserInput getSalesRep() {
		return SalesRep;
	}
	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep_ID Sales Representative or Company Agent
	 */

	public void setSalesRep_ID(int SalesRep_ID) {
		if (get_ID() == 0) {
			super.setSalesRep_ID(SalesRep_ID);
		}
	}
	/**
	 * Set Credit Used.
	 *
	 * @param SO_CreditUsed Current open balance
	 */

	public void setSO_CreditUsed(BigDecimal SO_CreditUsed) {
		if (get_ID() == 0) {
			super.setSO_CreditUsed(SO_CreditUsed);
		}
	}

	/**
	 * Set Credit Status.
	 *
	 * @param SOCreditStatus_RL Business Partner Credit Status
	 */
	public void setSOCreditStatus_RL(I_AD_Ref_ListInput SOCreditStatus_RL) {
		this.SOCreditStatus_RL = SOCreditStatus_RL;
		MRefList foreignEntity;
		if (SOCreditStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SOCreditStatus_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSOCreditStatus(foreignEntity.getValue());
		} else {
			this.setSOCreditStatus(null);
		}
	}

	/**
	 * Get Credit Status.
	 *
	 * @return Business Partner Credit Status
	 */
	public I_AD_Ref_ListInput getSOCreditStatus_RL() {
		return SOCreditStatus_RL;
	}
}
