package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashLine;
import org.compiere.model.MCashPlanLine;
import org.compiere.model.MConversionType;
import org.compiere.model.MElementValue;
import org.compiere.model.MFreightCategory;
import org.compiere.model.MOpportunity;
import org.compiere.model.MOrg;
import org.compiere.model.MPOS;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MProject;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
import org.compiere.model.X_C_OrderSource;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderInput extends MOrder_BH implements I_C_OrderInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mBH_Visit;
	private ForeignEntityInput mBH_Voided_Reason;
	private ForeignEntityInput mBill_BPartner;
	private ForeignEntityInput mBill_Location;
	private ForeignEntityInput mBill_User;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_CashLine;
	private ForeignEntityInput mC_CashPlanLine;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mC_DocTypeTarget;
	private ForeignEntityInput mC_Opportunity;
	private ForeignEntityInput mC_OrderSource;
	private ForeignEntityInput mC_POS;
	private ForeignEntityInput mC_Payment;
	private ForeignEntityInput mC_PaymentTerm;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mDropShip_BPartner;
	private ForeignEntityInput mDropShip_Location;
	private ForeignEntityInput mDropShip_User;
	private ForeignEntityInput mLink_Order;
	private ForeignEntityInput mM_FreightCategory;
	private ForeignEntityInput mM_PriceList;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mQuotationOrder;
	private ForeignEntityInput mRef_Order;
	private ForeignEntityInput mSalesRep;
	private ForeignEntityInput mUser1;
	private ForeignEntityInput mUser2;
	private I_AD_Ref_ListInput mDeliveryRule;
	private I_AD_Ref_ListInput mDeliveryViaRule;
	private I_AD_Ref_ListInput mDocAction;
	private I_AD_Ref_ListInput mDocStatus;
	private I_AD_Ref_ListInput mFreightCostRule;
	private I_AD_Ref_ListInput mInvoiceRule;
	private I_AD_Ref_ListInput mPriorityRule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Order_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_OrderInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		} else {
			this.setAD_User_ID(0);
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
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	@JsonProperty("BH_Visit")
	public void setBH_VisitInput(ForeignEntityInput BH_Visit) {
		this.mBH_Visit = BH_Visit;
		if (BH_Visit != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHVisit foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Visit", "BH_Visit_UU=?", get_TrxName())
							.setParameters(BH_Visit.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Visit_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Visit with UUID " + BH_Visit.getUUID());
			}
		} else {
			this.setBH_Visit_ID(0);
		}
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	@JsonProperty("BH_Visit")
	public ForeignEntityInput BH_Visit() {
		return mBH_Visit;
	}

	/**
	 * Set BH_Voided_Reason_ID.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason_ID
	 */
	@JsonProperty("BH_Voided_Reason")
	public void setBH_Voided_ReasonInput(ForeignEntityInput BH_Voided_Reason) {
		this.mBH_Voided_Reason = BH_Voided_Reason;
		if (BH_Voided_Reason != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHVoidedReason foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Voided_Reason", "BH_Voided_Reason_UU=?", get_TrxName())
							.setParameters(BH_Voided_Reason.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Voided_Reason_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Voided_Reason with UUID " + BH_Voided_Reason.getUUID());
			}
		} else {
			this.setBH_Voided_Reason_ID(0);
		}
	}

	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	@JsonProperty("BH_Voided_Reason")
	public ForeignEntityInput BH_Voided_Reason() {
		return mBH_Voided_Reason;
	}

	/**
	 * Set Invoice Partner.
	 *
	 * @param Bill_BPartner Business Partner to be invoiced
	 */
	@JsonProperty("Bill_BPartner")
	public void setBill_BPartnerInput(ForeignEntityInput Bill_BPartner) {
		this.mBill_BPartner = Bill_BPartner;
		if (Bill_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(Bill_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBill_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + Bill_BPartner.getUUID());
			}
		} else {
			this.setBill_BPartner_ID(0);
		}
	}

	/**
	 * Get Invoice Partner.
	 *
	 * @return Business Partner to be invoiced
	 */
	@JsonProperty("Bill_BPartner")
	public ForeignEntityInput Bill_BPartner() {
		return mBill_BPartner;
	}

	/**
	 * Set Invoice Location.
	 *
	 * @param Bill_Location Business Partner Location for invoicing
	 */
	@JsonProperty("Bill_Location")
	public void setBill_LocationInput(ForeignEntityInput Bill_Location) {
		this.mBill_Location = Bill_Location;
		if (Bill_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(Bill_Location.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBill_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + Bill_Location.getUUID());
			}
		} else {
			this.setBill_Location_ID(0);
		}
	}

	/**
	 * Get Invoice Location.
	 *
	 * @return Business Partner Location for invoicing
	 */
	@JsonProperty("Bill_Location")
	public ForeignEntityInput Bill_Location() {
		return mBill_Location;
	}

	/**
	 * Set Invoice Contact.
	 *
	 * @param Bill_User Business Partner Contact for invoicing
	 */
	@JsonProperty("Bill_User")
	public void setBill_UserInput(ForeignEntityInput Bill_User) {
		this.mBill_User = Bill_User;
		if (Bill_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Bill_User.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBill_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + Bill_User.getUUID());
			}
		} else {
			this.setBill_User_ID(0);
		}
	}

	/**
	 * Get Invoice Contact.
	 *
	 * @return Business Partner Contact for invoicing
	 */
	@JsonProperty("Bill_User")
	public ForeignEntityInput Bill_User() {
		return mBill_User;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	@JsonProperty("C_Activity")
	public void setC_ActivityInput(ForeignEntityInput C_Activity) {
		this.mC_Activity = C_Activity;
		if (C_Activity != null) {
			// Since an entity was passed, make sure it's in the DB
			MActivity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Activity", "C_Activity_UU=?", get_TrxName())
							.setParameters(C_Activity.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UUID " + C_Activity.getUUID());
			}
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	@JsonProperty("C_Activity")
	public ForeignEntityInput C_Activity() {
		return mC_Activity;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		if (C_BPartner_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(C_BPartner_Location.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + C_BPartner_Location.getUUID());
			}
		} else {
			this.setC_BPartner_Location_ID(0);
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
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(ForeignEntityInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		if (C_Campaign != null) {
			// Since an entity was passed, make sure it's in the DB
			MCampaign foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
							.setParameters(C_Campaign.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UUID " + C_Campaign.getUUID());
			}
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public ForeignEntityInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Cash Journal Line.
	 *
	 * @param C_CashLine Cash Journal Line
	 */
	@JsonProperty("C_CashLine")
	public void setC_CashLineInput(ForeignEntityInput C_CashLine) {
		this.mC_CashLine = C_CashLine;
		if (C_CashLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashLine", "C_CashLine_UU=?", get_TrxName())
							.setParameters(C_CashLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_CashLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashLine with UUID " + C_CashLine.getUUID());
			}
		} else {
			this.setC_CashLine_ID(0);
		}
	}

	/**
	 * Get Cash Journal Line.
	 *
	 * @return Cash Journal Line
	 */
	@JsonProperty("C_CashLine")
	public ForeignEntityInput C_CashLine() {
		return mC_CashLine;
	}

	/**
	 * Set Cash Plan Line.
	 *
	 * @param C_CashPlanLine Cash Plan Line
	 */
	@JsonProperty("C_CashPlanLine")
	public void setC_CashPlanLineInput(ForeignEntityInput C_CashPlanLine) {
		this.mC_CashPlanLine = C_CashPlanLine;
		if (C_CashPlanLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashPlanLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashPlanLine", "C_CashPlanLine_UU=?", get_TrxName())
							.setParameters(C_CashPlanLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_CashPlanLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashPlanLine with UUID " + C_CashPlanLine.getUUID());
			}
		} else {
			this.setC_CashPlanLine_ID(0);
		}
	}

	/**
	 * Get Cash Plan Line.
	 *
	 * @return Cash Plan Line
	 */
	@JsonProperty("C_CashPlanLine")
	public ForeignEntityInput C_CashPlanLine() {
		return mC_CashPlanLine;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(ForeignEntityInput C_Charge) {
		this.mC_Charge = C_Charge;
		if (C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(C_Charge.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UUID " + C_Charge.getUUID());
			}
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public ForeignEntityInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		if (C_ConversionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MConversionType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UUID " + C_ConversionType.getUUID());
			}
		} else {
			this.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public ForeignEntityInput C_ConversionType() {
		return mC_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (get_ID() != 0) {
			return;
		}
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		if (get_ID() != 0) {
			return;
		}
		if (C_DocType != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocType.getUUID());
			}
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set Target Document Type.
	 *
	 * @param C_DocTypeTarget Target document type for conversing documents
	 */
	@JsonProperty("C_DocTypeTarget")
	public void setC_DocTypeTargetInput(ForeignEntityInput C_DocTypeTarget) {
		this.mC_DocTypeTarget = C_DocTypeTarget;
		if (C_DocTypeTarget != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocTypeTarget.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocTypeTarget_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocTypeTarget.getUUID());
			}
		} else {
			this.setC_DocTypeTarget_ID(0);
		}
	}

	/**
	 * Get Target Document Type.
	 *
	 * @return Target document type for conversing documents
	 */
	@JsonProperty("C_DocTypeTarget")
	public ForeignEntityInput C_DocTypeTarget() {
		return mC_DocTypeTarget;
	}

	/**
	 * Set Sales Opportunity.
	 *
	 * @param C_Opportunity Sales Opportunity
	 */
	@JsonProperty("C_Opportunity")
	public void setC_OpportunityInput(ForeignEntityInput C_Opportunity) {
		this.mC_Opportunity = C_Opportunity;
		if (C_Opportunity != null) {
			// Since an entity was passed, make sure it's in the DB
			MOpportunity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Opportunity", "C_Opportunity_UU=?", get_TrxName())
							.setParameters(C_Opportunity.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Opportunity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Opportunity with UUID " + C_Opportunity.getUUID());
			}
		} else {
			this.setC_Opportunity_ID(0);
		}
	}

	/**
	 * Get Sales Opportunity.
	 *
	 * @return Sales Opportunity
	 */
	@JsonProperty("C_Opportunity")
	public ForeignEntityInput C_Opportunity() {
		return mC_Opportunity;
	}
	/**
	 * Set Order.
	 *
	 * @param C_Order_ID Order
	 */

	public void setC_Order_ID(int C_Order_ID) {
		if (get_ID() == 0) {
			super.setC_Order_ID(C_Order_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Order_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Order_UU();
	}

	/**
	 * Set Order Source.
	 *
	 * @param C_OrderSource Order Source
	 */
	@JsonProperty("C_OrderSource")
	public void setC_OrderSourceInput(ForeignEntityInput C_OrderSource) {
		this.mC_OrderSource = C_OrderSource;
		if (C_OrderSource != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_OrderSource foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderSource", "C_OrderSource_UU=?", get_TrxName())
							.setParameters(C_OrderSource.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_OrderSource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderSource with UUID " + C_OrderSource.getUUID());
			}
		} else {
			this.setC_OrderSource_ID(0);
		}
	}

	/**
	 * Get Order Source.
	 *
	 * @return Order Source
	 */
	@JsonProperty("C_OrderSource")
	public ForeignEntityInput C_OrderSource() {
		return mC_OrderSource;
	}

	/**
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	@JsonProperty("C_Payment")
	public void setC_PaymentInput(ForeignEntityInput C_Payment) {
		this.mC_Payment = C_Payment;
		if (C_Payment != null) {
			// Since an entity was passed, make sure it's in the DB
			MPayment_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + C_Payment.getUUID());
			}
		} else {
			this.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	@JsonProperty("C_Payment")
	public ForeignEntityInput C_Payment() {
		return mC_Payment;
	}

	/**
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm) {
		this.mC_PaymentTerm = C_PaymentTerm;
		if (C_PaymentTerm != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaymentTerm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
							.setParameters(C_PaymentTerm.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UUID " + C_PaymentTerm.getUUID());
			}
		} else {
			this.setC_PaymentTerm_ID(0);
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
	 * Set POS Terminal.
	 *
	 * @param C_POS Point of Sales Terminal
	 */
	@JsonProperty("C_POS")
	public void setC_POSInput(ForeignEntityInput C_POS) {
		this.mC_POS = C_POS;
		if (C_POS != null) {
			// Since an entity was passed, make sure it's in the DB
			MPOS foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_POS", "C_POS_UU=?", get_TrxName())
							.setParameters(C_POS.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_POS_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_POS with UUID " + C_POS.getUUID());
			}
		} else {
			this.setC_POS_ID(0);
		}
	}

	/**
	 * Get POS Terminal.
	 *
	 * @return Point of Sales Terminal
	 */
	@JsonProperty("C_POS")
	public ForeignEntityInput C_POS() {
		return mC_POS;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(ForeignEntityInput C_Project) {
		this.mC_Project = C_Project;
		if (C_Project != null) {
			// Since an entity was passed, make sure it's in the DB
			MProject foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UUID " + C_Project.getUUID());
			}
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public ForeignEntityInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Delivery Rule.
	 *
	 * @param DeliveryRule Defines the timing of Delivery
	 */
	@JsonProperty("DeliveryRule")
	public void setDeliveryRuleInput(I_AD_Ref_ListInput DeliveryRule) {
		this.mDeliveryRule = DeliveryRule;
		if (DeliveryRule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryRule.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
		if (DeliveryViaRule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryViaRule.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocAction.getUUID());
			}
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public I_AD_Ref_ListInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(I_AD_Ref_ListInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocStatus.getUUID());
			}
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public I_AD_Ref_ListInput DocStatus() {
		return mDocStatus;
	}
	/**
	 * Set Document No.
	 *
	 * @param DocumentNo Document sequence number of the document
	 */

	public void setDocumentNo(String DocumentNo) {
		if (get_ID() == 0) {
			super.setDocumentNo(DocumentNo);
		}
	}

	/**
	 * Set Drop Ship Business Partner.
	 *
	 * @param DropShip_BPartner Business Partner to ship to
	 */
	@JsonProperty("DropShip_BPartner")
	public void setDropShip_BPartnerInput(ForeignEntityInput DropShip_BPartner) {
		this.mDropShip_BPartner = DropShip_BPartner;
		if (DropShip_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(DropShip_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDropShip_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + DropShip_BPartner.getUUID());
			}
		} else {
			this.setDropShip_BPartner_ID(0);
		}
	}

	/**
	 * Get Drop Ship Business Partner.
	 *
	 * @return Business Partner to ship to
	 */
	@JsonProperty("DropShip_BPartner")
	public ForeignEntityInput DropShip_BPartner() {
		return mDropShip_BPartner;
	}

	/**
	 * Set Drop Shipment Location.
	 *
	 * @param DropShip_Location Business Partner Location for shipping to
	 */
	@JsonProperty("DropShip_Location")
	public void setDropShip_LocationInput(ForeignEntityInput DropShip_Location) {
		this.mDropShip_Location = DropShip_Location;
		if (DropShip_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(DropShip_Location.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDropShip_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + DropShip_Location.getUUID());
			}
		} else {
			this.setDropShip_Location_ID(0);
		}
	}

	/**
	 * Get Drop Shipment Location.
	 *
	 * @return Business Partner Location for shipping to
	 */
	@JsonProperty("DropShip_Location")
	public ForeignEntityInput DropShip_Location() {
		return mDropShip_Location;
	}

	/**
	 * Set Drop Shipment Contact.
	 *
	 * @param DropShip_User Business Partner Contact for drop shipment
	 */
	@JsonProperty("DropShip_User")
	public void setDropShip_UserInput(ForeignEntityInput DropShip_User) {
		this.mDropShip_User = DropShip_User;
		if (DropShip_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(DropShip_User.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDropShip_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + DropShip_User.getUUID());
			}
		} else {
			this.setDropShip_User_ID(0);
		}
	}

	/**
	 * Get Drop Shipment Contact.
	 *
	 * @return Business Partner Contact for drop shipment
	 */
	@JsonProperty("DropShip_User")
	public ForeignEntityInput DropShip_User() {
		return mDropShip_User;
	}

	/**
	 * Set Freight Cost Rule.
	 *
	 * @param FreightCostRule Method for charging Freight
	 */
	@JsonProperty("FreightCostRule")
	public void setFreightCostRuleInput(I_AD_Ref_ListInput FreightCostRule) {
		this.mFreightCostRule = FreightCostRule;
		if (FreightCostRule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FreightCostRule.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Grand Total.
	 *
	 * @param GrandTotal Total amount of document
	 */

	public void setGrandTotal(BigDecimal GrandTotal) {
		if (get_ID() == 0) {
			super.setGrandTotal(GrandTotal);
		}
	}

	/**
	 * Set Invoice Rule.
	 *
	 * @param InvoiceRule Frequency and method of invoicing 
	 */
	@JsonProperty("InvoiceRule")
	public void setInvoiceRuleInput(I_AD_Ref_ListInput InvoiceRule) {
		this.mInvoiceRule = InvoiceRule;
		if (InvoiceRule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceRule.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Approved.
	 *
	 * @param IsApproved Indicates if this document requires approval
	 */

	public void setIsApproved(boolean IsApproved) {
		if (get_ID() == 0) {
			super.setIsApproved(IsApproved);
		}
	}
	/**
	 * Set Credit Approved.
	 *
	 * @param IsCreditApproved Credit  has been approved
	 */

	public void setIsCreditApproved(boolean IsCreditApproved) {
		if (get_ID() == 0) {
			super.setIsCreditApproved(IsCreditApproved);
		}
	}
	/**
	 * Set Delivered.
	 *
	 * @param IsDelivered Delivered
	 */

	public void setIsDelivered(boolean IsDelivered) {
		if (get_ID() == 0) {
			super.setIsDelivered(IsDelivered);
		}
	}
	/**
	 * Set Invoiced.
	 *
	 * @param IsInvoiced Is this invoiced?
	 */

	public void setIsInvoiced(boolean IsInvoiced) {
		if (get_ID() == 0) {
			super.setIsInvoiced(IsInvoiced);
		}
	}
	/**
	 * Set Printed.
	 *
	 * @param IsPrinted Indicates if this document / line is printed
	 */

	public void setIsPrinted(boolean IsPrinted) {
		if (get_ID() == 0) {
			super.setIsPrinted(IsPrinted);
		}
	}
	/**
	 * Set Transferred.
	 *
	 * @param IsTransferred Transferred to General Ledger (i.e. accounted)
	 */

	public void setIsTransferred(boolean IsTransferred) {
		if (get_ID() == 0) {
			super.setIsTransferred(IsTransferred);
		}
	}

	/**
	 * Set Linked Order.
	 *
	 * @param Link_Order This field links a sales order to the purchase order that is generated from it.
	 */
	@JsonProperty("Link_Order")
	public void setLink_OrderInput(ForeignEntityInput Link_Order) {
		this.mLink_Order = Link_Order;
		if (get_ID() != 0) {
			return;
		}
		if (Link_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(Link_Order.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLink_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + Link_Order.getUUID());
			}
		} else {
			this.setLink_Order_ID(0);
		}
	}

	/**
	 * Get Linked Order.
	 *
	 * @return This field links a sales order to the purchase order that is generated from it.
	 */
	@JsonProperty("Link_Order")
	public ForeignEntityInput Link_Order() {
		return mLink_Order;
	}

	/**
	 * Set Freight Category.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	@JsonProperty("M_FreightCategory")
	public void setM_FreightCategoryInput(ForeignEntityInput M_FreightCategory) {
		this.mM_FreightCategory = M_FreightCategory;
		if (M_FreightCategory != null) {
			// Since an entity was passed, make sure it's in the DB
			MFreightCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_FreightCategory", "M_FreightCategory_UU=?", get_TrxName())
							.setParameters(M_FreightCategory.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_FreightCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_FreightCategory with UUID " + M_FreightCategory.getUUID());
			}
		} else {
			this.setM_FreightCategory_ID(0);
		}
	}

	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	@JsonProperty("M_FreightCategory")
	public ForeignEntityInput M_FreightCategory() {
		return mM_FreightCategory;
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public void setM_PriceListInput(ForeignEntityInput M_PriceList) {
		this.mM_PriceList = M_PriceList;
		if (M_PriceList != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(M_PriceList.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UUID " + M_PriceList.getUUID());
			}
		} else {
			this.setM_PriceList_ID(0);
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
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(ForeignEntityInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
		if (M_Shipper != null) {
			// Since an entity was passed, make sure it's in the DB
			MShipper foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
							.setParameters(M_Shipper.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Shipper_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Shipper with UUID " + M_Shipper.getUUID());
			}
		} else {
			this.setM_Shipper_ID(0);
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public ForeignEntityInput M_Shipper() {
		return mM_Shipper;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_Warehouse.getUUID());
			}
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}
	/**
	 * Set Posted.
	 *
	 * @param Posted Posting status
	 */

	public void setPosted(boolean Posted) {
		if (get_ID() == 0) {
			super.setPosted(Posted);
		}
	}

	/**
	 * Set Priority.
	 *
	 * @param PriorityRule Priority of a document
	 */
	@JsonProperty("PriorityRule")
	public void setPriorityRuleInput(I_AD_Ref_ListInput PriorityRule) {
		this.mPriorityRule = PriorityRule;
		if (PriorityRule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PriorityRule.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPriorityRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PriorityRule.getUUID());
			}
		} else {
			this.setPriorityRule(null);
		}
	}

	/**
	 * Get Priority.
	 *
	 * @return Priority of a document
	 */
	@JsonProperty("PriorityRule")
	public I_AD_Ref_ListInput PriorityRule() {
		return mPriorityRule;
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */

	public void setProcessed(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}

	/**
	 * Set Quotation.
	 *
	 * @param QuotationOrder Quotation used for generating this order
	 */
	@JsonProperty("QuotationOrder")
	public void setQuotationOrderInput(ForeignEntityInput QuotationOrder) {
		this.mQuotationOrder = QuotationOrder;
		if (QuotationOrder != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(QuotationOrder.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setQuotationOrder_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + QuotationOrder.getUUID());
			}
		} else {
			this.setQuotationOrder_ID(0);
		}
	}

	/**
	 * Get Quotation.
	 *
	 * @return Quotation used for generating this order
	 */
	@JsonProperty("QuotationOrder")
	public ForeignEntityInput QuotationOrder() {
		return mQuotationOrder;
	}

	/**
	 * Set Referenced Order.
	 *
	 * @param Ref_Order Reference to corresponding Sales/Purchase Order
	 */
	@JsonProperty("Ref_Order")
	public void setRef_OrderInput(ForeignEntityInput Ref_Order) {
		this.mRef_Order = Ref_Order;
		if (Ref_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(Ref_Order.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRef_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + Ref_Order.getUUID());
			}
		} else {
			this.setRef_Order_ID(0);
		}
	}

	/**
	 * Get Referenced Order.
	 *
	 * @return Reference to corresponding Sales/Purchase Order
	 */
	@JsonProperty("Ref_Order")
	public ForeignEntityInput Ref_Order() {
		return mRef_Order;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		if (SalesRep != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
		} else {
			this.setSalesRep_ID(0);
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
	 * Set Total Lines.
	 *
	 * @param TotalLines Total of all document lines
	 */

	public void setTotalLines(BigDecimal TotalLines) {
		if (get_ID() == 0) {
			super.setTotalLines(TotalLines);
		}
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	@JsonProperty("User1")
	public void setUser1Input(ForeignEntityInput User1) {
		this.mUser1 = User1;
		if (User1 != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User1.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUser1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User1.getUUID());
			}
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	@JsonProperty("User1")
	public ForeignEntityInput User1() {
		return mUser1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	@JsonProperty("User2")
	public void setUser2Input(ForeignEntityInput User2) {
		this.mUser2 = User2;
		if (User2 != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User2.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUser2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User2.getUUID());
			}
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	@JsonProperty("User2")
	public ForeignEntityInput User2() {
		return mUser2;
	}
}
