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
	 * Set Action_RL.
	 *
	 * @param Action_RL Indicates the Action to be performed
	 */
	void setAction_RL(I_AD_Ref_ListInput Action_RL);

	/**
	 * Get Action_RL.
	 *
	 * @return Indicates the Action to be performed
	 */
	I_AD_Ref_ListInput getAction_RL();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

	/**
	 * Set Bill_Location.
	 *
	 * @param Bill_Location Business Partner Location for invoicing
	 */
	void setBill_Location(I_C_BPartner_LocationInput Bill_Location);

	/**
	 * Get Bill_Location.
	 *
	 * @return Business Partner Location for invoicing
	 */
	I_C_BPartner_LocationInput getBill_Location();

	/**
	 * Set C_BP_ShippingAcct.
	 *
	 * @param C_BP_ShippingAcct C_BP_ShippingAcct
	 */
	void setC_BP_ShippingAcct(I_C_BP_ShippingAcctInput C_BP_ShippingAcct);

	/**
	 * Get C_BP_ShippingAcct.
	 *
	 * @return C_BP_ShippingAcct
	 */
	I_C_BP_ShippingAcctInput getC_BP_ShippingAcct();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput getC_BPartner_Location();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_Invoice(I_C_InvoiceInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	I_C_InvoiceInput getC_Invoice();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_Order(I_C_OrderInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	I_C_OrderInput getC_Order();

	/**
	 * Set C_UOM_Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	void setC_UOM_Length(I_C_UOMInput C_UOM_Length);

	/**
	 * Get C_UOM_Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	I_C_UOMInput getC_UOM_Length();

	/**
	 * Set C_UOM_Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	void setC_UOM_Weight(I_C_UOMInput C_UOM_Weight);

	/**
	 * Get C_UOM_Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	I_C_UOMInput getC_UOM_Weight();

	/**
	 * Set DeliveryConfirmationType_RL.
	 *
	 * @param DeliveryConfirmationType_RL DeliveryConfirmationType_RL
	 */
	void setDeliveryConfirmationType_RL(I_AD_Ref_ListInput DeliveryConfirmationType_RL);

	/**
	 * Get DeliveryConfirmationType_RL.
	 *
	 * @return DeliveryConfirmationType_RL
	 */
	I_AD_Ref_ListInput getDeliveryConfirmationType_RL();

	/**
	 * Set DotHazardClassOrDivision_RL.
	 *
	 * @param DotHazardClassOrDivision_RL DotHazardClassOrDivision_RL
	 */
	void setDotHazardClassOrDivision_RL(I_AD_Ref_ListInput DotHazardClassOrDivision_RL);

	/**
	 * Get DotHazardClassOrDivision_RL.
	 *
	 * @return DotHazardClassOrDivision_RL
	 */
	I_AD_Ref_ListInput getDotHazardClassOrDivision_RL();

	/**
	 * Set FOB_RL.
	 *
	 * @param FOB_RL FOB_RL
	 */
	void setFOB_RL(I_AD_Ref_ListInput FOB_RL);

	/**
	 * Get FOB_RL.
	 *
	 * @return FOB_RL
	 */
	I_AD_Ref_ListInput getFOB_RL();

	/**
	 * Set FreightCharges_RL.
	 *
	 * @param FreightCharges_RL FreightCharges_RL
	 */
	void setFreightCharges_RL(I_AD_Ref_ListInput FreightCharges_RL);

	/**
	 * Get FreightCharges_RL.
	 *
	 * @return FreightCharges_RL
	 */
	I_AD_Ref_ListInput getFreightCharges_RL();

	/**
	 * Set HoldAddress.
	 *
	 * @param HoldAddress HoldAddress
	 */
	void setHoldAddress(I_C_BPartner_LocationInput HoldAddress);

	/**
	 * Get HoldAddress.
	 *
	 * @return HoldAddress
	 */
	I_C_BPartner_LocationInput getHoldAddress();

	/**
	 * Set HomeDeliveryPremiumType_RL.
	 *
	 * @param HomeDeliveryPremiumType_RL HomeDeliveryPremiumType_RL
	 */
	void setHomeDeliveryPremiumType_RL(I_AD_Ref_ListInput HomeDeliveryPremiumType_RL);

	/**
	 * Get HomeDeliveryPremiumType_RL.
	 *
	 * @return HomeDeliveryPremiumType_RL
	 */
	I_AD_Ref_ListInput getHomeDeliveryPremiumType_RL();

	/**
	 * Set Insurance_RL.
	 *
	 * @param Insurance_RL Insurance_RL
	 */
	void setInsurance_RL(I_AD_Ref_ListInput Insurance_RL);

	/**
	 * Get Insurance_RL.
	 *
	 * @return Insurance_RL
	 */
	I_AD_Ref_ListInput getInsurance_RL();

	/**
	 * Set M_InOut.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	void setM_InOut(I_M_InOutInput M_InOut);

	/**
	 * Get M_InOut.
	 *
	 * @return Material Shipment Document
	 */
	I_M_InOutInput getM_InOut();

	/**
	 * Set M_Package.
	 *
	 * @param M_Package Shipment Package
	 */
	void setM_Package(I_M_PackageInput M_Package);

	/**
	 * Get M_Package.
	 *
	 * @return Shipment Package
	 */
	I_M_PackageInput getM_Package();

	/**
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_Shipper(I_M_ShipperInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	I_M_ShipperInput getM_Shipper();

	/**
	 * Set M_ShipperLabels.
	 *
	 * @param M_ShipperLabels M_ShipperLabels
	 */
	void setM_ShipperLabels(I_M_ShipperLabelsInput M_ShipperLabels);

	/**
	 * Get M_ShipperLabels.
	 *
	 * @return M_ShipperLabels
	 */
	I_M_ShipperLabelsInput getM_ShipperLabels();

	/**
	 * Set M_ShipperPackaging.
	 *
	 * @param M_ShipperPackaging M_ShipperPackaging
	 */
	void setM_ShipperPackaging(I_M_ShipperPackagingInput M_ShipperPackaging);

	/**
	 * Get M_ShipperPackaging.
	 *
	 * @return M_ShipperPackaging
	 */
	I_M_ShipperPackagingInput getM_ShipperPackaging();

	/**
	 * Set M_ShipperPickupTypes.
	 *
	 * @param M_ShipperPickupTypes M_ShipperPickupTypes
	 */
	void setM_ShipperPickupTypes(I_M_ShipperPickupTypesInput M_ShipperPickupTypes);

	/**
	 * Get M_ShipperPickupTypes.
	 *
	 * @return M_ShipperPickupTypes
	 */
	I_M_ShipperPickupTypesInput getM_ShipperPickupTypes();

	/**
	 * Set M_ShippingProcessor.
	 *
	 * @param M_ShippingProcessor M_ShippingProcessor
	 */
	void setM_ShippingProcessor(I_M_ShippingProcessorInput M_ShippingProcessor);

	/**
	 * Get M_ShippingProcessor.
	 *
	 * @return M_ShippingProcessor
	 */
	I_M_ShippingProcessorInput getM_ShippingProcessor();

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
	void setM_Warehouse(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput getM_Warehouse();

	/**
	 * Set NotificationType_RL.
	 *
	 * @param NotificationType_RL Type of Notifications
	 */
	void setNotificationType_RL(I_AD_Ref_ListInput NotificationType_RL);

	/**
	 * Get NotificationType_RL.
	 *
	 * @return Type of Notifications
	 */
	I_AD_Ref_ListInput getNotificationType_RL();

	/**
	 * Set PaymentRule_RL.
	 *
	 * @param PaymentRule_RL How you pay the invoice
	 */
	void setPaymentRule_RL(I_AD_Ref_ListInput PaymentRule_RL);

	/**
	 * Get PaymentRule_RL.
	 *
	 * @return How you pay the invoice
	 */
	I_AD_Ref_ListInput getPaymentRule_RL();

	/**
	 * Set ReturnBPartner.
	 *
	 * @param ReturnBPartner ReturnBPartner
	 */
	void setReturnBPartner(I_C_BPartnerInput ReturnBPartner);

	/**
	 * Get ReturnBPartner.
	 *
	 * @return ReturnBPartner
	 */
	I_C_BPartnerInput getReturnBPartner();

	/**
	 * Set ReturnLocation.
	 *
	 * @param ReturnLocation ReturnLocation
	 */
	void setReturnLocation(I_C_BPartner_LocationInput ReturnLocation);

	/**
	 * Get ReturnLocation.
	 *
	 * @return ReturnLocation
	 */
	I_C_BPartner_LocationInput getReturnLocation();

	/**
	 * Set ReturnUser.
	 *
	 * @param ReturnUser ReturnUser
	 */
	void setReturnUser(I_AD_UserInput ReturnUser);

	/**
	 * Get ReturnUser.
	 *
	 * @return ReturnUser
	 */
	I_AD_UserInput getReturnUser();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRep(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput getSalesRep();
}
