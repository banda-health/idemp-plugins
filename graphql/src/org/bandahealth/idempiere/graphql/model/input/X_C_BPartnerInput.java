package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BPartnerInput extends MBPartner_BH implements I_C_BPartnerInput {

	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mC_Dunning;
	private ForeignEntityInput mC_Greeting;
	private ForeignEntityInput mC_InvoiceSchedule;
	private ForeignEntityInput mC_PaymentTerm;
	private ForeignEntityInput mC_TaxGroup;
	private ForeignEntityInput mDefault1099Box;
	private ForeignEntityInput mInvoice_PrintFormat;
	private ForeignEntityInput mM_DiscountSchema;
	private ForeignEntityInput mM_PriceList;
	private ForeignEntityInput mPO_DiscountSchema;
	private ForeignEntityInput mPO_PaymentTerm;
	private ForeignEntityInput mPO_PriceList;
	private ForeignEntityInput mSalesRep;
	private I_AD_Ref_ListInput mDeliveryRule;
	private I_AD_Ref_ListInput mDeliveryViaRule;
	private I_AD_Ref_ListInput mFreightCostRule;
	private I_AD_Ref_ListInput mInvoiceRule;
	private I_AD_Ref_ListInput mPaymentRule;
	private I_AD_Ref_ListInput mPaymentRulePO;
	private I_AD_Ref_ListInput mSOCreditStatus;
	private I_AD_Ref_ListInput mbh_gender;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BPartner_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BPartnerInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBPartner_BH(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	@JsonProperty("AD_Language")
	public void setAD_LanguageInput(ForeignEntityInput AD_Language) {
		this.mAD_Language = AD_Language;
		MLanguage foreignEntity;
		if (AD_Language != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
							.setParameters(AD_Language.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Language(foreignEntity.getAD_Language());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Language with UUID " + AD_Language.getUUID());
			}
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
	public ForeignEntityInput AD_Language() {
		return mAD_Language;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
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
		if (bh_gender != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(bh_gender.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setbh_gender(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + bh_gender.getUUID());
			}
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
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		MBPGroup_BH foreignEntity;
		if (C_BP_Group != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
							.setParameters(C_BP_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_Group with UUID " + C_BP_Group.getUUID());
			}
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
	public ForeignEntityInput C_BP_Group() {
		return mC_BP_Group;
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_BPartner_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_BPartner_UU();
	}

	/**
	 * Set Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public void setC_DunningInput(ForeignEntityInput C_Dunning) {
		this.mC_Dunning = C_Dunning;
		MDunning foreignEntity;
		if (C_Dunning != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Dunning", "C_Dunning_UU=?", get_TrxName())
							.setParameters(C_Dunning.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Dunning_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Dunning with UUID " + C_Dunning.getUUID());
			}
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
	public ForeignEntityInput C_Dunning() {
		return mC_Dunning;
	}

	/**
	 * Set Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	@JsonProperty("C_Greeting")
	public void setC_GreetingInput(ForeignEntityInput C_Greeting) {
		this.mC_Greeting = C_Greeting;
		X_C_Greeting foreignEntity;
		if (C_Greeting != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Greeting", "C_Greeting_UU=?", get_TrxName())
							.setParameters(C_Greeting.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Greeting_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Greeting with UUID " + C_Greeting.getUUID());
			}
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
	public ForeignEntityInput C_Greeting() {
		return mC_Greeting;
	}

	/**
	 * Set Invoice Schedule.
	 *
	 * @param C_InvoiceSchedule Schedule for generating Invoices
	 */
	@JsonProperty("C_InvoiceSchedule")
	public void setC_InvoiceScheduleInput(ForeignEntityInput C_InvoiceSchedule) {
		this.mC_InvoiceSchedule = C_InvoiceSchedule;
		MInvoiceSchedule foreignEntity;
		if (C_InvoiceSchedule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceSchedule", "C_InvoiceSchedule_UU=?", get_TrxName())
							.setParameters(C_InvoiceSchedule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_InvoiceSchedule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceSchedule with UUID " + C_InvoiceSchedule.getUUID());
			}
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
	public ForeignEntityInput C_InvoiceSchedule() {
		return mC_InvoiceSchedule;
	}

	/**
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm) {
		this.mC_PaymentTerm = C_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (C_PaymentTerm != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
							.setParameters(C_PaymentTerm.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UUID " + C_PaymentTerm.getUUID());
			}
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
	public ForeignEntityInput C_PaymentTerm() {
		return mC_PaymentTerm;
	}

	/**
	 * Set Tax Group.
	 *
	 * @param C_TaxGroup Tax Group
	 */
	@JsonProperty("C_TaxGroup")
	public void setC_TaxGroupInput(ForeignEntityInput C_TaxGroup) {
		this.mC_TaxGroup = C_TaxGroup;
		X_C_TaxGroup foreignEntity;
		if (C_TaxGroup != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxGroup", "C_TaxGroup_UU=?", get_TrxName())
							.setParameters(C_TaxGroup.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_TaxGroup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxGroup with UUID " + C_TaxGroup.getUUID());
			}
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
	public ForeignEntityInput C_TaxGroup() {
		return mC_TaxGroup;
	}

	/**
	 * Set Default 1099 Box.
	 *
	 * @param Default1099Box Default 1099 Box
	 */
	@JsonProperty("Default1099Box")
	public void setDefault1099BoxInput(ForeignEntityInput Default1099Box) {
		this.mDefault1099Box = Default1099Box;
		X_C_1099Box foreignEntity;
		if (Default1099Box != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_1099Box", "C_1099Box_UU=?", get_TrxName())
							.setParameters(Default1099Box.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDefault1099Box_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_1099Box with UUID " + Default1099Box.getUUID());
			}
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
	public ForeignEntityInput Default1099Box() {
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
		if (DeliveryRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDeliveryRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DeliveryRule.getUUID());
			}
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
		if (DeliveryViaRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryViaRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDeliveryViaRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DeliveryViaRule.getUUID());
			}
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
		if (FreightCostRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FreightCostRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFreightCostRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + FreightCostRule.getUUID());
			}
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
	public void setInvoice_PrintFormatInput(ForeignEntityInput Invoice_PrintFormat) {
		this.mInvoice_PrintFormat = Invoice_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Invoice_PrintFormat != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Invoice_PrintFormat.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setInvoice_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + Invoice_PrintFormat.getUUID());
			}
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
	public ForeignEntityInput Invoice_PrintFormat() {
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
		if (InvoiceRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setInvoiceRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + InvoiceRule.getUUID());
			}
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
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
							.setParameters(AD_Image.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLogo_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UUID " + AD_Image.getUUID());
			}
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
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
	}

	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public void setM_DiscountSchemaInput(ForeignEntityInput M_DiscountSchema) {
		this.mM_DiscountSchema = M_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (M_DiscountSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(M_DiscountSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UUID " + M_DiscountSchema.getUUID());
			}
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
	public ForeignEntityInput M_DiscountSchema() {
		return mM_DiscountSchema;
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public void setM_PriceListInput(ForeignEntityInput M_PriceList) {
		this.mM_PriceList = M_PriceList;
		MPriceList foreignEntity;
		if (M_PriceList != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(M_PriceList.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UUID " + M_PriceList.getUUID());
			}
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
	public ForeignEntityInput M_PriceList() {
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
		if (PaymentRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPaymentRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PaymentRule.getUUID());
			}
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
		if (PaymentRulePO != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentRulePO.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPaymentRulePO(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PaymentRulePO.getUUID());
			}
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
	public void setPO_DiscountSchemaInput(ForeignEntityInput PO_DiscountSchema) {
		this.mPO_DiscountSchema = PO_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (PO_DiscountSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(PO_DiscountSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPO_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UUID " + PO_DiscountSchema.getUUID());
			}
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
	public ForeignEntityInput PO_DiscountSchema() {
		return mPO_DiscountSchema;
	}

	/**
	 * Set PO Payment Term.
	 *
	 * @param PO_PaymentTerm Payment rules for a purchase order
	 */
	@JsonProperty("PO_PaymentTerm")
	public void setPO_PaymentTermInput(ForeignEntityInput PO_PaymentTerm) {
		this.mPO_PaymentTerm = PO_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (PO_PaymentTerm != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
							.setParameters(PO_PaymentTerm.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPO_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UUID " + PO_PaymentTerm.getUUID());
			}
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
	public ForeignEntityInput PO_PaymentTerm() {
		return mPO_PaymentTerm;
	}

	/**
	 * Set Purchase Pricelist.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	@JsonProperty("PO_PriceList")
	public void setPO_PriceListInput(ForeignEntityInput PO_PriceList) {
		this.mPO_PriceList = PO_PriceList;
		MPriceList foreignEntity;
		if (PO_PriceList != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(PO_PriceList.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPO_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UUID " + PO_PriceList.getUUID());
			}
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
	public ForeignEntityInput PO_PriceList() {
		return mPO_PriceList;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
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
	public ForeignEntityInput SalesRep() {
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
		if (SOCreditStatus != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(SOCreditStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSOCreditStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + SOCreditStatus.getUUID());
			}
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
