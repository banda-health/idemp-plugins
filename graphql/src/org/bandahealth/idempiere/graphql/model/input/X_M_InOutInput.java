package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
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
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput DeliveryRule_RL;
	 private I_AD_Ref_ListInput DeliveryViaRule_RL;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_Ref_ListInput FOB_RL;
	 private I_AD_Ref_ListInput FreightCharges_RL;
	 private I_AD_Ref_ListInput FreightCostRule_RL;
	 private I_AD_Ref_ListInput Insurance_RL;
	 private I_AD_Ref_ListInput MovementType_RL;
	 private I_AD_Ref_ListInput Posted_RL;
	 private I_AD_Ref_ListInput PriorityRule_RL;
	 private I_AD_UserInput AD_User;
	 private I_AD_UserInput DropShip_User;
	 private I_AD_UserInput ReturnUser;
	 private I_AD_UserInput SalesRep;
	 private I_BH_VisitInput BH_Visit;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BPartnerInput DropShip_BPartner;
	 private I_C_BPartnerInput ReturnBPartner;
	 private I_C_BPartner_LocationInput C_BPartner_Location;
	 private I_C_BPartner_LocationInput DropShip_Location;
	 private I_C_BPartner_LocationInput ReturnLocation;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_ChargeInput C_Charge;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_ElementValueInput User1;
	 private I_C_ElementValueInput User2;
	 private I_C_InvoiceInput C_Invoice;
	 private I_C_OrderInput C_Order;
	 private I_C_ProjectInput C_Project;
	 private I_M_InOutInput Reversal;
	 private I_M_RMAInput M_RMA;
	 private I_M_ShipperInput M_Shipper;
	 private I_M_WarehouseInput M_Warehouse;

	/**
	 * Standard constructor
	 */
	public X_M_InOutInput(String ID) {
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	public void setC_Invoice(I_C_InvoiceInput C_Invoice) {
		this.C_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (get_ID() == 0 &&C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Invoice_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public I_C_InvoiceInput getC_Invoice() {
		return C_Invoice;
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
	 * Set Drop Ship Business Partner.
	 *
	 * @param DropShip_BPartner Business Partner to ship to
	 */
	public void setDropShip_BPartner(I_C_BPartnerInput DropShip_BPartner) {
		this.DropShip_BPartner = DropShip_BPartner;
		MBPartner_BH foreignEntity;
		if (DropShip_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(DropShip_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDropShip_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setDropShip_BPartner_ID(0);
		}
	}

	/**
	 * Get Drop Ship Business Partner.
	 *
	 * @return Business Partner to ship to
	 */
	public I_C_BPartnerInput getDropShip_BPartner() {
		return DropShip_BPartner;
	}

	/**
	 * Set Drop Shipment Location.
	 *
	 * @param DropShip_Location Business Partner Location for shipping to
	 */
	public void setDropShip_Location(I_C_BPartner_LocationInput DropShip_Location) {
		this.DropShip_Location = DropShip_Location;
		MBPartnerLocation foreignEntity;
		if (DropShip_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(DropShip_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDropShip_Location_ID(foreignEntity.get_ID());
		} else {
			this.setDropShip_Location_ID(0);
		}
	}

	/**
	 * Get Drop Shipment Location.
	 *
	 * @return Business Partner Location for shipping to
	 */
	public I_C_BPartner_LocationInput getDropShip_Location() {
		return DropShip_Location;
	}

	/**
	 * Set Drop Shipment Contact.
	 *
	 * @param DropShip_User Business Partner Contact for drop shipment
	 */
	public void setDropShip_User(I_AD_UserInput DropShip_User) {
		this.DropShip_User = DropShip_User;
		MUser_BH foreignEntity;
		if (DropShip_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(DropShip_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDropShip_User_ID(foreignEntity.get_ID());
		} else {
			this.setDropShip_User_ID(0);
		}
	}

	/**
	 * Get Drop Shipment Contact.
	 *
	 * @return Business Partner Contact for drop shipment
	 */
	public I_AD_UserInput getDropShip_User() {
		return DropShip_User;
	}

	/**
	 * Set Freight Terms.
	 *
	 * @param FOB_RL Freight Terms
	 */
	public void setFOB_RL(I_AD_Ref_ListInput FOB_RL) {
		this.FOB_RL = FOB_RL;
		MRefList foreignEntity;
		if (FOB_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FOB_RL.getID())
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
	public I_AD_Ref_ListInput getFOB_RL() {
		return FOB_RL;
	}

	/**
	 * Set Freight Charges.
	 *
	 * @param FreightCharges_RL Freight Charges
	 */
	public void setFreightCharges_RL(I_AD_Ref_ListInput FreightCharges_RL) {
		this.FreightCharges_RL = FreightCharges_RL;
		MRefList foreignEntity;
		if (FreightCharges_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FreightCharges_RL.getID())
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
	public I_AD_Ref_ListInput getFreightCharges_RL() {
		return FreightCharges_RL;
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
	 * Set Insurance.
	 *
	 * @param Insurance_RL Insurance
	 */
	public void setInsurance_RL(I_AD_Ref_ListInput Insurance_RL) {
		this.Insurance_RL = Insurance_RL;
		MRefList foreignEntity;
		if (Insurance_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Insurance_RL.getID())
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
	public I_AD_Ref_ListInput getInsurance_RL() {
		return Insurance_RL;
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
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	public void setM_Shipper(I_M_ShipperInput M_Shipper) {
		this.M_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), MShipper.Table_Name, MShipper.COLUMNNAME_M_Shipper_UU + "=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Shipper_ID(foreignEntity.get_ID());
		} else {
			this.setM_Shipper_ID(0);
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public I_M_ShipperInput getM_Shipper() {
		return M_Shipper;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	public void setM_Warehouse(I_M_WarehouseInput M_Warehouse) {
		this.M_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (get_ID() == 0 &&M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Warehouse_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public I_M_WarehouseInput getM_Warehouse() {
		return M_Warehouse;
	}

	/**
	 * Set Movement Type.
	 *
	 * @param MovementType_RL Method of moving the inventory
	 */
	public void setMovementType_RL(I_AD_Ref_ListInput MovementType_RL) {
		this.MovementType_RL = MovementType_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&MovementType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MovementType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMovementType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Movement Type.
	 *
	 * @return Method of moving the inventory
	 */
	public I_AD_Ref_ListInput getMovementType_RL() {
		return MovementType_RL;
	}

	/**
	 * Set Posted.
	 *
	 * @param Posted_RL Posting status
	 */
	public void setPosted_RL(I_AD_Ref_ListInput Posted_RL) {
		this.Posted_RL = Posted_RL;
		MRefList foreignEntity;
		if (Posted_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Posted_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPosted(foreignEntity.getValue());
		} else {
			this.setPosted(null);
		}
	}

	/**
	 * Get Posted.
	 *
	 * @return Posting status
	 */
	public I_AD_Ref_ListInput getPosted_RL() {
		return Posted_RL;
	}

	/**
	 * Set Priority.
	 *
	 * @param PriorityRule_RL Priority of a document
	 */
	public void setPriorityRule_RL(I_AD_Ref_ListInput PriorityRule_RL) {
		this.PriorityRule_RL = PriorityRule_RL;
		MRefList foreignEntity;
		if (PriorityRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PriorityRule_RL.getID())
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
	public I_AD_Ref_ListInput getPriorityRule_RL() {
		return PriorityRule_RL;
	}

	/**
	 * Set Return Partner.
	 *
	 * @param ReturnBPartner Return Partner
	 */
	public void setReturnBPartner(I_C_BPartnerInput ReturnBPartner) {
		this.ReturnBPartner = ReturnBPartner;
		MBPartner_BH foreignEntity;
		if (ReturnBPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(ReturnBPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReturnBPartner_ID(foreignEntity.get_ID());
		} else {
			this.setReturnBPartner_ID(0);
		}
	}

	/**
	 * Get Return Partner.
	 *
	 * @return Return Partner
	 */
	public I_C_BPartnerInput getReturnBPartner() {
		return ReturnBPartner;
	}

	/**
	 * Set Return Location.
	 *
	 * @param ReturnLocation Return Location
	 */
	public void setReturnLocation(I_C_BPartner_LocationInput ReturnLocation) {
		this.ReturnLocation = ReturnLocation;
		MBPartnerLocation foreignEntity;
		if (ReturnLocation != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(ReturnLocation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReturnLocation_ID(foreignEntity.get_ID());
		} else {
			this.setReturnLocation_ID(0);
		}
	}

	/**
	 * Get Return Location.
	 *
	 * @return Return Location
	 */
	public I_C_BPartner_LocationInput getReturnLocation() {
		return ReturnLocation;
	}

	/**
	 * Set Return User/Contact.
	 *
	 * @param ReturnUser Return User/Contact
	 */
	public void setReturnUser(I_AD_UserInput ReturnUser) {
		this.ReturnUser = ReturnUser;
		MUser_BH foreignEntity;
		if (ReturnUser != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(ReturnUser.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReturnUser_ID(foreignEntity.get_ID());
		} else {
			this.setReturnUser_ID(0);
		}
	}

	/**
	 * Get Return User/Contact.
	 *
	 * @return Return User/Contact
	 */
	public I_AD_UserInput getReturnUser() {
		return ReturnUser;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	public void setReversal(I_M_InOutInput Reversal) {
		this.Reversal = Reversal;
		MInOut_BH foreignEntity;
		if (Reversal != null &&
				(foreignEntity = new Query(getCtx(), MInOut_BH.Table_Name, MInOut_BH.COLUMNNAME_M_InOut_UU + "=?", get_TrxName())
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
	public I_M_InOutInput getReversal() {
		return Reversal;
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
}
