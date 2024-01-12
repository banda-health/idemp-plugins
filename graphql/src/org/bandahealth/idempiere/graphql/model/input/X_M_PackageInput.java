package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MPackage;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.MShipperPickupTypes;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_ShippingAcct;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageInput extends MPackage implements I_M_PackageInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BP_ShippingAcct;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_UOM_Length;
	private ForeignEntityInput mC_UOM_Weight;
	private ForeignEntityInput mHoldAddress;
	private ForeignEntityInput mM_InOut;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperLabels;
	private ForeignEntityInput mM_ShipperPackaging;
	private ForeignEntityInput mM_ShipperPickupTypes;
	private ForeignEntityInput mM_ShippingProcessor;
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
	public X_M_PackageInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPackage(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Estimated Weight.
	 *
	 * @param EstimatedWeight Estimated Weight
	 */

	public void setEstimatedWeight(BigDecimal EstimatedWeight) {
		if (get_ID() == 0) {
			super.setEstimatedWeight(EstimatedWeight);
		}
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
	 * @param M_Package_ID Shipment Package
	 */

	public void setM_Package_ID(int M_Package_ID) {
		if (get_ID() == 0) {
			super.setM_Package_ID(M_Package_ID);
		}
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
	 * Set Total Price.
	 *
	 * @param TotalPrice Total Price
	 */

	public void setTotalPrice(BigDecimal TotalPrice) {
		if (get_ID() == 0) {
			super.setTotalPrice(TotalPrice);
		}
	}
}
