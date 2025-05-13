package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_ShippingTransactionResolver;
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
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShippingTransactionInput extends MShippingTransaction implements I_M_ShippingTransactionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAction;
	private ForeignEntityInput mBill_Location;
	private ForeignEntityInput mC_BP_ShippingAcct;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_UOM_Length;
	private ForeignEntityInput mC_UOM_Weight;
	private ForeignEntityInput mDeliveryConfirmationType;
	private ForeignEntityInput mDotHazardClassOrDivision;
	private ForeignEntityInput mFOB;
	private ForeignEntityInput mFreightCharges;
	private ForeignEntityInput mHoldAddress;
	private ForeignEntityInput mHomeDeliveryPremiumType;
	private ForeignEntityInput mInsurance;
	private ForeignEntityInput mM_InOut;
	private ForeignEntityInput mM_Package;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperLabels;
	private ForeignEntityInput mM_ShipperPackaging;
	private ForeignEntityInput mM_ShipperPickupTypes;
	private ForeignEntityInput mM_ShippingProcessor;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mNotificationType;
	private ForeignEntityInput mPaymentRule;
	private ForeignEntityInput mReturnBPartner;
	private ForeignEntityInput mReturnLocation;
	private ForeignEntityInput mReturnUser;
	private ForeignEntityInput mSalesRep;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_ShippingTransaction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShippingTransactionInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Action.
	 *
	 * @param Action Indicates the Action to be performed
	 */
	@JsonProperty("Action")
	public void setActionInput(ForeignEntityInput Action) {
		this.mAction = Action;
		if (Action != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.ACTION_UUIDS_BY_VALUE.containsValue(Action.getUU())) {
				throw new AdempiereException("The reference list UU of " + Action.getUU() +
						" is not in the list defined for the Action column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Action.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Action.getUU());
			}
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
	public ForeignEntityInput Action() {
		return mAction;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
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
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(Bill_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(C_BP_ShippingAcct.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(C_BPartner_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		if (C_Invoice != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoice_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UU " + C_Invoice.getUU());
			}
		} else {
			this.setC_Invoice_ID(0);
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
		if (C_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UU " + C_Order.getUU());
			}
		} else {
			this.setC_Order_ID(0);
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
		if (C_UOM_Length != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM_Length.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(C_UOM_Weight.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.DELIVERYCONFIRMATIONTYPE_UUIDS_BY_VALUE.containsValue(DeliveryConfirmationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + DeliveryConfirmationType.getUU() +
						" is not in the list defined for the DeliveryConfirmationType column");
			}
			// Now make sure it's in the DB
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
	 * Set Dot Hazard Class or Division.
	 *
	 * @param DotHazardClassOrDivision Dot Hazard Class or Division
	 */
	@JsonProperty("DotHazardClassOrDivision")
	public void setDotHazardClassOrDivisionInput(ForeignEntityInput DotHazardClassOrDivision) {
		this.mDotHazardClassOrDivision = DotHazardClassOrDivision;
		if (DotHazardClassOrDivision != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.DOTHAZARDCLASSORDIVISION_UUIDS_BY_VALUE.containsValue(DotHazardClassOrDivision.getUU())) {
				throw new AdempiereException("The reference list UU of " + DotHazardClassOrDivision.getUU() +
						" is not in the list defined for the DotHazardClassOrDivision column");
			}
			// Now make sure it's in the DB
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
	 * Set Freight Terms.
	 *
	 * @param FOB Freight Terms
	 */
	@JsonProperty("FOB")
	public void setFOBInput(ForeignEntityInput FOB) {
		this.mFOB = FOB;
		if (!is_new()) {
			return;
		}
		if (FOB != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.FOB_UUIDS_BY_VALUE.containsValue(FOB.getUU())) {
				throw new AdempiereException("The reference list UU of " + FOB.getUU() +
						" is not in the list defined for the FOB column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FOB.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFOB(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + FOB.getUU());
			}
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
	public ForeignEntityInput FOB() {
		return mFOB;
	}

	/**
	 * Set Freight Charges.
	 *
	 * @param FreightCharges Freight Charges
	 */
	@JsonProperty("FreightCharges")
	public void setFreightChargesInput(ForeignEntityInput FreightCharges) {
		this.mFreightCharges = FreightCharges;
		if (!is_new()) {
			return;
		}
		if (FreightCharges != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.FREIGHTCHARGES_UUIDS_BY_VALUE.containsValue(FreightCharges.getUU())) {
				throw new AdempiereException("The reference list UU of " + FreightCharges.getUU() +
						" is not in the list defined for the FreightCharges column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FreightCharges.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFreightCharges(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + FreightCharges.getUU());
			}
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
	public ForeignEntityInput FreightCharges() {
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
		if (HoldAddress != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(HoldAddress.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.HOMEDELIVERYPREMIUMTYPE_UUIDS_BY_VALUE.containsValue(HomeDeliveryPremiumType.getUU())) {
				throw new AdempiereException("The reference list UU of " + HomeDeliveryPremiumType.getUU() +
						" is not in the list defined for the HomeDeliveryPremiumType column");
			}
			// Now make sure it's in the DB
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
	 * Set Insurance.
	 *
	 * @param Insurance Insurance
	 */
	@JsonProperty("Insurance")
	public void setInsuranceInput(ForeignEntityInput Insurance) {
		this.mInsurance = Insurance;
		if (!is_new()) {
			return;
		}
		if (Insurance != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.INSURANCE_UUIDS_BY_VALUE.containsValue(Insurance.getUU())) {
				throw new AdempiereException("The reference list UU of " + Insurance.getUU() +
						" is not in the list defined for the Insurance column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Insurance.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInsurance(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Insurance.getUU());
			}
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
	public ForeignEntityInput Insurance() {
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
		if (!is_new()) {
			return;
		}
		if (M_InOut != null) {
			// Since an entity was passed, make sure it's in the DB
			MInOut_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InOut", "M_InOut_UU=?", get_TrxName())
							.setParameters(M_InOut.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * @param M_Package Shipment Package
	 */
	@JsonProperty("M_Package")
	public void setM_PackageInput(ForeignEntityInput M_Package) {
		this.mM_Package = M_Package;
		if (M_Package != null) {
			// Since an entity was passed, make sure it's in the DB
			MPackage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Package", "M_Package_UU=?", get_TrxName())
							.setParameters(M_Package.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Package_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Package with UU " + M_Package.getUU());
			}
		} else {
			this.setM_Package_ID(0);
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
		if (M_Shipper != null) {
			// Since an entity was passed, make sure it's in the DB
			MShipper foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
							.setParameters(M_Shipper.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(M_ShipperLabels.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(M_ShipperPackaging.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(M_ShipperPickupTypes.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Shipping Processor.
	 *
	 * @param M_ShippingProcessor Shipping Processor
	 */
	@JsonProperty("M_ShippingProcessor")
	public void setM_ShippingProcessorInput(ForeignEntityInput M_ShippingProcessor) {
		this.mM_ShippingProcessor = M_ShippingProcessor;
		if (!is_new()) {
			return;
		}
		if (M_ShippingProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MShippingProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShippingProcessor", "M_ShippingProcessor_UU=?", get_TrxName())
							.setParameters(M_ShippingProcessor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ShippingProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShippingProcessor with UU " + M_ShippingProcessor.getUU());
			}
		} else {
			this.setM_ShippingProcessor_ID(0);
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
	@JsonProperty("M_ShippingTransaction_ID")
	public void setM_ShippingTransaction_IDFromJson(int M_ShippingTransaction_ID) {
		if (get_ID() == 0) {
			super.setM_ShippingTransaction_ID(M_ShippingTransaction_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_ShippingTransaction_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Notification Type.
	 *
	 * @param NotificationType Type of Notifications
	 */
	@JsonProperty("NotificationType")
	public void setNotificationTypeInput(ForeignEntityInput NotificationType) {
		this.mNotificationType = NotificationType;
		if (NotificationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.NOTIFICATIONTYPE_UUIDS_BY_VALUE.containsValue(NotificationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + NotificationType.getUU() +
						" is not in the list defined for the NotificationType column");
			}
			// Now make sure it's in the DB
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
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShippingTransactionResolver.PAYMENTRULE_UUIDS_BY_VALUE.containsValue(PaymentRule.getUU())) {
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
	 * Set Return Partner.
	 *
	 * @param ReturnBPartner Return Partner
	 */
	@JsonProperty("ReturnBPartner")
	public void setReturnBPartnerInput(ForeignEntityInput ReturnBPartner) {
		this.mReturnBPartner = ReturnBPartner;
		if (ReturnBPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(ReturnBPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setReturnBPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + ReturnBPartner.getUU());
			}
		} else {
			this.setReturnBPartner_ID(0);
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
		if (ReturnLocation != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(ReturnLocation.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setReturnLocation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UU " + ReturnLocation.getUU());
			}
		} else {
			this.setReturnLocation_ID(0);
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
		if (ReturnUser != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(ReturnUser.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setReturnUser_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + ReturnUser.getUU());
			}
		} else {
			this.setReturnUser_ID(0);
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
		if (SalesRep != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
}
