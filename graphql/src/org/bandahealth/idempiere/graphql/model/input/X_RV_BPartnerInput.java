package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.MBPartnerInfo;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCity;
import org.compiere.model.MCountry;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDunning;
import org.compiere.model.MInvoiceSchedule;
import org.compiere.model.MLanguage;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MRegion;
import org.compiere.model.MSalesRegion;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_C_Greeting;
import org.compiere.util.Env;
import org.eevolution.model.X_C_TaxGroup;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for RV_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_RV_BPartnerInput extends MBPartnerInfo implements I_RV_BPartnerInput {

	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAD_User_C_BPartner;
	private ForeignEntityInput mAD_User_C_BPartner_Location;
	private ForeignEntityInput mAD_User_Create;
	private ForeignEntityInput mAD_User_Update;
	private ForeignEntityInput mBPContactGreet;
	private ForeignEntityInput mBPartner_Parent;
	private ForeignEntityInput mC_BP_C_TaxGroup;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mC_BP_Location_C_BPartner;
	private ForeignEntityInput mC_BP_Location_C_Location;
	private ForeignEntityInput mC_BP_Location_Create;
	private ForeignEntityInput mC_BP_Location_SalesRegion;
	private ForeignEntityInput mC_BP_Location_Update;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_City;
	private ForeignEntityInput mC_Country;
	private ForeignEntityInput mC_Country_C_Currency;
	private ForeignEntityInput mC_Dunning;
	private ForeignEntityInput mC_Greeting;
	private ForeignEntityInput mC_InvoiceSchedule;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mC_Location_Create;
	private ForeignEntityInput mC_Location_Update;
	private ForeignEntityInput mC_PaymentTerm;
	private ForeignEntityInput mC_Region;
	private ForeignEntityInput mInvoice_PrintFormat;
	private ForeignEntityInput mM_DiscountSchema;
	private ForeignEntityInput mM_PriceList;
	private ForeignEntityInput mPO_DiscountSchema;
	private ForeignEntityInput mPO_PaymentTerm;
	private ForeignEntityInput mPO_PriceList;
	private ForeignEntityInput mSalesRep;
	private ForeignEntityInput mSupervisor;
	private I_AD_Ref_ListInput mDeliveryRule;
	private I_AD_Ref_ListInput mDeliveryViaRule;
	private I_AD_Ref_ListInput mFreightCostRule;
	private I_AD_Ref_ListInput mInvoiceRule;
	private I_AD_Ref_ListInput mNotificationType;
	private I_AD_Ref_ListInput mPaymentRule;
	private I_AD_Ref_ListInput mPaymentRulePO;
	private I_AD_Ref_ListInput mSOCreditStatus;

	/**
	 * Standard constructor
	 */
	public X_RV_BPartnerInput() {
		super(Env.getCtx(), (ResultSet) null, null);
	}
	/**
	 * Set Acquisition Cost.
	 *
	 * @param AcqusitionCost The cost of gaining the prospect as a customer
	 */

	public void setAcqusitionCost(BigDecimal AcqusitionCost) {
		if (get_ID() == 0) {
			super.setAcqusitionCost(AcqusitionCost);
		}
	}
	/**
	 * Set Actual Life Time Value.
	 *
	 * @param ActualLifeTimeValue Actual Life Time Revenue
	 */

	public void setActualLifeTimeValue(BigDecimal ActualLifeTimeValue) {
		if (get_ID() == 0) {
			super.setActualLifeTimeValue(ActualLifeTimeValue);
		}
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
		if (get_ID() == 0 && AD_Language != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
							.setParameters(AD_Language.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Language(foreignEntity.getAD_Language());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Language with UUID " + AD_Language.getUUID());
			}
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
	 * Set AD_User_C_BPartner_ID.
	 *
	 * @param AD_User_C_BPartner AD_User_C_BPartner_ID
	 */
	@JsonProperty("AD_User_C_BPartner")
	public void setAD_User_C_BPartnerInput(ForeignEntityInput AD_User_C_BPartner) {
		this.mAD_User_C_BPartner = AD_User_C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 && AD_User_C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(AD_User_C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_C_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + AD_User_C_BPartner.getUUID());
			}
		}
	}

	/**
	 * Get AD_User_C_BPartner_ID.
	 *
	 * @return AD_User_C_BPartner_ID
	 */
	@JsonProperty("AD_User_C_BPartner")
	public ForeignEntityInput AD_User_C_BPartner() {
		return mAD_User_C_BPartner;
	}

	/**
	 * Set AD_User_C_BPartner_Location_ID.
	 *
	 * @param AD_User_C_BPartner_Location AD_User_C_BPartner_Location_ID
	 */
	@JsonProperty("AD_User_C_BPartner_Location")
	public void setAD_User_C_BPartner_LocationInput(ForeignEntityInput AD_User_C_BPartner_Location) {
		this.mAD_User_C_BPartner_Location = AD_User_C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (get_ID() == 0 && AD_User_C_BPartner_Location != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(AD_User_C_BPartner_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_C_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + AD_User_C_BPartner_Location.getUUID());
			}
		}
	}

	/**
	 * Get AD_User_C_BPartner_Location_ID.
	 *
	 * @return AD_User_C_BPartner_Location_ID
	 */
	@JsonProperty("AD_User_C_BPartner_Location")
	public ForeignEntityInput AD_User_C_BPartner_Location() {
		return mAD_User_C_BPartner_Location;
	}
	/**
	 * Set ad_user_created.
	 *
	 * @param ad_user_created ad_user_created
	 */

	public void setad_user_created(Timestamp ad_user_created) {
		if (get_ID() == 0) {
			super.setad_user_created(ad_user_created);
		}
	}

	/**
	 * Set ad_user_createdby.
	 *
	 * @param AD_User_Create ad_user_createdby
	 */
	@JsonProperty("AD_User_Create")
	public void setAD_User_CreateInput(ForeignEntityInput AD_User_Create) {
		this.mAD_User_Create = AD_User_Create;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && AD_User_Create != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User_Create.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_CreatedBy(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User_Create.getUUID());
			}
		}
	}

	/**
	 * Get ad_user_createdby.
	 *
	 * @return ad_user_createdby
	 */
	@JsonProperty("AD_User_Create")
	public ForeignEntityInput AD_User_Create() {
		return mAD_User_Create;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
	/**
	 * Set ad_user_isactive.
	 *
	 * @param ad_user_isactive ad_user_isactive
	 */

	public void setad_user_isactive(boolean ad_user_isactive) {
		if (get_ID() == 0) {
			super.setad_user_isactive(ad_user_isactive);
		}
	}
	/**
	 * Set ad_user_updated.
	 *
	 * @param ad_user_updated ad_user_updated
	 */

	public void setad_user_updated(Timestamp ad_user_updated) {
		if (get_ID() == 0) {
			super.setad_user_updated(ad_user_updated);
		}
	}

	/**
	 * Set ad_user_updatedby.
	 *
	 * @param AD_User_Update ad_user_updatedby
	 */
	@JsonProperty("AD_User_Update")
	public void setAD_User_UpdateInput(ForeignEntityInput AD_User_Update) {
		this.mAD_User_Update = AD_User_Update;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && AD_User_Update != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User_Update.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_UpdatedBy(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User_Update.getUUID());
			}
		}
	}

	/**
	 * Get ad_user_updatedby.
	 *
	 * @return ad_user_updatedby
	 */
	@JsonProperty("AD_User_Update")
	public ForeignEntityInput AD_User_Update() {
		return mAD_User_Update;
	}
	/**
	 * Set ad_user_value.
	 *
	 * @param ad_user_value ad_user_value
	 */

	public void setad_user_value(String ad_user_value) {
		if (get_ID() == 0) {
			super.setad_user_value(ad_user_value);
		}
	}
	/**
	 * Set Address 1.
	 *
	 * @param Address1 Address line 1 for this location
	 */

	public void setAddress1(String Address1) {
		if (get_ID() == 0) {
			super.setAddress1(Address1);
		}
	}
	/**
	 * Set Address 2.
	 *
	 * @param Address2 Address line 2 for this location
	 */

	public void setAddress2(String Address2) {
		if (get_ID() == 0) {
			super.setAddress2(Address2);
		}
	}
	/**
	 * Set Address 3.
	 *
	 * @param Address3 Address Line 3 for the location
	 */

	public void setAddress3(String Address3) {
		if (get_ID() == 0) {
			super.setAddress3(Address3);
		}
	}
	/**
	 * Set Address 4.
	 *
	 * @param Address4 Address Line 4 for the location
	 */

	public void setAddress4(String Address4) {
		if (get_ID() == 0) {
			super.setAddress4(Address4);
		}
	}
	/**
	 * Set Birthday.
	 *
	 * @param Birthday Birthday or Anniversary day
	 */

	public void setBirthday(Timestamp Birthday) {
		if (get_ID() == 0) {
			super.setBirthday(Birthday);
		}
	}

	/**
	 * Set Partner Parent.
	 *
	 * @param BPartner_Parent Business Partner Parent
	 */
	@JsonProperty("BPartner_Parent")
	public void setBPartner_ParentInput(ForeignEntityInput BPartner_Parent) {
		this.mBPartner_Parent = BPartner_Parent;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 && BPartner_Parent != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(BPartner_Parent.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBPartner_Parent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + BPartner_Parent.getUUID());
			}
		}
	}

	/**
	 * Get Partner Parent.
	 *
	 * @return Business Partner Parent
	 */
	@JsonProperty("BPartner_Parent")
	public ForeignEntityInput BPartner_Parent() {
		return mBPartner_Parent;
	}

	/**
	 * Set BP Contact Greeting.
	 *
	 * @param BPContactGreet Greeting for Business Partner Contact
	 */
	@JsonProperty("BPContactGreet")
	public void setBPContactGreetInput(ForeignEntityInput BPContactGreet) {
		this.mBPContactGreet = BPContactGreet;
		X_C_Greeting foreignEntity;
		if (get_ID() == 0 && BPContactGreet != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Greeting", "C_Greeting_UU=?", get_TrxName())
							.setParameters(BPContactGreet.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBPContactGreeting(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Greeting with UUID " + BPContactGreet.getUUID());
			}
		}
	}

	/**
	 * Get BP Contact Greeting.
	 *
	 * @return Greeting for Business Partner Contact
	 */
	@JsonProperty("BPContactGreet")
	public ForeignEntityInput BPContactGreet() {
		return mBPContactGreet;
	}

	/**
	 * Set c_bp_c_taxgroup_id.
	 *
	 * @param C_BP_C_TaxGroup c_bp_c_taxgroup_id
	 */
	@JsonProperty("C_BP_C_TaxGroup")
	public void setC_BP_C_TaxGroupInput(ForeignEntityInput C_BP_C_TaxGroup) {
		this.mC_BP_C_TaxGroup = C_BP_C_TaxGroup;
		X_C_TaxGroup foreignEntity;
		if (get_ID() == 0 && C_BP_C_TaxGroup != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxGroup", "C_TaxGroup_UU=?", get_TrxName())
							.setParameters(C_BP_C_TaxGroup.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_C_TaxGroup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxGroup with UUID " + C_BP_C_TaxGroup.getUUID());
			}
		}
	}

	/**
	 * Get c_bp_c_taxgroup_id.
	 *
	 * @return c_bp_c_taxgroup_id
	 */
	@JsonProperty("C_BP_C_TaxGroup")
	public ForeignEntityInput C_BP_C_TaxGroup() {
		return mC_BP_C_TaxGroup;
	}
	/**
	 * Set c_bp_dunninggrace.
	 *
	 * @param c_bp_dunninggrace c_bp_dunninggrace
	 */

	public void setc_bp_dunninggrace(Timestamp c_bp_dunninggrace) {
		if (get_ID() == 0) {
			super.setc_bp_dunninggrace(c_bp_dunninggrace);
		}
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
		if (get_ID() == 0 && C_BP_Group != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
							.setParameters(C_BP_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_Group with UUID " + C_BP_Group.getUUID());
			}
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
	 * Set c_bp_ismanufacturer.
	 *
	 * @param c_bp_ismanufacturer c_bp_ismanufacturer
	 */

	public void setc_bp_ismanufacturer(boolean c_bp_ismanufacturer) {
		if (get_ID() == 0) {
			super.setc_bp_ismanufacturer(c_bp_ismanufacturer);
		}
	}
	/**
	 * Set c_bp_ispotaxexempt.
	 *
	 * @param c_bp_ispotaxexempt c_bp_ispotaxexempt
	 */

	public void setc_bp_ispotaxexempt(boolean c_bp_ispotaxexempt) {
		if (get_ID() == 0) {
			super.setc_bp_ispotaxexempt(c_bp_ispotaxexempt);
		}
	}

	/**
	 * Set c_bpartner_location_c_bpartner_id.
	 *
	 * @param C_BP_Location_C_BPartner c_bpartner_location_c_bpartner_id
	 */
	@JsonProperty("C_BP_Location_C_BPartner")
	public void setC_BP_Location_C_BPartnerInput(ForeignEntityInput C_BP_Location_C_BPartner) {
		this.mC_BP_Location_C_BPartner = C_BP_Location_C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 && C_BP_Location_C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BP_Location_C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Location_C_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BP_Location_C_BPartner.getUUID());
			}
		}
	}

	/**
	 * Get c_bpartner_location_c_bpartner_id.
	 *
	 * @return c_bpartner_location_c_bpartner_id
	 */
	@JsonProperty("C_BP_Location_C_BPartner")
	public ForeignEntityInput C_BP_Location_C_BPartner() {
		return mC_BP_Location_C_BPartner;
	}

	/**
	 * Set c_bp_location_c_location_id.
	 *
	 * @param C_BP_Location_C_Location c_bp_location_c_location_id
	 */
	@JsonProperty("C_BP_Location_C_Location")
	public void setC_BP_Location_C_LocationInput(ForeignEntityInput C_BP_Location_C_Location) {
		this.mC_BP_Location_C_Location = C_BP_Location_C_Location;
		MLocation foreignEntity;
		if (get_ID() == 0 && C_BP_Location_C_Location != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_BP_Location_C_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Location_C_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UUID " + C_BP_Location_C_Location.getUUID());
			}
		}
	}

	/**
	 * Get c_bp_location_c_location_id.
	 *
	 * @return c_bp_location_c_location_id
	 */
	@JsonProperty("C_BP_Location_C_Location")
	public ForeignEntityInput C_BP_Location_C_Location() {
		return mC_BP_Location_C_Location;
	}
	/**
	 * Set c_bp_location_created.
	 *
	 * @param c_bp_location_created c_bp_location_created
	 */

	public void setc_bp_location_created(Timestamp c_bp_location_created) {
		if (get_ID() == 0) {
			super.setc_bp_location_created(c_bp_location_created);
		}
	}

	/**
	 * Set c_bp_location_createdby.
	 *
	 * @param C_BP_Location_Create c_bp_location_createdby
	 */
	@JsonProperty("C_BP_Location_Create")
	public void setC_BP_Location_CreateInput(ForeignEntityInput C_BP_Location_Create) {
		this.mC_BP_Location_Create = C_BP_Location_Create;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && C_BP_Location_Create != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(C_BP_Location_Create.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Location_CreatedBy(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + C_BP_Location_Create.getUUID());
			}
		}
	}

	/**
	 * Get c_bp_location_createdby.
	 *
	 * @return c_bp_location_createdby
	 */
	@JsonProperty("C_BP_Location_Create")
	public ForeignEntityInput C_BP_Location_Create() {
		return mC_BP_Location_Create;
	}
	/**
	 * Set c_bp_location_fax.
	 *
	 * @param c_bp_location_fax c_bp_location_fax
	 */

	public void setc_bp_location_fax(String c_bp_location_fax) {
		if (get_ID() == 0) {
			super.setc_bp_location_fax(c_bp_location_fax);
		}
	}
	/**
	 * Set c_bp_location_isactive.
	 *
	 * @param c_bp_location_isactive c_bp_location_isactive
	 */

	public void setc_bp_location_isactive(boolean c_bp_location_isactive) {
		if (get_ID() == 0) {
			super.setc_bp_location_isactive(c_bp_location_isactive);
		}
	}
	/**
	 * Set c_bp_location_isbillto.
	 *
	 * @param c_bp_location_isbillto c_bp_location_isbillto
	 */

	public void setc_bp_location_isbillto(boolean c_bp_location_isbillto) {
		if (get_ID() == 0) {
			super.setc_bp_location_isbillto(c_bp_location_isbillto);
		}
	}
	/**
	 * Set c_bp_location_isdn.
	 *
	 * @param c_bp_location_isdn c_bp_location_isdn
	 */

	public void setc_bp_location_isdn(String c_bp_location_isdn) {
		if (get_ID() == 0) {
			super.setc_bp_location_isdn(c_bp_location_isdn);
		}
	}
	/**
	 * Set c_bp_location_ispayfrom.
	 *
	 * @param c_bp_location_ispayfrom c_bp_location_ispayfrom
	 */

	public void setc_bp_location_ispayfrom(boolean c_bp_location_ispayfrom) {
		if (get_ID() == 0) {
			super.setc_bp_location_ispayfrom(c_bp_location_ispayfrom);
		}
	}
	/**
	 * Set c_bp_location_isremitto.
	 *
	 * @param c_bp_location_isremitto c_bp_location_isremitto
	 */

	public void setc_bp_location_isremitto(boolean c_bp_location_isremitto) {
		if (get_ID() == 0) {
			super.setc_bp_location_isremitto(c_bp_location_isremitto);
		}
	}
	/**
	 * Set c_bp_location_isshipto.
	 *
	 * @param c_bp_location_isshipto c_bp_location_isshipto
	 */

	public void setc_bp_location_isshipto(boolean c_bp_location_isshipto) {
		if (get_ID() == 0) {
			super.setc_bp_location_isshipto(c_bp_location_isshipto);
		}
	}
	/**
	 * Set c_bp_location_name.
	 *
	 * @param c_bp_location_name c_bp_location_name
	 */

	public void setc_bp_location_name(String c_bp_location_name) {
		if (get_ID() == 0) {
			super.setc_bp_location_name(c_bp_location_name);
		}
	}
	/**
	 * Set c_bp_location_phone.
	 *
	 * @param c_bp_location_phone c_bp_location_phone
	 */

	public void setc_bp_location_phone(String c_bp_location_phone) {
		if (get_ID() == 0) {
			super.setc_bp_location_phone(c_bp_location_phone);
		}
	}
	/**
	 * Set c_bp_location_phone2.
	 *
	 * @param c_bp_location_phone2 c_bp_location_phone2
	 */

	public void setc_bp_location_phone2(String c_bp_location_phone2) {
		if (get_ID() == 0) {
			super.setc_bp_location_phone2(c_bp_location_phone2);
		}
	}

	/**
	 * Set c_bp_location_salesregion_id.
	 *
	 * @param C_BP_Location_SalesRegion c_bp_location_salesregion_id
	 */
	@JsonProperty("C_BP_Location_SalesRegion")
	public void setC_BP_Location_SalesRegionInput(ForeignEntityInput C_BP_Location_SalesRegion) {
		this.mC_BP_Location_SalesRegion = C_BP_Location_SalesRegion;
		MSalesRegion foreignEntity;
		if (get_ID() == 0 && C_BP_Location_SalesRegion != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_SalesRegion", "C_SalesRegion_UU=?", get_TrxName())
							.setParameters(C_BP_Location_SalesRegion.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Location_SalesRegion_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_SalesRegion with UUID " + C_BP_Location_SalesRegion.getUUID());
			}
		}
	}

	/**
	 * Get c_bp_location_salesregion_id.
	 *
	 * @return c_bp_location_salesregion_id
	 */
	@JsonProperty("C_BP_Location_SalesRegion")
	public ForeignEntityInput C_BP_Location_SalesRegion() {
		return mC_BP_Location_SalesRegion;
	}
	/**
	 * Set c_bp_location_updated.
	 *
	 * @param c_bp_location_updated c_bp_location_updated
	 */

	public void setc_bp_location_updated(Timestamp c_bp_location_updated) {
		if (get_ID() == 0) {
			super.setc_bp_location_updated(c_bp_location_updated);
		}
	}

	/**
	 * Set c_bp_location_updatedby.
	 *
	 * @param C_BP_Location_Update c_bp_location_updatedby
	 */
	@JsonProperty("C_BP_Location_Update")
	public void setC_BP_Location_UpdateInput(ForeignEntityInput C_BP_Location_Update) {
		this.mC_BP_Location_Update = C_BP_Location_Update;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && C_BP_Location_Update != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(C_BP_Location_Update.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Location_UpdatedBy(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + C_BP_Location_Update.getUUID());
			}
		}
	}

	/**
	 * Get c_bp_location_updatedby.
	 *
	 * @return c_bp_location_updatedby
	 */
	@JsonProperty("C_BP_Location_Update")
	public ForeignEntityInput C_BP_Location_Update() {
		return mC_BP_Location_Update;
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
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (get_ID() == 0 && C_BPartner_Location != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(C_BPartner_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + C_BPartner_Location.getUUID());
			}
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public ForeignEntityInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set City.
	 *
	 * @param C_City City
	 */
	@JsonProperty("C_City")
	public void setC_CityInput(ForeignEntityInput C_City) {
		this.mC_City = C_City;
		MCity foreignEntity;
		if (get_ID() == 0 && C_City != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_City", "C_City_UU=?", get_TrxName())
							.setParameters(C_City.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_City_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_City with UUID " + C_City.getUUID());
			}
		}
	}

	/**
	 * Get City.
	 *
	 * @return City
	 */
	@JsonProperty("C_City")
	public ForeignEntityInput C_City() {
		return mC_City;
	}
	/**
	 * Set c_country_ad_language.
	 *
	 * @param c_country_ad_language c_country_ad_language
	 */

	public void setc_country_ad_language(String c_country_ad_language) {
		if (get_ID() == 0) {
			super.setc_country_ad_language(c_country_ad_language);
		}
	}

	/**
	 * Set c_country_c_currency_id.
	 *
	 * @param C_Country_C_Currency c_country_c_currency_id
	 */
	@JsonProperty("C_Country_C_Currency")
	public void setC_Country_C_CurrencyInput(ForeignEntityInput C_Country_C_Currency) {
		this.mC_Country_C_Currency = C_Country_C_Currency;
		MCurrency_BH foreignEntity;
		if (get_ID() == 0 && C_Country_C_Currency != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Country_C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Country_C_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Country_C_Currency.getUUID());
			}
		}
	}

	/**
	 * Get c_country_c_currency_id.
	 *
	 * @return c_country_c_currency_id
	 */
	@JsonProperty("C_Country_C_Currency")
	public ForeignEntityInput C_Country_C_Currency() {
		return mC_Country_C_Currency;
	}
	/**
	 * Set c_country_description.
	 *
	 * @param c_country_description c_country_description
	 */

	public void setc_country_description(String c_country_description) {
		if (get_ID() == 0) {
			super.setc_country_description(c_country_description);
		}
	}

	/**
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	@JsonProperty("C_Country")
	public void setC_CountryInput(ForeignEntityInput C_Country) {
		this.mC_Country = C_Country;
		MCountry foreignEntity;
		if (get_ID() == 0 && C_Country != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Country", "C_Country_UU=?", get_TrxName())
							.setParameters(C_Country.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Country_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Country with UUID " + C_Country.getUUID());
			}
		}
	}

	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	@JsonProperty("C_Country")
	public ForeignEntityInput C_Country() {
		return mC_Country;
	}
	/**
	 * Set c_country_isactive.
	 *
	 * @param c_country_isactive c_country_isactive
	 */

	public void setc_country_isactive(boolean c_country_isactive) {
		if (get_ID() == 0) {
			super.setc_country_isactive(c_country_isactive);
		}
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
		if (get_ID() == 0 && C_Dunning != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Dunning", "C_Dunning_UU=?", get_TrxName())
							.setParameters(C_Dunning.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Dunning_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Dunning with UUID " + C_Dunning.getUUID());
			}
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
		if (get_ID() == 0 && C_Greeting != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Greeting", "C_Greeting_UU=?", get_TrxName())
							.setParameters(C_Greeting.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Greeting_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Greeting with UUID " + C_Greeting.getUUID());
			}
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
		if (get_ID() == 0 && C_InvoiceSchedule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceSchedule", "C_InvoiceSchedule_UU=?", get_TrxName())
							.setParameters(C_InvoiceSchedule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_InvoiceSchedule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceSchedule with UUID " + C_InvoiceSchedule.getUUID());
			}
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
	 * Set c_location_created.
	 *
	 * @param c_location_created c_location_created
	 */

	public void setc_location_created(Timestamp c_location_created) {
		if (get_ID() == 0) {
			super.setc_location_created(c_location_created);
		}
	}

	/**
	 * Set c_location_createdby.
	 *
	 * @param C_Location_Create c_location_createdby
	 */
	@JsonProperty("C_Location_Create")
	public void setC_Location_CreateInput(ForeignEntityInput C_Location_Create) {
		this.mC_Location_Create = C_Location_Create;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && C_Location_Create != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(C_Location_Create.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Location_CreatedBy(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + C_Location_Create.getUUID());
			}
		}
	}

	/**
	 * Get c_location_createdby.
	 *
	 * @return c_location_createdby
	 */
	@JsonProperty("C_Location_Create")
	public ForeignEntityInput C_Location_Create() {
		return mC_Location_Create;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(ForeignEntityInput C_Location) {
		this.mC_Location = C_Location;
		MLocation foreignEntity;
		if (get_ID() == 0 && C_Location != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UUID " + C_Location.getUUID());
			}
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	@JsonProperty("C_Location")
	public ForeignEntityInput C_Location() {
		return mC_Location;
	}
	/**
	 * Set c_location_isactive.
	 *
	 * @param c_location_isactive c_location_isactive
	 */

	public void setc_location_isactive(boolean c_location_isactive) {
		if (get_ID() == 0) {
			super.setc_location_isactive(c_location_isactive);
		}
	}
	/**
	 * Set c_location_updated.
	 *
	 * @param c_location_updated c_location_updated
	 */

	public void setc_location_updated(Timestamp c_location_updated) {
		if (get_ID() == 0) {
			super.setc_location_updated(c_location_updated);
		}
	}

	/**
	 * Set c_location_updatedby.
	 *
	 * @param C_Location_Update c_location_updatedby
	 */
	@JsonProperty("C_Location_Update")
	public void setC_Location_UpdateInput(ForeignEntityInput C_Location_Update) {
		this.mC_Location_Update = C_Location_Update;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && C_Location_Update != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(C_Location_Update.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Location_UpdatedBy(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + C_Location_Update.getUUID());
			}
		}
	}

	/**
	 * Get c_location_updatedby.
	 *
	 * @return c_location_updatedby
	 */
	@JsonProperty("C_Location_Update")
	public ForeignEntityInput C_Location_Update() {
		return mC_Location_Update;
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
		if (get_ID() == 0 && C_PaymentTerm != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
							.setParameters(C_PaymentTerm.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UUID " + C_PaymentTerm.getUUID());
			}
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
	 * Set c_region_description.
	 *
	 * @param c_region_description c_region_description
	 */

	public void setc_region_description(String c_region_description) {
		if (get_ID() == 0) {
			super.setc_region_description(c_region_description);
		}
	}

	/**
	 * Set Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public void setC_RegionInput(ForeignEntityInput C_Region) {
		this.mC_Region = C_Region;
		MRegion foreignEntity;
		if (get_ID() == 0 && C_Region != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Region", "C_Region_UU=?", get_TrxName())
							.setParameters(C_Region.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UUID " + C_Region.getUUID());
			}
		}
	}

	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public ForeignEntityInput C_Region() {
		return mC_Region;
	}
	/**
	 * Set c_region_isactive.
	 *
	 * @param c_region_isactive c_region_isactive
	 */

	public void setc_region_isactive(boolean c_region_isactive) {
		if (get_ID() == 0) {
			super.setc_region_isactive(c_region_isactive);
		}
	}
	/**
	 * Set City.
	 *
	 * @param City Identifies a City
	 */

	public void setCity(String City) {
		if (get_ID() == 0) {
			super.setCity(City);
		}
	}
	/**
	 * Set Comments.
	 *
	 * @param Comments Comments or additional information
	 */

	public void setComments(String Comments) {
		if (get_ID() == 0) {
			super.setComments(Comments);
		}
	}
	/**
	 * Set Contact Description.
	 *
	 * @param ContactDescription Description of Contact
	 */

	public void setContactDescription(String ContactDescription) {
		if (get_ID() == 0) {
			super.setContactDescription(ContactDescription);
		}
	}
	/**
	 * Set Contact Name.
	 *
	 * @param ContactName Business Partner Contact Name
	 */

	public void setContactName(String ContactName) {
		if (get_ID() == 0) {
			super.setContactName(ContactName);
		}
	}
	/**
	 * Set ISO Country Code.
	 *
	 * @param CountryCode Upper-case two-letter alphanumeric ISO Country code according to ISO 3166-1 - http://www.chemie.fu-berlin.de/diverse/doc/ISO_3166.html
	 */

	public void setCountryCode(String CountryCode) {
		if (get_ID() == 0) {
			super.setCountryCode(CountryCode);
		}
	}
	/**
	 * Set Country.
	 *
	 * @param CountryName Country Name
	 */

	public void setCountryName(String CountryName) {
		if (get_ID() == 0) {
			super.setCountryName(CountryName);
		}
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
		if (get_ID() == 0 &&DeliveryRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDeliveryRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DeliveryRule.getUUID());
			}
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
		if (get_ID() == 0 &&DeliveryViaRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryViaRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDeliveryViaRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DeliveryViaRule.getUUID());
			}
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
	 * Set Description.
	 *
	 * @param Description Optional short description of the record
	 */

	public void setDescription(String Description) {
		if (get_ID() == 0) {
			super.setDescription(Description);
		}
	}
	/**
	 * Set Document Copies.
	 *
	 * @param DocumentCopies Number of copies to be printed
	 */

	public void setDocumentCopies(int DocumentCopies) {
		if (get_ID() == 0) {
			super.setDocumentCopies(DocumentCopies);
		}
	}
	/**
	 * Set D-U-N-S.
	 *
	 * @param DUNS Dun & Bradstreet Number
	 */

	public void setDUNS(String DUNS) {
		if (get_ID() == 0) {
			super.setDUNS(DUNS);
		}
	}
	/**
	 * Set EMail Address.
	 *
	 * @param EMail Electronic Mail Address
	 */

	public void setEMail(String EMail) {
		if (get_ID() == 0) {
			super.setEMail(EMail);
		}
	}
	/**
	 * Set EMail User ID.
	 *
	 * @param EMailUser User Name (ID) in the Mail System
	 */

	public void setEMailUser(String EMailUser) {
		if (get_ID() == 0) {
			super.setEMailUser(EMailUser);
		}
	}
	/**
	 * Set Verification Info.
	 *
	 * @param EMailVerify Verification information of EMail Address
	 */

	public void setEMailVerify(String EMailVerify) {
		if (get_ID() == 0) {
			super.setEMailVerify(EMailVerify);
		}
	}
	/**
	 * Set EMail Verify.
	 *
	 * @param EMailVerifyDate Date Email was verified
	 */

	public void setEMailVerifyDate(Timestamp EMailVerifyDate) {
		if (get_ID() == 0) {
			super.setEMailVerifyDate(EMailVerifyDate);
		}
	}
	/**
	 * Set Fax.
	 *
	 * @param Fax Facsimile number
	 */

	public void setFax(String Fax) {
		if (get_ID() == 0) {
			super.setFax(Fax);
		}
	}
	/**
	 * Set First Sale.
	 *
	 * @param FirstSale Date of First Sale
	 */

	public void setFirstSale(Timestamp FirstSale) {
		if (get_ID() == 0) {
			super.setFirstSale(FirstSale);
		}
	}
	/**
	 * Set Flat Discount %.
	 *
	 * @param FlatDiscount Flat discount percentage 
	 */

	public void setFlatDiscount(BigDecimal FlatDiscount) {
		if (get_ID() == 0) {
			super.setFlatDiscount(FlatDiscount);
		}
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
		if (get_ID() == 0 &&FreightCostRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FreightCostRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFreightCostRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + FreightCostRule.getUUID());
			}
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
		if (get_ID() == 0 && Invoice_PrintFormat != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Invoice_PrintFormat.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setInvoice_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + Invoice_PrintFormat.getUUID());
			}
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
		if (get_ID() == 0 &&InvoiceRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setInvoiceRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + InvoiceRule.getUUID());
			}
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
	 * Set Customer.
	 *
	 * @param IsCustomer Indicates if this Business Partner is a Customer
	 */

	public void setIsCustomer(boolean IsCustomer) {
		if (get_ID() == 0) {
			super.setIsCustomer(IsCustomer);
		}
	}
	/**
	 * Set Default.
	 *
	 * @param IsDefault Default value
	 */

	public void setIsDefault(boolean IsDefault) {
		if (get_ID() == 0) {
			super.setIsDefault(IsDefault);
		}
	}
	/**
	 * Set Discount Printed.
	 *
	 * @param IsDiscountPrinted Print Discount on Invoice and Order
	 */

	public void setIsDiscountPrinted(boolean IsDiscountPrinted) {
		if (get_ID() == 0) {
			super.setIsDiscountPrinted(IsDiscountPrinted);
		}
	}
	/**
	 * Set Employee.
	 *
	 * @param IsEmployee Indicates if  this Business Partner is an employee
	 */

	public void setIsEmployee(boolean IsEmployee) {
		if (get_ID() == 0) {
			super.setIsEmployee(IsEmployee);
		}
	}
	/**
	 * Set One time transaction.
	 *
	 * @param IsOneTime One time transaction
	 */

	public void setIsOneTime(boolean IsOneTime) {
		if (get_ID() == 0) {
			super.setIsOneTime(IsOneTime);
		}
	}
	/**
	 * Set Prospect.
	 *
	 * @param IsProspect Indicates this is a Prospect
	 */

	public void setIsProspect(boolean IsProspect) {
		if (get_ID() == 0) {
			super.setIsProspect(IsProspect);
		}
	}
	/**
	 * Set Sales Representative.
	 *
	 * @param IsSalesRep Indicates if  the business partner is a sales representative or company agent
	 */

	public void setIsSalesRep(boolean IsSalesRep) {
		if (get_ID() == 0) {
			super.setIsSalesRep(IsSalesRep);
		}
	}
	/**
	 * Set Summary Level.
	 *
	 * @param IsSummary This is a summary entity
	 */

	public void setIsSummary(boolean IsSummary) {
		if (get_ID() == 0) {
			super.setIsSummary(IsSummary);
		}
	}
	/**
	 * Set SO Tax exempt.
	 *
	 * @param IsTaxExempt Business partner is exempt from tax on sales
	 */

	public void setIsTaxExempt(boolean IsTaxExempt) {
		if (get_ID() == 0) {
			super.setIsTaxExempt(IsTaxExempt);
		}
	}
	/**
	 * Set Vendor.
	 *
	 * @param IsVendor Indicates if this Business Partner is a Vendor
	 */

	public void setIsVendor(boolean IsVendor) {
		if (get_ID() == 0) {
			super.setIsVendor(IsVendor);
		}
	}
	/**
	 * Set Last Contact.
	 *
	 * @param LastContact Date this individual was last contacted
	 */

	public void setLastContact(Timestamp LastContact) {
		if (get_ID() == 0) {
			super.setLastContact(LastContact);
		}
	}
	/**
	 * Set Last Result.
	 *
	 * @param LastResult Result of last contact
	 */

	public void setLastResult(String LastResult) {
		if (get_ID() == 0) {
			super.setLastResult(LastResult);
		}
	}
	/**
	 * Set LDAP User Name.
	 *
	 * @param LDAPUser User Name used for authorization via LDAP (directory) services
	 */

	public void setLDAPUser(boolean LDAPUser) {
		if (get_ID() == 0) {
			super.setLDAPUser(LDAPUser);
		}
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
		if (get_ID() == 0 && M_DiscountSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(M_DiscountSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UUID " + M_DiscountSchema.getUUID());
			}
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
		if (get_ID() == 0 && M_PriceList != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(M_PriceList.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UUID " + M_PriceList.getUUID());
			}
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
	 * Set NAICS/SIC.
	 *
	 * @param NAICS Standard Industry Code or its successor NAIC - http://www.osha.gov/oshstats/sicser.html
	 */

	public void setNAICS(String NAICS) {
		if (get_ID() == 0) {
			super.setNAICS(NAICS);
		}
	}
	/**
	 * Set Name.
	 *
	 * @param Name Alphanumeric identifier of the entity
	 */

	public void setName(String Name) {
		if (get_ID() == 0) {
			super.setName(Name);
		}
	}
	/**
	 * Set Name 2.
	 *
	 * @param Name2 Additional Name
	 */

	public void setName2(String Name2) {
		if (get_ID() == 0) {
			super.setName2(Name2);
		}
	}

	/**
	 * Set Notification Type.
	 *
	 * @param NotificationType Type of Notifications
	 */
	@JsonProperty("NotificationType")
	public void setNotificationTypeInput(I_AD_Ref_ListInput NotificationType) {
		this.mNotificationType = NotificationType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&NotificationType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(NotificationType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setNotificationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + NotificationType.getUUID());
			}
		}
	}

	/**
	 * Get Notification Type.
	 *
	 * @return Type of Notifications
	 */
	@JsonProperty("NotificationType")
	public I_AD_Ref_ListInput NotificationType() {
		return mNotificationType;
	}
	/**
	 * Set Employees.
	 *
	 * @param NumberEmployees Number of employees
	 */

	public void setNumberEmployees(int NumberEmployees) {
		if (get_ID() == 0) {
			super.setNumberEmployees(NumberEmployees);
		}
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
		if (get_ID() == 0 &&PaymentRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPaymentRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PaymentRule.getUUID());
			}
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
		if (get_ID() == 0 &&PaymentRulePO != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentRulePO.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPaymentRulePO(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PaymentRulePO.getUUID());
			}
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
	 * Set Phone.
	 *
	 * @param Phone Identifies a telephone number
	 */

	public void setPhone(String Phone) {
		if (get_ID() == 0) {
			super.setPhone(Phone);
		}
	}
	/**
	 * Set 2nd Phone.
	 *
	 * @param Phone2 Identifies an alternate telephone number.
	 */

	public void setPhone2(String Phone2) {
		if (get_ID() == 0) {
			super.setPhone2(Phone2);
		}
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
		if (get_ID() == 0 && PO_DiscountSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(PO_DiscountSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPO_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UUID " + PO_DiscountSchema.getUUID());
			}
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
		if (get_ID() == 0 && PO_PaymentTerm != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
							.setParameters(PO_PaymentTerm.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPO_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UUID " + PO_PaymentTerm.getUUID());
			}
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
		if (get_ID() == 0 && PO_PriceList != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(PO_PriceList.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPO_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UUID " + PO_PriceList.getUUID());
			}
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
	 * Set Order Reference.
	 *
	 * @param POReference Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	 */

	public void setPOReference(String POReference) {
		if (get_ID() == 0) {
			super.setPOReference(POReference);
		}
	}
	/**
	 * Set ZIP.
	 *
	 * @param Postal Postal code
	 */

	public void setPostal(String Postal) {
		if (get_ID() == 0) {
			super.setPostal(Postal);
		}
	}
	/**
	 * Set Additional Zip.
	 *
	 * @param Postal_Add Additional ZIP or Postal code
	 */

	public void setPostal_Add(String Postal_Add) {
		if (get_ID() == 0) {
			super.setPostal_Add(Postal_Add);
		}
	}
	/**
	 * Set Potential Life Time Value.
	 *
	 * @param PotentialLifeTimeValue Total Revenue expected
	 */

	public void setPotentialLifeTimeValue(BigDecimal PotentialLifeTimeValue) {
		if (get_ID() == 0) {
			super.setPotentialLifeTimeValue(PotentialLifeTimeValue);
		}
	}
	/**
	 * Set Rating.
	 *
	 * @param Rating Classification or Importance
	 */

	public void setRating(String Rating) {
		if (get_ID() == 0) {
			super.setRating(Rating);
		}
	}
	/**
	 * Set Reference No.
	 *
	 * @param ReferenceNo Your customer or vendor number at the Business Partner's site
	 */

	public void setReferenceNo(String ReferenceNo) {
		if (get_ID() == 0) {
			super.setReferenceNo(ReferenceNo);
		}
	}
	/**
	 * Set Region.
	 *
	 * @param RegionName Name of the Region
	 */

	public void setRegionName(String RegionName) {
		if (get_ID() == 0) {
			super.setRegionName(RegionName);
		}
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
		if (get_ID() == 0 && SalesRep != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
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
	 * Set Sales Volume in 1.000.
	 *
	 * @param SalesVolume Total Volume of Sales in Thousands of Currency
	 */

	public void setSalesVolume(BigDecimal SalesVolume) {
		if (get_ID() == 0) {
			super.setSalesVolume(SalesVolume);
		}
	}
	/**
	 * Set Send EMail.
	 *
	 * @param SendEMail Enable sending Document EMail
	 */

	public void setSendEMail(boolean SendEMail) {
		if (get_ID() == 0) {
			super.setSendEMail(SendEMail);
		}
	}
	/**
	 * Set Share.
	 *
	 * @param ShareOfCustomer Share of Customer's business as a percentage
	 */

	public void setShareOfCustomer(int ShareOfCustomer) {
		if (get_ID() == 0) {
			super.setShareOfCustomer(ShareOfCustomer);
		}
	}
	/**
	 * Set Min Shelf Life %.
	 *
	 * @param ShelfLifeMinPct Minimum Shelf Life in percent based on Product Instance Guarantee Date
	 */

	public void setShelfLifeMinPct(int ShelfLifeMinPct) {
		if (get_ID() == 0) {
			super.setShelfLifeMinPct(ShelfLifeMinPct);
		}
	}
	/**
	 * Set Credit Available.
	 *
	 * @param SO_CreditAvailable Available Credit based on Credit Limit (not Total Open Balance) and Credit Used
	 */

	public void setSO_CreditAvailable(BigDecimal SO_CreditAvailable) {
		if (get_ID() == 0) {
			super.setSO_CreditAvailable(SO_CreditAvailable);
		}
	}
	/**
	 * Set Credit Limit.
	 *
	 * @param SO_CreditLimit Total outstanding invoice amounts allowed
	 */

	public void setSO_CreditLimit(BigDecimal SO_CreditLimit) {
		if (get_ID() == 0) {
			super.setSO_CreditLimit(SO_CreditLimit);
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
	 * Set Order Description.
	 *
	 * @param SO_Description Description to be used on orders
	 */

	public void setSO_Description(String SO_Description) {
		if (get_ID() == 0) {
			super.setSO_Description(SO_Description);
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
		if (get_ID() == 0 &&SOCreditStatus != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(SOCreditStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSOCreditStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + SOCreditStatus.getUUID());
			}
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

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public void setSupervisorInput(ForeignEntityInput Supervisor) {
		this.mSupervisor = Supervisor;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && Supervisor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Supervisor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSupervisor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + Supervisor.getUUID());
			}
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public ForeignEntityInput Supervisor() {
		return mSupervisor;
	}
	/**
	 * Set Tax ID.
	 *
	 * @param TaxID Tax Identification
	 */

	public void setTaxID(String TaxID) {
		if (get_ID() == 0) {
			super.setTaxID(TaxID);
		}
	}
	/**
	 * Set Title.
	 *
	 * @param Title Name this entity is referred to as
	 */

	public void setTitle(String Title) {
		if (get_ID() == 0) {
			super.setTitle(Title);
		}
	}
	/**
	 * Set Open Balance.
	 *
	 * @param TotalOpenBalance Total Open Balance Amount in primary Accounting Currency
	 */

	public void setTotalOpenBalance(BigDecimal TotalOpenBalance) {
		if (get_ID() == 0) {
			super.setTotalOpenBalance(TotalOpenBalance);
		}
	}
	/**
	 * Set URL.
	 *
	 * @param URL Full URL address - e.g. http://www.idempiere.org
	 */

	public void setURL(String URL) {
		if (get_ID() == 0) {
			super.setURL(URL);
		}
	}
	/**
	 * Set Search Key.
	 *
	 * @param Value Search key for the record in the format required - must be unique
	 */

	public void setValue(String Value) {
		if (get_ID() == 0) {
			super.setValue(Value);
		}
	}
}
