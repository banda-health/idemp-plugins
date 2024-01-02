package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShippingTransaction;

/**
 * Generated Interface for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShippingTransactionInput extends I_M_ShippingTransaction {

	/**
	 * Set Action.
	 *
	 * @param Action Indicates the Action to be performed
	 */
	void setActionInput(I_AD_Ref_ListInput Action);

	/**
	 * Get Action.
	 *
	 * @return Indicates the Action to be performed
	 */
	I_AD_Ref_ListInput Action();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput AD_User();

	/**
	 * Set Bill_Location.
	 *
	 * @param Bill_Location Business Partner Location for invoicing
	 */
	void setBill_LocationInput(I_C_BPartner_LocationInput Bill_Location);

	/**
	 * Get Bill_Location.
	 *
	 * @return Business Partner Location for invoicing
	 */
	I_C_BPartner_LocationInput Bill_Location();

	/**
	 * Set C_BP_ShippingAcct.
	 *
	 * @param C_BP_ShippingAcct C_BP_ShippingAcct
	 */
	void setC_BP_ShippingAcctInput(I_C_BP_ShippingAcctInput C_BP_ShippingAcct);

	/**
	 * Get C_BP_ShippingAcct.
	 *
	 * @return C_BP_ShippingAcct
	 */
	I_C_BP_ShippingAcctInput C_BP_ShippingAcct();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput C_BPartner_Location();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput C_Currency();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_InvoiceInput(I_C_InvoiceInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	I_C_InvoiceInput C_Invoice();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(I_C_OrderInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	I_C_OrderInput C_Order();

	/**
	 * Set C_UOM_Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	void setC_UOM_LengthInput(I_C_UOMInput C_UOM_Length);

	/**
	 * Get C_UOM_Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	I_C_UOMInput C_UOM_Length();

	/**
	 * Set C_UOM_Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	void setC_UOM_WeightInput(I_C_UOMInput C_UOM_Weight);

	/**
	 * Get C_UOM_Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	I_C_UOMInput C_UOM_Weight();

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
	void setHoldAddressInput(I_C_BPartner_LocationInput HoldAddress);

	/**
	 * Get HoldAddress.
	 *
	 * @return HoldAddress
	 */
	I_C_BPartner_LocationInput HoldAddress();

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
	void setM_InOutInput(I_M_InOutInput M_InOut);

	/**
	 * Get M_InOut.
	 *
	 * @return Material Shipment Document
	 */
	I_M_InOutInput M_InOut();

	/**
	 * Set M_Package.
	 *
	 * @param M_Package Shipment Package
	 */
	void setM_PackageInput(I_M_PackageInput M_Package);

	/**
	 * Get M_Package.
	 *
	 * @return Shipment Package
	 */
	I_M_PackageInput M_Package();

	/**
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_ShipperInput(I_M_ShipperInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	I_M_ShipperInput M_Shipper();

	/**
	 * Set M_ShipperLabels.
	 *
	 * @param M_ShipperLabels M_ShipperLabels
	 */
	void setM_ShipperLabelsInput(I_M_ShipperLabelsInput M_ShipperLabels);

	/**
	 * Get M_ShipperLabels.
	 *
	 * @return M_ShipperLabels
	 */
	I_M_ShipperLabelsInput M_ShipperLabels();

	/**
	 * Set M_ShipperPackaging.
	 *
	 * @param M_ShipperPackaging M_ShipperPackaging
	 */
	void setM_ShipperPackagingInput(I_M_ShipperPackagingInput M_ShipperPackaging);

	/**
	 * Get M_ShipperPackaging.
	 *
	 * @return M_ShipperPackaging
	 */
	I_M_ShipperPackagingInput M_ShipperPackaging();

	/**
	 * Set M_ShipperPickupTypes.
	 *
	 * @param M_ShipperPickupTypes M_ShipperPickupTypes
	 */
	void setM_ShipperPickupTypesInput(I_M_ShipperPickupTypesInput M_ShipperPickupTypes);

	/**
	 * Get M_ShipperPickupTypes.
	 *
	 * @return M_ShipperPickupTypes
	 */
	I_M_ShipperPickupTypesInput M_ShipperPickupTypes();

	/**
	 * Set M_ShippingProcessor.
	 *
	 * @param M_ShippingProcessor M_ShippingProcessor
	 */
	void setM_ShippingProcessorInput(I_M_ShippingProcessorInput M_ShippingProcessor);

	/**
	 * Get M_ShippingProcessor.
	 *
	 * @return M_ShippingProcessor
	 */
	I_M_ShippingProcessorInput M_ShippingProcessor();

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
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput M_Warehouse();

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

	/**
	 * Set ReturnBPartner.
	 *
	 * @param ReturnBPartner ReturnBPartner
	 */
	void setReturnBPartnerInput(I_C_BPartnerInput ReturnBPartner);

	/**
	 * Get ReturnBPartner.
	 *
	 * @return ReturnBPartner
	 */
	I_C_BPartnerInput ReturnBPartner();

	/**
	 * Set ReturnLocation.
	 *
	 * @param ReturnLocation ReturnLocation
	 */
	void setReturnLocationInput(I_C_BPartner_LocationInput ReturnLocation);

	/**
	 * Get ReturnLocation.
	 *
	 * @return ReturnLocation
	 */
	I_C_BPartner_LocationInput ReturnLocation();

	/**
	 * Set ReturnUser.
	 *
	 * @param ReturnUser ReturnUser
	 */
	void setReturnUserInput(I_AD_UserInput ReturnUser);

	/**
	 * Get ReturnUser.
	 *
	 * @return ReturnUser
	 */
	I_AD_UserInput ReturnUser();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput SalesRep();
}
