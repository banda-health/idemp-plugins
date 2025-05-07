package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Package;

/**
 * Generated Interface for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_PackageInput extends I_M_Package {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	ForeignEntityInput C_BPartner_Location();

	/**
	 * Set C_BP_ShippingAcct.
	 *
	 * @param C_BP_ShippingAcct C_BP_ShippingAcct
	 */
	void setC_BP_ShippingAcctInput(ForeignEntityInput C_BP_ShippingAcct);

	/**
	 * Get C_BP_ShippingAcct.
	 *
	 * @return C_BP_ShippingAcct
	 */
	ForeignEntityInput C_BP_ShippingAcct();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set C_UOM_Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	void setC_UOM_LengthInput(ForeignEntityInput C_UOM_Length);

	/**
	 * Get C_UOM_Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	ForeignEntityInput C_UOM_Length();

	/**
	 * Set C_UOM_Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	void setC_UOM_WeightInput(ForeignEntityInput C_UOM_Weight);

	/**
	 * Get C_UOM_Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	ForeignEntityInput C_UOM_Weight();

	/**
	 * Set DeliveryConfirmationType.
	 *
	 * @param DeliveryConfirmationType DeliveryConfirmationType
	 */
	void setDeliveryConfirmationTypeInput(ForeignEntityInput DeliveryConfirmationType);

	/**
	 * Get DeliveryConfirmationType.
	 *
	 * @return DeliveryConfirmationType
	 */
	ForeignEntityInput DeliveryConfirmationType();

	/**
	 * Set DotHazardClassOrDivision.
	 *
	 * @param DotHazardClassOrDivision DotHazardClassOrDivision
	 */
	void setDotHazardClassOrDivisionInput(ForeignEntityInput DotHazardClassOrDivision);

	/**
	 * Get DotHazardClassOrDivision.
	 *
	 * @return DotHazardClassOrDivision
	 */
	ForeignEntityInput DotHazardClassOrDivision();

	/**
	 * Set HoldAddress.
	 *
	 * @param HoldAddress HoldAddress
	 */
	void setHoldAddressInput(ForeignEntityInput HoldAddress);

	/**
	 * Get HoldAddress.
	 *
	 * @return HoldAddress
	 */
	ForeignEntityInput HoldAddress();

	/**
	 * Set HomeDeliveryPremiumType.
	 *
	 * @param HomeDeliveryPremiumType HomeDeliveryPremiumType
	 */
	void setHomeDeliveryPremiumTypeInput(ForeignEntityInput HomeDeliveryPremiumType);

	/**
	 * Get HomeDeliveryPremiumType.
	 *
	 * @return HomeDeliveryPremiumType
	 */
	ForeignEntityInput HomeDeliveryPremiumType();

	/**
	 * Set M_InOut.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	void setM_InOutInput(ForeignEntityInput M_InOut);

	/**
	 * Get M_InOut.
	 *
	 * @return Material Shipment Document
	 */
	ForeignEntityInput M_InOut();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_ShipperInput(ForeignEntityInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	ForeignEntityInput M_Shipper();

	/**
	 * Set M_ShipperLabels.
	 *
	 * @param M_ShipperLabels M_ShipperLabels
	 */
	void setM_ShipperLabelsInput(ForeignEntityInput M_ShipperLabels);

	/**
	 * Get M_ShipperLabels.
	 *
	 * @return M_ShipperLabels
	 */
	ForeignEntityInput M_ShipperLabels();

	/**
	 * Set M_ShipperPackaging.
	 *
	 * @param M_ShipperPackaging M_ShipperPackaging
	 */
	void setM_ShipperPackagingInput(ForeignEntityInput M_ShipperPackaging);

	/**
	 * Get M_ShipperPackaging.
	 *
	 * @return M_ShipperPackaging
	 */
	ForeignEntityInput M_ShipperPackaging();

	/**
	 * Set M_ShipperPickupTypes.
	 *
	 * @param M_ShipperPickupTypes M_ShipperPickupTypes
	 */
	void setM_ShipperPickupTypesInput(ForeignEntityInput M_ShipperPickupTypes);

	/**
	 * Get M_ShipperPickupTypes.
	 *
	 * @return M_ShipperPickupTypes
	 */
	ForeignEntityInput M_ShipperPickupTypes();

	/**
	 * Set NotificationType.
	 *
	 * @param NotificationType Type of Notifications
	 */
	void setNotificationTypeInput(ForeignEntityInput NotificationType);

	/**
	 * Get NotificationType.
	 *
	 * @return Type of Notifications
	 */
	ForeignEntityInput NotificationType();

	/**
	 * Set PaymentRule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	void setPaymentRuleInput(ForeignEntityInput PaymentRule);

	/**
	 * Get PaymentRule.
	 *
	 * @return How you pay the invoice
	 */
	ForeignEntityInput PaymentRule();
}
