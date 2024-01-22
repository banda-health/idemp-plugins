package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MPackage;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.MShipperPickupTypes;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.MShippingTransaction;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_ShippingAcct;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShippingTransactionInput extends MShippingTransaction implements I_M_ShippingTransactionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mBill_Location;
	private ForeignEntityInput mC_BP_ShippingAcct;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_UOM_Length;
	private ForeignEntityInput mC_UOM_Weight;
	private ForeignEntityInput mHoldAddress;
	private ForeignEntityInput mM_InOut;
	private ForeignEntityInput mM_Package;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperLabels;
	private ForeignEntityInput mM_ShipperPackaging;
	private ForeignEntityInput mM_ShipperPickupTypes;
	private ForeignEntityInput mM_ShippingProcessor;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mReturnBPartner;
	private ForeignEntityInput mReturnLocation;
	private ForeignEntityInput mReturnUser;
	private ForeignEntityInput mSalesRep;
	private I_AD_Ref_ListInput mAction;
	private I_AD_Ref_ListInput mDeliveryConfirmationType;
	private I_AD_Ref_ListInput mDotHazardClassOrDivision;
	private I_AD_Ref_ListInput mFOB;
	private I_AD_Ref_ListInput mFreightCharges;
	private I_AD_Ref_ListInput mHomeDeliveryPremiumType;
	private I_AD_Ref_ListInput mInsurance;
	private I_AD_Ref_ListInput mNotificationType;
	private I_AD_Ref_ListInput mPaymentRule;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShippingTransactionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MShippingTransaction(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Action.
	 *
	 * @param Action Indicates the Action to be performed
	 */
	@JsonProperty("Action")
	public void setActionInput(I_AD_Ref_ListInput Action) {
		this.mAction = Action;
		MRefList_BH foreignEntity;
		if (Action != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Action.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAction(foreignEntity.getValue());
		} else {
			this.setAction(null);
		}
	}

	/**
	 * Get Action.
	 *
	 * @return Indicates the Action to be performed
	 */
	@JsonProperty("Action")
	public I_AD_Ref_ListInput Action() {
		return mAction;
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Invoice Location.
	 *
	 * @param Bill_Location Business Partner Location for invoicing
	 */
	@JsonProperty("Bill_Location")
	public void setBill_LocationInput(ForeignEntityInput Bill_Location) {
		this.mBill_Location = Bill_Location;
		MBPartnerLocation foreignEntity;
		if (Bill_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
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
	public ForeignEntityInput Bill_Location() {
		return mBill_Location;
	}

	/**
	 * Set Business Partner Shipping Account.
	 *
	 * @param C_BP_ShippingAcct Business Partner Shipping Account
	 */
	@JsonProperty("C_BP_ShippingAcct")
	public void setC_BP_ShippingAcctInput(ForeignEntityInput C_BP_ShippingAcct) {
		this.mC_BP_ShippingAcct = C_BP_ShippingAcct;
		X_C_BP_ShippingAcct foreignEntity;
		if (C_BP_ShippingAcct != null &&
				(foreignEntity = new Query(getCtx(), "C_BP_ShippingAcct", "C_BP_ShippingAcct_UU=?", get_TrxName())
						.setParameters(C_BP_ShippingAcct.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BP_ShippingAcct_ID(foreignEntity.get_ID());
		} else {
			super.setC_BP_ShippingAcct_ID(0);
		}
	}

	/**
	 * Get Business Partner Shipping Account.
	 *
	 * @return Business Partner Shipping Account
	 */
	@JsonProperty("C_BP_ShippingAcct")
	public ForeignEntityInput C_BP_ShippingAcct() {
		return mC_BP_ShippingAcct;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
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
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
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
	public ForeignEntityInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Invoice_ID(foreignEntity.get_ID());
		} else {
			super.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public ForeignEntityInput C_Invoice() {
		return mC_Invoice;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (C_Order != null &&
				(foreignEntity = new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Order_ID(foreignEntity.get_ID());
		} else {
			super.setC_Order_ID(0);
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}

	/**
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public void setC_UOM_LengthInput(ForeignEntityInput C_UOM_Length) {
		this.mC_UOM_Length = C_UOM_Length;
		MUOM foreignEntity;
		if (C_UOM_Length != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM_Length.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_Length_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_Length_ID(0);
		}
	}

	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public ForeignEntityInput C_UOM_Length() {
		return mC_UOM_Length;
	}

	/**
	 * Set UOM for Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public void setC_UOM_WeightInput(ForeignEntityInput C_UOM_Weight) {
		this.mC_UOM_Weight = C_UOM_Weight;
		MUOM foreignEntity;
		if (C_UOM_Weight != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM_Weight.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_Weight_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_Weight_ID(0);
		}
	}

	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public ForeignEntityInput C_UOM_Weight() {
		return mC_UOM_Weight;
	}

	/**
	 * Set Delivery Confirmation Type.
	 *
	 * @param DeliveryConfirmationType Delivery Confirmation Type
	 */
	@JsonProperty("DeliveryConfirmationType")
	public void setDeliveryConfirmationTypeInput(I_AD_Ref_ListInput DeliveryConfirmationType) {
		this.mDeliveryConfirmationType = DeliveryConfirmationType;
		MRefList_BH foreignEntity;
		if (DeliveryConfirmationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DeliveryConfirmationType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDeliveryConfirmationType(foreignEntity.getValue());
		} else {
			this.setDeliveryConfirmationType(null);
		}
	}

	/**
	 * Get Delivery Confirmation Type.
	 *
	 * @return Delivery Confirmation Type
	 */
	@JsonProperty("DeliveryConfirmationType")
	public I_AD_Ref_ListInput DeliveryConfirmationType() {
		return mDeliveryConfirmationType;
	}

	/**
	 * Set Dot Hazard Class or Division.
	 *
	 * @param DotHazardClassOrDivision Dot Hazard Class or Division
	 */
	@JsonProperty("DotHazardClassOrDivision")
	public void setDotHazardClassOrDivisionInput(I_AD_Ref_ListInput DotHazardClassOrDivision) {
		this.mDotHazardClassOrDivision = DotHazardClassOrDivision;
		MRefList_BH foreignEntity;
		if (DotHazardClassOrDivision != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DotHazardClassOrDivision.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDotHazardClassOrDivision(foreignEntity.getValue());
		} else {
			this.setDotHazardClassOrDivision(null);
		}
	}

	/**
	 * Get Dot Hazard Class or Division.
	 *
	 * @return Dot Hazard Class or Division
	 */
	@JsonProperty("DotHazardClassOrDivision")
	public I_AD_Ref_ListInput DotHazardClassOrDivision() {
		return mDotHazardClassOrDivision;
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
		if (get_ID() == 0 &&FOB != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FOB.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFOB(foreignEntity.getValue());
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
		if (get_ID() == 0 &&FreightCharges != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FreightCharges.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFreightCharges(foreignEntity.getValue());
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
	 * Set Hold Address.
	 *
	 * @param HoldAddress Hold Address
	 */
	@JsonProperty("HoldAddress")
	public void setHoldAddressInput(ForeignEntityInput HoldAddress) {
		this.mHoldAddress = HoldAddress;
		MBPartnerLocation foreignEntity;
		if (HoldAddress != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
						.setParameters(HoldAddress.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHoldAddress_ID(foreignEntity.get_ID());
		} else {
			super.setHoldAddress_ID(0);
		}
	}

	/**
	 * Get Hold Address.
	 *
	 * @return Hold Address
	 */
	@JsonProperty("HoldAddress")
	public ForeignEntityInput HoldAddress() {
		return mHoldAddress;
	}

	/**
	 * Set Home Delivery Premium Type.
	 *
	 * @param HomeDeliveryPremiumType Home Delivery Premium Type
	 */
	@JsonProperty("HomeDeliveryPremiumType")
	public void setHomeDeliveryPremiumTypeInput(I_AD_Ref_ListInput HomeDeliveryPremiumType) {
		this.mHomeDeliveryPremiumType = HomeDeliveryPremiumType;
		MRefList_BH foreignEntity;
		if (HomeDeliveryPremiumType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(HomeDeliveryPremiumType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setHomeDeliveryPremiumType(foreignEntity.getValue());
		} else {
			this.setHomeDeliveryPremiumType(null);
		}
	}

	/**
	 * Get Home Delivery Premium Type.
	 *
	 * @return Home Delivery Premium Type
	 */
	@JsonProperty("HomeDeliveryPremiumType")
	public I_AD_Ref_ListInput HomeDeliveryPremiumType() {
		return mHomeDeliveryPremiumType;
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
		if (get_ID() == 0 &&Insurance != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Insurance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInsurance(foreignEntity.getValue());
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
	 * Set Shipment/Receipt.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	@JsonProperty("M_InOut")
	public void setM_InOutInput(ForeignEntityInput M_InOut) {
		this.mM_InOut = M_InOut;
		MInOut_BH foreignEntity;
		if (get_ID() == 0 && M_InOut != null &&
				(foreignEntity = new Query(getCtx(), "M_InOut", "M_InOut_UU=?", get_TrxName())
						.setParameters(M_InOut.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOut_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	@JsonProperty("M_InOut")
	public ForeignEntityInput M_InOut() {
		return mM_InOut;
	}

	/**
	 * Set Package.
	 *
	 * @param M_Package Shipment Package
	 */
	@JsonProperty("M_Package")
	public void setM_PackageInput(ForeignEntityInput M_Package) {
		this.mM_Package = M_Package;
		MPackage foreignEntity;
		if (M_Package != null &&
				(foreignEntity = new Query(getCtx(), "M_Package", "M_Package_UU=?", get_TrxName())
						.setParameters(M_Package.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Package_ID(foreignEntity.get_ID());
		} else {
			super.setM_Package_ID(0);
		}
	}

	/**
	 * Get Package.
	 *
	 * @return Shipment Package
	 */
	@JsonProperty("M_Package")
	public ForeignEntityInput M_Package() {
		return mM_Package;
	}

	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(ForeignEntityInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
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
	public ForeignEntityInput M_Shipper() {
		return mM_Shipper;
	}

	/**
	 * Set Shipper Labels.
	 *
	 * @param M_ShipperLabels Shipper Labels
	 */
	@JsonProperty("M_ShipperLabels")
	public void setM_ShipperLabelsInput(ForeignEntityInput M_ShipperLabels) {
		this.mM_ShipperLabels = M_ShipperLabels;
		MShipperLabels foreignEntity;
		if (M_ShipperLabels != null &&
				(foreignEntity = new Query(getCtx(), "M_ShipperLabels", "M_ShipperLabels_UU=?", get_TrxName())
						.setParameters(M_ShipperLabels.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperLabels_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShipperLabels_ID(0);
		}
	}

	/**
	 * Get Shipper Labels.
	 *
	 * @return Shipper Labels
	 */
	@JsonProperty("M_ShipperLabels")
	public ForeignEntityInput M_ShipperLabels() {
		return mM_ShipperLabels;
	}

	/**
	 * Set Shipper Packaging.
	 *
	 * @param M_ShipperPackaging Shipper Packaging
	 */
	@JsonProperty("M_ShipperPackaging")
	public void setM_ShipperPackagingInput(ForeignEntityInput M_ShipperPackaging) {
		this.mM_ShipperPackaging = M_ShipperPackaging;
		MShipperPackaging foreignEntity;
		if (M_ShipperPackaging != null &&
				(foreignEntity = new Query(getCtx(), "M_ShipperPackaging", "M_ShipperPackaging_UU=?", get_TrxName())
						.setParameters(M_ShipperPackaging.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperPackaging_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShipperPackaging_ID(0);
		}
	}

	/**
	 * Get Shipper Packaging.
	 *
	 * @return Shipper Packaging
	 */
	@JsonProperty("M_ShipperPackaging")
	public ForeignEntityInput M_ShipperPackaging() {
		return mM_ShipperPackaging;
	}

	/**
	 * Set Shipper Pickup Types.
	 *
	 * @param M_ShipperPickupTypes Shipper Pickup Types
	 */
	@JsonProperty("M_ShipperPickupTypes")
	public void setM_ShipperPickupTypesInput(ForeignEntityInput M_ShipperPickupTypes) {
		this.mM_ShipperPickupTypes = M_ShipperPickupTypes;
		MShipperPickupTypes foreignEntity;
		if (M_ShipperPickupTypes != null &&
				(foreignEntity = new Query(getCtx(), "M_ShipperPickupTypes", "M_ShipperPickupTypes_UU=?", get_TrxName())
						.setParameters(M_ShipperPickupTypes.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperPickupTypes_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShipperPickupTypes_ID(0);
		}
	}

	/**
	 * Get Shipper Pickup Types.
	 *
	 * @return Shipper Pickup Types
	 */
	@JsonProperty("M_ShipperPickupTypes")
	public ForeignEntityInput M_ShipperPickupTypes() {
		return mM_ShipperPickupTypes;
	}

	/**
	 * Set Shipping Processor.
	 *
	 * @param M_ShippingProcessor Shipping Processor
	 */
	@JsonProperty("M_ShippingProcessor")
	public void setM_ShippingProcessorInput(ForeignEntityInput M_ShippingProcessor) {
		this.mM_ShippingProcessor = M_ShippingProcessor;
		MShippingProcessor foreignEntity;
		if (get_ID() == 0 && M_ShippingProcessor != null &&
				(foreignEntity = new Query(getCtx(), "M_ShippingProcessor", "M_ShippingProcessor_UU=?", get_TrxName())
						.setParameters(M_ShippingProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShippingProcessor_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipping Processor.
	 *
	 * @return Shipping Processor
	 */
	@JsonProperty("M_ShippingProcessor")
	public ForeignEntityInput M_ShippingProcessor() {
		return mM_ShippingProcessor;
	}
	/**
	 * Set Shipping Transaction.
	 *
	 * @param M_ShippingTransaction_ID Shipping Transaction
	 */

	public void setM_ShippingTransaction_ID(int M_ShippingTransaction_ID) {
		if (get_ID() == 0) {
			super.setM_ShippingTransaction_ID(M_ShippingTransaction_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShippingTransaction_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShippingTransaction_UU();
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
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
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
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
		if (NotificationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(NotificationType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setNotificationType(foreignEntity.getValue());
		} else {
			this.setNotificationType(null);
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
	 * Set Return Partner.
	 *
	 * @param ReturnBPartner Return Partner
	 */
	@JsonProperty("ReturnBPartner")
	public void setReturnBPartnerInput(ForeignEntityInput ReturnBPartner) {
		this.mReturnBPartner = ReturnBPartner;
		MBPartner_BH foreignEntity;
		if (ReturnBPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
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
	public ForeignEntityInput ReturnBPartner() {
		return mReturnBPartner;
	}

	/**
	 * Set Return Location.
	 *
	 * @param ReturnLocation Return Location
	 */
	@JsonProperty("ReturnLocation")
	public void setReturnLocationInput(ForeignEntityInput ReturnLocation) {
		this.mReturnLocation = ReturnLocation;
		MBPartnerLocation foreignEntity;
		if (ReturnLocation != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
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
	public ForeignEntityInput ReturnLocation() {
		return mReturnLocation;
	}

	/**
	 * Set Return User/Contact.
	 *
	 * @param ReturnUser Return User/Contact
	 */
	@JsonProperty("ReturnUser")
	public void setReturnUserInput(ForeignEntityInput ReturnUser) {
		this.mReturnUser = ReturnUser;
		MUser_BH foreignEntity;
		if (ReturnUser != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
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
	public ForeignEntityInput ReturnUser() {
		return mReturnUser;
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
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
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
	public ForeignEntityInput SalesRep() {
		return mSalesRep;
	}
}
