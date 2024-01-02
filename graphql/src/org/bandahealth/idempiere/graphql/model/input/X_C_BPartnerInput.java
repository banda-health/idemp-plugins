package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_C_1099Box;
import org.compiere.model.X_C_Greeting;
import org.compiere.util.Env;
import org.eevolution.model.X_C_TaxGroup;

/**
 * Generated Model for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BPartnerInput extends MBPartner_BH implements I_C_BPartnerInput {

	 private I_AD_ImageInput mAD_Image;
	 private I_AD_LanguageInput mAD_Language;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_PrintFormatInput mInvoice_PrintFormat;
	 private I_AD_Ref_ListInput mDeliveryRule;
	 private I_AD_Ref_ListInput mDeliveryViaRule;
	 private I_AD_Ref_ListInput mFreightCostRule;
	 private I_AD_Ref_ListInput mInvoiceRule;
	 private I_AD_Ref_ListInput mPaymentRule;
	 private I_AD_Ref_ListInput mPaymentRulePO;
	 private I_AD_Ref_ListInput mSOCreditStatus;
	 private I_AD_Ref_ListInput mbh_gender;
	 private I_AD_UserInput mSalesRep;
	 private I_C_1099BoxInput mDefault1099Box;
	 private I_C_BP_GroupInput mC_BP_Group;
	 private I_C_DunningInput mC_Dunning;
	 private I_C_GreetingInput mC_Greeting;
	 private I_C_InvoiceScheduleInput mC_InvoiceSchedule;
	 private I_C_PaymentTermInput mC_PaymentTerm;
	 private I_C_PaymentTermInput mPO_PaymentTerm;
	 private I_C_TaxGroupInput mC_TaxGroup;
	 private I_M_DiscountSchemaInput mM_DiscountSchema;
	 private I_M_DiscountSchemaInput mPO_DiscountSchema;
	 private I_M_PriceListInput mM_PriceList;
	 private I_M_PriceListInput mPO_PriceList;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BPartnerInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	@JsonProperty("AD_Language")
	public void setAD_LanguageInput(I_AD_LanguageInput AD_Language) {
		this.mAD_Language = AD_Language;
		MLanguage foreignEntity;
		if (AD_Language != null &&
				(foreignEntity = new Query(getCtx(), MLanguage.Table_Name, MLanguage.COLUMNNAME_AD_Language_UU + "=?", get_TrxName())
						.setParameters(AD_Language.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Language(foreignEntity.getAD_Language());
		} else {
			super.setAD_Language(null);
		}
	}

	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	@JsonProperty("AD_Language")
	public I_AD_LanguageInput AD_Language() {
		return mAD_Language;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Gender.
	 *
	 * @param bh_gender Gender
	 */
	@JsonProperty("bh_gender")
	public void setbh_genderInput(I_AD_Ref_ListInput bh_gender) {
		this.mbh_gender = bh_gender;
		MRefList_BH foreignEntity;
		if (bh_gender != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(bh_gender.getID())
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
	@JsonProperty("bh_gender")
	public I_AD_Ref_ListInput bh_gender() {
		return mbh_gender;
	}

	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public void setC_BP_GroupInput(I_C_BP_GroupInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		MBPGroup_BH foreignEntity;
		if (C_BP_Group != null &&
				(foreignEntity = new Query(getCtx(), MBPGroup_BH.Table_Name, MBPGroup_BH.COLUMNNAME_C_BP_Group_UU + "=?", get_TrxName())
						.setParameters(C_BP_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BP_Group_ID(foreignEntity.get_ID());
		} else {
			super.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public I_C_BP_GroupInput C_BP_Group() {
		return mC_BP_Group;
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
	@JsonProperty("C_Dunning")
	public void setC_DunningInput(I_C_DunningInput C_Dunning) {
		this.mC_Dunning = C_Dunning;
		MDunning foreignEntity;
		if (C_Dunning != null &&
				(foreignEntity = new Query(getCtx(), MDunning.Table_Name, MDunning.COLUMNNAME_C_Dunning_UU + "=?", get_TrxName())
						.setParameters(C_Dunning.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Dunning_ID(foreignEntity.get_ID());
		} else {
			super.setC_Dunning_ID(0);
		}
	}

	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public I_C_DunningInput C_Dunning() {
		return mC_Dunning;
	}

	/**
	 * Set Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	@JsonProperty("C_Greeting")
	public void setC_GreetingInput(I_C_GreetingInput C_Greeting) {
		this.mC_Greeting = C_Greeting;
		X_C_Greeting foreignEntity;
		if (C_Greeting != null &&
				(foreignEntity = new Query(getCtx(), X_C_Greeting.Table_Name, X_C_Greeting.COLUMNNAME_C_Greeting_UU + "=?", get_TrxName())
						.setParameters(C_Greeting.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Greeting_ID(foreignEntity.get_ID());
		} else {
			super.setC_Greeting_ID(0);
		}
	}

	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	@JsonProperty("C_Greeting")
	public I_C_GreetingInput C_Greeting() {
		return mC_Greeting;
	}

	/**
	 * Set Invoice Schedule.
	 *
	 * @param C_InvoiceSchedule Schedule for generating Invoices
	 */
	@JsonProperty("C_InvoiceSchedule")
	public void setC_InvoiceScheduleInput(I_C_InvoiceScheduleInput C_InvoiceSchedule) {
		this.mC_InvoiceSchedule = C_InvoiceSchedule;
		MInvoiceSchedule foreignEntity;
		if (C_InvoiceSchedule != null &&
				(foreignEntity = new Query(getCtx(), MInvoiceSchedule.Table_Name, MInvoiceSchedule.COLUMNNAME_C_InvoiceSchedule_UU + "=?", get_TrxName())
						.setParameters(C_InvoiceSchedule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_InvoiceSchedule_ID(foreignEntity.get_ID());
		} else {
			super.setC_InvoiceSchedule_ID(0);
		}
	}

	/**
	 * Get Invoice Schedule.
	 *
	 * @return Schedule for generating Invoices
	 */
	@JsonProperty("C_InvoiceSchedule")
	public I_C_InvoiceScheduleInput C_InvoiceSchedule() {
		return mC_InvoiceSchedule;
	}

	/**
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public void setC_PaymentTermInput(I_C_PaymentTermInput C_PaymentTerm) {
		this.mC_PaymentTerm = C_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (C_PaymentTerm != null &&
				(foreignEntity = new Query(getCtx(), MPaymentTerm.Table_Name, MPaymentTerm.COLUMNNAME_C_PaymentTerm_UU + "=?", get_TrxName())
						.setParameters(C_PaymentTerm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaymentTerm_ID(foreignEntity.get_ID());
		} else {
			super.setC_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public I_C_PaymentTermInput C_PaymentTerm() {
		return mC_PaymentTerm;
	}

	/**
	 * Set Tax Group.
	 *
	 * @param C_TaxGroup Tax Group
	 */
	@JsonProperty("C_TaxGroup")
	public void setC_TaxGroupInput(I_C_TaxGroupInput C_TaxGroup) {
		this.mC_TaxGroup = C_TaxGroup;
		X_C_TaxGroup foreignEntity;
		if (C_TaxGroup != null &&
				(foreignEntity = new Query(getCtx(), X_C_TaxGroup.Table_Name, X_C_TaxGroup.COLUMNNAME_C_TaxGroup_UU + "=?", get_TrxName())
						.setParameters(C_TaxGroup.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_TaxGroup_ID(foreignEntity.get_ID());
		} else {
			super.setC_TaxGroup_ID(0);
		}
	}

	/**
	 * Get Tax Group.
	 *
	 * @return Tax Group
	 */
	@JsonProperty("C_TaxGroup")
	public I_C_TaxGroupInput C_TaxGroup() {
		return mC_TaxGroup;
	}

	/**
	 * Set Default 1099 Box.
	 *
	 * @param Default1099Box Default 1099 Box
	 */
	@JsonProperty("Default1099Box")
	public void setDefault1099BoxInput(I_C_1099BoxInput Default1099Box) {
		this.mDefault1099Box = Default1099Box;
		X_C_1099Box foreignEntity;
		if (Default1099Box != null &&
				(foreignEntity = new Query(getCtx(), X_C_1099Box.Table_Name, X_C_1099Box.COLUMNNAME_C_1099Box_UU + "=?", get_TrxName())
						.setParameters(Default1099Box.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDefault1099Box_ID(foreignEntity.get_ID());
		} else {
			super.setDefault1099Box_ID(0);
		}
	}

	/**
	 * Get Default 1099 Box.
	 *
	 * @return Default 1099 Box
	 */
	@JsonProperty("Default1099Box")
	public I_C_1099BoxInput Default1099Box() {
		return mDefault1099Box;
	}

	/**
	 * Set Delivery Rule.
	 *
	 * @param DeliveryRule Defines the timing of Delivery
	 */
	@JsonProperty("DeliveryRule")
	public void setDeliveryRuleInput(I_AD_Ref_ListInput DeliveryRule) {
		this.mDeliveryRule = DeliveryRule;
		MRefList_BH foreignEntity;
		if (DeliveryRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DeliveryRule.getID())
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
	@JsonProperty("DeliveryRule")
	public I_AD_Ref_ListInput DeliveryRule() {
		return mDeliveryRule;
	}

	/**
	 * Set Delivery Via.
	 *
	 * @param DeliveryViaRule How the order will be delivered
	 */
	@JsonProperty("DeliveryViaRule")
	public void setDeliveryViaRuleInput(I_AD_Ref_ListInput DeliveryViaRule) {
		this.mDeliveryViaRule = DeliveryViaRule;
		MRefList_BH foreignEntity;
		if (DeliveryViaRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DeliveryViaRule.getID())
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
	@JsonProperty("DeliveryViaRule")
	public I_AD_Ref_ListInput DeliveryViaRule() {
		return mDeliveryViaRule;
	}

	/**
	 * Set Freight Cost Rule.
	 *
	 * @param FreightCostRule Method for charging Freight
	 */
	@JsonProperty("FreightCostRule")
	public void setFreightCostRuleInput(I_AD_Ref_ListInput FreightCostRule) {
		this.mFreightCostRule = FreightCostRule;
		MRefList_BH foreignEntity;
		if (FreightCostRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FreightCostRule.getID())
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
	@JsonProperty("FreightCostRule")
	public I_AD_Ref_ListInput FreightCostRule() {
		return mFreightCostRule;
	}

	/**
	 * Set Invoice Print Format.
	 *
	 * @param Invoice_PrintFormat Print Format for printing Invoices
	 */
	@JsonProperty("Invoice_PrintFormat")
	public void setInvoice_PrintFormatInput(I_AD_PrintFormatInput Invoice_PrintFormat) {
		this.mInvoice_PrintFormat = Invoice_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Invoice_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFormat.Table_Name, X_AD_PrintFormat.COLUMNNAME_AD_PrintFormat_UU + "=?", get_TrxName())
						.setParameters(Invoice_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setInvoice_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setInvoice_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Invoice Print Format.
	 *
	 * @return Print Format for printing Invoices
	 */
	@JsonProperty("Invoice_PrintFormat")
	public I_AD_PrintFormatInput Invoice_PrintFormat() {
		return mInvoice_PrintFormat;
	}

	/**
	 * Set Invoice Rule.
	 *
	 * @param InvoiceRule Frequency and method of invoicing 
	 */
	@JsonProperty("InvoiceRule")
	public void setInvoiceRuleInput(I_AD_Ref_ListInput InvoiceRule) {
		this.mInvoiceRule = InvoiceRule;
		MRefList_BH foreignEntity;
		if (InvoiceRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceRule.getID())
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
	@JsonProperty("InvoiceRule")
	public I_AD_Ref_ListInput InvoiceRule() {
		return mInvoiceRule;
	}

	/**
	 * Set Logo.
	 *
	 * @param AD_Image Logo
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(I_AD_ImageInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + "=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setLogo_ID(foreignEntity.get_ID());
		} else {
			super.setLogo_ID(0);
		}
	}

	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	@JsonProperty("AD_Image")
	public I_AD_ImageInput AD_Image() {
		return mAD_Image;
	}

	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public void setM_DiscountSchemaInput(I_M_DiscountSchemaInput M_DiscountSchema) {
		this.mM_DiscountSchema = M_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (M_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(M_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			super.setM_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public I_M_DiscountSchemaInput M_DiscountSchema() {
		return mM_DiscountSchema;
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public void setM_PriceListInput(I_M_PriceListInput M_PriceList) {
		this.mM_PriceList = M_PriceList;
		MPriceList foreignEntity;
		if (M_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(M_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PriceList_ID(foreignEntity.get_ID());
		} else {
			super.setM_PriceList_ID(0);
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public I_M_PriceListInput M_PriceList() {
		return mM_PriceList;
	}

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public void setPaymentRuleInput(I_AD_Ref_ListInput PaymentRule) {
		this.mPaymentRule = PaymentRule;
		MRefList_BH foreignEntity;
		if (PaymentRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentRule.getID())
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
	@JsonProperty("PaymentRule")
	public I_AD_Ref_ListInput PaymentRule() {
		return mPaymentRule;
	}

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRulePO Purchase payment option
	 */
	@JsonProperty("PaymentRulePO")
	public void setPaymentRulePOInput(I_AD_Ref_ListInput PaymentRulePO) {
		this.mPaymentRulePO = PaymentRulePO;
		MRefList_BH foreignEntity;
		if (PaymentRulePO != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentRulePO.getID())
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
	@JsonProperty("PaymentRulePO")
	public I_AD_Ref_ListInput PaymentRulePO() {
		return mPaymentRulePO;
	}

	/**
	 * Set PO Discount Schema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	@JsonProperty("PO_DiscountSchema")
	public void setPO_DiscountSchemaInput(I_M_DiscountSchemaInput PO_DiscountSchema) {
		this.mPO_DiscountSchema = PO_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (PO_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(PO_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPO_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			super.setPO_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get PO Discount Schema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	@JsonProperty("PO_DiscountSchema")
	public I_M_DiscountSchemaInput PO_DiscountSchema() {
		return mPO_DiscountSchema;
	}

	/**
	 * Set PO Payment Term.
	 *
	 * @param PO_PaymentTerm Payment rules for a purchase order
	 */
	@JsonProperty("PO_PaymentTerm")
	public void setPO_PaymentTermInput(I_C_PaymentTermInput PO_PaymentTerm) {
		this.mPO_PaymentTerm = PO_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (PO_PaymentTerm != null &&
				(foreignEntity = new Query(getCtx(), MPaymentTerm.Table_Name, MPaymentTerm.COLUMNNAME_C_PaymentTerm_UU + "=?", get_TrxName())
						.setParameters(PO_PaymentTerm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPO_PaymentTerm_ID(foreignEntity.get_ID());
		} else {
			super.setPO_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get PO Payment Term.
	 *
	 * @return Payment rules for a purchase order
	 */
	@JsonProperty("PO_PaymentTerm")
	public I_C_PaymentTermInput PO_PaymentTerm() {
		return mPO_PaymentTerm;
	}

	/**
	 * Set Purchase Pricelist.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	@JsonProperty("PO_PriceList")
	public void setPO_PriceListInput(I_M_PriceListInput PO_PriceList) {
		this.mPO_PriceList = PO_PriceList;
		MPriceList foreignEntity;
		if (PO_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(PO_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPO_PriceList_ID(foreignEntity.get_ID());
		} else {
			super.setPO_PriceList_ID(0);
		}
	}

	/**
	 * Get Purchase Pricelist.
	 *
	 * @return Price List used by this Business Partner
	 */
	@JsonProperty("PO_PriceList")
	public I_M_PriceListInput PO_PriceList() {
		return mPO_PriceList;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(I_AD_UserInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			super.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public I_AD_UserInput SalesRep() {
		return mSalesRep;
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
	 * @param SOCreditStatus Business Partner Credit Status
	 */
	@JsonProperty("SOCreditStatus")
	public void setSOCreditStatusInput(I_AD_Ref_ListInput SOCreditStatus) {
		this.mSOCreditStatus = SOCreditStatus;
		MRefList_BH foreignEntity;
		if (SOCreditStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SOCreditStatus.getID())
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
	@JsonProperty("SOCreditStatus")
	public I_AD_Ref_ListInput SOCreditStatus() {
		return mSOCreditStatus;
	}
}
