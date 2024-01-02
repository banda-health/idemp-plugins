package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRMA;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_InOut - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutInput extends MInOut_BH implements I_M_InOutInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mDeliveryRule;
	 private I_AD_Ref_ListInput mDeliveryViaRule;
	 private I_AD_Ref_ListInput mDocAction;
	 private I_AD_Ref_ListInput mDocStatus;
	 private I_AD_Ref_ListInput mFOB;
	 private I_AD_Ref_ListInput mFreightCharges;
	 private I_AD_Ref_ListInput mFreightCostRule;
	 private I_AD_Ref_ListInput mInsurance;
	 private I_AD_Ref_ListInput mMovementType;
	 private I_AD_Ref_ListInput mPriorityRule;
	 private I_AD_UserInput mAD_User;
	 private I_AD_UserInput mDropShip_User;
	 private I_AD_UserInput mReturnUser;
	 private I_AD_UserInput mSalesRep;
	 private I_BH_VisitInput mBH_Visit;
	 private I_C_ActivityInput mC_Activity;
	 private I_C_BPartnerInput mC_BPartner;
	 private I_C_BPartnerInput mDropShip_BPartner;
	 private I_C_BPartnerInput mReturnBPartner;
	 private I_C_BPartner_LocationInput mC_BPartner_Location;
	 private I_C_BPartner_LocationInput mDropShip_Location;
	 private I_C_BPartner_LocationInput mReturnLocation;
	 private I_C_CampaignInput mC_Campaign;
	 private I_C_ChargeInput mC_Charge;
	 private I_C_DocTypeInput mC_DocType;
	 private I_C_ElementValueInput mUser1;
	 private I_C_ElementValueInput mUser2;
	 private I_C_InvoiceInput mC_Invoice;
	 private I_C_OrderInput mC_Order;
	 private I_C_ProjectInput mC_Project;
	 private I_M_InOutInput mReversal;
	 private I_M_RMAInput mM_RMA;
	 private I_M_ShipperInput mM_Shipper;
	 private I_M_WarehouseInput mM_Warehouse;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_InOutInput(@JsonProperty("ID") String ID) {
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(I_C_InvoiceInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (get_ID() == 0 &&C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Invoice_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public I_C_InvoiceInput C_Invoice() {
		return mC_Invoice;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(I_C_OrderInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 &&C_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public I_C_OrderInput C_Order() {
		return mC_Order;
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
	 * Set Freight Terms.
	 *
	 * @param FOB Freight Terms
	 */
	@JsonProperty("FOB")
	public void setFOBInput(I_AD_Ref_ListInput FOB) {
		this.mFOB = FOB;
		MRefList_BH foreignEntity;
		if (FOB != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FOB.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFOB(foreignEntity.getValue());
		} else {
			this.setFOB(null);
		}
	}

	/**
	 * Get Freight Terms.
	 *
	 * @return Freight Terms
	 */
	@JsonProperty("FOB")
	public I_AD_Ref_ListInput FOB() {
		return mFOB;
	}

	/**
	 * Set Freight Charges.
	 *
	 * @param FreightCharges Freight Charges
	 */
	@JsonProperty("FreightCharges")
	public void setFreightChargesInput(I_AD_Ref_ListInput FreightCharges) {
		this.mFreightCharges = FreightCharges;
		MRefList_BH foreignEntity;
		if (FreightCharges != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FreightCharges.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFreightCharges(foreignEntity.getValue());
		} else {
			this.setFreightCharges(null);
		}
	}

	/**
	 * Get Freight Charges.
	 *
	 * @return Freight Charges
	 */
	@JsonProperty("FreightCharges")
	public I_AD_Ref_ListInput FreightCharges() {
		return mFreightCharges;
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
	 * Set Insurance.
	 *
	 * @param Insurance Insurance
	 */
	@JsonProperty("Insurance")
	public void setInsuranceInput(I_AD_Ref_ListInput Insurance) {
		this.mInsurance = Insurance;
		MRefList_BH foreignEntity;
		if (Insurance != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Insurance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInsurance(foreignEntity.getValue());
		} else {
			this.setInsurance(null);
		}
	}

	/**
	 * Get Insurance.
	 *
	 * @return Insurance
	 */
	@JsonProperty("Insurance")
	public I_AD_Ref_ListInput Insurance() {
		return mInsurance;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_InOut_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_InOut_UU();
	}

	/**
	 * Set RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	@JsonProperty("M_RMA")
	public void setM_RMAInput(I_M_RMAInput M_RMA) {
		this.mM_RMA = M_RMA;
		MRMA foreignEntity;
		if (M_RMA != null &&
				(foreignEntity = new Query(getCtx(), MRMA.Table_Name, MRMA.COLUMNNAME_M_RMA_UU + "=?", get_TrxName())
						.setParameters(M_RMA.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_RMA_ID(foreignEntity.get_ID());
		} else {
			super.setM_RMA_ID(0);
		}
	}

	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	@JsonProperty("M_RMA")
	public I_M_RMAInput M_RMA() {
		return mM_RMA;
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
		if (get_ID() == 0 &&M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
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
	 * Set Movement Type.
	 *
	 * @param MovementType Method of moving the inventory
	 */
	@JsonProperty("MovementType")
	public void setMovementTypeInput(I_AD_Ref_ListInput MovementType) {
		this.mMovementType = MovementType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&MovementType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MovementType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMovementType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Movement Type.
	 *
	 * @return Method of moving the inventory
	 */
	@JsonProperty("MovementType")
	public I_AD_Ref_ListInput MovementType() {
		return mMovementType;
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
	 * Set Return Partner.
	 *
	 * @param ReturnBPartner Return Partner
	 */
	@JsonProperty("ReturnBPartner")
	public void setReturnBPartnerInput(I_C_BPartnerInput ReturnBPartner) {
		this.mReturnBPartner = ReturnBPartner;
		MBPartner_BH foreignEntity;
		if (ReturnBPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(ReturnBPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setReturnBPartner_ID(foreignEntity.get_ID());
		} else {
			super.setReturnBPartner_ID(0);
		}
	}

	/**
	 * Get Return Partner.
	 *
	 * @return Return Partner
	 */
	@JsonProperty("ReturnBPartner")
	public I_C_BPartnerInput ReturnBPartner() {
		return mReturnBPartner;
	}

	/**
	 * Set Return Location.
	 *
	 * @param ReturnLocation Return Location
	 */
	@JsonProperty("ReturnLocation")
	public void setReturnLocationInput(I_C_BPartner_LocationInput ReturnLocation) {
		this.mReturnLocation = ReturnLocation;
		MBPartnerLocation foreignEntity;
		if (ReturnLocation != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(ReturnLocation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setReturnLocation_ID(foreignEntity.get_ID());
		} else {
			super.setReturnLocation_ID(0);
		}
	}

	/**
	 * Get Return Location.
	 *
	 * @return Return Location
	 */
	@JsonProperty("ReturnLocation")
	public I_C_BPartner_LocationInput ReturnLocation() {
		return mReturnLocation;
	}

	/**
	 * Set Return User/Contact.
	 *
	 * @param ReturnUser Return User/Contact
	 */
	@JsonProperty("ReturnUser")
	public void setReturnUserInput(I_AD_UserInput ReturnUser) {
		this.mReturnUser = ReturnUser;
		MUser_BH foreignEntity;
		if (ReturnUser != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(ReturnUser.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setReturnUser_ID(foreignEntity.get_ID());
		} else {
			super.setReturnUser_ID(0);
		}
	}

	/**
	 * Get Return User/Contact.
	 *
	 * @return Return User/Contact
	 */
	@JsonProperty("ReturnUser")
	public I_AD_UserInput ReturnUser() {
		return mReturnUser;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	@JsonProperty("Reversal")
	public void setReversalInput(I_M_InOutInput Reversal) {
		this.mReversal = Reversal;
		MInOut_BH foreignEntity;
		if (Reversal != null &&
				(foreignEntity = new Query(getCtx(), MInOut_BH.Table_Name, MInOut_BH.COLUMNNAME_M_InOut_UU + "=?", get_TrxName())
						.setParameters(Reversal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setReversal_ID(foreignEntity.get_ID());
		} else {
			super.setReversal_ID(0);
		}
	}

	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	@JsonProperty("Reversal")
	public I_M_InOutInput Reversal() {
		return mReversal;
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
