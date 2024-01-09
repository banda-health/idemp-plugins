package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Package;

/**
 * Generated Interface for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_PackageInput extends I_M_Package {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

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
	void setDeliveryConfirmationTypeInput(I_AD_Ref_ListInput DeliveryConfirmationType);

	/**
	 * Get DeliveryConfirmationType.
	 *
	 * @return DeliveryConfirmationType
	 */
	I_AD_Ref_ListInput DeliveryConfirmationType();

	/**
	 * Set DotHazardClassOrDivision.
	 *
	 * @param DotHazardClassOrDivision DotHazardClassOrDivision
	 */
	void setDotHazardClassOrDivisionInput(I_AD_Ref_ListInput DotHazardClassOrDivision);

	/**
	 * Get DotHazardClassOrDivision.
	 *
	 * @return DotHazardClassOrDivision
	 */
	I_AD_Ref_ListInput DotHazardClassOrDivision();

	/**
	 * Set FOB.
	 *
	 * @param FOB FOB
	 */
	void setFOBInput(I_AD_Ref_ListInput FOB);

	/**
	 * Get FOB.
	 *
	 * @return FOB
	 */
	I_AD_Ref_ListInput FOB();

	/**
	 * Set FreightCharges.
	 *
	 * @param FreightCharges FreightCharges
	 */
	void setFreightChargesInput(I_AD_Ref_ListInput FreightCharges);

	/**
	 * Get FreightCharges.
	 *
	 * @return FreightCharges
	 */
	I_AD_Ref_ListInput FreightCharges();

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
	void setHomeDeliveryPremiumTypeInput(I_AD_Ref_ListInput HomeDeliveryPremiumType);

	/**
	 * Get HomeDeliveryPremiumType.
	 *
	 * @return HomeDeliveryPremiumType
	 */
	I_AD_Ref_ListInput HomeDeliveryPremiumType();

	/**
	 * Set Insurance.
	 *
	 * @param Insurance Insurance
	 */
	void setInsuranceInput(I_AD_Ref_ListInput Insurance);

	/**
	 * Get Insurance.
	 *
	 * @return Insurance
	 */
	I_AD_Ref_ListInput Insurance();

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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

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
	 * Set M_ShippingProcessor.
	 *
	 * @param M_ShippingProcessor M_ShippingProcessor
	 */
	void setM_ShippingProcessorInput(ForeignEntityInput M_ShippingProcessor);

	/**
	 * Get M_ShippingProcessor.
	 *
	 * @return M_ShippingProcessor
	 */
	ForeignEntityInput M_ShippingProcessor();

	/**
	 * Set NotificationType.
	 *
	 * @param NotificationType Type of Notifications
	 */
	void setNotificationTypeInput(I_AD_Ref_ListInput NotificationType);

	/**
	 * Get NotificationType.
	 *
	 * @return Type of Notifications
	 */
	I_AD_Ref_ListInput NotificationType();

	/**
	 * Set PaymentRule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	void setPaymentRuleInput(I_AD_Ref_ListInput PaymentRule);

	/**
	 * Get PaymentRule.
	 *
	 * @return How you pay the invoice
	 */
	I_AD_Ref_ListInput PaymentRule();
}
