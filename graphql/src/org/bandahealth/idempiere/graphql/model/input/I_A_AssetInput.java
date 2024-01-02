package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset;

/**
 * Generated Interface for A_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_AssetInput extends I_A_Asset {

	/**
	 * Set A_Asset_Action.
	 *
	 * @param A_Asset_Action A_Asset_Action
	 */
	void setA_Asset_ActionInput(I_AD_Ref_ListInput A_Asset_Action);

	/**
	 * Get A_Asset_Action.
	 *
	 * @return A_Asset_Action
	 */
	I_AD_Ref_ListInput A_Asset_Action();

	/**
	 * Set A_Asset_Class.
	 *
	 * @param A_Asset_Class A_Asset_Class
	 */
	void setA_Asset_ClassInput(I_A_Asset_ClassInput A_Asset_Class);

	/**
	 * Get A_Asset_Class.
	 *
	 * @return A_Asset_Class
	 */
	I_A_Asset_ClassInput A_Asset_Class();

	/**
	 * Set A_Asset_Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	void setA_Asset_GroupInput(I_A_Asset_GroupInput A_Asset_Group);

	/**
	 * Get A_Asset_Group.
	 *
	 * @return Group of Assets
	 */
	I_A_Asset_GroupInput A_Asset_Group();

	/**
	 * Set A_Asset_Status.
	 *
	 * @param A_Asset_Status A_Asset_Status
	 */
	void setA_Asset_StatusInput(I_AD_Ref_ListInput A_Asset_Status);

	/**
	 * Get A_Asset_Status.
	 *
	 * @return A_Asset_Status
	 */
	I_AD_Ref_ListInput A_Asset_Status();

	/**
	 * Set A_Asset_Type.
	 *
	 * @param A_Asset_Type A_Asset_Type
	 */
	void setA_Asset_TypeInput(I_A_Asset_TypeInput A_Asset_Type);

	/**
	 * Get A_Asset_Type.
	 *
	 * @return A_Asset_Type
	 */
	I_A_Asset_TypeInput A_Asset_Type();

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
	 * Set A_Parent_Asset.
	 *
	 * @param A_Parent_Asset A_Parent_Asset
	 */
	void setA_Parent_AssetInput(I_A_AssetInput A_Parent_Asset);

	/**
	 * Get A_Parent_Asset.
	 *
	 * @return A_Parent_Asset
	 */
	I_A_AssetInput A_Parent_Asset();

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
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput C_Activity();

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
	 * Set C_BPartnerSR.
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	void setC_BPartnerSRInput(I_C_BPartnerInput C_BPartnerSR);

	/**
	 * Get C_BPartnerSR.
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	I_C_BPartnerInput C_BPartnerSR();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(I_C_LocationInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	I_C_LocationInput C_Location();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput C_Project();

	/**
	 * Set Lease_BPartner.
	 *
	 * @param Lease_BPartner The Business Partner who rents or leases
	 */
	void setLease_BPartnerInput(I_C_BPartnerInput Lease_BPartner);

	/**
	 * Get Lease_BPartner.
	 *
	 * @return The Business Partner who rents or leases
	 */
	I_C_BPartnerInput Lease_BPartner();

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(I_M_AttributeSetInstanceInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	I_M_AttributeSetInstanceInput M_AttributeSetInstance();

	/**
	 * Set M_InOutLine.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	void setM_InOutLineInput(I_M_InOutLineInput M_InOutLine);

	/**
	 * Get M_InOutLine.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	I_M_InOutLineInput M_InOutLine();

	/**
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_LocatorInput(I_M_LocatorInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	I_M_LocatorInput M_Locator();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput M_Product();
}
