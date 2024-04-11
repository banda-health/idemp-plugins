package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_ShippingAcct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PackageInput extends MPackage implements I_M_PackageInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BP_ShippingAcct;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_UOM_Length;
	private ForeignEntityInput mC_UOM_Weight;
	private ForeignEntityInput mDeliveryConfirmationType;
	private ForeignEntityInput mDotHazardClassOrDivision;
	private ForeignEntityInput mHoldAddress;
	private ForeignEntityInput mHomeDeliveryPremiumType;
	private ForeignEntityInput mM_InOut;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperLabels;
	private ForeignEntityInput mM_ShipperPackaging;
	private ForeignEntityInput mM_ShipperPickupTypes;
	private ForeignEntityInput mNotificationType;
	private ForeignEntityInput mPaymentRule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_Package_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_PackageInput(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
			return;
		}
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
	 * Set Business Partner Shipping Account.
	 *
	 * @param C_BP_ShippingAcct Business Partner Shipping Account
	 */
	@JsonProperty("C_BP_ShippingAcct")
	public void setC_BP_ShippingAcctInput(ForeignEntityInput C_BP_ShippingAcct) {
		this.mC_BP_ShippingAcct = C_BP_ShippingAcct;
		if (C_BP_ShippingAcct != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_BP_ShippingAcct foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_ShippingAcct", "C_BP_ShippingAcct_UU=?", get_TrxName())
							.setParameters(C_BP_ShippingAcct.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BP_ShippingAcct_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_ShippingAcct with UU " + C_BP_ShippingAcct.getUU());
			}
		} else {
			this.setC_BP_ShippingAcct_ID(0);
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
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
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
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public void setC_UOM_LengthInput(ForeignEntityInput C_UOM_Length) {
		this.mC_UOM_Length = C_UOM_Length;
		if (C_UOM_Length != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM_Length.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_UOM_Length_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UU " + C_UOM_Length.getUU());
			}
		} else {
			this.setC_UOM_Length_ID(0);
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
		if (C_UOM_Weight != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM_Weight.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_UOM_Weight_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UU " + C_UOM_Weight.getUU());
			}
		} else {
			this.setC_UOM_Weight_ID(0);
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
	public void setDeliveryConfirmationTypeInput(ForeignEntityInput DeliveryConfirmationType) {
		this.mDeliveryConfirmationType = DeliveryConfirmationType;
		if (DeliveryConfirmationType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DeliveryConfirmationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDeliveryConfirmationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DeliveryConfirmationType.getUU());
			}
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
	public ForeignEntityInput DeliveryConfirmationType() {
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
	public void setDotHazardClassOrDivisionInput(ForeignEntityInput DotHazardClassOrDivision) {
		this.mDotHazardClassOrDivision = DotHazardClassOrDivision;
		if (DotHazardClassOrDivision != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DotHazardClassOrDivision.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDotHazardClassOrDivision(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DotHazardClassOrDivision.getUU());
			}
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
	public ForeignEntityInput DotHazardClassOrDivision() {
		return mDotHazardClassOrDivision;
	}

	/**
	 * Set Hold Address.
	 *
	 * @param HoldAddress Hold Address
	 */
	@JsonProperty("HoldAddress")
	public void setHoldAddressInput(ForeignEntityInput HoldAddress) {
		this.mHoldAddress = HoldAddress;
		if (HoldAddress != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(HoldAddress.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHoldAddress_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UU " + HoldAddress.getUU());
			}
		} else {
			this.setHoldAddress_ID(0);
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
	public void setHomeDeliveryPremiumTypeInput(ForeignEntityInput HomeDeliveryPremiumType) {
		this.mHomeDeliveryPremiumType = HomeDeliveryPremiumType;
		if (HomeDeliveryPremiumType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(HomeDeliveryPremiumType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHomeDeliveryPremiumType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + HomeDeliveryPremiumType.getUU());
			}
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
	public ForeignEntityInput HomeDeliveryPremiumType() {
		return mHomeDeliveryPremiumType;
	}

	/**
	 * Set Shipment/Receipt.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	@JsonProperty("M_InOut")
	public void setM_InOutInput(ForeignEntityInput M_InOut) {
		this.mM_InOut = M_InOut;
		if (get_ID() != 0) {
			return;
		}
		if (M_InOut != null) {
			// Since an entity was passed, make sure it's in the DB
			MInOut_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InOut", "M_InOut_UU=?", get_TrxName())
							.setParameters(M_InOut.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_InOut_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOut with UU " + M_InOut.getUU());
			}
		} else {
			this.setM_InOut_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_Package_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
	 * Set Shipper Labels.
	 *
	 * @param M_ShipperLabels Shipper Labels
	 */
	@JsonProperty("M_ShipperLabels")
	public void setM_ShipperLabelsInput(ForeignEntityInput M_ShipperLabels) {
		this.mM_ShipperLabels = M_ShipperLabels;
		if (M_ShipperLabels != null) {
			// Since an entity was passed, make sure it's in the DB
			MShipperLabels foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperLabels", "M_ShipperLabels_UU=?", get_TrxName())
							.setParameters(M_ShipperLabels.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ShipperLabels_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperLabels with UU " + M_ShipperLabels.getUU());
			}
		} else {
			this.setM_ShipperLabels_ID(0);
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
		if (M_ShipperPackaging != null) {
			// Since an entity was passed, make sure it's in the DB
			MShipperPackaging foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperPackaging", "M_ShipperPackaging_UU=?", get_TrxName())
							.setParameters(M_ShipperPackaging.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ShipperPackaging_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperPackaging with UU " + M_ShipperPackaging.getUU());
			}
		} else {
			this.setM_ShipperPackaging_ID(0);
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
		if (M_ShipperPickupTypes != null) {
			// Since an entity was passed, make sure it's in the DB
			MShipperPickupTypes foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperPickupTypes", "M_ShipperPickupTypes_UU=?", get_TrxName())
							.setParameters(M_ShipperPickupTypes.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ShipperPickupTypes_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperPickupTypes with UU " + M_ShipperPickupTypes.getUU());
			}
		} else {
			this.setM_ShipperPickupTypes_ID(0);
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
	 * Set Notification Type.
	 *
	 * @param NotificationType Type of Notifications
	 */
	@JsonProperty("NotificationType")
	public void setNotificationTypeInput(ForeignEntityInput NotificationType) {
		this.mNotificationType = NotificationType;
		if (NotificationType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(NotificationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setNotificationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + NotificationType.getUU());
			}
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
	public ForeignEntityInput NotificationType() {
		return mNotificationType;
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
			// Since an entity was passed, make sure it's in the DB
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
}
