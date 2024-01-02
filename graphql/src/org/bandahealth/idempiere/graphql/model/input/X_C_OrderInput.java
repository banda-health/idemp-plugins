package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
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

/**
 * Generated Model for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderInput extends MOrder_BH implements I_C_OrderInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mDeliveryRule;
	 private I_AD_Ref_ListInput mDeliveryViaRule;
	 private I_AD_Ref_ListInput mDocAction;
	 private I_AD_Ref_ListInput mDocStatus;
	 private I_AD_Ref_ListInput mFreightCostRule;
	 private I_AD_Ref_ListInput mInvoiceRule;
	 private I_AD_Ref_ListInput mPriorityRule;
	 private I_AD_UserInput mAD_User;
	 private I_AD_UserInput mBill_User;
	 private I_AD_UserInput mDropShip_User;
	 private I_AD_UserInput mSalesRep;
	 private I_BH_VisitInput mBH_Visit;
	 private I_BH_Voided_ReasonInput mBH_Voided_Reason;
	 private I_C_ActivityInput mC_Activity;
	 private I_C_BPartnerInput mBill_BPartner;
	 private I_C_BPartnerInput mC_BPartner;
	 private I_C_BPartnerInput mDropShip_BPartner;
	 private I_C_BPartner_LocationInput mBill_Location;
	 private I_C_BPartner_LocationInput mC_BPartner_Location;
	 private I_C_BPartner_LocationInput mDropShip_Location;
	 private I_C_CampaignInput mC_Campaign;
	 private I_C_CashLineInput mC_CashLine;
	 private I_C_CashPlanLineInput mC_CashPlanLine;
	 private I_C_ChargeInput mC_Charge;
	 private I_C_ConversionTypeInput mC_ConversionType;
	 private I_C_CurrencyInput mC_Currency;
	 private I_C_DocTypeInput mC_DocType;
	 private I_C_DocTypeInput mC_DocTypeTarget;
	 private I_C_ElementValueInput mUser1;
	 private I_C_ElementValueInput mUser2;
	 private I_C_OpportunityInput mC_Opportunity;
	 private I_C_OrderInput mLink_Order;
	 private I_C_OrderInput mQuotationOrder;
	 private I_C_OrderInput mRef_Order;
	 private I_C_OrderSourceInput mC_OrderSource;
	 private I_C_POSInput mC_POS;
	 private I_C_PaymentInput mC_Payment;
	 private I_C_PaymentTermInput mC_PaymentTerm;
	 private I_C_ProjectInput mC_Project;
	 private I_M_FreightCategoryInput mM_FreightCategory;
	 private I_M_PriceListInput mM_PriceList;
	 private I_M_ShipperInput mM_Shipper;
	 private I_M_WarehouseInput mM_Warehouse;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_OrderInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(I_AD_UserInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public I_AD_UserInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	@JsonProperty("BH_Visit")
	public void setBH_VisitInput(I_BH_VisitInput BH_Visit) {
		this.mBH_Visit = BH_Visit;
		MBHVisit foreignEntity;
		if (BH_Visit != null &&
				(foreignEntity = new Query(getCtx(), MBHVisit.Table_Name, MBHVisit.COLUMNNAME_BH_Visit_UU + "=?", get_TrxName())
						.setParameters(BH_Visit.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Visit_ID(foreignEntity.get_ID());
		} else {
			super.setBH_Visit_ID(0);
		}
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	@JsonProperty("BH_Visit")
	public I_BH_VisitInput BH_Visit() {
		return mBH_Visit;
	}

	/**
	 * Set BH_Voided_Reason_ID.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason_ID
	 */
	@JsonProperty("BH_Voided_Reason")
	public void setBH_Voided_ReasonInput(I_BH_Voided_ReasonInput BH_Voided_Reason) {
		this.mBH_Voided_Reason = BH_Voided_Reason;
		MBHVoidedReason foreignEntity;
		if (BH_Voided_Reason != null &&
				(foreignEntity = new Query(getCtx(), MBHVoidedReason.Table_Name, MBHVoidedReason.COLUMNNAME_BH_Voided_Reason_UU + "=?", get_TrxName())
						.setParameters(BH_Voided_Reason.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Voided_Reason_ID(foreignEntity.get_ID());
		} else {
			super.setBH_Voided_Reason_ID(0);
		}
	}

	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	@JsonProperty("BH_Voided_Reason")
	public I_BH_Voided_ReasonInput BH_Voided_Reason() {
		return mBH_Voided_Reason;
	}

	/**
	 * Set Invoice Partner.
	 *
	 * @param Bill_BPartner Business Partner to be invoiced
	 */
	@JsonProperty("Bill_BPartner")
	public void setBill_BPartnerInput(I_C_BPartnerInput Bill_BPartner) {
		this.mBill_BPartner = Bill_BPartner;
		MBPartner_BH foreignEntity;
		if (Bill_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(Bill_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBill_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setBill_BPartner_ID(0);
		}
	}

	/**
	 * Get Invoice Partner.
	 *
	 * @return Business Partner to be invoiced
	 */
	@JsonProperty("Bill_BPartner")
	public I_C_BPartnerInput Bill_BPartner() {
		return mBill_BPartner;
	}

	/**
	 * Set Invoice Location.
	 *
	 * @param Bill_Location Business Partner Location for invoicing
	 */
	@JsonProperty("Bill_Location")
	public void setBill_LocationInput(I_C_BPartner_LocationInput Bill_Location) {
		this.mBill_Location = Bill_Location;
		MBPartnerLocation foreignEntity;
		if (Bill_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(Bill_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBill_Location_ID(foreignEntity.get_ID());
		} else {
			super.setBill_Location_ID(0);
		}
	}

	/**
	 * Get Invoice Location.
	 *
	 * @return Business Partner Location for invoicing
	 */
	@JsonProperty("Bill_Location")
	public I_C_BPartner_LocationInput Bill_Location() {
		return mBill_Location;
	}

	/**
	 * Set Invoice Contact.
	 *
	 * @param Bill_User Business Partner Contact for invoicing
	 */
	@JsonProperty("Bill_User")
	public void setBill_UserInput(I_AD_UserInput Bill_User) {
		this.mBill_User = Bill_User;
		MUser_BH foreignEntity;
		if (Bill_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(Bill_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBill_User_ID(foreignEntity.get_ID());
		} else {
			super.setBill_User_ID(0);
		}
	}

	/**
	 * Get Invoice Contact.
	 *
	 * @return Business Partner Contact for invoicing
	 */
	@JsonProperty("Bill_User")
	public I_AD_UserInput Bill_User() {
		return mBill_User;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	@JsonProperty("C_Activity")
	public void setC_ActivityInput(I_C_ActivityInput C_Activity) {
		this.mC_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			super.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	@JsonProperty("C_Activity")
	public I_C_ActivityInput C_Activity() {
		return mC_Activity;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(I_C_BPartnerInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public I_C_BPartnerInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public I_C_BPartner_LocationInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(I_C_CampaignInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			super.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public I_C_CampaignInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Cash Journal Line.
	 *
	 * @param C_CashLine Cash Journal Line
	 */
	@JsonProperty("C_CashLine")
	public void setC_CashLineInput(I_C_CashLineInput C_CashLine) {
		this.mC_CashLine = C_CashLine;
		MCashLine foreignEntity;
		if (C_CashLine != null &&
				(foreignEntity = new Query(getCtx(), MCashLine.Table_Name, MCashLine.COLUMNNAME_C_CashLine_UU + "=?", get_TrxName())
						.setParameters(C_CashLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CashLine_ID(foreignEntity.get_ID());
		} else {
			super.setC_CashLine_ID(0);
		}
	}

	/**
	 * Get Cash Journal Line.
	 *
	 * @return Cash Journal Line
	 */
	@JsonProperty("C_CashLine")
	public I_C_CashLineInput C_CashLine() {
		return mC_CashLine;
	}

	/**
	 * Set Cash Plan Line.
	 *
	 * @param C_CashPlanLine Cash Plan Line
	 */
	@JsonProperty("C_CashPlanLine")
	public void setC_CashPlanLineInput(I_C_CashPlanLineInput C_CashPlanLine) {
		this.mC_CashPlanLine = C_CashPlanLine;
		MCashPlanLine foreignEntity;
		if (C_CashPlanLine != null &&
				(foreignEntity = new Query(getCtx(), MCashPlanLine.Table_Name, MCashPlanLine.COLUMNNAME_C_CashPlanLine_UU + "=?", get_TrxName())
						.setParameters(C_CashPlanLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CashPlanLine_ID(foreignEntity.get_ID());
		} else {
			super.setC_CashPlanLine_ID(0);
		}
	}

	/**
	 * Get Cash Plan Line.
	 *
	 * @return Cash Plan Line
	 */
	@JsonProperty("C_CashPlanLine")
	public I_C_CashPlanLineInput C_CashPlanLine() {
		return mC_CashPlanLine;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(I_C_ChargeInput C_Charge) {
		this.mC_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			super.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public I_C_ChargeInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(I_C_ConversionTypeInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		MConversionType foreignEntity;
		if (C_ConversionType != null &&
				(foreignEntity = new Query(getCtx(), MConversionType.Table_Name, MConversionType.COLUMNNAME_C_ConversionType_UU + "=?", get_TrxName())
						.setParameters(C_ConversionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ConversionType_ID(foreignEntity.get_ID());
		} else {
			super.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public I_C_ConversionTypeInput C_ConversionType() {
		return mC_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(I_C_CurrencyInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (get_ID() == 0 &&C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency_BH.Table_Name, MCurrency_BH.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public I_C_CurrencyInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(I_C_DocTypeInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (get_ID() == 0 &&C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public I_C_DocTypeInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set Target Document Type.
	 *
	 * @param C_DocTypeTarget Target document type for conversing documents
	 */
	@JsonProperty("C_DocTypeTarget")
	public void setC_DocTypeTargetInput(I_C_DocTypeInput C_DocTypeTarget) {
		this.mC_DocTypeTarget = C_DocTypeTarget;
		MDocType_BH foreignEntity;
		if (C_DocTypeTarget != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeTarget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocTypeTarget_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocTypeTarget_ID(0);
		}
	}

	/**
	 * Get Target Document Type.
	 *
	 * @return Target document type for conversing documents
	 */
	@JsonProperty("C_DocTypeTarget")
	public I_C_DocTypeInput C_DocTypeTarget() {
		return mC_DocTypeTarget;
	}

	/**
	 * Set Sales Opportunity.
	 *
	 * @param C_Opportunity Sales Opportunity
	 */
	@JsonProperty("C_Opportunity")
	public void setC_OpportunityInput(I_C_OpportunityInput C_Opportunity) {
		this.mC_Opportunity = C_Opportunity;
		MOpportunity foreignEntity;
		if (C_Opportunity != null &&
				(foreignEntity = new Query(getCtx(), MOpportunity.Table_Name, MOpportunity.COLUMNNAME_C_Opportunity_UU + "=?", get_TrxName())
						.setParameters(C_Opportunity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Opportunity_ID(foreignEntity.get_ID());
		} else {
			super.setC_Opportunity_ID(0);
		}
	}

	/**
	 * Get Sales Opportunity.
	 *
	 * @return Sales Opportunity
	 */
	@JsonProperty("C_Opportunity")
	public I_C_OpportunityInput C_Opportunity() {
		return mC_Opportunity;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Order_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Order_UU();
	}

	/**
	 * Set Order Source.
	 *
	 * @param C_OrderSource Order Source
	 */
	@JsonProperty("C_OrderSource")
	public void setC_OrderSourceInput(I_C_OrderSourceInput C_OrderSource) {
		this.mC_OrderSource = C_OrderSource;
		X_C_OrderSource foreignEntity;
		if (C_OrderSource != null &&
				(foreignEntity = new Query(getCtx(), X_C_OrderSource.Table_Name, X_C_OrderSource.COLUMNNAME_C_OrderSource_UU + "=?", get_TrxName())
						.setParameters(C_OrderSource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderSource_ID(foreignEntity.get_ID());
		} else {
			super.setC_OrderSource_ID(0);
		}
	}

	/**
	 * Get Order Source.
	 *
	 * @return Order Source
	 */
	@JsonProperty("C_OrderSource")
	public I_C_OrderSourceInput C_OrderSource() {
		return mC_OrderSource;
	}

	/**
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	@JsonProperty("C_Payment")
	public void setC_PaymentInput(I_C_PaymentInput C_Payment) {
		this.mC_Payment = C_Payment;
		MPayment_BH foreignEntity;
		if (C_Payment != null &&
				(foreignEntity = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", get_TrxName())
						.setParameters(C_Payment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Payment_ID(foreignEntity.get_ID());
		} else {
			super.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	@JsonProperty("C_Payment")
	public I_C_PaymentInput C_Payment() {
		return mC_Payment;
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
	 * Set POS Terminal.
	 *
	 * @param C_POS Point of Sales Terminal
	 */
	@JsonProperty("C_POS")
	public void setC_POSInput(I_C_POSInput C_POS) {
		this.mC_POS = C_POS;
		MPOS foreignEntity;
		if (C_POS != null &&
				(foreignEntity = new Query(getCtx(), MPOS.Table_Name, MPOS.COLUMNNAME_C_POS_UU + "=?", get_TrxName())
						.setParameters(C_POS.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_POS_ID(foreignEntity.get_ID());
		} else {
			super.setC_POS_ID(0);
		}
	}

	/**
	 * Get POS Terminal.
	 *
	 * @return Point of Sales Terminal
	 */
	@JsonProperty("C_POS")
	public I_C_POSInput C_POS() {
		return mC_POS;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(I_C_ProjectInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Project_ID(foreignEntity.get_ID());
		} else {
			super.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public I_C_ProjectInput C_Project() {
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
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		MRefList_BH foreignEntity;
		if (DocAction != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (DocStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocStatus(foreignEntity.getValue());
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
	public void setDropShip_BPartnerInput(I_C_BPartnerInput DropShip_BPartner) {
		this.mDropShip_BPartner = DropShip_BPartner;
		MBPartner_BH foreignEntity;
		if (DropShip_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(DropShip_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDropShip_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setDropShip_BPartner_ID(0);
		}
	}

	/**
	 * Get Drop Ship Business Partner.
	 *
	 * @return Business Partner to ship to
	 */
	@JsonProperty("DropShip_BPartner")
	public I_C_BPartnerInput DropShip_BPartner() {
		return mDropShip_BPartner;
	}

	/**
	 * Set Drop Shipment Location.
	 *
	 * @param DropShip_Location Business Partner Location for shipping to
	 */
	@JsonProperty("DropShip_Location")
	public void setDropShip_LocationInput(I_C_BPartner_LocationInput DropShip_Location) {
		this.mDropShip_Location = DropShip_Location;
		MBPartnerLocation foreignEntity;
		if (DropShip_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(DropShip_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDropShip_Location_ID(foreignEntity.get_ID());
		} else {
			super.setDropShip_Location_ID(0);
		}
	}

	/**
	 * Get Drop Shipment Location.
	 *
	 * @return Business Partner Location for shipping to
	 */
	@JsonProperty("DropShip_Location")
	public I_C_BPartner_LocationInput DropShip_Location() {
		return mDropShip_Location;
	}

	/**
	 * Set Drop Shipment Contact.
	 *
	 * @param DropShip_User Business Partner Contact for drop shipment
	 */
	@JsonProperty("DropShip_User")
	public void setDropShip_UserInput(I_AD_UserInput DropShip_User) {
		this.mDropShip_User = DropShip_User;
		MUser_BH foreignEntity;
		if (DropShip_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(DropShip_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDropShip_User_ID(foreignEntity.get_ID());
		} else {
			super.setDropShip_User_ID(0);
		}
	}

	/**
	 * Get Drop Shipment Contact.
	 *
	 * @return Business Partner Contact for drop shipment
	 */
	@JsonProperty("DropShip_User")
	public I_AD_UserInput DropShip_User() {
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
	public void setLink_OrderInput(I_C_OrderInput Link_Order) {
		this.mLink_Order = Link_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 &&Link_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(Link_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setLink_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Linked Order.
	 *
	 * @return This field links a sales order to the purchase order that is generated from it.
	 */
	@JsonProperty("Link_Order")
	public I_C_OrderInput Link_Order() {
		return mLink_Order;
	}

	/**
	 * Set Freight Category.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	@JsonProperty("M_FreightCategory")
	public void setM_FreightCategoryInput(I_M_FreightCategoryInput M_FreightCategory) {
		this.mM_FreightCategory = M_FreightCategory;
		MFreightCategory foreignEntity;
		if (M_FreightCategory != null &&
				(foreignEntity = new Query(getCtx(), MFreightCategory.Table_Name, MFreightCategory.COLUMNNAME_M_FreightCategory_UU + "=?", get_TrxName())
						.setParameters(M_FreightCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_FreightCategory_ID(foreignEntity.get_ID());
		} else {
			super.setM_FreightCategory_ID(0);
		}
	}

	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	@JsonProperty("M_FreightCategory")
	public I_M_FreightCategoryInput M_FreightCategory() {
		return mM_FreightCategory;
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
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(I_M_ShipperInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), MShipper.Table_Name, MShipper.COLUMNNAME_M_Shipper_UU + "=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Shipper_ID(foreignEntity.get_ID());
		} else {
			super.setM_Shipper_ID(0);
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public I_M_ShipperInput M_Shipper() {
		return mM_Shipper;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(I_M_WarehouseInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			super.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public I_M_WarehouseInput M_Warehouse() {
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
		MRefList_BH foreignEntity;
		if (PriorityRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PriorityRule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPriorityRule(foreignEntity.getValue());
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
	public void setQuotationOrderInput(I_C_OrderInput QuotationOrder) {
		this.mQuotationOrder = QuotationOrder;
		MOrder_BH foreignEntity;
		if (QuotationOrder != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(QuotationOrder.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setQuotationOrder_ID(foreignEntity.get_ID());
		} else {
			super.setQuotationOrder_ID(0);
		}
	}

	/**
	 * Get Quotation.
	 *
	 * @return Quotation used for generating this order
	 */
	@JsonProperty("QuotationOrder")
	public I_C_OrderInput QuotationOrder() {
		return mQuotationOrder;
	}

	/**
	 * Set Referenced Order.
	 *
	 * @param Ref_Order Reference to corresponding Sales/Purchase Order
	 */
	@JsonProperty("Ref_Order")
	public void setRef_OrderInput(I_C_OrderInput Ref_Order) {
		this.mRef_Order = Ref_Order;
		MOrder_BH foreignEntity;
		if (Ref_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(Ref_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRef_Order_ID(foreignEntity.get_ID());
		} else {
			super.setRef_Order_ID(0);
		}
	}

	/**
	 * Get Referenced Order.
	 *
	 * @return Reference to corresponding Sales/Purchase Order
	 */
	@JsonProperty("Ref_Order")
	public I_C_OrderInput Ref_Order() {
		return mRef_Order;
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
	public void setUser1Input(I_C_ElementValueInput User1) {
		this.mUser1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUser1_ID(foreignEntity.get_ID());
		} else {
			super.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	@JsonProperty("User1")
	public I_C_ElementValueInput User1() {
		return mUser1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	@JsonProperty("User2")
	public void setUser2Input(I_C_ElementValueInput User2) {
		this.mUser2 = User2;
		MElementValue foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUser2_ID(foreignEntity.get_ID());
		} else {
			super.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	@JsonProperty("User2")
	public I_C_ElementValueInput User2() {
		return mUser2;
	}
}
