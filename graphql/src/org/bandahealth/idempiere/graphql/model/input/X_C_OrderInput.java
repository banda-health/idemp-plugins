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
import org.bandahealth.idempiere.graphql.resolver.model.X_C_OrderResolver;
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
 * @version Release 11 - $Id$
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
	private ForeignEntityInput mDeliveryRule;
	private ForeignEntityInput mDeliveryViaRule;
	private ForeignEntityInput mDocAction;
	private ForeignEntityInput mDocStatus;
	private ForeignEntityInput mDropShip_BPartner;
	private ForeignEntityInput mDropShip_Location;
	private ForeignEntityInput mDropShip_User;
	private ForeignEntityInput mFreightCostRule;
	private ForeignEntityInput mInvoiceRule;
	private ForeignEntityInput mLink_Order;
	private ForeignEntityInput mM_FreightCategory;
	private ForeignEntityInput mM_PriceList;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mPaymentRule;
	private ForeignEntityInput mPriorityRule;
	private ForeignEntityInput mQuotationOrder;
	private ForeignEntityInput mRef_Order;
	private ForeignEntityInput mSalesRep;
	private ForeignEntityInput mUser1;
	private ForeignEntityInput mUser2;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Order_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_OrderInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
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
							.setParameters(BH_Visit.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Visit_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Visit with UU " + BH_Visit.getUU());
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
							.setParameters(BH_Voided_Reason.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Voided_Reason_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Voided_Reason with UU " + BH_Voided_Reason.getUU());
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
							.setParameters(Bill_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBill_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + Bill_BPartner.getUU());
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
							.setParameters(Bill_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBill_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UU " + Bill_Location.getUU());
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
							.setParameters(Bill_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBill_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + Bill_User.getUU());
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
							.setParameters(C_Activity.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UU " + C_Activity.getUU());
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
	 * Set Business Partner.
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
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
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
							.setParameters(C_BPartner_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UU " + C_BPartner_Location.getUU());
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
							.setParameters(C_Campaign.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UU " + C_Campaign.getUU());
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
							.setParameters(C_CashLine.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_CashLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashLine with UU " + C_CashLine.getUU());
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
							.setParameters(C_CashPlanLine.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_CashPlanLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashPlanLine with UU " + C_CashPlanLine.getUU());
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
							.setParameters(C_Charge.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UU " + C_Charge.getUU());
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
							.setParameters(C_ConversionType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UU " + C_ConversionType.getUU());
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
							.setParameters(C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + C_Currency.getUU());
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
							.setParameters(C_DocType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UU " + C_DocType.getUU());
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
							.setParameters(C_DocTypeTarget.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocTypeTarget_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UU " + C_DocTypeTarget.getUU());
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
							.setParameters(C_Opportunity.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Opportunity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Opportunity with UU " + C_Opportunity.getUU());
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
	@JsonProperty("C_Order_ID")
	public void setC_Order_IDFromJson(int C_Order_ID) {
		if (get_ID() == 0) {
			super.setC_Order_ID(C_Order_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Order_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
							.setParameters(C_OrderSource.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_OrderSource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderSource with UU " + C_OrderSource.getUU());
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
							.setParameters(C_Payment.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UU " + C_Payment.getUU());
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
							.setParameters(C_PaymentTerm.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UU " + C_PaymentTerm.getUU());
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
							.setParameters(C_POS.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_POS_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_POS with UU " + C_POS.getUU());
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
							.setParameters(C_Project.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UU " + C_Project.getUU());
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
	public void setDeliveryRuleInput(ForeignEntityInput DeliveryRule) {
		this.mDeliveryRule = DeliveryRule;
		if (DeliveryRule != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_OrderResolver.DELIVERYRULE_UUIDS_BY_VALUE.containsValue(DeliveryRule.getUU())) {
				throw new AdempiereException("The reference list UU of " + DeliveryRule.getUU() +
						" is not in the list defined for the DeliveryRule column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDeliveryRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DeliveryRule.getUU());
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
	public ForeignEntityInput DeliveryRule() {
		return mDeliveryRule;
	}

	/**
	 * Set Delivery Via.
	 *
	 * @param DeliveryViaRule How the order will be delivered
	 */
	@JsonProperty("DeliveryViaRule")
	public void setDeliveryViaRuleInput(ForeignEntityInput DeliveryViaRule) {
		this.mDeliveryViaRule = DeliveryViaRule;
		if (DeliveryViaRule != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_OrderResolver.DELIVERYVIARULE_UUIDS_BY_VALUE.containsValue(DeliveryViaRule.getUU())) {
				throw new AdempiereException("The reference list UU of " + DeliveryViaRule.getUU() +
						" is not in the list defined for the DeliveryViaRule column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryViaRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDeliveryViaRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DeliveryViaRule.getUU());
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
	public ForeignEntityInput DeliveryViaRule() {
		return mDeliveryViaRule;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(ForeignEntityInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_OrderResolver.DOCACTION_UUIDS_BY_VALUE.containsValue(DocAction.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocAction.getUU() +
						" is not in the list defined for the DocAction column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocAction.getUU());
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
	public ForeignEntityInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(ForeignEntityInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_OrderResolver.DOCSTATUS_UUIDS_BY_VALUE.containsValue(DocStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocStatus.getUU() +
						" is not in the list defined for the DocStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocStatus.getUU());
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
	public ForeignEntityInput DocStatus() {
		return mDocStatus;
	}
	/**
	 * Set Document No.
	 *
	 * @param DocumentNo Document sequence number of the document
	 */
	@JsonProperty("DocumentNo")
	public void setDocumentNoFromJson(String DocumentNo) {
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
							.setParameters(DropShip_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDropShip_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + DropShip_BPartner.getUU());
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
							.setParameters(DropShip_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDropShip_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UU " + DropShip_Location.getUU());
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
							.setParameters(DropShip_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDropShip_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + DropShip_User.getUU());
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
	public void setFreightCostRuleInput(ForeignEntityInput FreightCostRule) {
		this.mFreightCostRule = FreightCostRule;
		if (FreightCostRule != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_OrderResolver.FREIGHTCOSTRULE_UUIDS_BY_VALUE.containsValue(FreightCostRule.getUU())) {
				throw new AdempiereException("The reference list UU of " + FreightCostRule.getUU() +
						" is not in the list defined for the FreightCostRule column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FreightCostRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFreightCostRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + FreightCostRule.getUU());
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
	public ForeignEntityInput FreightCostRule() {
		return mFreightCostRule;
	}
	/**
	 * Set Grand Total.
	 *
	 * @param GrandTotal Total amount of document
	 */
	@JsonProperty("GrandTotal")
	public void setGrandTotalFromJson(BigDecimal GrandTotal) {
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
	public void setInvoiceRuleInput(ForeignEntityInput InvoiceRule) {
		this.mInvoiceRule = InvoiceRule;
		if (InvoiceRule != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_OrderResolver.INVOICERULE_UUIDS_BY_VALUE.containsValue(InvoiceRule.getUU())) {
				throw new AdempiereException("The reference list UU of " + InvoiceRule.getUU() +
						" is not in the list defined for the InvoiceRule column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInvoiceRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + InvoiceRule.getUU());
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
	public ForeignEntityInput InvoiceRule() {
		return mInvoiceRule;
	}
	/**
	 * Set Approved.
	 *
	 * @param IsApproved Indicates if this document requires approval
	 */
	@JsonProperty("IsApproved")
	public void setIsApprovedFromJson(boolean IsApproved) {
		if (get_ID() == 0) {
			super.setIsApproved(IsApproved);
		}
	}
	/**
	 * Set Credit Approved.
	 *
	 * @param IsCreditApproved Credit  has been approved
	 */
	@JsonProperty("IsCreditApproved")
	public void setIsCreditApprovedFromJson(boolean IsCreditApproved) {
		if (get_ID() == 0) {
			super.setIsCreditApproved(IsCreditApproved);
		}
	}
	/**
	 * Set Delivered.
	 *
	 * @param IsDelivered Delivered
	 */
	@JsonProperty("IsDelivered")
	public void setIsDeliveredFromJson(boolean IsDelivered) {
		if (get_ID() == 0) {
			super.setIsDelivered(IsDelivered);
		}
	}
	/**
	 * Set Invoiced.
	 *
	 * @param IsInvoiced Is this invoiced?
	 */
	@JsonProperty("IsInvoiced")
	public void setIsInvoicedFromJson(boolean IsInvoiced) {
		if (get_ID() == 0) {
			super.setIsInvoiced(IsInvoiced);
		}
	}
	/**
	 * Set Printed.
	 *
	 * @param IsPrinted Indicates if this document / line is printed
	 */
	@JsonProperty("IsPrinted")
	public void setIsPrintedFromJson(boolean IsPrinted) {
		if (get_ID() == 0) {
			super.setIsPrinted(IsPrinted);
		}
	}
	/**
	 * Set Transferred.
	 *
	 * @param IsTransferred Transferred to General Ledger (i.e. accounted)
	 */
	@JsonProperty("IsTransferred")
	public void setIsTransferredFromJson(boolean IsTransferred) {
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
							.setParameters(Link_Order.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLink_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UU " + Link_Order.getUU());
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
							.setParameters(M_FreightCategory.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_FreightCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_FreightCategory with UU " + M_FreightCategory.getUU());
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
							.setParameters(M_PriceList.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UU " + M_PriceList.getUU());
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
							.setParameters(M_Shipper.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Shipper_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Shipper with UU " + M_Shipper.getUU());
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
							.setParameters(M_Warehouse.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UU " + M_Warehouse.getUU());
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
	 * Set Payment Rule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public void setPaymentRuleInput(ForeignEntityInput PaymentRule) {
		this.mPaymentRule = PaymentRule;
		if (PaymentRule != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_OrderResolver.PAYMENTRULE_UUIDS_BY_VALUE.containsValue(PaymentRule.getUU())) {
				throw new AdempiereException("The reference list UU of " + PaymentRule.getUU() +
						" is not in the list defined for the PaymentRule column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPaymentRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PaymentRule.getUU());
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
	public ForeignEntityInput PaymentRule() {
		return mPaymentRule;
	}
	/**
	 * Set Posted.
	 *
	 * @param Posted Posting status
	 */
	@JsonProperty("Posted")
	public void setPostedFromJson(boolean Posted) {
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
	public void setPriorityRuleInput(ForeignEntityInput PriorityRule) {
		this.mPriorityRule = PriorityRule;
		if (PriorityRule != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_OrderResolver.PRIORITYRULE_UUIDS_BY_VALUE.containsValue(PriorityRule.getUU())) {
				throw new AdempiereException("The reference list UU of " + PriorityRule.getUU() +
						" is not in the list defined for the PriorityRule column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PriorityRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPriorityRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PriorityRule.getUU());
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
	public ForeignEntityInput PriorityRule() {
		return mPriorityRule;
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */
	@JsonProperty("Processed")
	public void setProcessedFromJson(boolean Processed) {
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
							.setParameters(QuotationOrder.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setQuotationOrder_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UU " + QuotationOrder.getUU());
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
							.setParameters(Ref_Order.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRef_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UU " + Ref_Order.getUU());
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
							.setParameters(SalesRep.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + SalesRep.getUU());
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
	@JsonProperty("TotalLines")
	public void setTotalLinesFromJson(BigDecimal TotalLines) {
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
							.setParameters(User1.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUser1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + User1.getUU());
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
							.setParameters(User2.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUser2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + User2.getUU());
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
