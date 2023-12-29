package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashLine;
import org.compiere.model.MCashPlanLine;
import org.compiere.model.MConversionType;
import org.compiere.model.MCurrency;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MProject;
import org.compiere.model.MRMA;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_Invoice;
import org.compiere.util.Env;

/**
 * Generated Model for C_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceInput extends X_C_Invoice implements I_C_InvoiceInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_Ref_ListInput InvoiceCollectionType_RL;
	 private I_AD_UserInput AD_User;
	 private I_AD_UserInput SalesRep;
	 private I_BH_VisitInput BH_Visit;
	 private I_BH_Voided_ReasonInput BH_Voided_Reason;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BPartner_LocationInput C_BPartner_Location;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_CashLineInput C_CashLine;
	 private I_C_CashPlanLineInput C_CashPlanLine;
	 private I_C_ChargeInput C_Charge;
	 private I_C_ConversionTypeInput C_ConversionType;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_DocTypeInput C_DocTypeTarget;
	 private I_C_DunningLevelInput C_DunningLevel;
	 private I_C_ElementValueInput User1;
	 private I_C_ElementValueInput User2;
	 private I_C_InvoiceInput RelatedInvoice;
	 private I_C_InvoiceInput Reversal;
	 private I_C_OrderInput C_Order;
	 private I_C_PaymentInput C_Payment;
	 private I_C_PaymentTermInput C_PaymentTerm;
	 private I_C_ProjectInput C_Project;
	 private I_M_PriceListInput M_PriceList;
	 private I_M_RMAInput M_RMA;

	/**
	 * Standard constructor
	 */
	public X_C_InvoiceInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	public void setBH_NavButtons(Object BH_NavButtons) {
		set_Value(COLUMNNAME_BH_NavButtons, BH_NavButtons);
	}


	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	public Object getBH_NavButtons() {
 		return get_Value(COLUMNNAME_BH_NavButtons);
	}


	/**
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	public void setBH_Visit(I_BH_VisitInput BH_Visit) {
		this.BH_Visit = BH_Visit;
		MBHVisit foreignEntity;
		if (BH_Visit != null &&
				(foreignEntity = new Query(getCtx(), MBHVisit.Table_Name, MBHVisit.COLUMNNAME_BH_Visit_UU + "=?", get_TrxName())
						.setParameters(BH_Visit.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Visit_ID(foreignEntity.get_ID());
		} else {
			this.setBH_Visit_ID(0);
		}
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public I_BH_VisitInput getBH_Visit() {
		return BH_Visit;
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */
	public void setBH_Visit_ID(int BH_Visit_ID) {
		if (BH_Visit_ID < 1) {
			set_Value(COLUMNNAME_BH_Visit_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_Visit_ID, BH_Visit_ID);
		}
	}


	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public int getBH_Visit_ID() {
 		Integer columnValue = (Integer) get_Value(COLUMNNAME_BH_Visit_ID);
		if (columnValue == null) {
			return 0;
		}
		return columnValue;
	}


	/**
	 * Set BH_Voided_Reason_ID.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason_ID
	 */
	public void setBH_Voided_Reason(I_BH_Voided_ReasonInput BH_Voided_Reason) {
		this.BH_Voided_Reason = BH_Voided_Reason;
		MBHVoidedReason foreignEntity;
		if (BH_Voided_Reason != null &&
				(foreignEntity = new Query(getCtx(), MBHVoidedReason.Table_Name, MBHVoidedReason.COLUMNNAME_BH_Voided_Reason_UU + "=?", get_TrxName())
						.setParameters(BH_Voided_Reason.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Voided_Reason_ID(foreignEntity.get_ID());
		} else {
			this.setBH_Voided_Reason_ID(0);
		}
	}

	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	public I_BH_Voided_ReasonInput getBH_Voided_Reason() {
		return BH_Voided_Reason;
	}

	/**
	 * Set BH_Voided_Reason_ID.
	 *
	 * @param BH_Voided_Reason_ID BH_Voided_Reason_ID
	 */
	public void setBH_Voided_Reason_ID(int BH_Voided_Reason_ID) {
		if (BH_Voided_Reason_ID < 1) {
			set_Value(COLUMNNAME_BH_Voided_Reason_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_Voided_Reason_ID, BH_Voided_Reason_ID);
		}
	}


	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	public int getBH_Voided_Reason_ID() {
 		Integer columnValue = (Integer) get_Value(COLUMNNAME_BH_Voided_Reason_ID);
		if (columnValue == null) {
			return 0;
		}
		return columnValue;
	}


	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	public void setC_Activity(I_C_ActivityInput C_Activity) {
		this.C_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public I_C_ActivityInput getC_Activity() {
		return C_Activity;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	public void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.C_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public I_C_BPartner_LocationInput getC_BPartner_Location() {
		return C_BPartner_Location;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public I_C_CampaignInput getC_Campaign() {
		return C_Campaign;
	}

	/**
	 * Set Cash Journal Line.
	 *
	 * @param C_CashLine Cash Journal Line
	 */
	public void setC_CashLine(I_C_CashLineInput C_CashLine) {
		this.C_CashLine = C_CashLine;
		MCashLine foreignEntity;
		if (C_CashLine != null &&
				(foreignEntity = new Query(getCtx(), MCashLine.Table_Name, MCashLine.COLUMNNAME_C_CashLine_UU + "=?", get_TrxName())
						.setParameters(C_CashLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_CashLine_ID(foreignEntity.get_ID());
		} else {
			this.setC_CashLine_ID(0);
		}
	}

	/**
	 * Get Cash Journal Line.
	 *
	 * @return Cash Journal Line
	 */
	public I_C_CashLineInput getC_CashLine() {
		return C_CashLine;
	}

	/**
	 * Set Cash Plan Line.
	 *
	 * @param C_CashPlanLine Cash Plan Line
	 */
	public void setC_CashPlanLine(I_C_CashPlanLineInput C_CashPlanLine) {
		this.C_CashPlanLine = C_CashPlanLine;
		MCashPlanLine foreignEntity;
		if (C_CashPlanLine != null &&
				(foreignEntity = new Query(getCtx(), MCashPlanLine.Table_Name, MCashPlanLine.COLUMNNAME_C_CashPlanLine_UU + "=?", get_TrxName())
						.setParameters(C_CashPlanLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_CashPlanLine_ID(foreignEntity.get_ID());
		} else {
			this.setC_CashPlanLine_ID(0);
		}
	}

	/**
	 * Get Cash Plan Line.
	 *
	 * @return Cash Plan Line
	 */
	public I_C_CashPlanLineInput getC_CashPlanLine() {
		return C_CashPlanLine;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	public void setC_Charge(I_C_ChargeInput C_Charge) {
		this.C_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public I_C_ChargeInput getC_Charge() {
		return C_Charge;
	}
	/**
	 * Set Charge.
	 *
	 * @param C_Charge_ID Additional document charges
	 */

	public void setC_Charge_ID(int C_Charge_ID) {
		if (get_ID() == 0) {
			super.setC_Charge_ID(C_Charge_ID);
		}
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	public void setC_ConversionType(I_C_ConversionTypeInput C_ConversionType) {
		this.C_ConversionType = C_ConversionType;
		MConversionType foreignEntity;
		if (C_ConversionType != null &&
				(foreignEntity = new Query(getCtx(), MConversionType.Table_Name, MConversionType.COLUMNNAME_C_ConversionType_UU + "=?", get_TrxName())
						.setParameters(C_ConversionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ConversionType_ID(foreignEntity.get_ID());
		} else {
			this.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public I_C_ConversionTypeInput getC_ConversionType() {
		return C_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	public void setC_DocType(I_C_DocTypeInput C_DocType) {
		this.C_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (get_ID() == 0 &&C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public I_C_DocTypeInput getC_DocType() {
		return C_DocType;
	}
	/**
	 * Set Document Type.
	 *
	 * @param C_DocType_ID Document type or rules
	 */

	public void setC_DocType_ID(int C_DocType_ID) {
		if (get_ID() == 0) {
			super.setC_DocType_ID(C_DocType_ID);
		}
	}

	/**
	 * Set Target Document Type.
	 *
	 * @param C_DocTypeTarget Target document type for conversing documents
	 */
	public void setC_DocTypeTarget(I_C_DocTypeInput C_DocTypeTarget) {
		this.C_DocTypeTarget = C_DocTypeTarget;
		MDocType_BH foreignEntity;
		if (C_DocTypeTarget != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeTarget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocTypeTarget_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocTypeTarget_ID(0);
		}
	}

	/**
	 * Get Target Document Type.
	 *
	 * @return Target document type for conversing documents
	 */
	public I_C_DocTypeInput getC_DocTypeTarget() {
		return C_DocTypeTarget;
	}
	/**
	 * Set Target Document Type.
	 *
	 * @param C_DocTypeTarget_ID Target document type for conversing documents
	 */

	public void setC_DocTypeTarget_ID(int C_DocTypeTarget_ID) {
		if (get_ID() == 0) {
			super.setC_DocTypeTarget_ID(C_DocTypeTarget_ID);
		}
	}

	/**
	 * Set Dunning Level.
	 *
	 * @param C_DunningLevel Dunning Level
	 */
	public void setC_DunningLevel(I_C_DunningLevelInput C_DunningLevel) {
		this.C_DunningLevel = C_DunningLevel;
		MDunningLevel foreignEntity;
		if (C_DunningLevel != null &&
				(foreignEntity = new Query(getCtx(), MDunningLevel.Table_Name, MDunningLevel.COLUMNNAME_C_DunningLevel_UU + "=?", get_TrxName())
						.setParameters(C_DunningLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DunningLevel_ID(foreignEntity.get_ID());
		} else {
			this.setC_DunningLevel_ID(0);
		}
	}

	/**
	 * Get Dunning Level.
	 *
	 * @return Dunning Level
	 */
	public I_C_DunningLevelInput getC_DunningLevel() {
		return C_DunningLevel;
	}
	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice_ID Invoice Identifier
	 */

	public void setC_Invoice_ID(int C_Invoice_ID) {
		if (get_ID() == 0) {
			super.setC_Invoice_ID(C_Invoice_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Invoice_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Invoice_UU();
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	public void setC_Order(I_C_OrderInput C_Order) {
		this.C_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 &&C_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public I_C_OrderInput getC_Order() {
		return C_Order;
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
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	public void setC_Payment(I_C_PaymentInput C_Payment) {
		this.C_Payment = C_Payment;
		MPayment_BH foreignEntity;
		if (C_Payment != null &&
				(foreignEntity = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", get_TrxName())
						.setParameters(C_Payment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Payment_ID(foreignEntity.get_ID());
		} else {
			this.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public I_C_PaymentInput getC_Payment() {
		return C_Payment;
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
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}
	/**
	 * Set Date Ordered.
	 *
	 * @param DateOrdered Date of Order
	 */

	public void setDateOrdered(Timestamp DateOrdered) {
		if (get_ID() == 0) {
			super.setDateOrdered(DateOrdered);
		}
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	public void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL) {
		this.DocAction_RL = DocAction_RL;
		MRefList foreignEntity;
		if (DocAction_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction_RL.getID())
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
	public I_AD_Ref_ListInput getDocAction_RL() {
		return DocAction_RL;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	public void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL) {
		this.DocStatus_RL = DocStatus_RL;
		MRefList foreignEntity;
		if (DocStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus_RL.getID())
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
	public I_AD_Ref_ListInput getDocStatus_RL() {
		return DocStatus_RL;
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
	 * Set Collection Status.
	 *
	 * @param InvoiceCollectionType_RL Invoice Collection Status
	 */
	public void setInvoiceCollectionType_RL(I_AD_Ref_ListInput InvoiceCollectionType_RL) {
		this.InvoiceCollectionType_RL = InvoiceCollectionType_RL;
		MRefList foreignEntity;
		if (InvoiceCollectionType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceCollectionType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInvoiceCollectionType(foreignEntity.getValue());
		} else {
			this.setInvoiceCollectionType(null);
		}
	}

	/**
	 * Get Collection Status.
	 *
	 * @return Invoice Collection Status
	 */
	public I_AD_Ref_ListInput getInvoiceCollectionType_RL() {
		return InvoiceCollectionType_RL;
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
	 * Set Pay Schedule valid.
	 *
	 * @param IsPayScheduleValid Is the Payment Schedule is valid
	 */

	public void setIsPayScheduleValid(boolean IsPayScheduleValid) {
		if (get_ID() == 0) {
			super.setIsPayScheduleValid(IsPayScheduleValid);
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
	 * Set Sales Transaction.
	 *
	 * @param IsSOTrx This is a Sales Transaction
	 */

	public void setIsSOTrx(boolean IsSOTrx) {
		if (get_ID() == 0) {
			super.setIsSOTrx(IsSOTrx);
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
	 * Set RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	public void setM_RMA(I_M_RMAInput M_RMA) {
		this.M_RMA = M_RMA;
		MRMA foreignEntity;
		if (M_RMA != null &&
				(foreignEntity = new Query(getCtx(), MRMA.Table_Name, MRMA.COLUMNNAME_M_RMA_UU + "=?", get_TrxName())
						.setParameters(M_RMA.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_RMA_ID(foreignEntity.get_ID());
		} else {
			this.setM_RMA_ID(0);
		}
	}

	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	public I_M_RMAInput getM_RMA() {
		return M_RMA;
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
	 * Set Related Invoice.
	 *
	 * @param RelatedInvoice Related Invoice
	 */
	public void setRelatedInvoice(I_C_InvoiceInput RelatedInvoice) {
		this.RelatedInvoice = RelatedInvoice;
		MInvoice_BH foreignEntity;
		if (RelatedInvoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(RelatedInvoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRelatedInvoice_ID(foreignEntity.get_ID());
		} else {
			this.setRelatedInvoice_ID(0);
		}
	}

	/**
	 * Get Related Invoice.
	 *
	 * @return Related Invoice
	 */
	public I_C_InvoiceInput getRelatedInvoice() {
		return RelatedInvoice;
	}
	/**
	 * Set Related Invoice.
	 *
	 * @param RelatedInvoice_ID Related Invoice
	 */

	public void setRelatedInvoice_ID(int RelatedInvoice_ID) {
		if (get_ID() == 0) {
			super.setRelatedInvoice_ID(RelatedInvoice_ID);
		}
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	public void setReversal(I_C_InvoiceInput Reversal) {
		this.Reversal = Reversal;
		MInvoice_BH foreignEntity;
		if (Reversal != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(Reversal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReversal_ID(foreignEntity.get_ID());
		} else {
			this.setReversal_ID(0);
		}
	}

	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public I_C_InvoiceInput getReversal() {
		return Reversal;
	}
	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal_ID ID of document reversal
	 */

	public void setReversal_ID(int Reversal_ID) {
		if (get_ID() == 0) {
			super.setReversal_ID(Reversal_ID);
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
	public void setUser1(I_C_ElementValueInput User1) {
		this.User1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser1_ID(foreignEntity.get_ID());
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public I_C_ElementValueInput getUser1() {
		return User1;
	}
	/**
	 * Set User Element List 1.
	 *
	 * @param User1_ID User defined list element #1
	 */

	public void setUser1_ID(int User1_ID) {
		if (get_ID() == 0) {
			super.setUser1_ID(User1_ID);
		}
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	public void setUser2(I_C_ElementValueInput User2) {
		this.User2 = User2;
		MElementValue foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser2_ID(foreignEntity.get_ID());
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public I_C_ElementValueInput getUser2() {
		return User2;
	}
	/**
	 * Set User Element List 2.
	 *
	 * @param User2_ID User defined list element #2
	 */

	public void setUser2_ID(int User2_ID) {
		if (get_ID() == 0) {
			super.setUser2_ID(User2_ID);
		}
	}
}
