package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MPackage;
import org.compiere.model.MRefList;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.MShipperPickupTypes;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_ShippingAcct;
import org.compiere.util.Env;

/**
 * Generated Model for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageInput extends MPackage implements I_M_PackageInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput DeliveryConfirmationType_RL;
	 private I_AD_Ref_ListInput DotHazardClassOrDivision_RL;
	 private I_AD_Ref_ListInput HomeDeliveryPremiumType_RL;
	 private I_AD_Ref_ListInput NotificationType_RL;
	 private I_AD_Ref_ListInput PaymentRule_RL;
	 private I_C_BP_ShippingAcctInput C_BP_ShippingAcct;
	 private I_C_BPartner_LocationInput C_BPartner_Location;
	 private I_C_BPartner_LocationInput HoldAddress;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_UOMInput C_UOM_Length;
	 private I_C_UOMInput C_UOM_Weight;
	 private I_M_InOutInput M_InOut;
	 private I_M_ShipperInput M_Shipper;
	 private I_M_ShipperLabelsInput M_ShipperLabels;
	 private I_M_ShipperPackagingInput M_ShipperPackaging;
	 private I_M_ShipperPickupTypesInput M_ShipperPickupTypes;

	/**
	 * Standard constructor
	 */
	public X_M_PackageInput(String ID) {
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
	 * Set Business Partner Shipping Account.
	 *
	 * @param C_BP_ShippingAcct Business Partner Shipping Account
	 */
	public void setC_BP_ShippingAcct(I_C_BP_ShippingAcctInput C_BP_ShippingAcct) {
		this.C_BP_ShippingAcct = C_BP_ShippingAcct;
		X_C_BP_ShippingAcct foreignEntity;
		if (C_BP_ShippingAcct != null &&
				(foreignEntity = new Query(getCtx(), X_C_BP_ShippingAcct.Table_Name, X_C_BP_ShippingAcct.COLUMNNAME_C_BP_ShippingAcct_UU + "=?", get_TrxName())
						.setParameters(C_BP_ShippingAcct.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BP_ShippingAcct_ID(foreignEntity.get_ID());
		} else {
			this.setC_BP_ShippingAcct_ID(0);
		}
	}

	/**
	 * Get Business Partner Shipping Account.
	 *
	 * @return Business Partner Shipping Account
	 */
	public I_C_BP_ShippingAcctInput getC_BP_ShippingAcct() {
		return C_BP_ShippingAcct;
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
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	public void setC_UOM_Length(I_C_UOMInput C_UOM_Length) {
		this.C_UOM_Length = C_UOM_Length;
		MUOM foreignEntity;
		if (C_UOM_Length != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM_Length.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_Length_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_Length_ID(0);
		}
	}

	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	public I_C_UOMInput getC_UOM_Length() {
		return C_UOM_Length;
	}

	/**
	 * Set UOM for Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	public void setC_UOM_Weight(I_C_UOMInput C_UOM_Weight) {
		this.C_UOM_Weight = C_UOM_Weight;
		MUOM foreignEntity;
		if (C_UOM_Weight != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM_Weight.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_Weight_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_Weight_ID(0);
		}
	}

	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	public I_C_UOMInput getC_UOM_Weight() {
		return C_UOM_Weight;
	}

	/**
	 * Set Delivery Confirmation Type.
	 *
	 * @param DeliveryConfirmationType_RL Delivery Confirmation Type
	 */
	public void setDeliveryConfirmationType_RL(I_AD_Ref_ListInput DeliveryConfirmationType_RL) {
		this.DeliveryConfirmationType_RL = DeliveryConfirmationType_RL;
		MRefList foreignEntity;
		if (DeliveryConfirmationType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DeliveryConfirmationType_RL.getID())
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
	public I_AD_Ref_ListInput getDeliveryConfirmationType_RL() {
		return DeliveryConfirmationType_RL;
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
	 * Set Dot Hazard Class or Division.
	 *
	 * @param DotHazardClassOrDivision_RL Dot Hazard Class or Division
	 */
	public void setDotHazardClassOrDivision_RL(I_AD_Ref_ListInput DotHazardClassOrDivision_RL) {
		this.DotHazardClassOrDivision_RL = DotHazardClassOrDivision_RL;
		MRefList foreignEntity;
		if (DotHazardClassOrDivision_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DotHazardClassOrDivision_RL.getID())
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
	public I_AD_Ref_ListInput getDotHazardClassOrDivision_RL() {
		return DotHazardClassOrDivision_RL;
	}

	/**
	 * Set Hold Address.
	 *
	 * @param HoldAddress Hold Address
	 */
	public void setHoldAddress(I_C_BPartner_LocationInput HoldAddress) {
		this.HoldAddress = HoldAddress;
		MBPartnerLocation foreignEntity;
		if (HoldAddress != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(HoldAddress.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setHoldAddress_ID(foreignEntity.get_ID());
		} else {
			this.setHoldAddress_ID(0);
		}
	}

	/**
	 * Get Hold Address.
	 *
	 * @return Hold Address
	 */
	public I_C_BPartner_LocationInput getHoldAddress() {
		return HoldAddress;
	}

	/**
	 * Set Home Delivery Premium Type.
	 *
	 * @param HomeDeliveryPremiumType_RL Home Delivery Premium Type
	 */
	public void setHomeDeliveryPremiumType_RL(I_AD_Ref_ListInput HomeDeliveryPremiumType_RL) {
		this.HomeDeliveryPremiumType_RL = HomeDeliveryPremiumType_RL;
		MRefList foreignEntity;
		if (HomeDeliveryPremiumType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(HomeDeliveryPremiumType_RL.getID())
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
	public I_AD_Ref_ListInput getHomeDeliveryPremiumType_RL() {
		return HomeDeliveryPremiumType_RL;
	}

	/**
	 * Set Shipment/Receipt.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	public void setM_InOut(I_M_InOutInput M_InOut) {
		this.M_InOut = M_InOut;
		MInOut_BH foreignEntity;
		if (get_ID() == 0 &&M_InOut != null &&
				(foreignEntity = new Query(getCtx(), MInOut_BH.Table_Name, MInOut_BH.COLUMNNAME_M_InOut_UU + "=?", get_TrxName())
						.setParameters(M_InOut.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_InOut_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	public I_M_InOutInput getM_InOut() {
		return M_InOut;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Package_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Package_UU();
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
	 * Set Shipper Labels.
	 *
	 * @param M_ShipperLabels Shipper Labels
	 */
	public void setM_ShipperLabels(I_M_ShipperLabelsInput M_ShipperLabels) {
		this.M_ShipperLabels = M_ShipperLabels;
		MShipperLabels foreignEntity;
		if (M_ShipperLabels != null &&
				(foreignEntity = new Query(getCtx(), MShipperLabels.Table_Name, MShipperLabels.COLUMNNAME_M_ShipperLabels_UU + "=?", get_TrxName())
						.setParameters(M_ShipperLabels.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperLabels_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShipperLabels_ID(0);
		}
	}

	/**
	 * Get Shipper Labels.
	 *
	 * @return Shipper Labels
	 */
	public I_M_ShipperLabelsInput getM_ShipperLabels() {
		return M_ShipperLabels;
	}

	/**
	 * Set Shipper Packaging.
	 *
	 * @param M_ShipperPackaging Shipper Packaging
	 */
	public void setM_ShipperPackaging(I_M_ShipperPackagingInput M_ShipperPackaging) {
		this.M_ShipperPackaging = M_ShipperPackaging;
		MShipperPackaging foreignEntity;
		if (M_ShipperPackaging != null &&
				(foreignEntity = new Query(getCtx(), MShipperPackaging.Table_Name, MShipperPackaging.COLUMNNAME_M_ShipperPackaging_UU + "=?", get_TrxName())
						.setParameters(M_ShipperPackaging.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperPackaging_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShipperPackaging_ID(0);
		}
	}

	/**
	 * Get Shipper Packaging.
	 *
	 * @return Shipper Packaging
	 */
	public I_M_ShipperPackagingInput getM_ShipperPackaging() {
		return M_ShipperPackaging;
	}

	/**
	 * Set Shipper Pickup Types.
	 *
	 * @param M_ShipperPickupTypes Shipper Pickup Types
	 */
	public void setM_ShipperPickupTypes(I_M_ShipperPickupTypesInput M_ShipperPickupTypes) {
		this.M_ShipperPickupTypes = M_ShipperPickupTypes;
		MShipperPickupTypes foreignEntity;
		if (M_ShipperPickupTypes != null &&
				(foreignEntity = new Query(getCtx(), MShipperPickupTypes.Table_Name, MShipperPickupTypes.COLUMNNAME_M_ShipperPickupTypes_UU + "=?", get_TrxName())
						.setParameters(M_ShipperPickupTypes.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperPickupTypes_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShipperPickupTypes_ID(0);
		}
	}

	/**
	 * Get Shipper Pickup Types.
	 *
	 * @return Shipper Pickup Types
	 */
	public I_M_ShipperPickupTypesInput getM_ShipperPickupTypes() {
		return M_ShipperPickupTypes;
	}

	/**
	 * Set Notification Type.
	 *
	 * @param NotificationType_RL Type of Notifications
	 */
	public void setNotificationType_RL(I_AD_Ref_ListInput NotificationType_RL) {
		this.NotificationType_RL = NotificationType_RL;
		MRefList foreignEntity;
		if (NotificationType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(NotificationType_RL.getID())
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
	public I_AD_Ref_ListInput getNotificationType_RL() {
		return NotificationType_RL;
	}

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRule_RL How you pay the invoice
	 */
	public void setPaymentRule_RL(I_AD_Ref_ListInput PaymentRule_RL) {
		this.PaymentRule_RL = PaymentRule_RL;
		MRefList foreignEntity;
		if (PaymentRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentRule_RL.getID())
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
	public I_AD_Ref_ListInput getPaymentRule_RL() {
		return PaymentRule_RL;
	}
}
